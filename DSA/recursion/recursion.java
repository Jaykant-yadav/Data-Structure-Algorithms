package DSA.recursion;

import java.util.Arrays;

public class recursion {
    //Decreasing Order
    public static void descOrder(int num) {
        //Base case
        if(num == 1) {
            System.out.println(num);
            return;
        }
        //print num
        System.out.print(num+ " ");
        descOrder(num-1); // func recursive call yourself
    }

    //Increasing Order
    public static void increOrder(int num) {
        //Base case
        if(num == 1) {
            System.out.print(num + " ");
            return;
        }
        increOrder(num-1); // func recursive call yourself
        //print num
        System.out.print(num+ " ");
    }

    //Print Factorial
    public static int printFacto(int num) {
        //Base case
        if(num == 0) {
            return 1;
        }
        // int fnm1 = printFacto(num-1); // func recursive call yourself
        // int fn = num * fnm1;
        // return fn;

        return num * printFacto(num-1);
    }

    //Print Natural Numbers
    public static int sumOfNaturalNum(int n) {
        //Base case
        if(n == 1) {
            return 1;
        }

        return sumOfNaturalNum(n-1) + n;
    }

    //Calculate nth term in fibonacci
    public static int fib(int n) {
        //Base case
        if(n == 0 || n == 1) {
            return n;
        }

        int fnm1 = fib(n-1);
        int fnm2 = fib(n-2);
        int fn = fnm1 + fnm2;
        return fn;
    }

    //Check if given array is sorted or not
    public static boolean isSorted(int arr[], int i){
        if(i == arr.length-1) {
            return true;
        }

        if(arr[i] > arr[i+1]) {
            return false;
        }

        return isSorted(arr, i+1);
    }

    //WAF to find the first occurence of an element in an Array
    public static int firstOccur(int arr[], int idx, int key) { //TC & SC -> O(n)
        if(idx == arr.length) {
            return -1;
        }
        if(arr[idx] == key) {
            return idx;
        }

        return firstOccur(arr, idx+1, key);
    }

    //WAF to find the last occurence of an element in an Array
    public static int lastOccur(int arr[], int idx, int key) { //TC & SC -> O(n)
        if(idx == arr.length) {
            return -1;
        }
        //look forward
        int isFound = lastOccur(arr, idx+1, key); //key search and stored idx
        //check with self
        if(isFound == -1 && arr[idx] == key) {
            return idx;
        }

        return isFound;
    }

    //Print x to the power n
    public static int power(int x, int n) {
        if(n == 0) {
            return 1;
        }
        /* int xnm1 = power(x, n-1);
        int xn = x * xnm1;
        return xn; */

        return power(x, n-1) * x;
    }

    public static int optimizedPower(int a, int n) {
        if(n == 0) {
            return 1;
        }

        int halfPower = optimizedPower(a, n/2);
        int halfPowerSq = halfPower * halfPower;

        //n is odd
        if(n % 2 != 0) {
            halfPowerSq = a * halfPowerSq;
        }

        return halfPowerSq;
    }

    //Tilling Problem -> AMAZON
    public static int tilingProblem(int n) { //2 X n (floor size)
        //base case
        if(n == 0 || n == 1) {
            return 1;
        }

        //work -> choice
        //vertical choice
        int fnm1 = tilingProblem(n-1);

        //Horizontal choice
        int fnm2 = tilingProblem(n-2);

        int totalWays = fnm1 + fnm2;
        return totalWays;

        // return tilingProblem(n-1) + tilingProblem(n-2);
    }

    //Remove Duplicates in a String -> Google, Microsoft
    public static void removeDuplicates(String str, int idx, StringBuilder newStr, boolean map[]) {
        //Base case
        if(idx == str.length()) {
            System.out.println(newStr);
            return;
        }

        //Work
        char currChar = str.charAt(idx);
        if(map[currChar-'a'] == true) {
            //duplicate
            removeDuplicates(str, idx+1, newStr, map);
        } else {
            map[currChar - 'a'] = true;
            removeDuplicates(str, idx+1, newStr.append(currChar), map);
        }
    }

