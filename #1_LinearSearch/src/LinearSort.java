/**
 * to jest główny projekt od sowy
 */
//class LinearSort{
//
//    public static void main (String Args[]) {
//
////ta deklaracja (ilw) jest niekonieczna - długość wektora jest określana przez
////ilość elementów podstawianych
//        int ile = 10;
//
//        int[] wek = {6,10,11,13,15,18,45,56,87,94};
//        int i;
//        int liczba_szukana = 15;//trzeba sprawdzić różne, w tym nie występujące
//
////tutaj dopisujemy kod algorytmu szukania
//
//    }//main
//}//Szukaj

/**
 * Tu mamy kod zadania 1
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Zadanie 1a
 */
class RepeatElement
{
    void printRepeating(int arr[], int size)
    {
        int i, j;
        System.out.println("Repeated Elements are :");
        for (i = 0; i < size; i++)
        {
            for (j = i + 1; j < size; j++)
            {
                if (arr[i] == arr[j])
                    System.out.print(arr[i] + " ");
            }
        }
    }

    public static void main(String[] args)
    {
        RepeatElement repeat = new RepeatElement();
        int arr[] = {4, 2, 4, 5, 2, 3, 1};
        int arr_size = arr.length;


        repeat.printRepeating(arr, arr_size);
    }
}


/**
 * To działa do zadania 1a jednak jest to za trudne
 */

//TODO trzeba to zmienic zeby nie bylo to tak skompliowane
class BinarySearch {

    public static void main(String args[]) {

        int c, n, search, array[];
        boolean searchStatus = false;

        ArrayList<Integer> al = new ArrayList<Integer>();

        Scanner in = new Scanner(System.in);
        System.out.println("Enter number of elements");
        n = in.nextInt();
        array = new int[n];
        System.out.println("Enter " + n + " integers");
        for (c = 0; c < n; c++)
            array[c] = in.nextInt();
        System.out.println("Enter value to find");
        search = in.nextInt();
        for (c = 0; c < n; c++) {
            if (array[c] == search)     /* Searching element is present */ {
                al.add(c + 1);
                searchStatus = true;
            }
        }
        if (searchStatus == false)  /* Searching element is absent */
            System.out.println(search + " is not present in array.");
        else {
            System.out.print(search + " is present in array at location ");
            for (Integer i : al)
                System.out.print(i + ",");
        }
    }
}

/**
 * @author Jakub Marciniak
 * mamy tu wypisywanie liczb zduplikowanych
 */

class Linear {

//        int[] tablica = new int[]{1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 9, 12, 32, 43};
//
//
//        /**
//         * Pętla wyswietlająca elementy które występują w tablicy
//         */
//        for (int i = 0; i < 10; i++)
//            System.out.print(" " + tablica[i] + ", "  );
//        System.out.println(" ");
//        System.out.println("Elementy zduplikowane: ");
//
//        for (int i = 0; i < tablica.length; i++) {
//            for (int j = i+1; j < tablica.length; j++) {
//
//                if (tablica[i] == tablica[j]) {
//                    System.out.println(tablica[j]);
//                }
//            }
//        }
//    }


    public static void main(String[] args) {

        int[] TablicaLiczb = new int[]{6,10,11,12,12,15,16,18,18,45,56,56,94};
        int pozycja  = -1;
        boolean searchStatus = false;

        //Pętla wyswietlająca elementy które występują w tablicy
        for (int i = 0; i < TablicaLiczb.length; i++){
            pozycja++;
            System.out.print(" " + TablicaLiczb[i] +"- pozycja ->" + pozycja + " , ");
        }

        System.out.println(" ");   //Odstęp pomiedy wynikiem a wypisaną tablicą

        pozycja = -1; //TODO do usuniecia
        for (int i = 0; i < TablicaLiczb.length; i++) {
            pozycja++;
            for (int j = i+1; j < TablicaLiczb.length; j++) {

                if ( j != i && TablicaLiczb[i] == TablicaLiczb[j]) {
                    searchStatus = true;
                    System.out.println("Element " + TablicaLiczb[i] +"  " + j);

                } //if
            }//for
        }//for


        if(searchStatus == false)
        {
            System.out.println("Niestety podanej liczby nie ma w tablicy");
        }//if

    }





//        public static void main(String[] args)
//        {
//
//            int[] TablicaLiczb = {6,10,12,13,14,15,45,56,87,94};
//            //int LiczbaSzukana = 11;
//
//            int index =0;
//            /**
//             * Pętla wyswietlająca elementy które występują w tablicy
//             */
//            for (int i = 0; i < 10; i++)
//                System.out.print(" " + TablicaLiczb[i] + ", "  );
//
//            //Odstęp pomiedy wynikiem a wypisaną tablicą
//
//            System.out.println(" ");
//            for(int i = 0; i < TablicaLiczb.length; i++)
//            {   index++;
//                for(int j = i + 1 ; j < TablicaLiczb.length ; j++)
//                {
//                    if(TablicaLiczb[i] == TablicaLiczb[j])
//                        System.out.println("Element "+ TablicaLiczb[j] +" występuje na pozycji: " + index);
//                    else {
//                        System.out.println("nie ma nic godnego uwagi i podwojnego ");
//                    }
//
//                }
//                // here we are returning the index of the element if found
//
//            }
//            if(wyjscie == -1) //
//            {
//                System.out.println("Niestety podanej liczby nie ma w tablicy");
//            }
//            else
//            {
//                System.out.println("Element "+ LiczbaSzukana +" występuje na pozycji: " + wyjscie);
//            }
        }







