public class productOfArraysAcceptSelf {
    //Brute Force - O(n2)
    public static int[] productOfArrays(int nums[]){
        int n = nums.length;
        int ans[] = new int[n];
        for(int i=0; i<n; i++){
            int prod = 1;
            for(int j=0; j<n; j++){
                if(i != j){
                    prod *= nums[j];
                }
            }
            ans[i] = prod;
        }
        return ans;
    }

    //Optimized Code - O(n)
    //Time Complxity - O(1)
    public static int[] productOfArrays2(int nums[]) {
        int n = nums.length;

        int ans[] = new int[n];
        ans[0] = 1;
        //prefix => ans => leftside
        for(int i=1; i<n; i++) {
            ans[i] = ans[i-1] * nums[i-1];
        }

        //suffix -> rightside
        int suffix = 1;
        for(int i=n-2; i>=0; i--) {
            suffix *= nums[i+1]; //ith suffix
            ans[i] *= suffix;
        }

        return ans;
    }
    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4};
        int res[] = new int[nums.length];
        // res = productOfArrays(nums);
        res = productOfArrays2(nums);
        for(int i=0; i<res.length; i++){
            System.out.print(res[i]+",");
        }
    }
}
