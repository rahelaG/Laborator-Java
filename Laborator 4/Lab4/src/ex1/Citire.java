package ex1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Citire {

public static List<Echipament> CitireEchipamente(String fis) throws FileNotFoundException {
    List<Echipament> lista=new ArrayList<>();
    Scanner sc=new Scanner(new FileReader(fis));
    while (sc.hasNextLine()) {
        String v[]=sc.nextLine().split(";");
        String tip=v[5];
        switch(tip.toLowerCase()){
            case "imprimanta":
                lista.add(new Imprimanta(v[0], Integer.parseInt(v[1]), Double.parseDouble(v[2]), v[3],
                        Stare.valueOf(v[4]), Integer.parseInt(v[6]), v[7],
                        Integer.parseInt(v[8]), ModTiparire.valueOf(v[9])));
                break;
            case "copiator":
                lista.add(new Copiator(v[0], Integer.parseInt(v[1]), Double.parseDouble(v[2]), v[3],
                        Stare.valueOf(v[4]),Integer.parseInt(v[6]),FormatCopiere.valueOf(v[7])));
                break;
            case "sistem de calcul":
                lista.add(new SistemCalcul(v[0], Integer.parseInt(v[1]), Double.parseDouble(v[2]), v[3],
                        Stare.valueOf(v[4]),v[6],Integer.parseInt(v[7]),Integer.parseInt(v[8]),SistemOperare.valueOf(v[9])));
                break;
        }
    }
    sc.close();
    return lista;
}
}
