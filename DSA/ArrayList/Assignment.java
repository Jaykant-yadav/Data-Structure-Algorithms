package DSA.ArrayList;

import java.util.*;

public class Assignment {
    // Monotonic ArrayList - Easy -> O(n)
    public static boolean isMonotonic(ArrayList<Integer> list) {
        boolean incresing = true;
        boolean decresing = true;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) < list.get(i + 1)) {
                decresing = false;
            }

            if (list.get(i) > list.get(i + 1)) {
                incresing = false;
            }
        }

        return incresing || decresing;
    }

    // Lonely Numbers in ArrayList - Medium ->
    public static List<Integer> lonelyNum(ArrayList<Integer> list) {
        Collections.sort(list);
        ArrayList<Integer> lists = new ArrayList<>();
        if (list.size() == 1) {
            list.add(list.get(0));
        }
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                if (list.get(i + 1) != list.get(i) + 1 && list.get(i) != list.get(i + 1)) {
                    lists.add(list.get(i));
                }
            } else if (i == list.size() - 1) {
                if (list.get(i - 1) != list.get(i) - 1 && list.get(i - 1) != list.get(i)) {
                    lists.add(list.get(i));
                }
            } else {
                if (list.get(i - 1) != list.get(i) - 1 && list.get(i + 1) != list.get(i) + 1
                        && list.get(i - 1) != list.get(i) && list.get(i + 1) != list.get(i)) {
                    lists.add(list.get(i));
                }
            }
        }

        return lists;
    }

    public static List<Integer> allLonelyNum(ArrayList<Integer> list) {
        Collections.sort(list);
        ArrayList<Integer> lists = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                if (list.get(i + 1) - list.get(i) > 1) {
                    lists.add(list.get(i));
                }
            } else if (i == list.size() - 1) {
                if (list.get(i) - list.get(i - 1) > 1) {
                    lists.add(list.get(i));
                }
            } else {
                if ((list.get(i + 1) - list.get(i) > 1) && (list.get(i) - list.get(i - 1) > 1)) {
                    lists.add(list.get(i));
                }
            }
        }

        return lists;
    }

    public static ArrayList<Integer> findAllLonelyNums(int nums[]) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }
        }
        int[] freq = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            freq[nums[i]]++;
        }
        ArrayList<Integer> sol = new ArrayList<>();

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == 1) {
                boolean hasPrev = (i - 1 >= 0 && freq[i - 1] > 0);
                boolean hasNext = (i + 1 < freq.length && freq[i + 1] > 0);

                if (!hasPrev && !hasNext) {
                    sol.add(i);
                }
            }
        }

        return sol;
    }

    // Most Frequent Number Following Key In an Array
    public static int mostFreqNum(int nums[], int key){
        Map<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == key) {
                int target = nums[i + 1];
                freq.put(target, freq.getOrDefault(target, 0) + 1);
            }
        }

        int ans = -1, maxCount = 0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                ans = entry.getKey();
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(5);
        list.add(6);
        list.add(8);

        int arr[] = { 10, 5, 6, 8 };
        // System.out.println(isMonotonic(list));
        System.out.println(lonelyNum(list));
        System.out.println(allLonelyNum(list));
    }
}
