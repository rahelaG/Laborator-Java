package ex2;

public class PerecheNumere {
    private int a;
    private int b;

    public PerecheNumere() {
    }

    public PerecheNumere(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "PerecheNumere{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }

    public boolean consFib(){
        int x=0;
        int y=1;
        while(y <= Math.max(a,b)){
            if((x == a && y == b) || (x == b && y == a)){
                return true;
            }
            int temp=y;
            y=x+temp;
            x=temp;
        }
        return false;
    }

    public int Cmmmc(){


        int ans = (a > b) ? a : b;

        while (true) {
            if (ans % a == 0 && ans % b == 0)
                break;
            ans++;
        }
        return ans;
    }

    private int sumaCifrelor(int n){
        int sum=0;
        while(n>0){
            sum+=n%10;
            n=n/10;
        }
        return sum;
    }

    public boolean sumCifEgale(){
        return sumaCifrelor(a)==sumaCifrelor(b);
    }

    private int nrPare(int n){
        int pare=0;
        while(n>0){
            if(n%10%2==0){
                pare++;
            }
            n=n/10;
        }
        return pare;
    }

    public boolean sumPareEgale(){
        return nrPare(a)==nrPare(b);
    }





}
