public class maxProductSubArray {
    public static int maximumProduct(int arr[]){
        int max = Integer.MIN_VALUE;
        int prefix = 1, suffix = 1;

        int n = arr.length;
        for(int i=0; i<n; i++) {
            if(prefix == 0) {
                prefix = 1;
            }

            if(suffix == 0){
                suffix = 1;
            }

            prefix *= arr[i]; //left
            suffix *= arr[n-i-1]; //right
            max = Math.max(max, Math.max(prefix, suffix));
        }
        return max;
    }
    public static void main(String[] args) {
        int arr[] = {2, 3, -2, 4};
        System.out.println(maximumProduct(arr));
    }
}
