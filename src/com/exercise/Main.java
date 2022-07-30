package com.exercise;
import java.io.*;
import java.util.*;
//import java.util.spi.AbstractResourceBundleProvider;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Game game_init = new Game();
        game_init.iteration();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to play again? (only 'yes' answer is accepted as desire to continue)");
        String answer = scanner.next();

        while(answer.equals("yes")){
            Game game = new Game();
            game.iteration();
            if (!answer.equals("yes")){
                break;
            }
        }
    }
}
