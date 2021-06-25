//import java.util.ArrayList;
//import java.util.Random;
//
//public class GameOfLife {
//    // determine the shell window columns by doing
//    // $ tput cols
//    // cols / 3 should be the grid param
//    private static final int COLUMNS = 20;
//    private static final int ROWS = 20;
//
//    private static final boolean SHOW_GENERATION = false;
//
//    private static final int MILLISECS = 50;
//
//    // alive cell character
//    private static final String LIFE = "●";
//    // trails of the dead cell
//    private static final String DEATH = ":";
//    private static final String NOTH = " ";
//
//    public static void main(String... args) {
//        String[][] mainGrid = generateGrid(COLUMNS, ROWS);
//
//        int generationCounter = 0;
//
//        boolean cloningGridAlternation = false;
//        boolean isGridStuck = false;
//        String[][] stuckGridClone = copyGrid(mainGrid);
//
//        while(true) {
//            clearScreen();
//            printGrid(mainGrid);
//
//            if (SHOW_GENERATION)
//                System.out.print("Gen " + (generationCounter++) + " ");
//
//            String[][] nextGenGrid = copyGrid(mainGrid);
//
//            for (int i = 0; i < mainGrid.length; i++) {
//                for (int j = 0; j < mainGrid[i].length; j++) {
//
//                    int lifeForms = 0;
//
//                    ArrayList<String> neighbors = new ArrayList<String>();
//
//                    // find the neighbor cells to the current one.
//                    // the grid closes in itself due to the modulus operator
//                    neighbors.add(mainGrid[Math.floorMod(i - 1, mainGrid.length)][Math.floorMod(j - 1, mainGrid[i].length)]);
//                    neighbors.add(mainGrid[Math.floorMod(i - 1, mainGrid.length)][j]);
//                    neighbors.add(mainGrid[Math.floorMod(i - 1, mainGrid.length)][Math.floorMod(j + 1, mainGrid[i].length)]);
//                    neighbors.add(mainGrid[i][Math.floorMod(j - 1, mainGrid[i].length)]);
//                    neighbors.add(mainGrid[i][Math.floorMod(j + 1, mainGrid[i].length)]);
//                    neighbors.add(mainGrid[Math.floorMod(i + 1, mainGrid.length)][Math.floorMod(j - 1, mainGrid[i].length)]);
//                    neighbors.add(mainGrid[Math.floorMod(i + 1, mainGrid.length)][j]);
//                    neighbors.add(mainGrid[Math.floorMod(i + 1, mainGrid.length)][Math.floorMod(j + 1, mainGrid[i].length)]);
//
//                    if (mainGrid[i][j].compareTo(DEATH) == 0) {
//                        nextGenGrid[i][j] = NOTH;
//                    }
//
//                    for (int k = 0; k < neighbors.size(); k++)
//                        if (neighbors.get(k).compareTo(LIFE) == 0)
//                            lifeForms += 1;
//
//                    if (mainGrid[i][j].compareTo(DEATH) == 0 ||
//                            mainGrid[i][j].compareTo(NOTH) == 0) {
//                        // check if I can spawn a new cell
//                        if (lifeForms == 3) {
//                            nextGenGrid[i][j] = LIFE;
//                        }
//                    } else { // else current cell lives
//                        // check if cell must die of over-population or under-population
//                        if (lifeForms < 2 || lifeForms > 3) {
//                            nextGenGrid[i][j] = DEATH;
//                        }
//                    }
//                }
//            }
//
//            if (cloningGridAlternation) {
//                isGridStuck = isSameGrid(mainGrid, stuckGridClone);
//
//                if (!isGridStuck)
//                    stuckGridClone = copyGrid(mainGrid);
//            }
//
//
//            if (isGridStuck) {
//                mainGrid = generateGrid(COLUMNS, ROWS);
//                generationCounter = 0;
//            } else {
//                // copy grid with new generations to the one
//                // previously created
//                mainGrid = copyGrid(nextGenGrid);
//            }
//
//            // wait n milliseconds before repeating the loop
//            try {
//                Thread.sleep(1000);
//            } catch(InterruptedException ex) {
//                Thread.currentThread().interrupt();
//            }
//
//            cloningGridAlternation = !cloningGridAlternation;
//        }
//    }
//
//    private static boolean isSameGrid(String[][] firstGrid, String[][] secondGrid) {
//        boolean sameGrid = true;
//
//        for (int i = 0; i < firstGrid.length; i++)
//            for (int j = 0; j < firstGrid[i].length; j++)
//                if (firstGrid[i][j].compareTo(secondGrid[i][j]) != 0)
//                    sameGrid = false;
//
//        return sameGrid;
//    }
//
//    private static String[][] copyGrid(String[][] grid) {
//        String[][] tempGrid = new String[grid.length][grid[0].length];
//
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[i].length; j++) {
//                tempGrid[i][j] = grid[i][j];
//            }
//        }
//
//        return tempGrid;
//    }
//
//    public static String[][] generateGrid(int width, int height) {
//        String[][] randomGrid = new String[height][width];
//        Random rand = new Random();
//
//        for (int i = 0; i < randomGrid.length; i++) {
//            for (int j = 0; j < randomGrid[i].length; j++) {
//                boolean god = rand.nextBoolean();
//
//                if (god)
//                    randomGrid[i][j] = LIFE;
//                else
//                    randomGrid[i][j] = DEATH;
//            }
//        }
//
//        return randomGrid;
//    }
//
//    private static void clearScreen() {
//        for(int i = 0; i < 100; i++)
//            System.out.println();
//    }
//
//    public static void printGrid(String[][] matrix) {
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++) {
//                System.out.print(" " + matrix[i][j] + " ");
//            }
//
//            if ((i+1) == matrix.length && !SHOW_GENERATION)
//                System.out.print("");
//            else
//                System.out.println();
//        }
//    }
//}
//



/**
 * @author Sylwia Cieślak
 */

import java.util.Scanner;

public class GameOfLife {

    // stałe symbolizujące żywą i martwą komórkę
    private final char ZYWA = '#';
    private final char MARTWA = '.';
    // pola przechowujące rozmiar naszej planszy
    private int wiersze;
    private int kolumny;
    // deklaracja macierzy z planszą gry
    private boolean[][] plansza;

    // konstruktor, podajemy liczbę wierszy i kolumn planszy
    public GameOfLife(int wiersze, int kolumny) {
        // inicjalizujemy pola naszej klasy
        this.wiersze = wiersze;
        this.kolumny = kolumny;
        // tworzymy odpowiednią macierz, domyślnie wypełniona jest ona wartościami false
        plansza = new boolean[wiersze][kolumny];
    }

    // metoda pokazująca planszę na ekranie
    public void pokazPlansze(){
        // wyświetlamy każdy element planszy, w zależności od zawartości na ekranie pojawi się odpowiedni znak
        for(boolean[] wiersz : plansza){
            for(boolean element : wiersz)
                System.out.print((element) ? ZYWA : MARTWA);
            System.out.println();
        }
    }

    // przykładowa metoda uzupełniająca planszę populacją początkową
    public void utworzDaneTestowe() {
        // tworzymy populację początkową (standardowy Exploder)
        plansza[5][5] = true; plansza[5][7] = true; plansza[5][9] = true;
        plansza[6][5] = true; plansza[6][9] = true;
        plansza[7][5] = true; plansza[7][9] = true;
        plansza[8][5] = true; plansza[8][9] = true;
        plansza[9][5] = true; plansza[9][7] = true; plansza[9][9] = true;
    }

    // metoda zwraca liczbę żywych sąsiadów konkretnej komórki
    // w wywołaniu podajemy współrzędne komórki
    private int liczbaSasiadow(int x, int y) {

        // zmienna przechowująca liczbę sąsiadów
        int sasiedzi = 0;

        // sprawdzamy komórki na około naszej
        for(int i = x-1; i <= x+1; i++) {
            // jeżeli przekraczamy zakres planszy (wiersz) idziemy dalej
            if(i < 0 || i > wiersze-1) continue;
            for(int j = y-1; j <= y+1; j++) {
                // jeżeli przekraczamy zakres planszy (kolumna), lub jesteśmy w komórce(x,y) idziemy dalej
                if(j < 0 || j > kolumny-1 || (i == x && j == y)) continue;
                // jeśli sąsiad jest żywy to zwiększamy naszą zmienną
                if(plansza[i][j]) sasiedzi++;
            }
        }
        // zwracamy zmienną
        return sasiedzi;
    }

    // metoda sprawdza czy dana komórka będzie żywa czy też martwa w następnym etapie
    // w wywołaniu podajemy współrzędne komórki
    private boolean ewolucja(int x, int y) {

        // sprawdzamy liczbę żywych sąsiadów
        int sasiedzi = liczbaSasiadow(x, y);

        // jeżeli nasza komórka jest żywa
        if(plansza[x][y]) {
            // jeśli liczba sąsiadów jest mniejsza lub równa jeden lub większa od trzech to nasza komórka będzie martwa
            if(sasiedzi <= 1 || sasiedzi > 3) return false;
            // jeśli liczba sąsiadów jest równa trzy lub dwa to nasza komórka będzie żywa
            if(sasiedzi == 3 || sasiedzi == 2) return true;
        } else {
            // jeśli nasza komórka jest martwa i ma dokładnie trzech żywych sąsiadów to będzie żyła
            if(sasiedzi == 3) return true;
        }
        // w każdym innym przypadku zwracamy fałsz (komórka jest martwa)
        return false;
    }

    // metoda tworzy następną populację/pokolenie komórek
    public void nastepnePokolenie() {
        // tworzymy planszę tymczasową o takim samy rozmiarze jak nasza
        boolean[][] planszaTymczasowa = new boolean[wiersze][kolumny];

        // uzupełniamy nową planszę wartościami na podstawie ogólnych zasad
        for(int i = 0; i < wiersze; i++)
            for(int j = 0; j < kolumny; j++)
                planszaTymczasowa[i][j] = ewolucja(i, j);

        // nasza główna plansza staje się planszą tymczasową
        plansza = planszaTymczasowa;
    }

    public static void main(String[] args) {

        // wyświetlamy napisy informacyjne
        System.out.println("Gra w życie - [Enter] generuje następne pokolenie, dowolny znak i [Enter] kończy grę.");

        // obsługujemy wejście
        Scanner sc = new Scanner(System.in);

        // tworzymy nowy obiekt przekazując do konstruktora rozmiar planszy
        GameOfLife gra = new GameOfLife(15, 15);
        // wypełniamy naszą planszę wartościami testowymi
        gra.utworzDaneTestowe();
        // wyświetlamy planszę na ekranie
        gra.pokazPlansze();

        // dopóki użytkownik będzie naciskał klawisz Enter
        while(sc.nextLine().equals("")) {
            // generujemy następne pokolenie
            gra.nastepnePokolenie();
            // wyświetlamy go na ekranie
            gra.pokazPlansze();
        }
    }
}


//najlepsze jezt chyba to
//package conway;

//import java.util.*;
//        import java.io.*;
//
//public class GameOfLife
//{
//    //Set grid size
//    int l=20,b=60;
//    public static void main(String[] args)
//    {
//
//        GameOfLife now=new GameOfLife();
//        now.setGame();
//    }
//    void setGame()
//    {
//        char[][] config=new char[l][b];
//        startGame(config,l,b);
//    }
//    void startGame(char[][] mat,int l, int b)
//    {
//        Scanner s=new Scanner(System.in);
//        String ch="";
//        float per=0;
//        while(!ch.equals("y"))
//        {
//            per=setConfig(mat);
//            //setCustomConfig(mat,"GOLglidergun.txt");
//            display2D(mat);
//            System.out.println((per*100)+"% of grid filled.");
//            System.out.println("Begin? y/n");
//            ch=s.nextLine();
//        }
//        while(!ch.equals("x"))
//        {
//            mat=transform(mat,l,b);
//            display2D(mat);
//
//            System.out.println("Ctrl+Z to stop.");
//
//            try
//            {
//                Thread.sleep(1000);
//            }
//            catch(Exception e)
//            {
//                System.out.println("Something went horribly wrong.");
//            }
//
//            //ch=s.nextLine();
//        }
//        s.close();
//        System.out.println("Game Over");
//    }
//
//    char[][] transform(char[][] mat,int l, int b)
//    {
//
//        char[][] newmat=new char[l][b];
//        for(int i=0;i<l;i++)
//            for(int j=0;j<b;j++)
//                newmat[i][j]=flip(mat,i,j);
//        return newmat;
//    }
//    char flip(char[][] mat,int i, int j)
//    {
//        int count=around(mat,i,j);
//        if(mat[i][j]=='*')
//        {
//            if(count<2||count>3)
//                return '_';
//            return '*';
//        }
//        else
//        {
//            if(count==3)
//                return '*';
//            return '_';
//        }
//    }
//    int around(char[][] mat, int i, int j)
//    {
//        int count=0;
//        for(int x=i-1;x<=i+1;x++)
//            for(int y=j-1;y<=j+1;y++)
//            {
//                if(x==i&&y==j)
//                    continue;
//                count+=eval(mat,x,y);
//            }
//        return count;
//    }
//    int eval(char[][] mat, int i, int j)
//    {
//        if(i<0||j<0||i==l||j==b)
//            return 0;
//        if(mat[i][j]=='*')
//            return 1;
//        return 0;
//    }
//
//    float setCustomConfig(char[][] arr,String infile)
//    {
//        try
//        {
//            BufferedReader br=new BufferedReader(new FileReader(infile));
//            String line;
//            for(int i=0;i<arr.length;i++)
//            {
//                line=br.readLine();
//                for(int j=0;j<arr[0].length;j++)
//                    arr[i][j]=line.charAt(j);
//            }
//            br.close();
//        }
//        catch(Exception e)
//        {
//            System.out.println(e.getMessage());
//        }
//        return 0;
//    }
//
//    float setConfig(char[][] arr)
//    {
//        //Enter percentage of grid to be filled.
//        float per=(float)Math.random();
//        for(int i=0;i<arr.length;i++)
//            setConfig1D(arr[i],per);
//        return per;
//    }
//    void setConfig1D(char[] arr,float per)
//    {
//        for(int i=0;i<arr.length;i++)
//        {
//            if(Math.random()<per)
//                arr[i]='*';
//            else
//                arr[i]='_';
//        }
//    }
//    void display2D(char[][] arr)
//    {
//        for(int i=0;i<arr.length;i++)
//            display1D(arr[i]);
//        System.out.println();
//    }
//    void display1D(char[] arr)
//    {
//        for(int i=0;i<arr.length;i++)
//            System.out.print(arr[i]);
//        System.out.println();
//    }
//}