    //Friends Pairing Problem -> GOLDMAN SACHS
    public static int friendsPairing(int n) {
        //Base Case
        if(n == 1 || n == 2) {
            return n;
        }
        //Choice
        //single
        int fnm1 = friendsPairing(n-1);

        //pair
        int fnm2 = friendsPairing(n-2);
        int pairWays = (n-1) * fnm2;

        //total Ways
        int totalWays = fnm1 + pairWays;
        return totalWays;

        // return friendsPairing(n-1) + (n-1) * friendsPairing(n-2);
    }

    //Binary Strings Problem -> PAYTM
    public static void printBinStrings(int n, int lastPlace, String str) {
        //base case
        if(n == 0) {
            System.out.println(str);
            return;
        }

        //Work
        /* if(lastPlace == 0) {
            //Sit 0 on chair n
            printBinStrings(n-1, 0, str.append("0"));
            printBinStrings(n-1, 1, str.append("1"));
        } else {
            printBinStrings(n-1, 0, str.append("0"));
        } */

        printBinStrings(n-1, 0, str+"0");
        if(lastPlace == 0) {
            printBinStrings(n-1, 1, str+"1");
        }
    }

    public static void findAllOccurence(int arr[], int i, int key) {
        if(i == arr.length) {
            return;
        }

        if(arr[i] == key) {
            System.out.print(i + " ");;
        }

        findAllOccurence(arr, i+1, key);
    }

    public static void convertNumToStr(int nums) {
        String words[] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};

        //Approach - I
        /* String newStr = Integer.toString(nums);

        StringBuilder result = new StringBuilder();

        for(int i=0; i<newStr.length(); i++) {
            char digit = newStr.charAt(i);
            result.append(words[digit - '0']);

            if(i < newStr.length()-1) {
                result.append(" ");
            }
        }
        return result.toString(); */

        //Approach - II
        if(nums == 0) {
            return;
        }

        int lastDigit = nums % 10;
        convertNumToStr(nums/10);
        System.out.print(words[lastDigit] + " ");
    }

    public static int printStrLength(String str) {
        //base case
        if(str.length() == 0) {
            return 0;
        }

        /* //Using loop
        int count = 0;
        char newStr[] = str.toCharArray();
        for(char newStrs : newStr) {
            count++;
        } */

        //recursive
        return printStrLength(str.substring(1)) + 1;        
    }

    public static int countSubStr(String str, int i, int j, int n) {
        if(n == 1) {
            return 1;
        }

        if(n <= 0) {
            return 0;
        }

        int res = countSubStr(str, i+1, j, n-1) + countSubStr(str, i, j-1, n-1) - countSubStr(str, i+1, j-1, n-2);
        if(str.charAt(i) == str.charAt(j)) {
            res++;
        }

        return res;
    }

    // System.out.println(countSubStr(str, 0, n-1, n));

    public static void main(String[] args) {
        int num = 6;
        // descOrder(num);
        // increOrder(num);
        // System.out.println(printFacto(num));
        // System.out.println(sumOfNaturalNum(num));
        // System.out.println(fib(num));
        int arr[] = {3, 2, 4, 5, 6, 2, 7, 2, 2};
        // System.out.println(isSorted(arr, 0));
        // System.out.println(firstOccur(arr, 0, 5));
        // System.out.println(lastOccur(arr, 0, 5));
        // System.out.println(power(2, 10));
        // System.out.println(optimizedPower(2, 5));
        // System.out.println(tilingProblem(4));
        // removeDuplicates("appnnacollege", 0, new StringBuilder(""), new boolean[26]);
        // System.out.println(friendsPairing(3));
        // printBinStrings(3, 0, "");
        // findAllOccurence(arr, 0, 2);
        int nums = 258586860;
        // convertNumToStr(nums);
        // System.out.println(printStrLength("Jaykant"));
        // String name = "Jaykant";
        // System.out.println(name.substring(1));

        String str = "abcab";
        int n = str.length();
        System.out.println(countSubStr(str, 0, n-1, n));


    }
}
