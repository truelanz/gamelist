package com.truelanz.gamelist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.truelanz.gamelist.dto.GameDTO;
import com.truelanz.gamelist.dto.GameMinDTO;
import com.truelanz.gamelist.services.GameService;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping(value = "/{id}") // {} <- indica que o path receberá um parâmetro de variável.
    public GameDTO findById(@PathVariable Long id) { //@PathVariable para vincular um variável como caminho (path)
        GameDTO result = gameService.findById(id);
        return result;
    }
    
    @GetMapping
    public List<GameMinDTO> findAll() {
        List<GameMinDTO> result = gameService.findAll();
        return result;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<GameDTO> createGame(@RequestBody GameDTO gameDTO) {
        GameDTO createdGame = gameService.createGame(gameDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdGame);
    }
}
