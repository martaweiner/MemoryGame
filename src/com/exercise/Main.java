package com.exercise;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
            Game game = new Game();
            while (true) {
                game.iteration();
            }




//        FileReader fr = null;
//        // OTWIERANIE PLIKU:
//        try {
//            fr = new FileReader("Words.txt");
//        } catch (FileNotFoundException e) {
//            System.out.println("Error");
//            System.exit(1);
//        }
//        BufferedReader bfr = new BufferedReader(fr);
//
//        List<String> list = bfr.lines().collect(Collectors.toList());
//        //Collections.shuffle(list); // losowość
//
//        Scanner choice = new Scanner(System.in);
//        System.out.println("Wybierz poziom trudności: \n1. Podstawowy \n2. Zaawansowany");
//        int answer = choice.nextInt();
//
//        if (answer == 1) {
//            System.out.println("Wybrałeś poziom podstawowy \nSłowa do odgadnięcia: ");
//            for (int i = 0; i < 4; i++) {
//                Collections.shuffle(list);
//                System.out.print(list.get(i) + " ");}
//            } else if (answer == 2) {
//                System.out.println("Wybrałeś poziom zaawansowany\nSłowa do odgadnięcia:");
//                for (int i = 0; i < 8; i++) {
//                    Collections.shuffle(list);
//                    System.out.print(list.get(i) + " ");}
//                } else{
//                    System.out.println("Wybierz prawidłową opcję"); // dopóki nie wybeirze 1,2 while selected
//                }

        //tablica obiektow, nie tylko str. .obiekt ma w sobie slowo, czy ma byc pokazywane, visible/not visible,
        //jezeli jest w stanie połowicznym, odgadnięte,
        // słowo : stan w jakim jest

        // indeksy, kopiuje do tablicy ale nie mogą się powtarzać i usuwam z macierzystej
        // pytanie o uruchomienie

        }
    }