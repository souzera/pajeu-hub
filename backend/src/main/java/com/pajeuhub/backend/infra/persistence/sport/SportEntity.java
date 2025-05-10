package com.pajeuhub.backend.infra.persistence.sport;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import jakarta.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "hub_sports")
public class SportEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private boolean status;
}
