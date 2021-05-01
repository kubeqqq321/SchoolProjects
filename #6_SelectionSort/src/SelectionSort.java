import java.util.Random;
import java.util.Scanner;

/**
 * @author Sylwia Cieślak
 */

public class SelectionSort {

    public void SelectSorting(int[] tab) {

        int lengt = tab.length;
        for (int i = 0; i < lengt - 1; i++) {

            // min is the index of the smallest element with an index greater or equal to i
            // min_index jest indexem o najmniejszym eleemencie z inedxem większym lub równym i
            int min_index = i;

            for (int j = i + 1; j < lengt; j++) {
                if (tab[j] < tab[min_index])
                    min_index = j;
            }
            //Zamiana i-tego elementu z min elementem
            int tempNumber = tab[min_index];
            tab[min_index] = tab[i];
            tab[i] = tempNumber;
        }
    }

    public static void printTab(int[] tab) {
        //użycei pętli for each ponieważ iterujemy jedynie po elementach żeby
        //je wszystkie wypisac w odpowiedniej kolejności
        System.out.print("[ ");
        for (int i : tab) {
            System.out.print(i + ", ");
        }
        System.out.print("]");
    }

    public void randomNums(int[] tab, int amount){
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

        SelectionSort selectionSort = new SelectionSort();
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nWpisz ile liczb ma zosatć wpisanych do tablicy: ");
        int AmountNumbers = scanner.nextInt();
        int[] TAB = new int[AmountNumbers];

        System.out.println("\nTablica nieposortowana: ");
        selectionSort.randomNums(TAB , AmountNumbers);

        System.out.println("Sorted array");
        selectionSort.SelectSorting(TAB);
        SelectionSort.printTab(TAB);

    }

}
