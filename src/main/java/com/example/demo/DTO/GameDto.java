package com.example.demo.DTO;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "games")
@Data
public class GameDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int number;
    private int guesses;

    public GameDto() {
        this.number = (int) (Math.random() * 100) + 1;
        this.guesses = 0;
    }
}
