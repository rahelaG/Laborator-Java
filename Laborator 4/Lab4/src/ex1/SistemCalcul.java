package ex1;

public class SistemCalcul extends Echipament {
    private String tip_mon;
    private int vic_proc;
    private int c_hdd;
    private SistemOperare sistemOp;

    public SistemCalcul(String denumire, int nr_inv, double pret, String zona_mag, Stare stare, String tip_mon, int vic_proc, int c_hdd, SistemOperare sistemOp) {
        super(denumire, nr_inv, pret, zona_mag, stare);
        this.tip_mon = tip_mon;
        this.vic_proc = vic_proc;
        this.c_hdd = c_hdd;
        this.sistemOp = sistemOp;
    }

    public void setSistemOp(SistemOperare sistemOp) {
        this.sistemOp = sistemOp;
    }

    @Override
    public String toString() {
        return "SistemCalcul{" +
                "tip_mon='" + tip_mon + '\'' +
                ", vic_proc=" + vic_proc +
                ", c_hdd=" + c_hdd +
                ", sistemOp=" + sistemOp +
                ", denumire='" + denumire + '\'' +
                ", nr_inv=" + nr_inv +
                ", pret=" + pret +
                ", zona_mag='" + zona_mag + '\'' +
                ", stare=" + stare +
                '}';
    }
}
