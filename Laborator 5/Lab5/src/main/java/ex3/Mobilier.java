package ex3;

import java.util.List;

public class Mobilier {
    private String nume;
    private List<Placa> placi;

    public Mobilier() {
    }

    public Mobilier(String nume, List<Placa> placi) {
        this.nume = nume;
        this.placi = placi;
    }

    @Override
    public String toString() {
        return "Mobilier{" +
                "nume='" + nume + '\'' +
                ", placi=" + placi +
                '}';
    }

    public void afisarePlaci(){
        System.out.println("Mobilier: "+nume);
        System.out.println("Placile:");
        for(Placa p: placi){
            System.out.println(p);
        }
    }

    public double getNrColiPal() {
        final double ARIE_COLA = 2800.0 * 2070.0; // mm^2
        double arieTotala = 0;

        for (Placa p : placi) {
            arieTotala += p.arieTotala(); // lungime * latime * nr_bucati
        }

        return Math.ceil(arieTotala / ARIE_COLA);
    }



    public void setPlaci(List<Placa> placi) {
        this.placi = placi;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public List<Placa> getPlaci() {
        return placi;
    }

    public String getNume() {
        return nume;
    }
}
