package com.example.demo.DTO;

import lombok.Data;

import java.util.Random;
@Data

public class GameDto {
    private int id;
    private int number;
    private int guesses;
    public static int gameCount;



    public GameDto() {
        id = 1 + gameCount++;
        number = (int) (Math.random() * 100) + 1;
        guesses = 0;

    }
}

