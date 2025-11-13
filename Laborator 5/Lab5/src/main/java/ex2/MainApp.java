package ex2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import exemplul1.Persoana;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class MainApp {

    public static void scriere(List<PerecheNumere> lista) {
        try {
            ObjectMapper mapper=new ObjectMapper();
            File file=new File("src/main/resources/perechiNumere.json");
            mapper.writeValue(file,lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<PerecheNumere> citire() {
        try {
            File file=new File("src/main/resources/perechiNumere.json");
            ObjectMapper mapper=new ObjectMapper();
            List<PerecheNumere> perechi = mapper
                    .readValue(file, new TypeReference<List<PerecheNumere>>(){});
            return perechi;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        List<PerecheNumere> perechi=citire();
        //System.out.println(perechi);
        System.out.println("Afisare perechi");
        for(PerecheNumere p:perechi){
            System.out.println(p);
        }
        //perechi.add(new PerecheNumere(28,33));
        //scriere(perechi);

        List<PerecheNumere> finConsPerechi=perechi.stream()
                .filter(PerecheNumere::consFib)
                .collect(Collectors.toList());

        System.out.println();
        System.out.println("-----Medtoda 1------");
        System.out.println("Perechile care sunt numere consecutive in sirul lui Fibonacci sunt:");
        finConsPerechi.forEach(System.out::println);



        System.out.println();
        System.out.println("-----Medtoda 2------");
        System.out.println("Cmmmc pentru fiecare pereche");
        perechi.forEach(p -> System.out.println(p+" cmmmc: "+ p.Cmmmc()));

        System.out.println();
        System.out.println("-----Medtoda 3------");
        System.out.println("Perechile care au suma numerelor egale:");

        //perechi.add(new PerecheNumere(23,41));
        List<PerecheNumere> perechisumaCif=perechi.stream()
                .filter(PerecheNumere::sumCifEgale)
                .collect(Collectors.toList());
        perechisumaCif.forEach(System.out::println);

        System.out.println();
        System.out.println("-----Metoda 4-----");
        System.out.println("Perechile care au acelasi numar de nr pare sunt:");

        List<PerecheNumere> perechiParEgale=perechi.stream()
                        .filter(PerecheNumere::sumPareEgale)
                .collect(Collectors.toList());
        perechiParEgale.forEach(System.out::println);


        scriere(perechi);



        }


    }

