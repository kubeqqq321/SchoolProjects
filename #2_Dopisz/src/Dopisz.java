
import java.util.ArrayList;


import java.util.*;
import java.util.Vector;
import java.util.HashSet;
import java.util.Set;

import java.util.Scanner;
import java.util.Arrays;
/**
 * @author Sylwia Cieślak
 */

class Dopisz
{
    public static void main (String Args[])
    {
         int[] Tab = new int[]{6, 8, 14, 11, 14, 18, 46, 59, 88, 97,0};

        System.out.println("Tablica bez dodanych elementów: ");
        System.out.println(Arrays.toString(Tab)); //Wyswietlenie tablicy jako String

        Scanner scanner = new Scanner(System.in);
        System.out.printf("Podaj liczbe calkowita, ktora chcesz dodac do tablicy: ");
       int Dopisywanie =  scanner.nextInt();

        DodajDoTablicy(Tab , Dopisywanie); // (Tablica , Wartość którą chcemy dodać do tablicy )
    }//main

     static void DodajDoTablicy(int[] TAB2, int val)
     {
        int i = 0;
        while (i < TAB2.length - 1 && TAB2[i] < val) //znajdowanie pozycji wstawienie -> i
        { i++; }

        if (i < TAB2.length - 1)    // przesunięcie 1 elementu w prawo (ignoruje osotni element)
        {System.arraycopy(TAB2, i, TAB2, i + 1, TAB2.length - i - 1);}

        TAB2[i] = val;  //dodanie elementu
        System.out.println("Tablica z dodanym elementem: ");
        System.out.println(Arrays.toString(TAB2));
    }
}//Dopisz



 class Test {

    public static void main(String[] args) {
        int[] yourInitialArray = {6,8,11,14,14,18,46,59,88,97,0,0,0,0,0};

        // Creating a temporary ArrayList
        ArrayList<Integer> temporary = new ArrayList<Integer>();
        for (int i = 0; i < yourInitialArray.length; i++) {
            if (i != 0) {
                temporary.add(yourInitialArray[i]);
            } else {
                temporary.add(91);
                temporary.add(yourInitialArray[i]);
            }
        }
        yourInitialArray = new int[temporary.size()];
        for (int j = 0; j < temporary.size(); j++) {
            yourInitialArray[j] = temporary.get(j);
            System.out.println(yourInitialArray[j]);
        }

    }
}





// Java program to insert an
// element in a sorted array

class Main {
    // Inserts a key in arr[] of given
    // capacity.  n is current size of arr[].
    // This function returns n+1 if insertion
    // is successful, else n.
    static int insertSorted(int arr[], int n, int key, int capacity)
    {
        // Cannot insert more elements if n is already
        // more than or equal to capcity
        if (n>= capacity)
            return n;

        int i;
        for (i = n - 1; (i >= 0 && arr[i] > key); i--)
            arr[i + 1] = arr[i];

        arr[i + 1] = key;

        return (n + 1);
    }

    /* Driver program to test above function */
    public static void main(String[] args)
    {
        //int arr[] = new int[20];

       int arr[] = {2,4,6,8,11,13,14,14,15,18,36,40,46,59,61,67,88,97,99,999,1500,2031,0};

        int capacity = arr.length;
        int n = capacity-1;
        int key =1000;

        System.out.print("\nBefore Insertion: ");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");

        // Inserting key
        n = insertSorted(arr, n, key, capacity);

        System.out.print("\nAfter Insertion: ");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");



    }

}




// Java Program to add an element in an Array



class GFGop {

    // Function to add x in arr
    public static int[] addX(int n, int arr[], int x)
    {
        int i;

        // create a new array of size n+1
        int newarr[] = new int[n + 1];

        // insert the elements from
        // the old array into the new array
        // insert all elements till n
        // then insert x at n+1
        for (i = 0; i < n; i++)
            newarr[i] = arr[i];

        newarr[n] = x;

        return newarr;
    }

