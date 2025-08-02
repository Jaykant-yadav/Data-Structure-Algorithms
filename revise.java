import java.util.Arrays;

public class revise {
    public static int maxSubArraySum(int arr[]){
        int currSum = 0;
        int MaxSum = Integer.MIN_VALUE;

        int prefix[] = new int[arr.length];
        prefix[0] = arr[0];

        for(int i=1; i<prefix.length; i++){
            prefix[i] = prefix[i-1] + arr[i];
        }

        for(int i=0; i<arr.length; i++){
            for(int j=i; j<arr.length; j++){
                currSum = i == 0 ? prefix[j] : prefix[j] - prefix[i-1];
                MaxSum = Math.max(MaxSum, currSum);
            }

        }

        return MaxSum;
    }

    public static int subArrayOfCountk(int nums[], int k){
        int count = 0;
        int currSum = 0;
        for(int i=0; i<nums.length; i++){
            currSum = 0;
            for(int j=i; j<nums.length; j++){
                if(i == j){
                    currSum = nums[j];
                }else {
                    currSum += nums[i] + nums[j];
                }
                if(currSum == k){
                    count++;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int arr[] = {1, 1, 1};
        int arrs[] = {1, 2, 3};
        System.out.println(subArrayOfCountk(arrs, 3));       
        System.out.println(subArrayOfCountk(arr, 2));       

    }

    public static void printArr(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}