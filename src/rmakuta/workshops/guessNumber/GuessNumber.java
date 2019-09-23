/*
* Gra w zgadywanie liczby wylosowanej z zakresu 1-100
* */

package rmakuta.workshops.guessNumber;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args){

        Random r = new Random();
        int number = r.nextInt(100)+1;

        while (true){
            System.out.print("Zgadnij liczbę: ");
            Scanner scan = new Scanner(System.in);
            while (!scan.hasNextInt()) {
                scan.nextLine();
                System.out.println("To nie jest liczba. ");
                System.out.print("Zgadnij liczbę: ");
            }
            int x = scan.nextInt();
            if(x > number){
                System.out.println("Za dużo! ");
            } else if (x < number){
                System.out.println("Za mało! ");
            } else {
                System.out.print("Zgadłeś!");
                break;
            }
        }
    }
}
