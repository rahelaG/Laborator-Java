package ex3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) throws FileNotFoundException {

        String file="src/ex3/in.txt";
        Scanner reader=new Scanner(new FileReader(file));
        Scanner scanner=new Scanner(System.in);

        String sir=reader.nextLine();
        StringBuilder sb=new StringBuilder(sir);
        System.out.println("Dati sirul pe care vreti sa il inserati:");
        String sirInserat=scanner.nextLine();
        System.out.println("Introduceti pozitia unde vreti sa inserati:");
        int pozIns=scanner.nextInt();
        scanner.nextLine();
        sb.insert(pozIns,sirInserat);
        System.out.println("Dupa inserare"+ sb);

        System.out.println("Dati pozitia de la care doriti stergerea:");
        int pozSters=scanner.nextInt();
        scanner.nextLine();
        System.out.println("Dati cate caractere vreti sa stergeti");
        int carSters=scanner.nextInt();
        scanner.nextLine();
        sb.delete(pozSters, pozSters + carSters);
        System.out.println("Dupa stergere: "+ sb);


    }
}
