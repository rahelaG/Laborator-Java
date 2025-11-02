package ex1;

import java.io.*;
import java.util.List;

public class SerializareEchipamente {

    // metoda de scriere (serializare)
    public static void scrieEchipamente(List<Echipament> lista, String fis) {
        try {
            FileOutputStream f = new FileOutputStream(fis);
            ObjectOutputStream oos = new ObjectOutputStream(f);
            oos.writeObject(lista);   // scriem întreaga listă
            oos.close();
            f.close();
            System.out.println("Echipamentele au fost serializate in " + fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // metoda de citire (deserializare)
    @SuppressWarnings("unchecked")
    public static List<Echipament> citesteEchipamente(String fis) {
        try {
            FileInputStream f = new FileInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(f);
            List<Echipament> lista = (List<Echipament>) ois.readObject();
            ois.close();
            f.close();
            System.out.println("Echipamentele au fost citite din " + fis);
            return lista;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
