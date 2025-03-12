package com.example.demo.Controller;

import com.example.demo.DTO.GameDto;
import com.example.demo.Service.GameLogic;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("game")
public class GameController {
    private GameLogic gameLogic = new GameLogic();

    @GetMapping("{id}/{guess}")
    public String guessNumber(@PathVariable int id, @PathVariable int guess) {

        return gameLogic.makeGuess(id, guess);
    }


    @GetMapping()
    public String createGame(){
        return gameLogic.createGame();
        }
    }

