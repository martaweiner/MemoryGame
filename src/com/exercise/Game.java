package com.exercise;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Game {
    private String[] strings = {"slowa", "litery", "zdania"};
    private ArrayList<Word> wordsUp;
    private ArrayList<Word> wordsDown;

    public Game() {
        wordsUp = new ArrayList<>();
        wordsDown = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            wordsUp.add(new Word(strings[i]));
            wordsDown.add(new Word(strings[i]));
        }

        Collections.shuffle(wordsUp);
        Collections.shuffle(wordsDown);
    }


    public void iteration() {

        int szansa = 0;

        Scanner choice = new Scanner(System.in);
        System.out.println("Wybierz poziom trudności: \n1. Podstawowy \n2. Zaawansowany");
        int answer = choice.nextInt();
//        int szansa = 0;

        if (answer == 1) {
            szansa = 2;
        } else if (answer == 2) {
            szansa = 3;
        }

        while (answer == 1 || answer == 2) {
            if (answer == 1) {
                System.out.println("Wybrałeś poziom podstawowy. Szanse do odgadnięcia: 10");

                System.out.println("Wsprzółrzędne A");
                int pozycja1 = new Scanner(System.in).nextInt();

                wordsUp.get(pozycja1).uncover();
                for (int i = 0; i < szansa; i++) {
                    Word word = wordsUp.get(i);
                    if (word.isUncovered()) {
                        System.out.print(word.getText() + " ");
                    } else
                        System.out.print(" x ");
                }
                System.out.println();

                System.out.println("Współrzędne B");
                int pozycja2 = new Scanner(System.in).nextInt();

                wordsDown.get(pozycja2).uncover();
                for (int i = 0; i < szansa; i++) {
                    Word word = wordsDown.get(i);
                    if (word.isUncovered()) {
                        System.out.print(word.getText() + " ");
                    } else
                        System.out.print(" x ");
                }
                System.out.println();

                if (!wordsUp.get(pozycja1).equals(wordsDown.get(pozycja2))) {
                    wordsUp.get(pozycja1).cover();
                    wordsDown.get(pozycja2).cover();
                }
            } else if (answer == 2) {
                System.out.println("Wybrałeś poziom zaawansowany. Szanse do odgadnięcia: 15");
                while (answer == 1 || answer == 2) {
                    System.out.println("Wsprzółrzędne A");
                    int pozycja1 = new Scanner(System.in).nextInt();

                    wordsUp.get(pozycja1).uncover();
                    for (int i = 0; i < szansa; i++) {
                        Word word = wordsUp.get(i);
                        if (word.isUncovered()) {
                            System.out.print(word.getText() + " ");
                        } else
                            System.out.print(" x ");
                    }
                    System.out.println();

                    System.out.println("Współrzędne B");
                    int pozycja2 = new Scanner(System.in).nextInt();

                    wordsDown.get(pozycja2).uncover();
                    for (int i = 0; i < szansa; i++) {
                        Word word = wordsDown.get(i);
                        if (word.isUncovered()) {
                            System.out.print(word.getText() + " ");
                        } else
                            System.out.print(" x ");
                    }
                    System.out.println();

                    if (!wordsUp.get(pozycja1).equals(wordsDown.get(pozycja2))) {
                        wordsUp.get(pozycja1).cover();
                        wordsDown.get(pozycja2).cover();
                    }
                }
            }
        }
    }
}
