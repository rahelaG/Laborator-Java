package ex1;

public class Imprimanta extends Echipament{
    private int ppm;
    private String rezolutie;
    private int p_car;
    private ModTiparire tiparire;

    public Imprimanta(String denumire, int nr_inv, double pret, String zona_mag, Stare stare,
            int ppm, String rezolutie, int p_car, ModTiparire tiparire) {
        super(denumire, nr_inv, pret, zona_mag, stare);
        this.ppm = ppm;
        this.rezolutie = rezolutie;
        this.p_car = p_car;
        this.tiparire = tiparire;
    }

    public void setTiparire(ModTiparire tiparire) {
        this.tiparire = tiparire;
    }

    @Override
    public String toString() {
        return "Imprimanta{" +
                "ppm=" + ppm +
                ", rezolutie='" + rezolutie + '\'' +
                ", p_car=" + p_car +
                ", tiparire=" + tiparire +
                ", denumire='" + denumire + '\'' +
                ", nr_inv=" + nr_inv +
                ", pret=" + pret +
                ", zona_mag='" + zona_mag + '\'' +
                ", stare=" + stare +
                '}';
    }
}
