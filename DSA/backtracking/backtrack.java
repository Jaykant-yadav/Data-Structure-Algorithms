package DSA.backtracking;

import DSA.Strings.string;

public class backtrack {

    public static void printArr(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void changeArr(int arr[], int i, int val) {
        //base case
        if(i == arr.length) {
            printArr(arr);
            return;
        }

        // recursion
        arr[i] = val;
        changeArr(arr, i+1, val+1);//fnx call step
        arr[i] = arr[i] - 2;//backtracking step
    }

    public static void findSubsets(String str, String ans, int i) {
        //Base case
        if(i == str.length()) {
            if(ans.length() == 0) {
                System.out.println("null");
            } else {
                System.out.println(ans);
            }
            return;
        }

        //recursion
        // yes choice
        findSubsets(str, ans+str.charAt(i), i+1);

        // No Choice
        findSubsets(str, ans, i+1);
    }
    // find permutations -> O(n * n!)
    public static void findPermutations(String str, String ans) {
        // base case
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }

        // recursion
        for(int i=0; i<str.length(); i++) {
            char curr = str.charAt(i);
            // abcde = ab + de
            String newStr = str.substring(0, i) + str.substring(i+1);
            findPermutations(newStr, ans+curr);
        }
    }
    public static void main(String[] args) {
        // int arr[] = new int[5];
        // changeArr(arr, 0, 1);
        // printArr(arr);

        String str = "abc";
        // findSubsets(str, "", 0);
        findPermutations(str, "");

    }
}
