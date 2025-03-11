package DSA.Arrays;

class maxSumOfSubArrays {
    //Brute Force - O(n3) -> I
    public static void maxSumSubArrays(int arr[]){
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for(int i=0; i<arr.length; i++) {
            for(int j=i; j<arr.length; j++) {
                currSum = 0; // value always change
                for(int k=i; k<=j; k++) {
                    // System.out.print(arr[k] + " ");
                    //sub Arrays Sum
                    currSum += arr[k];
                }
                System.out.println(currSum);
                if(maxSum < currSum){
                    maxSum = currSum;
                }
            }
        }
        System.out.println("Max of Total SubArrays Sum : " +  maxSum);
    }


    //optimize method - O(n2) -> II
    public static void prefixSum(int num[]){
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int prefix[] = new int[num.length];

        prefix[0] = num[0];
        //calculate prefix arrays -prefix[i-1] + arr[i] 
        for(int i=1; i<prefix.length; i++) {
            prefix[i] = prefix[i-1] + num[i];
        }

        for(int i=0; i<num.length; i++) {
            int start = i;
            for(int j=i; j<num.length; j++) {
                int end = j;    
                //prefix[end] - prefix[start - 1] 
                currSum = start == 0 ? prefix[end] : prefix[end] - prefix[start-1];
                if(maxSum < currSum) {
                    maxSum = currSum;
                }
            }
        }
        System.out.println("Max of Total SubArrays Sum : " +  maxSum);
    }


    //Kadan's Algorithms - O(n) -> III
    public static void kadansAlgo(int arr[]){
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for(int i=0; i<arr.length; i++){
            currSum += arr[i];            
            maxSum = Math.max(maxSum, currSum);
            if(currSum < 0){
                currSum = 0;
            }
        }
        System.out.println("Max of Total SubArrays Sum : " +  maxSum);
    }
    public static void main(String[] args) {
        // int arr[] = {2, 4, 6, 8, 10};
        int arr[] = {-1, -2, -3, -4};
        // maxSumSubArrays(num);
        // prefixSum(arr);
        kadansAlgo(arr);
    }
    
}
//Explanation of prefix Arrays

/* For example, if the input array is [2, 4, 6, 8, 10], 
the prefix array will be calculated as:

prefix[0] = num[0] = 2
prefix[1] = prefix[0] + num[1] = 2 + 4 = 6
prefix[2] = prefix[1] + num[2] = 6 + 6 = 12
prefix[3] = prefix[2] + num[3] = 12 + 8 = 20
prefix[4] = prefix[3] + num[4] = 20 + 10 = 30

Resulting prefix[] array: [2, 6, 12, 20, 30] 
for the array [2, 4, 6, 8, 10], the prefix sum array will be [2, 6, 12, 20, 30]. 
Let's break down how the sum is calculated for various subarrays.

For i = 0 (start at index 0):

Subarray [2] (sum = prefix[0] = 2)
Subarray [2, 4] (sum = prefix[1] = 6)
Subarray [2, 4, 6] (sum = prefix[2] = 12)
Subarray [2, 4, 6, 8] (sum = prefix[3] = 20)
Subarray [2, 4, 6, 8, 10] (sum = prefix[4] = 30)

For i = 1 (start at index 1):

Subarray [4] (sum = prefix[1] - prefix[0] = 6 - 2 = 4)
Subarray [4, 6] (sum = prefix[2] - prefix[0] = 12 - 2 = 10)
Subarray [4, 6, 8] (sum = prefix[3] - prefix[0] = 20 - 2 = 18)
Subarray [4, 6, 8, 10] (sum = prefix[4] - prefix[0] = 30 - 2 = 28)

For i = 2 (start at index 2):

Subarray [6] (sum = prefix[2] - prefix[1] = 12 - 6 = 6)
Subarray [6, 8] (sum = prefix[3] - prefix[1] = 20 - 6 = 14)
Subarray [6, 8, 10] (sum = prefix[4] - prefix[1] = 30 - 6 = 24)

For i = 3 (start at index 3):

Subarray [8] (sum = prefix[3] - prefix[2] = 20 - 12 = 8)
Subarray [8, 10] (sum = prefix[4] - prefix[2] = 30 - 12 = 18)

For i = 4 (start at index 4):

Subarray [10] (sum = prefix[4] - prefix[3] = 30 - 20 = 10)
As the loops progress, maxSum is updated whenever a larger sum is found.

Final Result:
After iterating through all possible subarrays, maxSum will contain the largest sum. 
In this case, the maximum sum is 30, which corresponds to the entire array [2, 4, 6, 8, 10].
*/