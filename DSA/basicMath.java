package DSA;

import java.util.*;

public class basicMath {
    public static void checkPrime(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                System.out.println("non-Prime");
            }
        }
        System.out.println("Prime");
    }

    // Sieve of Eratosthenes Algo
    public static int countPrime(int num) {
        boolean isPrime[] = new boolean[num + 1];// [n+1]
        Arrays.fill(isPrime, true);// n=10 -> [true, true, true...............true+11th times]

        int count = 0;
        for (int i = 2; i < num; i++) {// [2, 3, 5, 7] -> 4
            if (isPrime[i]) {
                count++;
                for (int j = i * 2; j < num; j = j + i) {// [2, 4, 6, 8, 10], [9] -> discarded element
                    isPrime[j] = false;
                }
            }
        }
        return count; // 10 -> 4
    }

    public static void printDigits(int num) {
        int count = 0;
        int sum = 0;
        while (num != 0) {
            int digit = num % 10;
            System.out.print(digit + " ");
            count++;
            sum += digit;
            num = num / 10;
        }
        System.out.println();
        System.out.println("no of digits : " + count);
        System.out.println("sum of digits : " + sum);
    }

    // Armstrong number
    /*
     * Armstrong number is a number that is equal to the sum of cubes of its digits.
     * Ex-153, 371, 1
     * 153 -> 1^3 -> 1
     * 5^3 -> 125 => 1 + 125 + 27 = 153
     * 3^3 -> 27
     * 
     * 371 -> 3^3 -> 27
     * 7^3 -> 343 => 27 + 343 + 1 = 371
     * 1^3 -> 1
     * 
     * 1 -> 1^3 = 1
     */
    public static boolean armstrongNumber(int num) {
        int copyNum = num;
        int sumOfCubes = 0;
        while (num != 0) {
            int digit = num % 10;
            sumOfCubes += (digit * digit * digit);
            num /= 10;
        }

        return sumOfCubes == copyNum;
    }

    public static String numsToWord(int nums) {
        String words[] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};

        String newStr = Integer.toString(nums);

        StringBuilder res = new StringBuilder();

        for(int i=0; i<newStr.length(); i++) {
            char digit = newStr.charAt(i);
            res.append(words[digit - '0']);

            if(i < newStr.length() - 1) {
                res.append(" ");
            }
        }       

        return res.toString();
    }

    public static void main(String[] args) {
        int num = 1534;
        // checkPrime(num);
        // System.out.println(countPrime(num));
        // printDigits(num);

        if (armstrongNumber(num)) {
            System.out.println(num + " is an armstrong number");
        } else {
            System.out.println(num + " is not an armstrong number");
        }

        System.out.println(numsToWord(2019));
    }
}
