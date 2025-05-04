import java.util.*;

public class Challange {
    // #1day 3Sum
    public static List<List<Integer>> threeSum(int nums[]) { // Fixed the return type to ArrayList<Integer>
        Arrays.sort(nums);
        List<List<Integer>> tripletsNum = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                        if (!tripletsNum.contains(triplet)) {
                            tripletsNum.add(triplet);
                        }
                    }
                }
            }
        }
        return tripletsNum;
    }

    // #2day Length of Last Word
    public static int lengthOfLastWord(String s) {
       
        if (s == null || s.length() == 0) return 0;
        int length = 0;
        int i = s.length() - 1;


        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }


        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }
        return length;
    }

    public static void main(String[] args) {
        // int arr[] = {-1, 0, 1, 2, -1, -4};
        /* int arr[] = { 0, 0, 0 };
        List<List<Integer>> result = threeSum(arr);
        System.out.println(result); */

        String s = "Hello world";
        System.out.println(lengthOfLastWord(s));
        
    }
}
