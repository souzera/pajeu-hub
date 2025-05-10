package com.pajeuhub.backend.infra.persistence;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import jakarta.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "auth_users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;
}
