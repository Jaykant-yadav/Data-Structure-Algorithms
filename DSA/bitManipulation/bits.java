package DSA.bitManipulation;

public class bits {
    // Check Even Or Odd Number
    public static void OddOrEven(int n) {
        int bitMask = 1;
        if ((n & bitMask) == 0) {
            // Even
            System.out.println("Even number");
        } else {
            // n & bitMask == 1
            System.out.println("Odd number");
        }
    }

    // Get ith Bit
    public static int getIthBit(int n, int i) { // i places
        int bitMask = 1 << i;
        if ((n & bitMask) == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    // SET Ith Bit
    public static int setIthBit(int n, int i) {
        int bitMask = 1 << i;
        return n | bitMask;
    }

    // CLEAR Ith Bit
    public static int clearIthBit(int n, int i) {
        int bitMask = 1 << i;
        return n & (~bitMask);
    }

    // UPDATE ith Bit
    public static int updateIthBit(int n, int i, int newBit) {
        /*
         * if(newBit == 0) {
         * return clearIthBit(n, i);
         * } else {
         * return setIthBit(n, i);
         * }
         */

        n = clearIthBit(n, i);
        int bitMask = newBit << i;
        return n | bitMask;
    }

    //CLEAR LAST I Bits
    public static int clearIBits(int n, int i) {
        int bitMask = (~0)<<i;
        return n & bitMask;
    }

    //CLEAR Range of Bits
    public static int clearRangeOfBits(int n, int i, int j) {
        int a = ((~0)<<(j+1));
        int b = (1<<i)-1;
        int bitMask = a | b;
        return n & bitMask;
    }

    //check if a number is a power of 2 or not
    public static boolean isPowerOfTwo(int n) {
        if((n & (n-1)) == 0){
            return true;
        }
        return false;
    }

    //Count Set Bits in a Number - Google & Amazon
    public static int countSetBits(int n) {
        int count = 0;
        while (n > 0) { 
            if((n&1) != 0) { // check our LSB
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    //fast Exponentiation
    public static int fastExpo(int a, int n){
        int ans = 1;
        while (n > 0) {
            if((n & 1) != 0) { //check LSB
                ans = ans * a;
            }
            a = a * a;
            n = n>>1;
        }
        return ans;
    }

    //Swap two number without third variable
    public static void swapTwoNum(int x, int y) {
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
        System.out.println("x: " + x + "," + " y: " + y);
    }

    //Convert Uppercase charater to Lowercase using bits
    public static void conUppToLow(char ch1) {
        for(char ch ='A' ;ch <= 'Z'; ch++) {
            System.out.println((char) (ch | ' '));
        }
    }
    public static void main(String[] args) {
        /*
         * System.out.println(5 & 6); // 4
         * System.out.println(5 | 6); // 7
         * System.out.println(5 ^ 6); // 3
         * System.out.println(~5); // -6
         * System.out.println(~0); // -1
         * System.out.println(5<<2); // 20
         * System.out.println(6>>1); // 3
         */

        // OddOrEven(11);
        // System.out.println(getIthBit(10, 3));
        // System.out.println(setIthBit(10, 2));
        // System.out.println(clearIthBit(10, 1));
        // System.out.println(updateIthBit(10, 2, 1));
        // System.out.println(clearIBits(15, 2));
        // System.out.println(clearRangeOfBits(10, 2, 4));
        // System.out.println(isPowerOfTwo(5));
        // System.out.println(countSetBits(10));
        // System.out.println(fastExpo(5, 3));

        conUppToLow('a');
    }
}
