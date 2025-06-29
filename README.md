
# ⚽ Projeto Pajeu Hub

## 1. Introdução

Este documento tem como objetivo fornecer uma visão abrangente do projeto **Pajeu Hub**, um sistema de agendamento de quadras esportivas desenvolvido com foco em princípios de Clean Architecture e utilizando a linguagem de programação Java com o framework Spring Boot. O projeto foi criado com propósitos didáticos, visando a revisão e aplicação de conceitos de programação e arquitetura de software.

O Pajeu Hub permite que usuários agendem quadras esportivas, gerenciem atividades, locais, esportes e jogadores. A arquitetura do sistema foi projetada para ser modular, testável e de fácil manutenção, seguindo as diretrizes da Clean Architecture para separar as preocupações e garantir a independência das camadas.

## 2. Visão Geral do Projeto

O Pajeu Hub é uma aplicação backend que gerencia o agendamento de quadras esportivas. Ele oferece funcionalidades para:

*   **Gerenciamento de Atividades:** Criação, busca e visualização de atividades de agendamento, incluindo informações sobre o local, esporte, criador e participantes.
*   **Gerenciamento de Locais:** Cadastro e consulta de locais (quadras) disponíveis para agendamento, com detalhes como endereço, cidade e tipo.
*   **Gerenciamento de Esportes:** Definição e listagem de diferentes modalidades esportivas.
*   **Gerenciamento de Jogadores:** Registro e consulta de jogadores, associados a usuários do sistema.
*   **Autenticação de Usuários:** Registro e login de usuários para acesso às funcionalidades do sistema.

O projeto é construído em Java com Spring Boot, utilizando JPA para persistência de dados e um banco de dados relacional (configurável via `application.properties`).



## 3. Arquitetura do Sistema

O Pajeu Hub adota os princípios da **Clean Architecture**, proposta por Robert C. Martin (Uncle Bob). Essa arquitetura visa criar sistemas que são independentes de frameworks, bancos de dados, UI e agentes externos, facilitando a manutenção, testabilidade e evolução do software. A ideia central é organizar o código em camadas concêntricas, onde as dependências fluem apenas de fora para dentro.

### 3.1. Clean Architecture

No contexto do Pajeu Hub, a Clean Architecture é aplicada da seguinte forma:

*   **Entidades (Entities):** Representam as regras de negócio mais importantes e menos propensas a mudanças. São objetos puros de Java que encapsulam dados e comportamento relacionados ao domínio. No Pajeu Hub, as entidades são `Activity`, `Place`, `Player`, `Sport` e `User`.
*   **Casos de Uso (Use Cases):** Contêm as regras de negócio específicas da aplicação. Orquestram o fluxo de dados entre as entidades e os gateways. Cada caso de uso representa uma funcionalidade específica do sistema (ex: `CreateActivityCase`, `FindPlaceCase`).
*   **Gateways:** São interfaces que definem contratos para a comunicação com camadas externas, como bancos de dados ou serviços externos. A camada de casos de uso depende dessas interfaces, mas não de suas implementações concretas. Exemplos incluem `ActivityGateway`, `PlaceGateway`, etc.
*   **Frameworks e Drivers (Infrastructure):** Esta é a camada mais externa, onde estão as implementações concretas dos gateways, frameworks de persistência (JPA/Hibernate), controladores REST, DTOs e outras preocupações de infraestrutura. É a camada que mais depende das camadas internas.

Essa separação garante que as regras de negócio (Entidades e Casos de Uso) permaneçam intocadas por mudanças na tecnologia de banco de dados, framework web ou interface de usuário.

### 3.2. Estrutura de Pastas

A estrutura de pastas do projeto reflete a aplicação da Clean Architecture, organizando o código de forma lógica e coesa:

