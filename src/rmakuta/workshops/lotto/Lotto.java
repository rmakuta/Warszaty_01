package rmakuta.workshops.lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Lotto {
    public static void main(String[] args) {
        //wygenerowanie tablicy 49 kolejnych liczb
        Integer[] arr = new Integer[49];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        //przetasowanie tablicy wybranie sześciu pierwszych jako wylosowanej szóstki
        Collections.shuffle(Arrays.asList(arr));
        int[] numbers = new int[6];
        for (int i = 0; i < 6; i++) {
            numbers[i] = arr[i];
        }

        // sortowanie tablicy wyników
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

        //pobieranie wytypowanych liczb
        Scanner scan = new Scanner(System.in);
        int[] usersNumbers = new int[6];
        int z = 0;
        int next = 1;
        int check = 0;
        while (z < 6) {
            System.out.print("Podaj " + next++ + ". liczbę z zakresu 1 - 49: ");

            // pobieraj, aż użytkownik poda int
            while (!scan.hasNextInt()) {
                scan.next();
                System.out.print("Podaj właściwy parametr: ");
            }

            int x = scan.nextInt();

            //sprawdź czy liczba jest zakresu 1-49 i czy się powtarza
            boolean isCorrect = true;
            if(x >= 1 && x <= 49){
                for (int i = 0; i < 6; i++) {
                    if (x == usersNumbers[i]) {
                        System.out.println("już było");
                        next--;
                        isCorrect = false;
                        break;
                    }
                }
            }else {
                System.out.println("Liczba nie mieści się w zakresie 1-49!");
                next--;
                continue;
            }

            if (!isCorrect) {
                continue;
            }
            usersNumbers[z] = x;
            z++;
            //sprawdź czy wytypowana liczba jest wśród wylosowanych
            for(int i = 0; i < numbers.length; i++){
                if (x == numbers[i]){
                    check++;
                }
            }
        }

        //wyświetlenie wyniku losowania
        System.out.print("Wynik losowania: ");
        for (int n : numbers) {
            System.out.print("[" + n + "]");
        }
        System.out.println();

        for(int i = 0; i < usersNumbers.length - 1; i++){
            for(int j = 0; j < usersNumbers.length - 1; j++){
                if(usersNumbers[j] > usersNumbers[j+1]){
                    bubble = usersNumbers[j];
                    usersNumbers[j] = usersNumbers[j+1];
                    usersNumbers[j+1] = bubble;
                }
            }
        }

        System.out.print("Twoje liczby: ");
        for (int u : usersNumbers) {
            System.out.print("[" + u + "]");
        }
        System.out.println();

        switch (check){
            case 3:
                System.out.println("Trafiłeś trójkę!");
                break;
            case 4:
                System.out.println("Trafiłeś czwórkę!");
                break;
            case 5:
                System.out.println("Trafiłeś piątkę!");
                break;
            case 6:
                System.out.println("Trafiłeś szóstkę!");
                break;
            default:
                System.out.println("Nic nie trafiłeś. Może następnym razem? :)");
        }
    }
}

