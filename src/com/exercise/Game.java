package com.exercise;
//import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.lang.Math;
import java.io.FileWriter;
import java.time.LocalDateTime;

public class Game {
    private List<String> strings;
    private ArrayList<Word> wordsUp;
    private ArrayList<Word> wordsDown;

    private int easy_no_of_tries = 10;
    private int hard_no_of_tries = 15;
    private int easy_no_of_words = 4;
    private int hard_no_of_words = 8;

    public Game() {

        FileReader fr = null;
        // opening a file:
        try {
            fr = new FileReader("Words.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Error during loading a file");
            System.exit(1);
        }
        BufferedReader bfr = new BufferedReader(fr);

        strings = bfr.lines().collect(Collectors.toList());
        wordsUp = new ArrayList<>();
        wordsDown = new ArrayList<>();

    }

    public boolean check_if_ended(ArrayList<Word> words_up, ArrayList<Word> words_down, int no_of_words) {
        boolean success = true;
        for (int i = 0; i < no_of_words; i++) {
            Word my_word = words_up.get(i);
            if (!my_word.isUncovered()) {
                success = false;
            }
        }
        for (int i = 0; i < no_of_words; i++) {
            Word my_word = words_down.get(i);
            if (!my_word.isUncovered()) {
                success = false;
            }
        }
        return success;
    }

    public void matrix_printer(int no_of_words, ArrayList<Word> my_words) {
        for (int i = 0; i < no_of_words; i++) {
            Word my_word = my_words.get(i);
            if (my_word.isUncovered()) {
                System.out.print(my_word.getText() + " ");
            } else
                System.out.print(" X ");
        }
        System.out.println();
    }

    public void iteration() {

        boolean success = false;
        Scanner choice = new Scanner(System.in);
        System.out.println("Choose level: \n1. Easy \n2. Hard");
        int answer = -1;
        try {
            answer = Integer.parseInt(choice.next());
            if (answer!=1 && answer!=2){
                System.out.println("You gave me a number not equals 1 nor 2 option");
                System.exit(1);
            }
        } catch (NumberFormatException e) {
            System.out.println("You gave me a string instead of integer");
            System.exit(1);
        }

        Collections.shuffle(strings);
        int j = 0;

        long startTime = System.nanoTime();

        if (answer == 1) {
            System.out.println("Your choice: easy level. Chances: 10");

            for (int a=0; a<easy_no_of_words; a++){
                wordsUp.add(new Word(strings.get(a)));
                wordsDown.add(new Word(strings.get(a)));
            }

            Collections.shuffle(wordsUp);
            Collections.shuffle(wordsDown);

            matrix_printer(easy_no_of_words, wordsUp);
            matrix_printer(easy_no_of_words, wordsDown);

            while (j < easy_no_of_tries) {

                int position1 = -1;
                int position2 = -1;

                j++;
                System.out.println("Chance: " + j);

                System.out.println("Coordinate A");

                try {
                    position1 = Integer.parseInt(choice.next());
                    if (position1<0 || position1>=easy_no_of_words){
                        System.out.println("You gave me a bad index (not existing)");
                        System.exit(1);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("You gave me a string instead of integer");
                    System.exit(1);
                }

                wordsUp.get(position1).uncover();

                matrix_printer(easy_no_of_words, wordsUp);
                matrix_printer(easy_no_of_words, wordsDown);

                System.out.println("Coordinate B");

                try {
                    position2 = Integer.parseInt(choice.next());
                    if (position2<0 || position2>=easy_no_of_words){
                        System.out.println("You gave me a bad index (not existing)");
                        System.exit(1);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("You gave me a string instead of integer");
                    System.exit(1);
                }

                wordsDown.get(position2).uncover();

                matrix_printer(easy_no_of_words, wordsUp);
                matrix_printer(easy_no_of_words, wordsDown);

                if (!wordsUp.get(position1).equals(wordsDown.get(position2))) {
                    wordsUp.get(position1).cover();
                    wordsDown.get(position2).cover();
                }

                if (check_if_ended(wordsUp, wordsDown, easy_no_of_words)) {
                    success = true;
                    break;
                }

            }

        } else {
            System.out.println("Your choice: hard level. Chances: 15");

            for (int a=0; a<hard_no_of_words; a++){
                wordsUp.add(new Word(strings.get(a)));
                wordsDown.add(new Word(strings.get(a)));
            }

            Collections.shuffle(wordsUp);
            Collections.shuffle(wordsDown);

            matrix_printer(hard_no_of_words, wordsUp);
            matrix_printer(hard_no_of_words, wordsDown);

            while (j < hard_no_of_tries) {

                int position1 = -1;
                int position2 = -1;

                j++;
                System.out.println("Chance: " + j);

                System.out.println("Coordinate A");

                try {
                    position1 = Integer.parseInt(choice.next());
                    if (position1<0 || position1>=hard_no_of_words){
                        System.out.println("You gave me a bad index (not existing)");
                        System.exit(1);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("You gave me a string instead of integer");
                    System.exit(1);
                }

                wordsUp.get(position1).uncover();

                matrix_printer(hard_no_of_words, wordsUp);
                matrix_printer(hard_no_of_words, wordsDown);

                System.out.println("Coordinate B");

                try {
                    position2 = Integer.parseInt(choice.next());
                    if (position2<0 || position2>=hard_no_of_words){
                        System.out.println("You gave me a bad index (not existing)");
                        System.exit(1);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("You gave me a string instead of integer");
                    System.exit(1);
                }

                wordsDown.get(position2).uncover();

                matrix_printer(hard_no_of_words, wordsUp);
                matrix_printer(hard_no_of_words, wordsDown);

                if (!wordsUp.get(position1).equals(wordsDown.get(position2))) {
                    wordsUp.get(position1).cover();
                    wordsDown.get(position2).cover();
                }

                if (check_if_ended(wordsUp, wordsDown, hard_no_of_words)) {
                    success = true;
                    break;
                }

            }
        }

        long endTime   = System.nanoTime();
        double totalTime_in_sec = (endTime - startTime)/Math.pow(10, 9);

        if (success) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Your game has ended with a success! Give me your name to properly save your results.");
            String name = scanner.next();

            try {
                FileWriter myWriter = new FileWriter("results.csv", true);
                myWriter.write(name + "," + java.time.LocalDate.now() + "," + totalTime_in_sec + "," + j + "\n");
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            System.out.println("Game has ended with a success");
        } else {
            System.out.println("Game has ended with a loss");
        }

        System.out.println("You have used " + j + " chances.");
        System.out.println("It tooks you " + totalTime_in_sec + " seconds.");
    }
}

