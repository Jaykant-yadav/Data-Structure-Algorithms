package DSA.Arrays;

public class binarySearch {
    //Time Complexity - O(log n) -> Binary Search always apply on Sorted
    //TC-> N->N/2->N/4->N/8----[1]
    public static int search(int num[], int target) {
        int start = 0, end = num.length-1;
        while (start <= end) {
            int mid = (start + end) / 2;
            // comparison
            if(num[mid] == target){ //found
                return mid;
            } else if(num[mid] < target) { //right
                start = mid++;
            } else {    //left
                end = mid--;
            }
        }
        return -1;
    }
    public static void main(String args[]){
        int Number[] = {2, 4, 6, 8, 10, 12, 14};
        int target = 10;
        int index = search(Number, target);
        if(index != -1) {
            System.out.println("found index is : " + index);
        } else {
            System.out.println("not found");
        }

    }
}
