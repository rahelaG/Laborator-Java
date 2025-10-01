import java.util.Scanner;

public class ex1 {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Lungime=");
        int lun = scanner.nextInt();
        System.out.println("Latime=");
        int lat = scanner.nextInt();
        int arie=lun*lat;
        int perimetru=2*(lun+lat);
        System.out.println("Aria este "+arie);
        System.out.println("Perimetrul este  "+perimetru);
        scanner.close();

    }
}