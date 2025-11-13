package ex3;

import java.util.Arrays;

public class Placa {
    public String descriere;
    private int lungime;
    private int latime;
    private Orientare orientare;
    private boolean[] canturi = new boolean[4];
    private int nr_bucati;

    public Placa() {
    }

    public Placa(String descriere, int lungime, int latime, Orientare orientare, boolean[] canturi, int nr_bucati) {
        this.descriere = descriere;
        this.lungime = lungime;
        this.latime = latime;
        this.orientare = orientare;
        this.canturi = canturi;
        this.nr_bucati = nr_bucati;
    }

    @Override
    public String toString() {
        return "Placa{" +
                "descriere='" + descriere + '\'' +
                ", lungime=" + lungime +
                ", latime=" + latime +
                ", orientare=" + orientare +
                ", canturi=" + Arrays.toString(canturi) +
                ", nr_bucati=" + nr_bucati +
                '}';
    }

    public double arieTotala() {
        return lungime * latime * nr_bucati;
    }

    public int getNr_bucati() {
        return nr_bucati;
    }

    public void setNr_bucati(int nr_bucati) {
        this.nr_bucati = nr_bucati;
    }

    public void setCanturi(boolean[] canturi) {
        this.canturi = canturi;
    }

    public void setOrientare(Orientare orientare) {
        this.orientare = orientare;
    }

    public void setLatime(int latime) {
        this.latime = latime;
    }

    public void setLungime(int lungime) {
        this.lungime = lungime;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public boolean[] getCanturi() {
        return canturi;
    }

    public Orientare getOrientare() {
        return orientare;
    }

    public int getLatime() {
        return latime;
    }

    public int getLungime() {
        return lungime;
    }

    public String getDescriere() {
        return descriere;
    }
}
