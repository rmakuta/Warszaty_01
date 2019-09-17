package rmakuta.workshops;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Lotto {

    public static void main(String[] args) {

        // ułożenie 49 liczb w tablicy, w losowej kolejności

        Integer[] arr = new Integer[49];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        // System.out.println(Arrays.toString(arr));
        Collections.shuffle(Arrays.asList(arr));
        // System.out.println(Arrays.toString(arr));

        //wybranie szęsciu pierwszych i przypsanie ich jako wylosowanej szóstki

        int[] numbers = new int[6];

        for (int i = 0; i < 6; i++) {
            numbers[i] = arr[i];
        }

        // sortowanie liczb
        int bubble;
        for(int i = 0; i < numbers.length - 1; i++){
            for(int j = 0; j < numbers.length - 1; j++){
                if(numbers[j] > numbers[j+1]){
                    bubble = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = bubble;
                }
            }
        }

        for (int n : numbers) {
            System.out.print("[" + n + "]");
        }
        System.out.println();

        // pobieranie danych od użytkownika

        Scanner scan = new Scanner(System.in);
        int[] usersNumbers = new int[6];
        int z = 0;

        while (z < 6) {

            System.out.print("Podaj liczbę z zakresu 1 - 49: ");

            // pobieraj, aż użytkownik poda int

            while (!scan.hasNextInt()) {
                scan.next();
                System.out.print("Podaj właściwy parametr: ");
            }

            int x = scan.nextInt();

            // sprawdź czy liczba jest zakresu 1-49
            boolean isNew = true;
            for (int i = 0; i < 6; i++) {

                if (x == usersNumbers[i]) {
                    System.out.println("już było");
                    isNew = false;
                    break;
                }
            }
            if (!isNew) {
                continue;
            }
            if (x < 1 && x > 49) {
                continue;
            }

            usersNumbers[z] = x;
            z++;
        }

        for (int u : usersNumbers) {
            System.out.print("[" + u + "]");
        }

        /*for(int i = 0; i < numbers.length - 1; i++){
            for(int j = 0; j < numbers.length - 1; j++){
                if(numbers[j] > numbers[j+1]){
                    bubble = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = bubble;
                }
            }
        }*/

        int check = 0;
        for(int i = 0; i < numbers.length; i++){
            if (usersNumbers[i] == numbers[i]){
                check++;
            }
        }

        if(check >= 3){
            System.out.println("Trafiłeś przynajmniej trójkę!");
        }
    }
}

