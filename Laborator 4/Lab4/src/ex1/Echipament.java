package ex1;

import java.io.Serializable;

public abstract class Echipament implements Serializable {
    public String denumire;
    public int nr_inv;
    public double pret;
    public String zona_mag;
    public Stare stare;

    public Echipament(String denumire, int nr_inv, double pret, String zona_mag, Stare stare) {
        this.denumire = denumire;
        this.nr_inv = nr_inv;
        this.pret = pret;
        this.zona_mag = zona_mag;
        this.stare = stare;
    }

    public int getNr_inv() {
        return nr_inv;
    }

    public Stare getStare() {
        return stare;
    }

    public void setStare(Stare stare) {
        this.stare = stare;
    }

    public abstract String toString();
}
