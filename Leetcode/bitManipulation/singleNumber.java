package bitManipulation;

public class singleNumber {
    public static int singleNum(int arr[]) {
        int bit = 0, i = 0;
        while (arr.length < 0) {
            bit = bit ^ arr[i];
            i++;
        }
        return bit;
        
    }
    public static void main(String[] args) {
        int arr[] = {4,1,2,1,2};
        // System.out.println(singleNum(arr));
        System.out.println(singleNum(arr));

    }
}
