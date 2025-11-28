package ex2;

import java.util.Objects;

public class SetTobe extends InstrumentMuzical{
    private TipTobe tip_tobe;
    private int nr_tobe;
    private int nr_cinele;

    public SetTobe(String producator, double pret, TipTobe tip_tobe, int nr_tobe, int nr_cinele) {
        super(producator, pret);
        this.tip_tobe = tip_tobe;
        this.nr_tobe = nr_tobe;
        this.nr_cinele = nr_cinele;
    }

    @Override
    public String toString() {
        return "SetTobe{" +
                "tip_tobe=" + tip_tobe +
                ", nr_tobe=" + nr_tobe +
                ", nr_cinele=" + nr_cinele +
                '}';
    }

    public void setNr_cinele(int nr_cinele) {
        this.nr_cinele = nr_cinele;
    }

    public void setNr_tobe(int nr_tobe) {
        this.nr_tobe = nr_tobe;
    }

    public void setTip_tobe(TipTobe tip_tobe) {
        this.tip_tobe = tip_tobe;
    }

    public int getNr_cinele() {
        return nr_cinele;
    }

    public int getNr_tobe() {
        return nr_tobe;
    }

    public TipTobe getTip_tobe() {
        return tip_tobe;
    }

    public SetTobe(String producator, double pret) {
        super(producator, pret);
    }

    public SetTobe() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SetTobe setTobe = (SetTobe) o;
        return nr_tobe == setTobe.nr_tobe && nr_cinele == setTobe.nr_cinele && tip_tobe == setTobe.tip_tobe;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tip_tobe, nr_tobe, nr_cinele);
    }
}
