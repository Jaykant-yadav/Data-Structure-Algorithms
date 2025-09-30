import java.util.Arrays; //inbuilt sorting package
import java.util.Collections; //Reverse order in sort

public class Sorting {
    // Print Arrays function
    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // Bubble sort - O(n2)
    public static void BubbleSort(int arr[]) {
        for (int turn = 0; turn < arr.length - 1; turn++) {
            for (int j = 0; j < arr.length - 1 - turn; j++) {
                // incresing -> (>) & decresing -> (<)
                if (arr[j] > arr[j + 1]) {
                    // swap
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    // Selection Sort - O(n2)
    public static void selectionSort(int arr[]) {
        // turn -> i
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                // incresing -> (>) & decresing -> (<)
                if (arr[minPos] > arr[j]) {
                    minPos = j;
                }
            }

            // swap
            int temp = arr[minPos];
            arr[minPos] = arr[i];
            arr[i] = temp;
        }
    }

    // Insertion sort - O(n2)
    public static void insertionSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            int prev = i - 1;
            // finding out the correct pos to insert
            while (prev >= 0 && arr[prev] > curr) {
                arr[prev + 1] = arr[prev];
                prev--;
            }
            // insertion
            arr[prev + 1] = curr;
        }
    }

    // Counting Sort - O(n + range) -> use of count sort always with small range
    // element
    public static void countingSort(int arr[]) {
        // calculate Largest element
        int Largest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            Largest = Math.max(Largest, arr[i]);
        }

        // create new count array
        int count[] = new int[Largest + 1];
        for (int j = 0; j < arr.length; j++) {
            count[arr[j]]++;
        }

        // sorting
        int j = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[j] = i;
                j++;
                count[i]--;
            }
        }

    }

    // Cyclic Sort
    /*
     * Rule:
     * Cyclic sort works when the array contains numbers in the range [1 to N]
     * (continuous range, no missing or extra numbers, and all unique).
     * For example: [3, 5, 2, 1, 4]
     */

    public static void cyclicSort(int arr[]) {
        int i = 0;
        while (i < arr.length) {
            int corrPost = arr[i] - 1;
            if (arr[i] != arr[corrPost]) {
                swap(arr, i, corrPost);
            } else {
                i++;
            }
        }
    }

    private static void swap(int arr[], int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static void main(String[] args) {
        int arr[] = { 3, 5, 2, 1, 4 };
        // BubbleSort(arr);

        // selectionSort(arr);

        // insertionSort(arr);

        // countingSort(arr);
        // printArr(arr);

        int nums[] = { 2, 5, 1, 9, 7, 6 };
        cyclicSort(nums);
        printArr(nums);

        /*********** > INBUILT SORT < *************/
        // import java.util.Arrays; //inbuilt sorting package
        // Arrays.sort(arr); // Time Complexity -> O(n logn)
        // Arrays.sort(arr, 2, 6); // start - end Index based sort

        // Reverse order in sort
        // import java.util.Collections;
        // Arrays.sort(nums, Collections.reverseOrder()); //apply on only Capital
        // Integer, Object oriented data types
        // Arrays.sort(nums, 0, 4, Collections.reverseOrder()); //start - end Index
        // based sort
        /* Reverse Order function internaly used comparator */

    }
}
