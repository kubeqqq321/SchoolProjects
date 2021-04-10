import java.util.ArrayList;

/**
 * @author Sylwia Cieślak
 */
public class LinearSearch {
    public static void main(String[] args) {

        //liczby w tablicy liczone są od 0 i w tym przypadku do 9
        int[] TablicaLiczb = {6, 10, 12, 13, 15, 18, 45, 56, 87, 94};
        int LiczbaSzukana = 18;
        boolean sprawdzanie = false;

        //Pętla wyswietlająca elementy które występują w tablicy
        for (int i = 0; i < TablicaLiczb.length; i++)
                System.out.print(" " + TablicaLiczb[i] + ", ");

        //Odstęp pomiedzy wynikiem a wypisaną tablicą
        System.out.println(" ");

        //Pętla która przechodzi po całej tablicy oraz istnieje warunek który
        // sprawdza czy dana wartość w tablicy jest równa LiczbaSzukana
        int pozycja = -1;
        for (int i = 0; i < TablicaLiczb.length; i++) {
            pozycja++;
            //Warunek który oznajmia, że jeśli LiczbaSzukana jest równa
            //liczbie znajdującej się w tablicy pętla przestaje działać
            if (TablicaLiczb[i] == LiczbaSzukana) {
                sprawdzanie = true;
                System.out.println("Element " + LiczbaSzukana + " występuje na pozycji: " + pozycja);
                break;
            }//if
        }//for
        // jeśli liczby nie ma w tablicy to pokazany jest komunikat
        if (sprawdzanie == false)
        {
            System.out.println("Niestety podanej liczby nie ma w tablicy");
        }//if

    }//public static void main(String[] args)
}//public class LinearSearch




class lin
{
    public static int search(int arr[], int x)
    {
        int n = arr.length;
        for (int i = 0; i < n; i++)
        {
            if (arr[i] == x)
                return i;
        }
        return -1;
    }

    // Driver code
    public static void main(String args[])
    {
        int arr[] = { 2, 3, 4, 10, 40 };
        int x = 10;

        // Function call
        int result = search(arr, x);
        if (result == -1)
            System.out.print(
                    "Element is not present in array");
        else
            System.out.print("Element is present at index "
                    + result);
    }
}



class Frequency {

    public static void main(String[] args) {

        //Initialize array
        int[] arr = new int[]{6, 10, 11, 12, 12, 15, 16, 18, 18, 45, 56, 56, 94};
        //Array fr will store frequencies of element
        int[] fr = new int[arr.length];
        int visited = -1;
        int count = 1;

        for (int i = 0; i < arr.length; i++) {
            //int count = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                    //To avoid counting same element again
                    fr[j] = visited;
                }
            }
            if (fr[i] == visited)
                fr[i] = count;
        }

        //Displays the frequency of each element present in array
        System.out.println("---------------------");
        System.out.println(" Element | Frequency");
        System.out.println("---------------------");
        for (int i = 0; i < fr.length; i++) {
            if (fr[i] == count)
                System.out.println("    " + arr[i] + "    |    " + fr[i]);
        }
        System.out.println("---------------------");
    }
}


// Java implementation of the
// above approach


class GFG {


    static void findDuplicates(
            int arr[], int len) {


        boolean ifPresent = false;


        ArrayList<Integer> al = new ArrayList<Integer>();

        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (arr[i] == arr[j]) {
                    if (al.contains(arr[i])) {
                        break;
                    } else {
                        al.add(arr[i]);
                        ifPresent = true;
                    }
                }
            }
        }

        if (ifPresent == true) {

            System.out.print(al + " ");
        } else {
            System.out.print(
                    "No duplicates present in arrays");
        }
    }

    public static void findDuplicateArray(int[] array) {
        int size = array.length;
        //creating array to hold count frequency of array elements
        int[] countFrequency = new int[size];
        // filling countFrequency with -1 value on every index
        for (int i = 0; i < size; i++) {
            countFrequency[i] = -1;//[-1,-1,-1,-1,-1...]
        }

        int count = 1;
        for (int i = 0; i < size; i++) {
            //check countFrequency[i] != 0 because 0 means it already counted
            if (countFrequency[i] != 0) {
                for (int j = i + 1; j < size; j++) {
                    //if array[i] == array[j] then increase count value
                    if (array[i] == array[j]) {
                        count++;
                        /*only at first occurence of an element count value
                         *will be increased else everywhere it  will be 0
                         */
                        countFrequency[j] = 0;
                    }
                }
                countFrequency[i] = count;
            }
            count = 1;
        }
        // array         = [2,3,2,5,3]
        //countFrequency = [2,2,0,1,0]


        System.out.println("duplicate elements in array");
        for (int i = 0; i < array.length; i++) {
            if (countFrequency[i] / 2 >= 1)
                System.out.print(array[i] + " ");
        }
        System.out.println();

        System.out.println("number of duplicate elements");
        count = 0;
        for (int i = 0; i < array.length; i++) {
            if (countFrequency[i] / 2 >= 1)
                count++;
        }
        System.out.print(count);
        System.out.println();

        System.out.println("numbers of pair of dulicate with  repeatation");
        count = 0;
        for (int i = 0; i < array.length; i++) {
            if (countFrequency[i] >= 2) {
                int div = countFrequency[i] / 2;
                count += div;
            }
        }
        System.out.println(count);

        int[] array3 = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < countFrequency[i]; j++) {
                array3[i] = array[i];
            }
        }
    }


    // Driver Code
    public static void main(String[] args) {

        int arr[] = new int[]{6, 10, 11, 12, 12, 15, 16, 18, 18, 45, 56, 56, 94};
        int n = arr.length;


        findDuplicateArray(arr);

    }
}







