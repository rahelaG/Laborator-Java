package ex1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class ex1 {

    static void afisare(String[] vector, int nr){
        int count=0;
        while(count<nr){
            System.out.println((count+1)+" "+vector[count]);
            count++;
        }

    }
    public static void main(String[] args) throws FileNotFoundException {
        String fileIn="C:\\Laboratoare Java\\Laborator 2\\Laborator2\\src\\ex1\\judete_in.txt";
        Scanner reader=new Scanner(new FileReader(fileIn));
        Scanner scanner=new Scanner(System.in);

        //creare vector
        String[] vector=new String[100];
        int count=0;
        //punere judete in vector
        while(reader.hasNextLine()){
            String line=reader.nextLine();
            vector[count]=line;
            System.out.println(vector[count]);
            count++;
        }
        //sortare
        System.out.println("Vectorul sortat este:");
        Arrays.sort(vector,0,count);
        afisare(vector, count);

        //pozitie judet
        System.out.println("Dati un judet:");
        String judet=scanner.nextLine();
        System.out.println("Ati selectat judetul "+judet);

        int poz=Arrays.binarySearch(vector,0,count,judet);
        System.out.println("Judetul "+" a fost gasit pe pozitia "+poz);

    }
}
