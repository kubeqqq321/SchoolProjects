import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        String path = "przyklad.txt";
        String line = "";
        Stack<String> stack = new Stack<String>();


        try {

            BufferedReader br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {

                String[] values = line.split(" ");
                System.out.println( values[0]+ " " + values[1]);
                //values[0] = DOPISZ ,USUN ,PRZESUN ,ZMIEN 1 kolumna
                //values[1] = litery lub cyfry 2 kolumna

                switch (values[0]) {
                    case "DOPISZ": // dodajemy elementy do Stack
                        stack.push(values[1]);

                        break;
//                    case "USUN":  //usuwamy ostatnio dodany element
//                        if (values[1].equals("1"))
//                            stack.pop();
//                        break;
                    case "PRZESUN":  //

                        break;
//                    case "ZMIEN":  //zamieniamy ostatnio dodany element z innym podanym
//
//                        stack.pop();
//                        stack.push(values[1]);
//
//                        break;
                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(stack);
    }

}


