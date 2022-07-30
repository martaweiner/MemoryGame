package com.exercise;
import java.io.*;
import java.util.*;
import java.util.spi.AbstractResourceBundleProvider;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        game.iteration();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to play again?");
        String answer = scanner.next();

        if(answer.equals("yes")){
            game.iteration();
        }
    }
}


        //tablica obiektow, nie tylko str. .obiekt ma w sobie slowo, czy ma byc pokazywane, visible/not visible,
        //jezeli jest w stanie połowicznym, odgadnięte,
        // słowo : stan w jakim jest

        // indeksy, kopiuje do tablicy ale nie mogą się powtarzać i usuwam z macierzystej
        // pytanie o uruchomienie