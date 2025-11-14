package lab6;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class MainApp {

    public static void scriere(List<Angajat> lista) {
        try {
            ObjectMapper mapper=new ObjectMapper();
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            mapper.registerModule(new JavaTimeModule());
            File file=new File("src/main/resources/angajati.json");
            mapper.writeValue(file,lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Angajat> citire() {
        try {
            File file=new File("src/main/resources/angajati.json");
            ObjectMapper mapper=new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            List<Angajat> angajati = mapper
                    .readValue(file, new TypeReference<List<Angajat>>(){});
            return angajati;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        List<Angajat> angajati=new ArrayList<Angajat>();
//        System.out.println(angajati);
//        for(Angajat p:angajati){
//            System.out.println(p);
//        }
        angajati.add(new Angajat("Maria","sef", LocalDate.parse("2017-11-05"),15000));
        angajati.add(new Angajat("Ion","contabil", LocalDate.parse("2013-10-06"),2000));
        angajati.add(new Angajat("Andrei","director", LocalDate.parse("2024-07-09"),18000));
        angajati.add(new Angajat("Mirela","programator", LocalDate.parse("2019-10-21"),7000));
        angajati.add(new Angajat("Mihai","director", LocalDate.parse("2024-07-09"),18000));
        angajati.add(new Angajat("Alex","programator", LocalDate.parse("2020-09-12"),10000));
        scriere(angajati);

        while(true){
            System.out.println("Dati optiunea:");
            int opt=sc.nextInt();
            sc.nextLine();

            switch(opt){
                case 1:
                    angajati.forEach(System.out::println);
                    break;
                case 2:
                    angajati.stream()
                            .filter(a->a.getSalariul()>2500)
                            .forEach(System.out::println);
                    break;
                case 3:
                    int anTrecut=LocalDate.now().getYear()-1;
                    List<Angajat> angajatiAprilie=angajati.stream()
                            .filter(a->a.getData_angajarii().getYear()==anTrecut)
                            .filter(a->a.getData_angajarii().getMonthValue()==4)
                            .filter(a->a.getPost().contains("sef") || a.getPost().contains("director"))
                            .collect(Collectors.toList());

                    angajatiAprilie.forEach(System.out::println);
                    break;
                case 4:
                    angajati.stream()
                            .filter(a->!a.getPost().contains("sef") && !a.getPost().contains("director"))
                            .sorted(Comparator.comparing(Angajat::getSalariul).reversed())
                            .forEach(System.out::println);
                    break;
                case 5:
                    List<String> numeMajuscule=angajati.stream()
                            .map(a->a.getNume().toUpperCase())
                            .collect(Collectors.toList());
                    numeMajuscule.forEach(System.out::println);
                    break;
                case 6:
                    angajati.stream()
                            .filter(a->a.getSalariul()<3000)
                            .map(a->a.getSalariul())
                            .forEach(System.out::println);
                    break;
                case 7:
                    Optional<Angajat> primulAngajat=angajati.stream()
                            .min((a1,a2)->a1.getData_angajarii().compareTo(a2.getData_angajarii()));
                    if(primulAngajat.isPresent()){
                        System.out.println("Primul angajat este:"+primulAngajat.get());
                    }
                    else{
                        System.out.println("Lista e goala!");
                    }
                    break;
                case 8:
                    DoubleSummaryStatistics statistici=angajati.stream()
                            .collect(Collectors.summarizingDouble(a->a.getSalariul()));
                    System.out.println("Salariul minim "+statistici.getMin());
                    System.out.println("Salariul mediu "+ statistici.getAverage());
                    System.out.println("Salariul maxim "+statistici.getMax());
                    break;
                case 9:
                    angajati.stream()
                            .filter(a->a.getNume().contains("Ion"))
                            .findAny()
                            .ifPresentOrElse(
                                    a-> System.out.println("Firma are cel putin un Ion angajat"),
                                    ()-> System.out.println("Firma nu are nici un Ion angajat")
                            );
                    break;
                case 10:
                    long countAng=angajati.stream()
                            .filter(a->a.getData_angajarii().getYear()==LocalDate.now().getYear()-1)
                            .filter(a->a.getData_angajarii().getMonthValue()==6 ||
                                    a.getData_angajarii().getMonthValue()==7 ||
                                    a.getData_angajarii().getMonthValue()==8)
                            .count();
                    System.out.println(countAng);
                    break;



            }
        }
    }
}
