package com.truelanz.gamelist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.truelanz.gamelist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {
    
}
