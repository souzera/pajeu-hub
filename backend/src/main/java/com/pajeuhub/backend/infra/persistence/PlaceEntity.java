package com.pajeuhub.backend.infra.persistence;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

import com.pajeuhub.backend.core.enums.PlaceType;

@Entity
@Table(name = "hub_places")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
