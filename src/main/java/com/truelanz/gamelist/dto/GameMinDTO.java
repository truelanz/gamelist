package com.truelanz.gamelist.dto;

import com.truelanz.gamelist.entities.Game;
import com.truelanz.gamelist.projections.GameMinProjection;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GameMinDTO {
    
    private Long id;
    private String title;
    private Integer year;
    private String imgUrl;
    private String shortDescription;

    public GameMinDTO(Game entity) {
        id = entity.getId();
        title = entity.getTitle();
        year = entity.getYear();
        imgUrl = entity.getImgUrl();
        shortDescription = entity.getShortDescription();
    }

    public GameMinDTO(GameMinProjection entityProjection) {
        id = entityProjection.getId();
        title = entityProjection.getTitle();
        year = entityProjection.getGameYear();
        imgUrl = entityProjection.getImgUrl();
        shortDescription = entityProjection.getShortDescription();
    }   
}


