package DSA.Arrays;

public class reverseArray {
    //Two Pointer Approach
    //Time Complexity = O(n)
    //Space Complexity = O(1)
    public static void reverseNum(int num[]) {
        int start = 0, end = num.length-1; 
        while (start < end) {
            //Swap
            int temp = num[start];
            num[start] = num[end];
            num[end] = temp;
            start++;
            end--;
        }
    }
    public static void main(String args[]){
        int num[] = {2, 8, 5, 6, 7};
        reverseNum(num);
        //Print of Arrays
        for(int i=0; i<num.length; i++) {
            System.out.print (num[i] + " ");
        }
        System.out.println();

    }
}
