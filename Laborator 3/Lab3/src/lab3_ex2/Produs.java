package lab3_ex2;

import java.time.LocalDate;
import java.util.List;

public class Produs {

    private String Denumire;
    private float Pret;
    private int Cantitate;
    private LocalDate DataExpirarii;

    public Produs(String Denumire, float Pret, int Cantitate, LocalDate DataExpirarii) {
        this.Denumire = Denumire;
        this.Pret = Pret;
        this.Cantitate = Cantitate;
        this.DataExpirarii = DataExpirarii;
    }

    public float getPret() {
        return Pret;
    }

    public int getCantitate() {
        return Cantitate;
    }

    public String getDenumire() {
        return Denumire;
    }

    public static int getIncasari() {
        return incasari;
    }

    public LocalDate getDataExpirarii() {
        return DataExpirarii;
    }

    @Override
    public String toString() {
        return Denumire + " " + Pret + " " + Cantitate + " " + DataExpirarii;
    }

    public boolean esteExpirat(LocalDate dataCurenta) {
        return dataCurenta.isAfter(DataExpirarii);

    }

    private static int incasari = 0;

    public boolean vinde(int cantitateProdus) {

        if (Cantitate - cantitateProdus < 0) {
            System.out.println("Stoc insuficient pentru produs");
            return false;
        }

        Cantitate -= cantitateProdus;
        incasari += cantitateProdus * Pret;
        return true;
    }

}
