package DSA.Arrays;

public class linearSearch {
    //-> Time complexity : O(n)
    public static int search(int arr[], int target) {
        if(arr.length == 0) {
            return -1;
        }
        //traverse the array & find the target
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String args[]) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
        int target = 7;
        if(search(arr, target) == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index : " + search(arr, target));
        }
    }
}
