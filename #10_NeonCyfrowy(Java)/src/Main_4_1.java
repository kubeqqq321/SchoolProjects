import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main_4_1 {

    public static void main(String[] args) throws FileNotFoundException {

        //There paste a path name to file which you want to open
        File file = new File("przyklad.txt");
        Scanner scanner  = new Scanner(file);

        /**
         * This loop shows all line from file
         */
        while (scanner.hasNextLine()){
            System.out.println(scanner.nextLine());
        }

        int odp1=0;
        String s;
        char c;

        for (int nr = 0; nr < 20; nr++) {
            scanner.
        }

    }

}
