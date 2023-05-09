package com.truelanz.gamelist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.truelanz.gamelist.dto.GameMinDTO;
import com.truelanz.gamelist.entities.Game;
import com.truelanz.gamelist.repositories.GameRepository;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        // Transformando retorno de List<Game>, para List<GameMinDTO> ...
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;
    }

}
