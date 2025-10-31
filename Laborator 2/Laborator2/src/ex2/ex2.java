package ex2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ex2 {
    public static void main(String[] args) throws FileNotFoundException {
        String fileIn="C:\\Laboratoare Java\\Laborator 2\\Laborator2\\src\\ex2\\cantec_in.txt";
        String fileOut="C:\\Laboratoare Java\\Laborator 2\\Laborator2\\src\\ex2\\cantec_out.txt";

        Scanner reader=new Scanner(new FileReader(fileIn));
        PrintStream writer=new PrintStream(fileOut);

        ArrayList<Vers> versuri=new ArrayList();

        while (reader.hasNextLine()) {
            String linie=reader.nextLine();
            if(!(linie.isEmpty())){
                versuri.add(new Vers(linie));
                System.out.println(linie);
            }
        }
        Random rand=new Random();
        String cuvant="fată.";
        for (Vers v:versuri) {
            int nrCuvinte = v.NumarCuvinte();
            int nrVocale = v.NumarVocale();
            double r = rand.nextDouble(0,1);
            v.majuscule(r);
            if (v.ultimCuvant(cuvant)) {
                writer.println(v.linie + " " + nrCuvinte + " cuvinte " + " " + nrVocale + " vocale * "+"nr generat: "+r);
            } else {
                writer.println(v.linie + " " + nrCuvinte + " cuvinte " + " " + nrVocale + " vocale "+"nr generat: "+r);
            }


        }

    }
}
