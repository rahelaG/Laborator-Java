package lab3;

public class Parabola {

    public int a;
    public int b;
    public int c;

    public Parabola(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double[] varf() {
        double vx = (-(double) b) / (2 * a);
        double delta = -(double) b * b + 4 * a * c;
        double vy = (-(double) delta) / (4 * a);
        return new double[]{vx, vy};
    }

    @Override
    public String toString() {
        return a + "x^2+" + b + "x+" + c;
    }

    public double[] mijloc(Parabola p2) {
        double[] v1 = this.varf();
        double[] v2 = p2.varf();
        double xm = (v1[0] + v2[0]) / 2;
        double ym = (v1[1] + v2[1]) / 2;
        return new double[]{xm, ym};
    }

    public static double[] mijlocStatic(Parabola p1, Parabola p2) {

        double[] v1 = p1.varf();
        double[] v2 = p2.varf();

        double xm = (v1[0] + v2[0]) / 2;
        double ym = (v1[1] + v2[1]) / 2;
        return new double[]{xm, ym};
    }

    public double lungimeSegment(Parabola p2) {
        double[] v1 = this.varf();
        double[] v2 = p2.varf();
        double lm = Math.hypot(v2[0] - v1[0], v2[1] - v1[1]);
        return lm;
    }

    public static double lungimeSegmentStatic(Parabola p1, Parabola p2) {
        double[] v1 = p1.varf();
        double[] v2 = p2.varf();
        double lm = Math.hypot(v2[0] - v1[0], v2[1] - v1[1]);
        return lm;
    }


}
