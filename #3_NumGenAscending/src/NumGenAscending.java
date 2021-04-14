import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Sylwia Cieślak
 */

public class NumGenAscending {

    public static void main(String args[]) {


        Scanner sc = new Scanner(System.in);
        System.out.print("Wprowadz ile chcesz wylosowac liczb: ");
        int amount = sc.nextInt();

        System.out.print("Wprowadz jaka ma być najwieksza liczba: ");
        int max = sc.nextInt();

        generateRandom(amount, max);
    }

    public static int[] generateIncreasingRandoms(int amount, int max) {
        int[] randomNumbers = new int[amount];
        Random random = new Random();
        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = random.nextInt(max);
        }
        // Arrays.sort(randomNumbers);
        return randomNumbers;
    }

    public static int[] generateRandom(int amountElements, int maxValue) {

        int[] randomNumbers = new int[amountElements];
        double delta = maxValue / (float)amountElements;
        Random random = new Random();
        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = (int) Math.round(i*delta + random.nextDouble() * delta);
            System.out.print(randomNumbers[i] + " ");
        }
        return randomNumbers;
    }
}

class ArrayCompleteTask {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array that is to be created::");
        int size = sc.nextInt();
        int[] myArray = new int[size];
        Random random = new Random();

        for(int i = 0; i<size; i++) {
            myArray[i] = random.nextInt(101);
            System.out.println(myArray[i]);
        }

        for(int i = 0; i<size-1; i++) {
            for (int j = i+1; j<myArray.length; j++) {
                if(myArray[i] > myArray[j]) {
                    int temp = myArray[i];
                    myArray[i] = myArray[j];
                    myArray[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(myArray));
    }
}

class RandomExample1
{
    public static void main(String[] args)
    {
        // generate random number
        double a = Math.random();
        double b = Math.random();
        // Output is different every time this code is executed
        System.out.println(a);
        System.out.println((int)Math.round(a));
        System.out.println(b);
    }
}