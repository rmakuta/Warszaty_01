package rmakuta.workshops.guessNumber2;

import java.util.Scanner;

public class GuessNumber2 {
    public static void main(String[] args) {

        System.out.println("Pomyśl liczbę od 0 do 1000 a ja ją zgadnę w maksymalnie 10 próbach.");

        int min = 0, max = 1000, guess;
        boolean next = true;
        int step = 1;
        String answer;

        Scanner scan = new Scanner(System.in);

        while (next){

            guess = ((max - min)/2) + min;

            System.out.println("Zgaduję " + step++ + ": " + guess + " Zgadłem? (t/n)");
            answer = scan.nextLine();

            if(answer.equals("t")){
                System.out.println("Wygrałem!");
                next = false;
            }else {
                System.out.println("Za dużo? (t/n)");
                answer = scan.nextLine();
                if(answer.equals("t")){
                    max = guess;
                }else {
                    System.out.println("Za mało? (t/n)");
                    answer = scan.nextLine();
                    if(answer.equals("t")){
                        min = guess;
                    }else {
                        System.out.println("Nie oszukuj!");
                    }
                }
            }

//            guess = ((max - min)/2) + min;
//
//            System.out.println("Zgaduję " + step++ + ": " + guess + " (za dużo/za mało/zgadłeś)");
//            answer = scan.nextLine();
//
//            switch (answer){
//                case "za dużo":
//                    max = guess;
//                    break;
//                case "za mało":
//                    min = guess;
//                    break;
//                case "zgadłeś":
//                    System.out.println("Wygrałem!");
//                    next = false;
//                    break;
//            }
        }
    }
}
