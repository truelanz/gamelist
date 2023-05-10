package com.truelanz.gamelist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.truelanz.gamelist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {
    
}
