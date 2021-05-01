import java.util.Random;
import java.util.Scanner;

/**
 * @author Sylwia Cieślak
 */

public class BubbleSort {

    public void bubbleSort(int[] Array) {

        int lengh = Array.length;

        for (int i = 0; i < lengh - 1; i++) {
            for (int j = 0; j < (lengh - 1 - i); j++) {
                if (Array[j] > Array[j + 1]) {
                    //Tutaj bieżący element jest porównywany z następnym elementem.
                    //Jeśli bieżący element jest większy niż następny element, jest zamieniany.
                    int tempNumber = Array[j];
                    Array[j] = Array[j + 1];
                    Array[j + 1] = tempNumber;
                }//if
            }//for
        }//for

    }//bubbleSort

    public void printArray(int[] Array) {
        //użycei pętli for each ponieważ iterujemy jedynie po elementach żeby
        //je wszystkie wypisac w odpowiedniej kolejności
        System.out.print("[ ");
        for (int i : Array) {
            System.out.print(i + ", ");
        }
        System.out.print("]");
    }

    public void randomNums(int tab[], int amount){
        Random random = new Random();

        int mnoznikNextDouble = 1000; //liczba maksymalna do której będą generowane liczby
        System.out.print("[ ");
        for (int i = 0; i < amount; i++) {
            tab[i] = (int) (random.nextDouble() * (mnoznikNextDouble+1));
            System.out.print(tab[i] + ", ");
        }
        System.out.println("]");
    }


    public static void main(String[] args) {

        BubbleSort bubble = new BubbleSort();
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nWpisz ile liczb ma zosatć wpisanych do tablicy: ");
        int AmountArray = scanner.nextInt();
        int[] Tab = new int[AmountArray];

        System.out.println("\nTablica nieposortowana: ");
        bubble.randomNums(Tab , AmountArray);
        System.out.println("\nTablica posortowana:");
        bubble.bubbleSort(Tab);
        bubble.printArray(Tab);
        System.out.println("");

    }//main

}//class BubbleSort