    // Driver code
    public static void main(String[] args)
    {

        int n = 10;
        int i;

        // initial array of size 10
        int arr[]
                = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        // print the original array
        System.out.println("Initial Array:\n"
                + Arrays.toString(arr));

        // element to be added
        int x = 2;

        // call the method to add x in arr
        arr = addX(n, arr, x);

        // print the updated array
        System.out.println("\nArray with " + x
                + " added:\n"
                + Arrays.toString(arr));
    }
}





class SearchTest {
    public static void main(String args[]) throws Exception {
        int array[] = {6,8,11,14,14,18,46,59,88,97,0,0,0,0,0,0};

        // Ensure array sorted
        Arrays.sort(array);
        printArray("Sorted array", array);

        // Search for element in array
        int index = Arrays.binarySearch(array, 2);
        System.out.println("Found 2 at " + index);

        // Search for element not in array
        index = Arrays.binarySearch(array, 1);
        System.out.println("Didn't find 1 at " + index);

        // Insert
        int newIndex = -index - 1;
        array = insertElement(array, 98, newIndex);
        printArray("With 1 added", array);

    }

    private static void printArray(String message, int array[]) {
        System.out.println(message + ": [length: " + array.length + "]");

        for (int i = 0, n = array.length; i < n; i++) {
            if (i != 0)
                System.out.print(", ");
            System.out.print(array[i]);
        }
        System.out.println();
    }

    private static int[] insertElement(int original[], int element, int index) {
        int length = original.length;
        int destination[] = new int[length + 1];
        System.arraycopy(original, 0, destination, 0, index);
        destination[index] = element;
        System.arraycopy(original, index, destination, index + 1, length
                - index);
        return destination;
    }
}





 class Insert_Array
{
    public static void main(String[] args)
    {
        int n, pos, x;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter no. of elements you want in array:");
        n = s.nextInt();
        int a[] = {6,8,11,14,14,18,46,59,88,97,0,0,0,0,0};;
        System.out.println("Enter all the elements:");
        for(int i = 0; i < n; i++)
        {
            System.out.println(a[i] + ", ");
        }
        System.out.print("Enter the position where you want to insert element:");
        pos = s.nextInt();
        System.out.print("Enter the element you want to insert:");
        x = s.nextInt();
        for(int i = (n-1); i >= (pos-1); i--)
        {
            a[i+1] = a[i];
        }
        a[pos-1] = x;
        System.out.print("After inserting:");
        for(int i = 0; i < n; i++)
        {
            System.out.print(a[i]+",");
        }
        System.out.print(a[n]);
    }
}

class sort{
    public static int[] insert(int[] a, int k) {
        int[] s = new int[a.length + 1];
        for(int i = 0; i < a.length; i++) {
            if(k < a[i]) {
                s[i] = k;
                for(int j = i + 1; j < s.length; j++) {
                    System.out.println(s[i] + ", ");
                    s[j] = a[i];
                    i++;
                }
                System.out.println(s);
                return s;
            } else {
                s[i] = a[i];
            }
        }
        return s;
    }

    public static void main(String[] args) {

        int a[] = {6,8,11,14,14,18,46,59,88,97,0,0,0,0,0};
        int key = 12;

        insert(a,key);

    }
}


 class AddingItemsDynamically {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array :: ");
        int size = sc.nextInt();
        String myArray[] = new String[size];
        System.out.println("Enter elements of the array (Strings) :: ");
        for(int i=0; i<size; i++) {
            myArray[i] = sc.next();
        }
        System.out.println(Arrays.toString(myArray));
        ArrayList<String> myList = new ArrayList<String>(Arrays.asList(myArray));
        System.out.println("Enter the element that is to be added:");
        String element = sc.next();
        myList.add(element);
        myArray = myList.toArray(myArray);
        System.out.println(Arrays.toString(myArray));
    }
}



// Java program to insert an element in
// an array and then sorting it.

// Importing util files


class Gfgg {

