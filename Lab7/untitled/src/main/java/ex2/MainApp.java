package ex2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;




public class MainApp {


        public static void scriere(Set<InstrumentMuzical> instrumente) {
            try {
                ObjectMapper mapper = new ObjectMapper();
                mapper.activateDefaultTyping(mapper.getPolymorphicTypeValidator());
                File file = new File("src/main/resources/instrumente.json");
                mapper.writeValue(file, instrumente);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    public static Set<InstrumentMuzical> citire() {
        try {
            File file=new File("src/main/resources/instrumente.json");
            ObjectMapper mapper=new ObjectMapper();
            Set<InstrumentMuzical> instrumente2 = mapper
                    .readValue(file, new TypeReference< Set<InstrumentMuzical>>(){});
            return instrumente2;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Set<InstrumentMuzical> instrumente=new HashSet<InstrumentMuzical>();
        instrumente.add(new Chitara("HB",2900, TipChitara.ACUSTICA,6));
        instrumente.add(new Chitara("Ibanez",7000, TipChitara.ELECTRICA,5));
        instrumente.add(new Chitara("Fender",1000, TipChitara.CLASICA,6));

        instrumente.add(new SetTobe("Yamaha",2900, TipTobe.ACUSTICE,5,3));
        instrumente.add(new SetTobe("HB",4500, TipTobe.ELECTRONICE,6,2));
        instrumente.add(new SetTobe("HB",5900, TipTobe.ACUSTICE,6,3));
        instrumente.forEach(System.out::println);
        scriere(instrumente);

        System.out.println();
        var instrumente2=citire();
        instrumente2.forEach(System.out::println);


        System.out.println("Implementarea pentru set este:"+instrumente2.getClass().getName());
        System.out.println();
        boolean aduagat=instrumente.add(new SetTobe("HB",5900, TipTobe.ACUSTICE,6,3));

        if(aduagat){
            System.out.println("Colectia permite duplicate!");
        }
        else{
            System.out.println("Colectia nu permite duplicate!");
        }

        System.out.println();
        instrumente2.removeIf(i->i.getPret()>3000);
        instrumente2.forEach(System.out::println);

        System.out.println();
        instrumente2
                .stream()
                .filter((i)->i instanceof Chitara)
                .forEach(System.out::println);

        System.out.println();
        instrumente2
                .stream()
                .filter((i)->i.getClass()== Chitara.class)
                .forEach(System.out::println);

        System.out.println();
        instrumente2
                .stream()
                .filter(i->i instanceof Chitara)
                .map(i-> (Chitara) i)
                .max(Comparator.comparingInt(Chitara::getNr_corzi))
                .ifPresent(i-> System.out.println(i));

        System.out.println();
        instrumente2
                .stream()
                .filter(i->i instanceof SetTobe)
                .map(i->(SetTobe) i)
                .sorted(Comparator.comparingInt(SetTobe::getNr_tobe))
                .forEach(System.out::println);

    }
}