```
pajeu-hub/
├── backend/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/
│   │   │   │       └── pajeuhub/
│   │   │   │           └── backend/
│   │   │   │               ├── core/             # Camada de Domínio (Entidades, Casos de Uso, Gateways de Interface)
│   │   │   │               │   ├── entities/     # Entidades de Negócio (Activity, Place, Player, Sport, User)
│   │   │   │               │   ├── enums/        # Enums do Domínio (PlaceType)
│   │   │   │               │   ├── gateway/      # Interfaces de Gateway (ActivityGateway, PlaceGateway, etc.)
│   │   │   │               │   └── usecases/     # Casos de Uso (CreateActivityCase, FindPlaceCase, etc.)
│   │   │   │               └── infra/            # Camada de Infraestrutura (Implementações de Gateways, DTOs, Persistência, Controllers)
│   │   │   │                   ├── beans/        # Configuração de Beans Spring (BeanConfiguration)
│   │   │   │                   ├── dto/          # Data Transfer Objects (ActivityDTO, PlaceDTO, etc.)
│   │   │   │                   ├── gateway/      # Implementações dos Gateways (ActivityRepositoryGateway)
│   │   │   │                   ├── mapper/       # Mappers entre Entidades, DTOs e Entidades de Persistência
│   │   │   │                   ├── persistence/  # Entidades de Persistência e Repositórios JPA
│   │   │   │                   └── presentation/ # Controladores REST (ActivityController, PlaceController, etc.)
│   │   │   └── resources/
│   │   └── test/
│   └── pom.xml
└── README.md
```

Esta estrutura visa manter a separação de responsabilidades e facilitar a navegação e compreensão do projeto, alinhando-se com os princípios da Clean Architecture.



## 4. Entidades do Domínio (Core Entities)

As entidades representam os objetos de negócio centrais do sistema, encapsulando dados e comportamentos essenciais. Elas são independentes de qualquer framework ou tecnologia, garantindo que as regras de negócio permaneçam no centro da aplicação.

### 4.1. Activity

Representa uma atividade de agendamento de quadra esportiva. Contém informações sobre a atividade em si, o local, o criador, o esporte e os participantes.

```java
public record Activity(
    Long id,
    String info,
    Date date,
    Place place,
    Player creator,
    Sport sport,
    List<Player> members,
    boolean status
) {}
```

### 4.2. Place

Representa um local (quadra) disponível para agendamento.

```java
public record Place(
    Long id,
    String address,
    String city,
    String cep,
    boolean status,
    PlaceType kind
) {}
```

### 4.3. Player

Representa um jogador que pode participar de atividades.

```java
public record Player(
    Long id,
    String name,
    String contact,
    User user
) {}
```

### 4.4. Sport

Representa uma modalidade esportiva.

```java
public record Sport(
    Long id,
    String name,
    String description,
    boolean status
) {}
```

### 4.5. User

Representa um usuário do sistema, com credenciais de login.

```java
public record User(
    Long id,
    String login,
    String password
) {}
```



## 5. Casos de Uso (Use Cases)

Os casos de uso encapsulam as regras de negócio específicas da aplicação, orquestrando o fluxo de dados entre as entidades e os gateways. Cada interface de caso de uso define um contrato para uma funcionalidade específica, e suas implementações contêm a lógica de negócio.

### 5.1. Casos de Uso de Atividade (Activity Use Cases)

*   **CreateActivityCase:** Define a operação para criar uma nova atividade.

    ```java
    public interface CreateActivityCase {
        public Activity execute(Activity activity);
    }
    ```

*   **FindActivityCase:** Define a operação para encontrar uma atividade por ID.

    ```java
    public interface FindActivityCase {
        public Activity execute(Long id);
    }
    ```

### 5.2. Casos de Uso de Local (Place Use Cases)

*   **CreatePlaceCase:** Define a operação para criar um novo local.

    ```java
    public interface CreatePlaceCase {
        public Place execute(Place place);
    }
    ```

*   **FindPlaceCase:** Define a operação para encontrar um local por ID.

    ```java
    public interface FindPlaceCase {
        public Place execute(Long id);
    }
    ```

### 5.3. Casos de Uso de Jogador (Player Use Cases)

*   **CreatePlayerCase:** Define a operação para criar um novo jogador.

    ```java
    public interface CreatePlayerCase {
        public Player execute(Player player);
    }
    ```

*   **FindPlayerCase:** Define a operação para encontrar um jogador por ID.

    ```java
    public interface FindPlayerCase {
        public Player execute(Long id);
    }
    ```

### 5.4. Casos de Uso de Esporte (Sport Use Cases)

