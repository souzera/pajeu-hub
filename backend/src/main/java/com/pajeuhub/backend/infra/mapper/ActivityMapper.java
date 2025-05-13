package com.pajeuhub.backend.infra.mapper;

import java.util.List;
import org.springframework.stereotype.Component;

import com.pajeuhub.backend.core.entities.Place;
import com.pajeuhub.backend.infra.dto.PlaceDTO;
import com.pajeuhub.backend.core.entities.Player;
import com.pajeuhub.backend.infra.dto.PlayerDTO;
import com.pajeuhub.backend.core.entities.Sport;
import com.pajeuhub.backend.infra.dto.SportDTO;

import com.pajeuhub.backend.core.entities.Activity;
import com.pajeuhub.backend.infra.dto.ActivityDTO;
import com.pajeuhub.backend.infra.persistence.activity.ActivityEntity;

@Component
public class ActivityMapper {
    
    public ActivityDTO toDTO(Activity activity){
        SportDTO sportDTO = new SportMapper().toDTO(activity.sport());
        PlaceDTO placeDTO = new PlaceMapper().toDTO(activity.place());
        PlayerDTO creatorDTO = new PlayerMapper().toDTO(activity.creator());
        List<PlayerDTO> membersDTO = new java.util.ArrayList<>();
        activity.members().forEach(
            playerDTO -> {
                membersDTO.add(new PlayerMapper().toDTO(playerDTO));
            }
        );
        return new ActivityDTO(activity.id(), activity.info(), activity.date(), placeDTO, creatorDTO, sportDTO, membersDTO, activity.status());
    }

    public ActivityDTO toDTO(ActivityEntity activityEntity){
        SportDTO sportDTO = new SportMapper().toDTO(activityEntity.getSport());
        PlaceDTO placeDTO = new PlaceMapper().toDTO(activityEntity.getPlace());
        PlayerDTO creatorDTO = new PlayerMapper().toDTO(activityEntity.getCreator());
        List<PlayerDTO> membersDTO = new java.util.ArrayList<>();
        activityEntity.getMembers().forEach(
            playerDTO -> {
                membersDTO.add(new PlayerMapper().toDTO(playerDTO));
            }
        );
        return new ActivityDTO(activityEntity.getId(), activityEntity.getInfo(), activityEntity.getDate(), placeDTO, creatorDTO, sportDTO, membersDTO, activityEntity.isStatus());
    }

    public Activity toDomain(ActivityDTO activityDTO){
        Sport sport = new SportMapper().toDomain(activityDTO.sport());
        Place place = new PlaceMapper().toDomain(activityDTO.place());
        Player creator = new PlayerMapper().toDomain(activityDTO.creator());
        
        List<Player> members = new java.util.ArrayList<>();

        activityDTO.members().forEach(
            playerDTO -> {
                members.add(new PlayerMapper().toDomain(playerDTO));
            }
        );

        return new Activity(activityDTO.id(), activityDTO.info(), activityDTO.date(), place, creator, sport, members, activityDTO.status());
    }

    public Activity toDomain(ActivityEntity activityEntity){
        Sport sport = new SportMapper().toDomain(activityEntity.getSport());
        Place place = new PlaceMapper().toDomain(activityEntity.getPlace());
        Player creator = new PlayerMapper().toDomain(activityEntity.getCreator());
        
        List<Player> members = new java.util.ArrayList<>();

        activityEntity.getMembers().forEach(
            playerDTO -> {
                members.add(new PlayerMapper().toDomain(playerDTO));
            }
        );

        return new Activity(activityEntity.getId(), activityEntity.getInfo(), activityEntity.getDate(), place, creator, sport, members, activityEntity.isStatus());
    }
}
