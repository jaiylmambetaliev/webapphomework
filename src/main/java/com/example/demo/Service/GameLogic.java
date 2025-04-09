package com.example.demo.Service;

import com.example.demo.DTO.GameDto;
import com.example.demo.Repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GameLogic {
    private final GameRepository gameRepository;

    public GameLogic(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public String createGame() {
        GameDto game = new GameDto();
        gameRepository.save(game);
        return String.valueOf(game.getId());
    }

    public Optional<GameDto> getGame(int id) {
        return gameRepository.findById(id);
    }

    public String makeGuess(int id, int guess) {
        Optional<GameDto> optionalGame = getGame(id);

        if (optionalGame.isEmpty()) {
            return "Game not found";
        }

        GameDto game = optionalGame.get();
        game.setGuesses(game.getGuesses() + 1);
        gameRepository.save(game);

        if (guess == game.getNumber()) {
            return "Correct! " + game.getGuesses() + " guesses";
        } else if (guess < game.getNumber()) {
            return "Number is bigger. " + game.getGuesses() + " guesses";
        } else {
            return "Number is smaller. " + game.getGuesses() + " guesses";
        }
    }
}