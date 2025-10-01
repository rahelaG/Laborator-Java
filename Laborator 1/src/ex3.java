import java.util.Scanner;

public class ex3 {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Dati un numar = ");
        int nr = scanner.nextInt();
        int div=0;
        for(int i=1;i<nr/2;i++){
            if(nr%i==0){
                div++;
                System.out.println("Un divizor este "+i);
            }

        }
        if(div==1){
            System.out.println("Numarul dat este prim");
        }
    }
}