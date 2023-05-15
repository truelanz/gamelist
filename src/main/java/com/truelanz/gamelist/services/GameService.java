package com.truelanz.gamelist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.truelanz.gamelist.dto.GameDTO;
import com.truelanz.gamelist.dto.GameMinDTO;
import com.truelanz.gamelist.entities.Game;
import com.truelanz.gamelist.projections.GameMinProjection;
import com.truelanz.gamelist.repositories.GameRepository;



@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id).get();
        GameDTO dto = new GameDTO(result);
        return dto;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        // Transformando retorno de List<Game>, para List<GameMinDTO> ...
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId) {
        List<GameMinProjection> result = gameRepository.searchByList(listId);
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;
    }

    @Transactional(readOnly = false)
    public GameDTO createGame(GameDTO gameDTO) {
        Game game = new Game();
        game.setTitle(gameDTO.getTitle());
        game.setYear(gameDTO.getYear());
        game.setGenre(gameDTO.getGenre());
        game.setPlatforms(gameDTO.getPlatforms());
        game.setScore(gameDTO.getScore());
        game.setImgUrl(gameDTO.getImgUrl());
        game.setShortDescription(gameDTO.getShortDescription());
        game.setLongDescription(gameDTO.getLongDescription());

        // Salva o jogo no banco de dados
        Game savedGame = gameRepository.save(game);

        // Retorna o DTO do jogo salvo
        return new GameDTO(savedGame);
    }
}
