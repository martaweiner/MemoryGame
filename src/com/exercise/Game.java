package com.exercise;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.lang.Math;
import java.io.FileWriter;

public class Game {
    private List<String> strings;
    private ArrayList<Word> wordsUp;
    private ArrayList<Word> wordsDown;
    private Scanner scanner = new Scanner(System.in);

    private final int level_easy = 1;
    private final int level_hard = 2;
    private final int easy_no_of_tries = 10;
    private final int hard_no_of_tries = 15;
    private final int easy_no_of_words = 4;
    private final int hard_no_of_words = 8;


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
        int answer = -1;
        while (true) {
            System.out.println("Choose level:");
            System.out.println("" + level_easy + ". Easy");
            System.out.println("" + level_hard + ". Hard");
            try {
                answer = Integer.parseInt(scanner.next());
                if (answer!=level_easy && answer!=level_hard){
                    System.out.println("You gave me an invalid number");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("You gave me a string instead of integer");
            }
        }

        Collections.shuffle(strings);

        long startTime = System.nanoTime();
        int no_of_tries;
        boolean success ;
        if (answer == 1) {
            no_of_tries=play("easy", easy_no_of_tries, easy_no_of_words);
            success= no_of_tries < easy_no_of_tries;
        } else {
            no_of_tries=play("hard", hard_no_of_tries, hard_no_of_words);
            success = no_of_tries < hard_no_of_tries;
        }

        long endTime   = System.nanoTime();
        double totalTime_in_sec = (endTime - startTime)/Math.pow(10, 9);

        if (success) {

            System.out.println("Your game has ended with a success! Give me your name to properly save your results.");
            String name = scanner.next();

            try {
                FileWriter myWriter = new FileWriter("results.csv", true);
                myWriter.write(name + "," + java.time.LocalDate.now() + "," + totalTime_in_sec + "," + no_of_tries + "\n");
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

        System.out.println("You have used " + no_of_tries + " chances.");
        System.out.println("It tooks you " + totalTime_in_sec + " seconds.");
    }

    private int play (String level_name, int no_of_tries, int no_of_words) {
        System.out.println("Your choice: " + level_name + " level. Chances: " + no_of_tries);

        for (int a=0; a<no_of_words; a++){
            wordsUp.add(new Word(strings.get(a)));
            wordsDown.add(new Word(strings.get(a)));

        }

        Collections.shuffle(wordsUp);
        Collections.shuffle(wordsDown);

        matrix_printer(no_of_words, wordsUp);
        matrix_printer(no_of_words, wordsDown);

        int j = 0;

        while (j < no_of_tries) {

            int position1 = -1;
            int position2 = -1;

            j++;
            System.out.println("Chance: " + j);

            System.out.println("Coordinate A");
            while (true) {
                try {
                    position1 = Integer.parseInt(scanner.next());
                    if (position1 < 0 || position1 >= no_of_words) {
                        System.out.println("You gave me a bad index (not existing)");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("You gave me a string instead of integer");
                }
            }

            wordsUp.get(position1).uncover();

            matrix_printer(no_of_words, wordsUp);
            matrix_printer(no_of_words, wordsDown);

            System.out.println("Coordinate B");
            while (true) {
                try {
                    position2 = Integer.parseInt(scanner.next());
                    if (position2 < 0 || position2 >= no_of_words) {
                        System.out.println("You gave me a bad index (not existing)");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("You gave me a string instead of integer");
                }
            }

            wordsDown.get(position2).uncover();

            matrix_printer(no_of_words, wordsUp);
            matrix_printer(no_of_words, wordsDown);

            if (!wordsUp.get(position1).equals(wordsDown.get(position2))) {
                wordsUp.get(position1).cover();
                wordsDown.get(position2).cover();
            }

            if (check_if_ended(wordsUp, wordsDown, no_of_words)) {
                break;
            }

        }
        return j;
    }
}

