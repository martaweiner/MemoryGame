package com.exercise;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Game {
    private ArrayList<Word> wordsUp;
    private ArrayList<Word> wordsDown;

    public Game() {

        FileReader fr = null;
        // opening a file:
        try {
            fr = new FileReader("Words.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Error");
            System.exit(1);
        }
        BufferedReader bfr = new BufferedReader(fr);

        List<String> strings = bfr.lines().collect(Collectors.toList());
        wordsUp = new ArrayList<>();
        wordsDown = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            wordsUp.add(new Word(strings.get(i)));
            wordsDown.add(new Word(strings.get(i)));
        }

        Collections.shuffle(wordsUp);
        Collections.shuffle(wordsDown);
    }

    public void iteration() {

        Scanner choice = new Scanner(System.in);
        System.out.println("Choose level: \n1. Easy \n2. Hard");
        int answer = choice.nextInt();
        int j = 0;

            if (answer == 1) {
                System.out.println("Your choice: easy level. Chances: 10");
                while (j < 3) {
                    j++;
                    System.out.println("Chance: " + j);

                    System.out.println("Coordinate A");
                    int position1 = new Scanner(System.in).nextInt();

                    wordsUp.get(position1).uncover();
                    for (int i = 0; i < 3; i++) {
                        Word word = wordsUp.get(i);
                        if (word.isUncovered()) {
                            System.out.print(word.getText() + " ");
                        } else
                            System.out.print(" x ");
                    }
                    System.out.println();

                    System.out.println("Coordinate B");
                    int position2 = new Scanner(System.in).nextInt();

                    wordsDown.get(position2).uncover();
                    for (int i = 0; i < 3; i++) {
                        Word word = wordsDown.get(i);
                        if (word.isUncovered()) {
                            System.out.print(word.getText() + " ");
                        } else
                            System.out.print(" x ");
                    }
                    System.out.println();

                    if (!wordsUp.get(position1).equals(wordsDown.get(position2))) {
                        wordsUp.get(position1).cover();
                        wordsDown.get(position2).cover();
                    }
                }
            } else if (answer == 2) {
                System.out.println("Your choice: hard level. Chances: 15");
                while (j < 15) {

                    System.out.println("Coordinate A");
                    int position1 = new Scanner(System.in).nextInt();

                    wordsUp.get(position1).uncover();
                    for (int i = 0; i < 3; i++) {
                        Word word = wordsUp.get(i);
                        if (word.isUncovered()) {
                            System.out.print(word.getText() + " ");
                        } else
                            System.out.print(" x ");
                    }
                    System.out.println();

                    System.out.println("Coordinate B");
                    int position2 = new Scanner(System.in).nextInt();

                    wordsDown.get(position2).uncover();
                    for (int i = 0; i < 3; i++) {
                        Word word = wordsDown.get(i);
                        if (word.isUncovered()) {
                            System.out.print(word.getText() + " ");
                        } else
                            System.out.print(" x ");
                    }
                    System.out.println();

                    if (!wordsUp.get(position1).equals(wordsDown.get(position2))) {
                        wordsUp.get(position1).cover();
                        wordsDown.get(position2).cover();
                    } else {
                        System.out.println("Mistake. Please enter the correct data: 1 or 2");
                    }
                }
            }
    }
}

