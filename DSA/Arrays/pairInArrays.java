package DSA.Arrays;

class pairInArrays {
    public static void pair(int arr[]){
        //Time Complexity = O(n2)
        int tp = 0;
        for(int i=0; i<arr.length; i++) {
            for(int j=i+1; j<arr.length; j++) {
                System.out.print("(" + arr[i] + ", " + arr[j] + ")" + " ");
                tp++;
            }
            System.out.println();
        }
        System.out.println("Total number of pair : " + tp);
    }

    public static void main(String args[]){
        int arr[] = {2, 4, 6, 8, 10};
        pair(arr);
        //Total number of pair = n(n-1)/2
    }   
}