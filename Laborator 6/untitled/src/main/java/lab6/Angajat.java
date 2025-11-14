package lab6;

import java.time.LocalDate;

public class Angajat {

    private String nume;
    private String post;
    private LocalDate data_angajarii;
    private float salariul;

    public Angajat() {
    }

    public Angajat(String nume, String post, LocalDate data_angajarii, float salariul) {
        this.nume = nume;
        this.post = post;
        this.data_angajarii = data_angajarii;
        this.salariul = salariul;
    }

    public void setSalariul(float salariul) {
        this.salariul = salariul;
    }

    public void setData_angajarii(LocalDate data_angajarii) {
        this.data_angajarii = data_angajarii;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public float getSalariul() {
        return salariul;
    }

    public LocalDate getData_angajarii() {
        return data_angajarii;
    }

    public String getPost() {
        return post;
    }

    public String getNume() {
        return nume;
    }

    @Override
    public String toString() {
        return "Angajat{" +
                "nume='" + nume + '\'' +
                ", post='" + post + '\'' +
                ", data_angajarii=" + data_angajarii +
                ", salariul=" + salariul +
                '}';
    }
}
