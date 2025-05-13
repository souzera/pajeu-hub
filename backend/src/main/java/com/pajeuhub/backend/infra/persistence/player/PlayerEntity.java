package com.pajeuhub.backend.infra.persistence.player;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import com.pajeuhub.backend.infra.persistence.user.UserEntity;

import jakarta.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "hub_player")
public class PlayerEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String contact;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;
}
