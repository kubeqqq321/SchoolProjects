import java.util.Random;
import java.util.Scanner;

/**
 * @author Sylwia Cieślak
 */

public class InsertionSort {


    public void insertSort(int Tab[]) {
        // Przejście w pętli przez Tab.length - 1 elementów
        for (int next = 1; next < Tab.length; next++) {
            int insert = Tab[next]; // Wartość do wstawienia
            int moveItem = next; // Lokalizacja do wstawienia elementu

            // Poszukaj miejsca wstawienia aktualnego elementu
            while (moveItem > 0 && Tab[moveItem - 1] > insert) {
                // Przesuń element w prawo o jedno miejsce
                Tab[moveItem] = Tab[moveItem - 1];
                moveItem--;
            }

            Tab[moveItem] = insert; // Umieść wstawiany element
        }
    }

    public void printArray(int[] Array) {
        //użycei pętli for each ponieważ iterujemy jedynie po elementach żeby
        //je wszystkie wypisac w odpowiedniej kolejności
        System.out.print("[ ");
        for (int i : Array) {
            System.out.print(i + ", ");
        }
        System.out.print("]");
    }

    public void randomNums(int tab[], int amount) {
        Random random = new Random();

        int mnoznikNextDouble = 1000; //liczba maksymalna do której będą generowane liczby
        System.out.print("[ ");
        for (int i = 0; i < amount; i++) {
            tab[i] = (int) (random.nextDouble() * (mnoznikNextDouble + 1));
            System.out.print(tab[i] + ", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {

        InsertionSort insert = new InsertionSort();
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nWpisz ile liczb ma zosatć wpisanych do tablicy: ");
        int AmountArray = scanner.nextInt();
        int[] Tab = new int[AmountArray];

        System.out.println("\nTablica nieposortowana: ");
        insert.randomNums(Tab, AmountArray);
        System.out.println("\nTablica posortowana:");
        insert.insertSort(Tab);
        insert.printArray(Tab);
        System.out.println("");

    }//main

}







