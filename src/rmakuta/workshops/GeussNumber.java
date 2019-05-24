package rmakuta.workshops;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GeussNumber {

    public static void main(String[] args)
    {

        Random r = new Random();
        int number = r.nextInt(10)+1;

        System.out.print("Zgadnij liczbę: ");

        Scanner scan = new Scanner(System.in);
        int x = 0;

        while (true){

            while (!scan.hasNextInt())
            {
                scan.nextLine();
                System.out.print("Podaj właściwy parametr: ");
            }

            x = scan.nextInt();

            if(x > number){

                System.out.print("Za dużo! Spróbuj jeszcze raz: ");

            } else if (x < number){

                System.out.print("Za mało! Spróbuj jeszcze raz: ");

            } else {

                System.out.print("Zgadłeś!");
                break;
            }
        }


    }
}
