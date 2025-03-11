package DSA.divideAndConquer;


public class divideConquer {

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Merge Sort
    public static void mergeSort(int arr[], int si, int ei) {
        // Base Case
        if (si >= ei) {
            return;
        }

        // Work
        int mid = si + (ei - si) / 2; // (si+ei)/2
        mergeSort(arr, si, mid); // left part
        mergeSort(arr, mid + 1, ei); // right part
        merge(arr, si, mid, ei); // Merge left & right
    }

    public static void merge(int arr[], int si, int mid, int ei) {
        // Temp Array
        // left(0, 3) right(4, 6) = 3 -> 6 - 0 -> 6 + 1 => 7
        int temp[] = new int[ei - si + 1];
        int i = si; // iterator for left part
        int j = mid + 1; // iterator for right part
        int k = 0; // iterator for temp arr
        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        // left part
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // right part
        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        // copy temp to original arr
        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    // Quick Sort
    public static void quickSort(int arr[], int si, int ei) {
        // base case
        if (si >= ei) {
            return;
        }
        // last element
        int pIdx = partition(arr, si, ei);
        quickSort(arr, si, pIdx - 1); // left
        quickSort(arr, pIdx + 1, ei); // right
    }

    public static int partition(int arr[], int si, int ei) {
        int pivot = arr[ei];
        int i = si - 1; // to make palce for elements smaller than pivot

        for (int j = si; j < ei; j++) {
            if (arr[j] <= pivot) {
                i++;
                // swap
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        // swap
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;
        return i;
    }

    // Search in rotated Sorted Array - Binary Search
    public static int searchInRotatedArr(int arr[], int target, int st, int ei) {
        // Base Case
        if (st > ei) {
            return -1;
        }
        // kaam
        int mid = st + (ei - st) / 2; // (st+ei)/2
        // case Found
        if (arr[mid] == target) {
            return mid;
        }

        // Mid on L1
        if (arr[st] <= arr[mid]) {
            // Case a: left
            if (arr[st] <= target && target <= arr[mid]) {
                return searchInRotatedArr(arr, target, st, mid - 1);
            } else {
                // Case b : right
                return searchInRotatedArr(arr, target, mid + 1, ei);
            }
        }

        // Mid on L2
        else {
            // Case c : right
            if (arr[mid] <= target && target <= arr[ei]) {
                return searchInRotatedArr(arr, target, mid + 1, ei);
            } else {
                // Case d : left
                return searchInRotatedArr(arr, target, st, mid - 1);
            }

        }

    }

    // Using single loop search in rotated array
    public static int searchInRotatedArrays(int arr[], int target) {
        int si = 0, ei = arr.length;
        while (si <= ei) {
            // Find mid
            int mid = si + (ei - si) / 2;

            // Found element
            if (arr[mid] == target) {
                return mid;
            }

            // Mid if L1 -> array of start to large target but array of mid too small
            if (arr[si] <= arr[mid]) {
                // Case a: left side
                if (arr[si] <= target && target < arr[mid]) {
                    ei = mid - 1; // end --;
                } else {
                    // Case b: right side
                    si = mid + 1; // start++;
                }
            }

            // mid if L2 -> arr[mid] <= target >= arr[ei] -> array of mid to large target
            // but array of end too small
            else {
                if (arr[mid] <= target && target <= arr[ei]) {
                    si = mid + 1; // start++;
                } else {
                    ei = mid - 1; // end--;
                }
            }
        }
        return -1;
    }

    // Merge Two Sorted Arrays
    public static int[] mergeTwoSortedArrays(int arr1[], int arr2[]) {
        int n = arr1.length; // Get the length of the first array (arr1)
        int m = arr2.length; // Get the length of the second array (arr2)

        int res[] = new int[n + m]; // Create a result array (res) with a length equal to the sum of arr1 and arr2
                                    // lengths
        int i = 0, j = 0, k = 0; // Initialize iteration variables: i for arr1, j for arr2, k for res

        while (i < n && j < m) { // Loop as long as both i and j are within their respective array bounds
            if (arr1[i] < arr2[j]) { // If the current element in arr1 is less than the current element in arr2
                res[k] = arr1[i]; // Store the element from arr1 into the result array (res)
                i++; // Move to the next element in arr1
            } else { // If the current element in arr2 is less than or equal to the current element
                     // in arr1
                res[k] = arr2[j]; // Store the element from arr2 into the result array (res)
                j++; // Move to the next element in arr2
            }
            k++; // Always move to the next position in the result array (res)
        }

        while (i < n) { // If there are remaining elements in arr1 after comparing all of arr2
            res[k] = arr1[i]; // Copy the remaining elements from arr1 into the result array (res)
            i++; // Move to the next element in arr1
            k++; // Move to the next position in the result array (res)
        }

        while (j < m) { // If there are remaining elements in arr2 after comparing all of arr1
            res[k] = arr2[j]; // Copy the remaining elements from arr2 into the result array (res)
            j++; // Move to the next element in arr2
            k++; // Move to the next position in the result array (res)
        }

        return res; // Return the merged and sorted result array (res)
    }

    // Practice Question - 1 -> Easy
    /*
     * Question 1: Apply Merge sort to sort an array of Strings. (Assume that all
     * the characters in all the Strings are in lowercase). (EASY)
     * input: arr = {"sun", "earth", "mars", "mercury"} -> output : arr = {"earth",
     * "mars", "mercury", "sun"}
     */
    public static void sortString(String str[], int st, int ei) {
        if (st >= ei) {
            return;
        }

        int mid = st + (ei - st) / 2;
        sortString(str, st, mid);// left
        sortString(str, mid + 1, ei);

        StringSort(str, mid, st, ei);
    }

    public static void StringSort(String str[], int mid, int st, int ei) {
        String res[] = new String[ei - st + 1];
        int i = st, j = mid + 1, k = 0;

        while (i <= mid && j <= ei) {
            int result = str[i].compareTo(str[j]);
            if (result < 0) {
                res[k] = str[i];
                i++;
            } else {
                res[k] = str[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            res[k] = str[i];
            i++;
            k++;
        }

        while (j <= ei) {
            res[k] = str[j];
            j++;
            k++;
        }

        for (k = 0, i = st; k < res.length; k++, i++) {
            str[i] = res[k];
        }
    }

    /* Practice Question - 2 -> (MEDIUM)
     * Question 2: Given an array nums of size n, return the majority element.
     * The majority element is the element that appears more than Ln / 21 times. You
     * may assume that the majority element always exists in the array.
     * 
     * Sample Input 1: nums = [3,2,3]
     * Sample Output 1:3
     * 
     * Sample Input 2: nums = [2,2,1,1,1,2,2]
     * Sample Output 2:2
     */
    public static int majorityElement(int arr[]) {
        int i = 0, j = 0;
        int count = 0;
        while (i <= arr.length && j <= arr.length) {
            if(arr[i] == arr[j]) {
                i++;
                count++;
            } 
            j++;
            
        }
        return count;
    }

    // Practice Question - 3 -> Hard
    /*
     * Question 3: Given an array of integers. Find the Inversion Count in the
     * array. (HARD)
     * Inversion Count: For an array, inversion count indicates how far (or close)
     * the array is from being sorted. If the array is already sorted then the
     * inversion count is 0. If an array is sorted in the reverse order then the
     * inversion count is the maximum. Formally, two elements a[i] and a[j] form an
     * inversion if a[i] > a[j] and i < j.
     * 
     * Sample Input 1: N = 5, arr[] = {2, 4, 1, 3, 5)
     * Sample Output 1: 3, because it has 3 inversions - (2, 1), (4, 1), (4, 3).
     *
     * Sample Input 2: N = 5, arr[] = {2, 3, 4, 5, 6)
     * Sample Output 2: 0, because the array is already sorted
     */
    public static int[] countInversion(int arr[], int st, int ei) {
        if (st >= ei) {
            int bc[] = new int[1];
            bc[0] = arr[st];
            return bc;
        }

        int mid = st + (ei - st) / 2;
        int left[] = countInversion(arr, st, mid);
        int right[] = countInversion(arr, mid + 1, ei);

        int mergeSort[] = mergeSort(left, right);
        return mergeSort;
    }

    static int count = 0;

    public static int[] mergeSort(int left[], int right[]) {
        int n = left.length;
        int m = right.length;

        int res[] = new int[n + m];
        int i = 0, j = 0, k = 0;
        while (i < n && j < m) {
            if (left[i] < right[j]) {
                res[k] = left[i];
                i++;
            } else {
                res[k] = right[j];
                count += n - i;
                j++;
            }
            k++;
        }

        while (i < n) {
            res[k] = left[i];
            i++;
            k++;
        }

        while (j < m) {
            res[k] = right[j];
            j++;
            k++;
        }
        return res;
    }

    public static void main(String[] args) {
        // int arr[] = { 4, 5, 6, 7, 0, 1, 2 };
        // mergeSort(arr, 0, arr.length - 1);
        // quickSort(arr, 0, arr.length - 1);
        // printArr(arr);
        // System.out.println(searchInRotatedArr(arr, 6, 0, arr.length-1));
        // System.out.println(searchInRotatedArrays(arr, 0));
        // int arr1[] = { 1, 5, 9, 13, 17 };
        // int arr2[] = { 2, 4, 7, 10, 18, 20 };
        // int res[] = mergeTwoSortedArrays(arr1, arr2);
        // printArr(res);
        // String str[] = { "sun", "earth", "mars", "mercury" };
        // sortString(str, 0, str.length - 1);
        // for (int i = 0; i < str.length; i++) {
        //     System.out.print(str[i] + " ");
        // }

        int nums[] = {2,2,1,1,1,2,2};
        // System.out.println(majorityElement(nums));

        // mergeSort(str, 0, str.length);

        // int arr[] = { 2, 4, 1, 3, 5 };
        // countInversion(arr, 0, arr.length - 1);
        // System.out.println(count);

        boolean var1 = true;

                    boolean var2 = false;

                    if (var1)

                        System.out.println(var1);

                    else

                        System.out.println(var2);

    }
}