*   **CreateSportCase:** Define a operação para criar um novo esporte.

    ```java
    public interface CreateSportCase {
        public Sport execute(Sport sport);
    }
    ```

*   **FindSportCase:** Define a operação para encontrar um esporte por ID.

    ```java
    public interface FindSportCase {
        public Sport execute(Long id);
    }
    ```

### 5.5. Casos de Uso de Usuário (User Use Cases)

*   **CreateUserCase:** Define a operação para criar um novo usuário.

    ```java
    public interface CreateUserCase {
        public User execute(User user);
    }
    ```

*   **LoginCase:** Define a operação para realizar o login de um usuário.

    ```java
    public interface LoginCase {
        public String execute(String login, String password);
    }
    ```



## 6. Gateways

Os gateways são interfaces que definem os contratos para a comunicação com as camadas externas, como bancos de dados ou serviços de autenticação. Eles permitem que a camada de casos de uso seja independente das implementações de infraestrutura.

### 6.1. ActivityGateway

Define as operações para persistir e recuperar atividades.

```java
public interface ActivityGateway {
    Activity createActivity(Activity activity);
    Activity findActivityById(Long id);
}
```

### 6.2. PlaceGateway

Define as operações para persistir e recuperar locais.

```java
public interface PlaceGateway {
    Place createPlace(Place place);
    Place findPlaceById(Long id);
}
```

### 6.3. PlayerGateway

Define as operações para persistir e recuperar jogadores.

```java
public interface PlayerGateway {
    Player createPlayer(Player player);
    Player findPlayerById(Long id);
}
```

### 6.4. SportGateway

Define as operações para persistir e recuperar esportes.

```java
public interface SportGateway {
    Sport createSport(Sport sport);
    Sport findSportById(Long id);
}
```

### 6.5. UserGateway

Define as operações para persistir e autenticar usuários.

```java
public interface UserGateway {
    User createUser(User user);
    String login(String login, String password);
}
```



## 7. Infraestrutura

A camada de infraestrutura contém as implementações concretas dos gateways, DTOs, mappers, entidades de persistência e controladores REST. É a camada mais externa da Clean Architecture, responsável por lidar com detalhes de implementação como bancos de dados e frameworks web.

### 7.1. Beans (Configuração de Dependências)

A classe `BeanConfiguration` é responsável por configurar e fornecer as implementações dos casos de uso como beans Spring, injetando as dependências necessárias (gateways).

```java
@Configuration
public class BeanConfiguration {

    // ACTIVITY
    @Bean
    public CreateActivityCase createActivityCase(ActivityGateway activityGateway) {
        return new CreateActivityCaseImpl(activityGateway);
    }

    // PLACE
    @Bean
    public CreatePlaceCase createPlaceCase(PlaceGateway placeGateway){
        return new CreatePlaceCaseImpl(placeGateway);
    }

    // SPORT
    @Bean
    public CreateSportCase createSportCase(SportGateway sportGateway){
        return new CreateSportCaseImpl(sportGateway);
    }

    // PLAYER
    @Bean
    public CreatePlayerCase createPlayerCase(PlayerGateway playerGateway) {
        return new CreatePlayerCaseImpl(playerGateway);
    }

    // USER
    @Bean
    public CreateUserCase createUserCase(UserGateway userGateway) {
        return new CreateUserCaseImpl(userGateway);
    }
}
```

### 7.2. DTOs (Data Transfer Objects)

Os DTOs são objetos simples usados para transferir dados entre as camadas da aplicação, especialmente entre a camada de apresentação (controladores) e a camada de casos de uso/infraestrutura. Eles representam a estrutura dos dados que são recebidos de ou enviados para a API.

*   **ActivityDTO:**

    ```java
    public record ActivityDTO(
        Long id,
        String info,
        Date date,
        PlaceDTO place,
        PlayerDTO creator,
        SportDTO sport,
        List<PlayerDTO> members,
        boolean status
    ) {}
    ```

*   **PlaceDTO:**

    ```java
    public record PlaceDTO(
            Long id,
            String address,
            String city,
            String cep,
            boolean status,
            PlaceType kind
    ) {}
    ```

*   **PlayerDTO:**

    ```java
    public record PlayerDTO(
        Long id,
        String name,
        String contact,
        UserDTO user
    ) {}
    ```

