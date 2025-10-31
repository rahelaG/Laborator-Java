package ex4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        List<Persoana> persoane=new ArrayList<>();

        System.out.println("Dati numarul de persoane:");
        int n=sc.nextInt();
        sc.nextLine();

        for(int i=0;i<n;i++){
            System.out.println("Dati nume:");
            String nume=sc.nextLine();

            String cnp;
            while(true) {
                System.out.println("Dati cnp");
                 cnp = sc.nextLine();
                if(Persoana.cnpValid(cnp))
                    break;
                else
                    System.out.println("Cnp ivalid! Reintroduceti!");
            }
            persoane.add(new Persoana(nume,cnp));
        }
        System.out.println("Persoanele sunt:");
        persoane.forEach(System.out::println);

    }
}