    // Main function
    public static void main(String args[]) throws Exception
    {

        // Given number
        int given_number = 12;

        // Array
        int array[] = {6,8,11,14,14,18,46,59,88,97,0,0,0,0,0};

        // Creating new array with increased size
        int new_array[] = new int[array.length + 1];

        // Copying elements from one array to another
        for (int i = 0; i < array.length; i++) {
            new_array[i] = array[i];
        }

        // Adding new element
        new_array[new_array.length - 1] = given_number;

        // Sorting new array
        //Arrays.sort(new_array);

        // print array
        for (int i = 0; i < new_array.length; i++)
            System.out.print(new_array[i] + " ");
    }
}




 class Gfg {

    // Main function
    public static void main(String args[])
    {

        // Given Number
        int given_number = 99;

        // Array
        int array[] = {6,8,11,14,14,18,46,59,88,97,0,0,0,0};

        // Sort Given array
        //Arrays.sort(array);

        // Creating new array with increased size
        int new_array[] = new int[array.length+1];

        // Copying elements from one
        // array to another as in approach 2
        int i , j = 0;
        for (i = 0; i <= new_array.length; i++) {
            if (given_number <= array[i]) {
                new_array[i] = given_number;
                break;
            }
            else
                new_array[i] = array[j++];
        }

         //copy the remaining elements
        for (int k = i + 1; k < new_array.length; k++)
            new_array[k] = array[j++];

        // print new array
        for (i = 0; i < new_array.length; i++)
            System.out.print(new_array[i] + " ");
    }
}




 class GFGg {

    public static void main(String[] args)
    {

        // using wrapper class here for array,
        // to convert into object
        Integer arr[] = {6,8,11,14,14,18,46,59,88,97};

        Set<Integer> sets = new HashSet<Integer>(Arrays.asList(arr));

        sets.add(5);

        arr = sets.toArray(arr);

        // print the array
        System.out.println(Arrays.toString(arr));
    }
}


class Mainly {
    // Inserts a key in arr[] of given
    // capacity.  n is current size of arr[].
    // This function returns n+1 if insertion
    // is successful, else n.
    static int insertSorted(int arr[], int n, int key, int capacity)
    {
        // Cannot insert more elements if n is already
        // more than or equal to capcity
        if (n >= capacity)
            return n;

        int i;
        for (i = n - 1; (i >= 0 && arr[i] > key); i--)
            arr[i + 1] = arr[i];

        arr[i + 1] = key;

        return (n + 1);
    }

    /* Driver program to test above function */
    public static void main(String[] args)
    {
        int arr[] = new int[20];
        arr = new int[]{6, 8, 11, 14, 14, 18, 46, 59, 88, 97,0,0,0,0,0};
        int capacity = arr.length;
        int n = capacity+1;
        int key = 26;

        System.out.print("\nBefore Insertion: ");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");

        // Inserting key
        n = insertSorted(arr, n, key, capacity);

        System.out.print("\nAfter Insertion: ");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
}






class vector {

    // Main driver method
    public static void main(String[] args)
    {

        // Create an ArrayList
        ArrayList<Integer> ArrList = new ArrayList<Integer>();

        // Adding elements in above ArrayList created
        // Custom inputs
        ArrList.add(1);
        ArrList.add(2);
        ArrList.add(3);
        ArrList.add(4);

        // Dispaly message
        System.out.print("The ArrayList is : ");

        // Display original ArrayList
        System.out.println(ArrList);

        // Creating a vector for elements
        Vector<Integer> vector = new Vector<Integer>();

        // Insert elements in vector
        // Custom inputs
        vector.add(2);
        vector.add(5);
        vector.add(7);

        // Note: Chosen index where added may vary as per
        // req Add vector element in arrayList at 1 index
        ArrList.addAll(1, vector);

        // Display arrayList after insert elements
        // at specific indexchosen above
        System.out.println(
                "List after addition of element at specifc index : ");
        ArrList.sort((Comparator<? super Integer>) vector);

        // Display List after adding element at specific
        // index
        System.out.println(ArrList);
    }
}