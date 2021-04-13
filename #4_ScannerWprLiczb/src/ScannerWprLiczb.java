import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Sylwia Cieślak
 */

public class ScannerWprLiczb {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<Integer>();
        System.out.println("Prosze podac 10 liczb");

        int sum = 0;
        for(int i=0 ; i<10 ; i++){
            sum = scanner.nextInt();
            arr.add(sum);
        }

        System.out.println(arr);

    }
}
