/**
 * @author Sylwia Cieślak
 */

public class SzukajNajm {

    public static void main(String[] args) {

        //Definiujemy tablice nieposortowana
        int [] Array = new int [] {12,14,17,9,7,4,13,57,89,45,6,3,26,73,14,65,2,1,6,7,5,434,654,234,543,53,2,6,754,32,6,7};

        System.out.println("");
        for(int i:Array){
            System.out.print(i + ", ");
        }

        //Definiujemy min number który jest pierwszym elementem naszej tablicy
        int minNumber = Array[0];

        //Pętla po wszytskich elementach w tablicy
        for (int i = 0; i < Array.length; i++) {
            //Sprawdzamy elementy w tablicy, jeśli Array[i] < minNumber (czyli w naszym przypadku liczby 12)
            //to wtedy przypisujemy do minNumber wartość mniejszą która występuje dalej w tablicy ( będzie to 9)
            //jeśli minNumber będzie najmniejszą znalezioną liczbą wypisujemy ją.
            if(Array[i] < minNumber)
                minNumber = Array[i];
        }
        System.out.println("\nSmallest element: " + minNumber);
    }
}




