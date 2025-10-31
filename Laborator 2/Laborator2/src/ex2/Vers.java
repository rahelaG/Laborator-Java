package ex2;

public class Vers {

    String linie;

    public Vers(String linie) {
        this.linie = linie;
    }

    public int NumarCuvinte() {
        int countWords = linie.split("\\s").length;
        return countWords;
    }

    public int NumarVocale() {
        int count = 0;
        for (char c : linie.toLowerCase().toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }
        return count;
    }

    public boolean ultimCuvant(String cuvant) {
        return linie.endsWith(cuvant);
    }

    public void majuscule(double nr) {
        if (nr < 0.1) {
            linie = linie.toUpperCase();
        }
    }



}


