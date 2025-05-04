package Interview150;

public class Java {
    // Extra Space
    public static int[] rotateArrays(int nums[], int k) {
        int n = nums.length;//length
        int result[] = new int[nums.length];//new array
        for(int i=0; i<k; i++) {//i=0-k
            result[i] = nums[n - k + i];//7-3+1=> 
        }

        for(int i=k; i<n; i++) {
            result[i] = nums[i-k];
        }

        return result;
    }

    // Brute Force
    public static void rotateArrays2(int nums[], int k) {
        int n = nums.length;
        for(int i=0; i<k; i++) {
            int last = nums[n-1];
            for(int j=n-1; j>0; j--) {
                nums[j] = nums[j-1];
            }
            nums[0] = last;
        }
    }

    // MINISUM SIZE SubArray Sum 
    public static int miniSizeSubArrSum(int nums[], int target) {
        int n = nums.length;
        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            sum += nums[right];

            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }


    public static void main(String[] args) {
        // Rotate Array
        int arr[] = {1, 2, 3, 4, 5 , 6, 7};
        int k = 3;
        // int nums[] = rotateArrays(arr, k);
        rotateArrays2(arr, k);
        printArr(arr);
    }

    // Print arr
    public static void printArr(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
