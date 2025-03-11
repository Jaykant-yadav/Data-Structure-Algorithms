public class removeDuplicates {
    //Time Complexity -> O(n)
    public static int removeDuplicate(int arr[]){
        int count = 1;
        for(int i=1; i<arr.length; i++) {
            //prev != end
            if(arr[i-1] != arr[i]){
                arr[count] = arr[i];
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int arr[] = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicate(arr));
    }
}
