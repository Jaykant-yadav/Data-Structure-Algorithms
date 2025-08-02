package DSA_Sheet;

import java.util.*;

public class easy {
    public static int majorityElement(int nums[]) { // O(n)
        if (nums.length == 0 || nums.length == 1)
            return -1;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // Set<Integer> keySet = map.keySet();
        for (Integer key : map.keySet()) {
            if (map.get(key) > nums.length / 2) {
                return key;
            }
        }

        return -1;
    }

    // Passcal Tringle - I
    public static List<List<Integer>> PascalTringle(int n) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> ans = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    ans.add(1);
                } else {
                    int val = res.get(i - 1).get(j - 1) + res.get(i - 1).get(j);
                    ans.add(val);
                }
            }
            res.add(ans);
        }

        return res;
    }

    // Passcal Tringle - II
    public static List<Integer> PascalTringle2(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            List<Integer> curr = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (i == j || j == 0) {
                    curr.add(1);
                } else {
                    curr.add(res.get(j - 1) + res.get(j));
                }
            }

            res = curr;
        }

        return res;
    }

    public static void main(String[] args) {
        // int nums[] = {3, 2, 3};
        // int nums[] = {};
        // int nums[] = {7, 7, 7, 7, 7};
        int nums[] = {1, 2, 2, 2, 2};
        // int nums[] = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));

        // System.out.println(PascalTringle(0));
        // System.out.println(PascalTringle2(3));
    }
}
