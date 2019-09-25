/*
* Kostka do gry
* xDy+z
* y – rodzaj kostek, których należy użyć (np. D6, D10),
* x – liczba rzutów kośćmi (jeśli rzucamy raz, ten parametr jest pomijalny),
* z – (opcjonalnie) liczba, którą należy dodać (lub odjąć) do wyniku rzutów.
*/

package rmakuta.workshops.dice;

import java.util.Random;
import java.util.Scanner;

public class Dice {
    public static void main(String[] args) {
        System.out.println("Podaj kod: ");
        Scanner scan = new Scanner(System.in);
        String code = scan.nextLine();
        System.out.println(throwDice(code));
    }
    public static int throwDice(String code){

        String quantityThrows = "0", typeDice = "0", numberToAdd = "";
        char option = ' ';
        char[] codeArr = code.toCharArray();
        int choose = 0;
        boolean toAdd = false;

        for (int i=0; i<codeArr.length; i++){
            if (codeArr[i] == 'D'){
                choose = 1;
                i++;
            }else if (codeArr[i] == '-' || codeArr[i] == '+'){
                choose = 2;
                option = codeArr[i];
            }
            switch (choose){
                case 0:
                    quantityThrows += codeArr[i];
                    break;
                case 1:
                    typeDice += codeArr[i];
                    break;
                case 2:
                    toAdd = true;
                    numberToAdd += codeArr[i];
                    break;
            }
        }

        Random random = new Random();
        int result = 0, i = 0;

        do{
            int tmp = random.nextInt(Integer.parseInt(typeDice))+1;
            result += tmp;
            i++;
        }while (i<Integer.parseInt(quantityThrows));

        if(toAdd){
            result += Integer.parseInt(numberToAdd);
        }
        return result;
    }
}

