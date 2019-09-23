package rmakuta.workshops.guessNumber2;

import java.util.Scanner;

public class GuessNumber2 {
    public static void main(String[] args) {

        System.out.println("Pomyśl liczbę od 0 do 1000 a ja ją zgadnę w maksymalnie 10 próbach.");
        Scanner scan = new Scanner(System.in);

        int min = 0, max = 1000, guess;
        guess = ((max - min)/2) + min;
        System.out.println("Zgaduję: " + guess);
        
    }
}
