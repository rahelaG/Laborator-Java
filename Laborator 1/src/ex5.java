import java.util.Random;

public class ex5 {
    public static void main(String[] args) {
        Random rand = new Random();
        int fib=0;
        int n = rand.nextInt(21);
        int neg=5*(n*n)+4;
        int poz=5*(n*n)-4;

        int sn=(int)Math.sqrt(neg);
        int sp=(int)Math.sqrt(poz);
        if((sn*sn==neg) ||(sp*sp==poz)){
            fib=1;
        }
        if(fib==0){
            System.out.println("Numarul generat, "+n+", nu face parte din sirul lui Fibonacci");
        }
        else{
            System.out.println("Numarul generat, "+n+", face parte din sirul lui Fibonacci");
        }
    }
}
