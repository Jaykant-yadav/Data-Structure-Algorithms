package DSA_Sheet.GeneralQs;

public class Recursion {
    // Print 1 to N 
    public static void oneToNPrint(int n){
        if(n == 1){
            System.out.print(1 + " ");
            return;
        }

        oneToNPrint(n-1);
        System.out.print(n + " ");
    }

    // Print N to 1
    public static void nToOnePrint(int n){
        if(n == 1){
            System.out.print(n + " ");
            return;
        }

        System.out.print(n + " ");
        nToOnePrint(n-1);
    }

    // Sum of First N numbers
    public static int sumOfFirstNum(int n){
        int sum = 0;
        if(n == 0){
            return 0;
        }

        sum += n;
        sumOfFirstNum(n-1);
        return sum;
    }

    // /Fibonacci Number
    public static int fibonacci(int n){
        if(n == 0 || n == 1){
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }
    public static void main(String args[]){
      System.out.println(sumOfFirstNum(5));
    }
}
