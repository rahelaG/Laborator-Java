import java.util.Random;

public class ex4 {
    public static void main(String[] args) {

        Random rand = new Random();
        int a = rand.nextInt(31);
        int b = rand.nextInt(31);
        System.out.println(a+" "+b);

        while(a != 0)
        {
            int r = b % a;
            b = a;
            a = r;
        }
        System.out.println("Cel mai mare divizor comun al numerelor generate random este "+b);
    }
}
