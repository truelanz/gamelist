package com.truelanz.gamelist.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_game")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true) // incluir somente os EqualsAndHashCode.Include
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // usar id como key
    @EqualsAndHashCode.Include // incluiur hashcode and equals no id
    private Long id;
    private String title;
    @Column(name = "game_year") // mudar nome no banco de dados
    private Integer year;
    private String genre;
    private String platforms;
    private Double score;
    private String imgUrl;
    @Column(columnDefinition = "TEXT") // aceitar mais que 255 characters
    private String shortDescription;
    @Column(columnDefinition = "TEXT")
    private String longDescription;

}
