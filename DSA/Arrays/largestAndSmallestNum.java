package DSA.Arrays;

class largestAndSmallestNum {
    //Find the largest & Smallest Number
    //Time Complexity = O(n)

    public static void getBothElement(int arr[]){
        int max = Integer.MIN_VALUE; // -infinity
        int min = Integer.MAX_VALUE; // +infinity
        for(int i=0; i<arr.length; i++) {
            if(arr[i]>max){
                max = arr[i];
            }
            if(arr[i] < min){
                min = arr[i];
            }
        }
        System.out.println("Largest value : " + max);
        System.out.println("Smallest value : " + min);
    }
    public static void main(String args[]){
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
        getBothElement(arr);
    }
    
}