package ex1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;


public class MainApp {

    public static void scriere(Map<Integer, Carte> carti) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File("src/main/resources/carti.json");
            mapper.writeValue(file, carti);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<Integer, Carte> citire() {
        try {
            File file = new File("src/main/resources/carti.json");
            ObjectMapper mapper = new ObjectMapper();
            Map<Integer, Carte> carti = mapper
                    .readValue(file, new TypeReference<Map<Integer, Carte>>() {
                    });
            return carti;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        var carti = citire();
        //inserare
        carti.put(7, new Carte("Ion", "Liviu Rebreanu", 1920));
        // scriere(carti);
        //afisare
//        for(var e:carti.entrySet()){
//            System.out.println("ID: "+e.getKey()+" -> "+e.getValue());
//        }
        var carti2 = carti.entrySet();
        var i = carti2.iterator();
        while (i.hasNext()) {
            var it = i.next();
            if (it.getKey() == 7) {
                i.remove();
            } else {
                System.out.println("ID: " + it.getKey() + " -> " + it.getValue());
            }
        }
        carti.putIfAbsent(8, new Carte("Moara cu noroc", "Ioan Slavici", 1881));
        scriere(carti);
        System.out.println();

        var i2 = carti2.iterator();

        while (i2.hasNext()) {
            var entry = i2.next();
            if (entry.getKey() == 8)
                System.out.println("ID: " + entry.getKey() + "-> " + entry.getValue());
        }

        Set<Carte> cartiSet = new HashSet<Carte>(carti.values());
        cartiSet
                .stream()
                .filter(c -> c.autorul().equalsIgnoreCase("Yuval Noah Harari"))
                .forEach(System.out::println);

        System.out.println();
        cartiSet
                .stream()
                .sorted((c1, c2) -> c1.titlul().compareToIgnoreCase(c2.titlul()))
                .forEach(System.out::println);
        System.out.println();

        cartiSet
                .stream()
                .min(Comparator.comparingInt(Carte::anul))
                .ifPresent(c -> System.out.println("Cea mai veche carte: " + c));


    }
}
