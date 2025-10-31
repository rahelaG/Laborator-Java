package ex4;

import java.time.LocalDate;
import java.time.Period;

public class Persoana {
    private String nume;
    private String cnp;

    public Persoana(String nume, String cnp) {
        this.nume = nume;
        this.cnp = cnp;
    }

    public String getCnp() {
        return cnp;
    }

    public String getNume() {
        return nume;
    }

    public int GetVarsta(){

        char s=cnp.charAt(0);
        int an=Integer.parseInt(cnp.substring(1,3));
        int luna=Integer.parseInt(cnp.substring(3,5));
        int zi=Integer.parseInt(cnp.substring(5,7));

        if(s=='1' || s=='2'){
            an+=1900;
        }
        if(s=='5' || s=='6'){
            an+=2000;
        }

        LocalDate DataNasterii=LocalDate.of(an, luna, zi);
        LocalDate DataCurenta=LocalDate.now();
        return Period.between(DataNasterii, DataCurenta).getYears();
    }

    public static boolean cnpValid(String cnp){
        if(cnp.length()!=13)
            return false;

        if(!cnp.matches("\\d+"))
            return false;

        char s=cnp.charAt(0);
        if(s!='1' && s!='2' && s!='5' && s!='6')
            return false;

        int suma=0;
        int[] verif={2,7,9,1,4,6,3,5,8,2,7,9};
        for(int i=0;i<12;i++){
            suma+=(cnp.charAt(i)-'0')*verif[i];
        }
        int rest=suma%11;
        int cifraControl=(rest==10)? 1: rest;
        return cifraControl==cnp.charAt(12)-'0';

    }

    @Override
    public String toString() {
        return "Persoana{" +
                "nume='" + nume + '\'' +
                ", cnp='" + cnp + '\'' +
                '}';
    }
}
