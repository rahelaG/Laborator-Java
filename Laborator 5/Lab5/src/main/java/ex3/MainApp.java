package ex3;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ex2.PerecheNumere;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {

    public static void scriere(List<Mobilier> mobiliere) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File("src/main/resources/mobilier.json");
            mapper.writeValue(file, mobiliere);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Mobilier> citire() {
        try {
            File file = new File("src/main/resources/mobilier.json");
            ObjectMapper mapper = new ObjectMapper();
            List<Mobilier> mobiliere = mapper
                    .readValue(file, new TypeReference<List<Mobilier>>() {
                    });
            return mobiliere;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
//ex1
        Scanner sc = new Scanner(System.in);
        List<Mobilier> mobiliere = citire();
        //mobiliere.forEach(System.out::println);
//ex2
//        for(Mobilier m:mobiliere){
//            m.afisarePlaci();
//        }
//ex3
//        System.out.println("Dati o piesa de mobilier");
//        String mob=sc.nextLine();
//        for(Mobilier m:mobiliere){
//            if(m.getNume().equalsIgnoreCase(mob)){
//                m.afisarePlaci();
//            }
//        }
//ex4
        System.out.println("Dati o piesa de mobilier");
        String mobi = sc.nextLine();
        for (Mobilier m : mobiliere) {
            if (m.getNume().equalsIgnoreCase(mobi)) {
                System.out.println("Este nevoie de " + m.getNrColiPal() + " coli de pal");
            }

        }


    }
}
