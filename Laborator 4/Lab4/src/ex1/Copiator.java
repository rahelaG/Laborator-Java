package ex1;

public class Copiator extends Echipament{
    private int p_ton;
    private FormatCopiere format;

    public Copiator(String denumire, int nr_inv, double pret, String zona_mag, Stare stare, int p_ton, FormatCopiere format) {
        super(denumire, nr_inv, pret, zona_mag, stare);
        this.p_ton = p_ton;
        this.format = format;
    }

    public void setFormat(FormatCopiere format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return "Copiator{" +
                "p_ton=" + p_ton +
                ", format=" + format +
                ", denumire='" + denumire + '\'' +
                ", nr_inv=" + nr_inv +
                ", pret=" + pret +
                ", zona_mag='" + zona_mag + '\'' +
                ", stare=" + stare +
                '}';
    }
}
