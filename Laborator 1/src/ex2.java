import java.io.*;
import java.util.Scanner;

public class ex2 {

    public static void main(String[] args) throws FileNotFoundException {
        String nume_fis= "C:\\Laboratoare Java\\Laborator 1\\src\\in.txt";
        String nume_fis_out= "C:\\Laboratoare Java\\Laborator 1\\src\\out.txt";
        PrintStream flux_out = new PrintStream (nume_fis_out);
        //BufferedReader flux_in;
        //flux_in = new BufferedReader(new FileReader(nume_fis));
        Scanner scanner=new Scanner(new FileReader(nume_fis));

        int ma=0;
        int suma=0;
        int nr=0;
        int valMax=-10000000;
        int valMin=1000000;


        while (scanner.hasNextLine()){
            String data=scanner.nextLine();
            System.out.println(data);
            int x=Integer.parseInt(data);
            suma+=x;
            nr++;
            if(x>valMax){
                valMax=x;
            }
            if(x<valMax){
                valMin=x;
            }
        }

        ma=suma/nr;
//        System.out.println("Media numerelor este: "+ma);
//        System.out.println("Cel mai mare: "+valMax);
//        System.out.println("Cel mai mic: "+valMin);

        flux_out.println("Media numerelor este: "+ma);
        flux_out.println("Cel mai mare: "+valMax);
        flux_out.println("Cel mai mic: "+valMin);
    }
}