package com.pajeuhub.backend.infra.persistence.activity;

import java.util.Date;

import com.pajeuhub.backend.infra.persistence.place.PlaceEntity;
import com.pajeuhub.backend.infra.persistence.player.PlayerEntity;
import com.pajeuhub.backend.infra.persistence.sport.SportEntity;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


import jakarta.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "hub_activities")
public class ActivityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String info;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "place_id", nullable = false)
    private PlaceEntity place;

    @ManyToOne
    @JoinColumn(name = "creator_id", nullable = false)
    private PlayerEntity creator;
    
    @ManyToOne
    @JoinColumn(name = "sport_id", nullable = false)
    private SportEntity sport;

    @ManyToMany
    @JoinTable(
        name = "hub_activity_members",
        joinColumns = @JoinColumn(name = "activity_id"),
        inverseJoinColumns = @JoinColumn(name = "player_id")
    )
    private PlayerEntity[] members;
    
    private boolean status;
}
