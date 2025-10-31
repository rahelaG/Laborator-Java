package lab3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class lab3 {
    public static void main(String[] args) throws FileNotFoundException {
        String fileIn = "src/lab3/in.txt";
        Scanner scanner = new Scanner(new FileReader(fileIn));
        List<Parabola> parabole = new ArrayList<Parabola>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (!line.isEmpty()) {
                String[] parts = line.split(",");
                int a = Integer.parseInt(parts[0]);
                int b = Integer.parseInt(parts[1]);
                int c = Integer.parseInt(parts[2]);
                parabole.add(new Parabola(a, b, c));
            }
        }
        System.out.println("----Afisare parabole si varfuri----");
        for (Parabola p : parabole) {
            double[] varf = p.varf();
            System.out.println("Parabola " + p.toString());
            System.out.println("Are urmatorul varf: " + varf[0] + ", " + varf[1]);
        }
        System.out.println("------------");

        System.out.println("Coordonatele mijlocului seg. care uneste varfurile primelor 2 parabole sunt:");
        Parabola p1 = parabole.get(0);
        Parabola p2 = parabole.get(1);
        double[] mijloc = p1.mijloc(p2);
        System.out.println(mijloc[0] + " " + mijloc[1]);

        System.out.println("-------------");
        System.out.println("-||- prin metoda statica sunt:");
        double[] mijlocStatic = Parabola.mijlocStatic(p1, p2);
        System.out.println(mijlocStatic[0] + " " + mijlocStatic[1]);

        System.out.println("-------------");
        System.out.println("Lungimea segmentului care uneste varfurile primelor doua parabole este:");
        double ls = p1.lungimeSegment(p2);
        System.out.println(ls);

        System.out.println("-------------");
        System.out.println("-||- prin metoda statica sunt:");
        double lsStatic = Parabola.lungimeSegmentStatic(p1, p2);
        System.out.println(lsStatic);

    }
}
