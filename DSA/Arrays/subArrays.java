package DSA.Arrays;

public class subArrays {
    //Time Complexity -> O(n3)
    public static void printSubArrays(int arr[]){
        int ts = 0;
        for(int i=0; i<arr.length; i++) { //start
            for(int j=i; j<arr.length; j++) { //end
                for(int k=i; k<=j; k++) { // print start -> end
                    System.out.print(arr[k] + " ");
                }
                ts++;
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("Total subArrays : " + ts);
    }
    public static void main(String[] args) {
        int arr[] = {2, 4, 6, 8, 10};
        printSubArrays(arr);
        //Total sub Arrays = n(n+1)/2;
    }
}
