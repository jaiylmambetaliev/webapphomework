package com.example.demo.Service;

import com.example.demo.DTO.GameDto;

import java.util.HashMap;
import java.util.Map;

public class GameLogic {
    private Map<Integer, GameDto> games = new HashMap<Integer, GameDto>();

    public String createGame(){
        GameDto game = new GameDto();
        games.put(game.getId(), game);
        return String.valueOf(game.getId());
    }
    public GameDto getGame(int id){
        return games.get(id);
    }
    public String makeGuess(int id, int guess){
        GameDto game = getGame(id);
        game.setGuesses(game.getGuesses() + 1);
        if(guess == game.getNumber()){
            return "Correct " + game.getGuesses() + "guesses";
        } else if (guess < game.getNumber()){
            return "Number is bigger " + game.getGuesses() + "guesses";
        } else return "Number is smaller " + game.getGuesses() + "guesses";
    }

}