*   **SportDTO:**

    ```java
    public record SportDTO(
        Long id,
        String name,
        String description,
        boolean status
    ) {}
    ```

*   **UserDTO:**

    ```java
    public record UserDTO(
        Long id,
        String login,
        String password
    ){}
    ```

### 7.3. Gateways de Infraestrutura (Implementações)

Essas classes implementam as interfaces de gateway definidas na camada `core`, conectando os casos de uso com a camada de persistência (repositórios JPA).

*   **ActivityRepositoryGateway:** Implementa `ActivityGateway`, utilizando `ActivityRepository` para acesso a dados.

    ```java
    @Component
    public class ActivityRepositoryGateway implements ActivityGateway{

        private final ActivityRepository activityRepository;
        private final ActivityMapper activityMapper;

        public ActivityRepositoryGateway(
            ActivityRepository activityRepository,
            ActivityMapper activityMapper
        ) {
            this.activityRepository = activityRepository;
            this.activityMapper = activityMapper;
        }

        @Override
        public Activity createActivity(Activity activity) {
            ActivityEntity activityEntity = activityMapper.toEntity(activity);
            ActivityEntity savedActivityEntity = activityRepository.save(activityEntity);

            return activityMapper.toDomain(savedActivityEntity);
        }

        @Override
        public Activity findActivityById(Long id) {
            throw new UnsupportedOperationException("Unimplemented method 'findActivityById'");
        } 
    }
    ```

### 7.4. Mappers

Os mappers são responsáveis por converter objetos entre as diferentes camadas da aplicação (Entidades de Domínio, DTOs e Entidades de Persistência). Isso garante que cada camada trabalhe com o formato de dados apropriado.

*   **ActivityMapper:** Converte entre `Activity` (domínio), `ActivityDTO` (DTO) e `ActivityEntity` (persistência).

    ```java
    @Component
    public class ActivityMapper {
        // Métodos toDTO, toDomain, toEntity para Activity, ActivityDTO e ActivityEntity
    }
    ```

*   **PlaceMapper:** Converte entre `Place`, `PlaceDTO` e `PlaceEntity`.

    ```java
    @Component
    public class PlaceMapper {
        // Métodos toDTO, toDomain, toEntity para Place, PlaceDTO e PlaceEntity
    }
    ```

*   **PlayerMapper:** Converte entre `Player`, `PlayerDTO` e `PlayerEntity`.

    ```java
    @Component
    public class PlayerMapper {
        // Métodos toDTO, toDomain, toEntity para Player, PlayerDTO e PlayerEntity
    }
    ```

*   **SportMapper:** Converte entre `Sport`, `SportDTO` e `SportEntity`.

    ```java
    @Component
    public class SportMapper {
        // Métodos toDTO, toDomain, toEntity para Sport, SportDTO e SportEntity
    }
    ```

*   **UserMapper:** Converte entre `User`, `UserDTO` e `UserEntity`.

    ```java
    @Component
    public class UserMapper {
        // Métodos toDTO, toDomain, toEntity para User, UserDTO e UserEntity
    }
    ```

### 7.5. Persistência (Entidades e Repositórios)

Esta subcamada define as entidades que mapeiam para as tabelas do banco de dados e os repositórios Spring Data JPA para operações CRUD.

*   **ActivityEntity e ActivityRepository:**

    ```java
    @Entity
    @Table(name = "hub_activities")
    public class ActivityEntity { /* ... */ }

    public interface ActivityRepository extends JpaRepository<ActivityEntity, Long> {}
    ```

*   **PlaceEntity e PlaceRepository:**

    ```java
    @Entity
    @Table(name = "hub_places")
    public class PlaceEntity { /* ... */ }

    public interface PlaceRepository extends JpaRepository<PlaceEntity, Long>{}
    ```

*   **PlayerEntity e PlayerRepository:**

    ```java
    @Entity
    @Table(name = "hub_player")
    public class PlayerEntity { /* ... */ }

    public interface PlayerRepository extends JpaRepository<PlayerEntity, Long> {}
    ```

*   **SportEntity e SportRepository:**

    ```java
    @Entity
    @Table(name = "hub_sports")
    public class SportEntity { /* ... */ }

    public interface SportRepository extends JpaRepository<SportEntity, Long> {}
    ```

