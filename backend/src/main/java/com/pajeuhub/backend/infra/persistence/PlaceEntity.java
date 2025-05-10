package com.pajeuhub.backend.infra.persistence;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import jakarta.persistence.*;

import com.pajeuhub.backend.core.enums.PlaceType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "hub_places")
public class PlaceEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private String city;
    private String cep;
    private boolean status;
    private PlaceType kind;
}
