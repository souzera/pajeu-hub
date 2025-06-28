
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