package lab3_ex2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ex2 {
    public static void main(String[] args) throws FileNotFoundException {

        String fileIn = "src/lab3_ex2/produse.csv";
        Scanner scanner = new Scanner(new FileReader(fileIn));
        PrintStream writer = new PrintStream("src/lab3_ex2/out.txt");
        Scanner sc = new Scanner(System.in);

        List<Produs> produse = new ArrayList<Produs>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (!line.isEmpty()) {
                String[] parts = line.split(",");
                String denumire = parts[0];
                float pret = Float.parseFloat(parts[1]);
                int cantitate = Integer.parseInt(parts[2]);
                LocalDate date = LocalDate.parse(parts[3], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                //System.out.println(parts[0]+" "+parts[1]+" "+parts[2]+" "+parts[3]);
                produse.add(new Produs(denumire, pret, cantitate, date));
            }
        }

        System.out.println("----------Afisarea tuturor produselor-----------");
        for (Produs p : produse) {
            System.out.println(p.toString());
        }

        System.out.println("----------Afisarea produselor expirate-----------");
        LocalDate azi = LocalDate.now();
        boolean expirat = false;
        for (Produs p : produse) {
            //System.out.println(p.toString());
            if (p.esteExpirat(azi)) {
                System.out.println("Produsul " + p.toString() + " este expirat!");
                expirat = true;
            }

        }
        if (expirat == false) {
            System.out.println("Nu exista produse expirate!");
        }

        System.out.println("-------Afisare produse pret minim-------");

        float min = produse.get(0).getPret();
        for (Produs p : produse) {
            if (p.getPret() < min)
                min = p.getPret();
        }

        for (Produs p : produse) {
            if (p.getPret() == min)
                System.out.println(p);
        }

        System.out.println("Dati cantitatea:");
        int cantitate = sc.nextInt();
        sc.nextLine();

        for (Produs p : produse) {
            if (p.getCantitate() < cantitate)
                writer.println(p);
        }

        System.out.println("Intrpduceti denumirea produsului:");
        String denumire = sc.nextLine();
        System.out.println("Introduceti cantitatea:");
        int cant = sc.nextInt();
        Produs produsGasit = null;
        for (Produs p : produse) {
            if (p.getDenumire().equalsIgnoreCase(denumire))
                produsGasit = p;
        }

        boolean vandut = produsGasit.vinde(cant);

        if (vandut && produsGasit.getCantitate() == 0) {
            produse.remove(produsGasit);
            System.out.println("Produsul " + produsGasit.getDenumire() + " a fost epuizat si a fost eliminat din stoc");
        }

        System.out.println("Incasari totale pana acum: " + Produs.getIncasari() + " lei");


    }
}