*   **UserEntity e UserRepository:**

    ```java
    @Entity
    @Table(name = "auth_users")
    public class UserEntity { /* ... */ }

    public interface UserRepository extends JpaRepository<UserEntity, Long> {}
    ```

### 7.6. Apresentação (Controllers)

Os controladores REST expõem as funcionalidades da aplicação através de endpoints HTTP. Eles recebem requisições, invocam os casos de uso apropriados e retornam as respostas.

*   **ActivityController:** Gerencia as operações relacionadas a atividades.

    ```java
    @RestController
    @RequestMapping("api/v1/activities")
    public class ActivityController { /* ... */ }
    ```

*   **PlaceController:** Gerencia as operações relacionadas a locais.

    ```java
    @RestController
    @RequestMapping("api/v1/places")
    public class PlaceController { /* ... */ }
    ```

*   **PlayerController:** Gerencia as operações relacionadas a jogadores.

    ```java
    @RestController
    public class PlayerController { /* ... */ }
    ```

*   **SportController:** Gerencia as operações relacionadas a esportes.

    ```java
    @RestController
    @RequestMapping("api/v1/sports")
    public class SportController { /* ... */ }
    ```

*   **UserController:** Gerencia as operações relacionadas a usuários (registro e login).

    ```java
    @RestController
    public class UserController { /* ... */ }
    ```



## 8. Tecnologias Utilizadas

O projeto Pajeu Hub utiliza as seguintes tecnologias:

*   **Java 17:** Linguagem de programação principal.
*   **Spring Boot 3.x:** Framework para desenvolvimento de aplicações Java, facilitando a configuração e o deploy.
*   **Spring Data JPA:** Para persistência de dados, abstraindo a interação com o banco de dados relacional.
*   **Hibernate:** Implementação de JPA.
*   **Lombok:** Biblioteca para reduzir código boilerplate em classes Java.
*   **Maven:** Ferramenta de automação de build e gerenciamento de dependências.
*   **PostgreSQL (ou outro banco de dados relacional):** Banco de dados utilizado para persistir as informações do sistema. (Configurável via `application.properties`)
*   **Docker/Docker Compose:** Para orquestração e execução do ambiente de desenvolvimento.



## 9. Como Rodar o Projeto

Para rodar o projeto Pajeu Hub localmente, siga os passos abaixo:

### Pré-requisitos

*   Java Development Kit (JDK) 17 ou superior
*   Maven 3.x
*   Docker e Docker Compose (opcional, para rodar o banco de dados)

### Configuração do Banco de Dados

O projeto utiliza um banco de dados relacional. Você pode configurar as credenciais do banco de dados no arquivo `src/main/resources/application.properties`.

Exemplo de configuração para PostgreSQL:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/pajeuhub
spring.datasource.username=user
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

Se você tiver o Docker e Docker Compose instalados, pode usar o `docker-compose.yml` fornecido no repositório para subir uma instância do PostgreSQL:

```bash
docker-compose up -d
```

### Executando a Aplicação

1.  **Clone o repositório:**

    ```bash
    git clone https://github.com/souzera/pajeu-hub.git
    cd pajeu-hub/backend
    ```

2.  **Compile o projeto:**

    ```bash
    mvn clean install
    ```

3.  **Execute a aplicação:**

    ```bash
    mvn spring-boot:run
    ```

A aplicação estará disponível em `http://localhost:8080` (ou na porta configurada no `application.properties`).



## 10. Contribuição

Contribuições são bem-vindas! Se você deseja contribuir com o projeto, siga os passos abaixo:

1.  Faça um fork do repositório.
2.  Crie uma nova branch para sua feature (`git checkout -b feature/minha-feature`).
3.  Faça suas alterações e commit (`git commit -am 'feat: minha nova feature'`).
4.  Envie para a branch (`git push origin feature/minha-feature`).
5.  Abra um Pull Request.

Por favor, certifique-se de que seu código siga as boas práticas e que os testes estejam passando.



## 11. Licença

Este projeto está licenciado sob a Licença MIT. Consulte o arquivo `LICENSE` para mais detalhes.


