import java.util.*;
public class powXY {
    //Pow(X, Y)
    public static double powOfXy(double X, int Y){
        return (double) Math.pow(X, Y);
    }
    public static void main(String[] args) {
        double X = 2.00000;
        int Y = 10;
        System.out.println(powOfXy(X, Y));
    }
}
