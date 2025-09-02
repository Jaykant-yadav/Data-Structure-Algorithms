package DSA.ArrayList;
import java.util.*;

public class arraylist {
    public static void main(String[] args) {
        // Java Collection Framework
        // ClassName objectName = new ClassName();
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<Boolean> list3 = new ArrayList<>();

        //Add elements -> O(1)
        list.add(1); 
        list.add(2); 
        list.add(3);
        list.add(4);
        list.add(5);
        // list.add(2, 10); //-> O(n)
        // System.out.println(list.size());

        // Get Operations -> O(1)
        // System.out.println(list.get(2));

        // Delete -> O(n)
        // list.remove(2);
        // System.out.println(list);

        // set operations -> O(n)
        // System.out.println(list.set(2, 8));
        // System.out.println(list);

        // Contains Element -> O(n)
        // System.out.println(list.contains(8));
        // System.out.println(list.contains(3));

        // print the arrayList
        for(int i=0; i<list.size(); i++) {
            // System.out.print(list.get(i) + " ");
        }

        // Reverse print ArrayList -O(n)
        for(int i=list.size()-1; i>=0; i--) {
            // System.out.print(list.get(i) +" ");
        }

        // Find maximum in an arrayList -> O(n)
        int max = Integer.MIN_VALUE;
        for(int i=0; i<list.size(); i++) {
            // if(max < list.get(i)) {
            //     max = list.get(i);
            // }

            max = Math.max(max, list.get(i));
        }
        // System.out.println(max);

        // Swap 2 Numbers
        int idx1 = 1, idx2 = 3;
        // System.out.println(list);
        swap(list, idx1, idx2);
        // System.out.println(list);

        // ArrayList Sort
        Collections.sort(list);
        // System.out.println(list);
        Collections.sort(list, Collections.reverseOrder());
        // System.out.println(list);

        // Multi-Dimentional ArrayList
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        ArrayList<Integer> list1 = new  ArrayList<>();
        list1.add(1); list1.add(2);
        mainList.add(list1);

        ArrayList<Integer> lists2 = new  ArrayList<>();
        lists2.add(3); lists2.add(4);
        mainList.add(lists2);

        for(int i=0; i<mainList.size(); i++) {
            ArrayList<Integer> currList = mainList.get(i);
            for(int j=0; j<currList.size(); j++) {
                // System.out.print(currList.get(j) + " ");
            }
            // System.out.println();
        }

        // System.out.println(mainList);

        // Examples
        ArrayList<ArrayList<Integer>> mainLists = new ArrayList<>();
        ArrayList<Integer> numList = new  ArrayList<>();
        ArrayList<Integer> numList2 = new  ArrayList<>();
        ArrayList<Integer> numList3 = new  ArrayList<>();

        for(int i=1; i<=5; i++) {
            numList.add(i*1);// 1 2 3 4 5
            numList2.add(i*2);// 2 4 6 8 10
            numList3.add(i*3);// 3 9 12 15 18
        }
        // System.out.println(numList);
        // System.out.println(numList2);
        // System.out.println(numList3);
        mainLists.add(numList);
        mainLists.add(numList2);
        mainLists.add(numList3);
        // numList2.remove(3);
        // numList3.remove(2);

        // System.out.println(mainLists);

        //Nested loop
        for(int i=0; i<mainLists.size(); i++) {
            ArrayList<Integer> currList = mainLists.get(i);
            for(int j=0; j<currList.size(); j++) {
                // System.out.print(currList.get(j) + " ");
            }
            // System.out.println();
        }

        // Container with stored most water
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);

        ArrayList<Integer> lists = new ArrayList<>();
        lists.add(11);
        lists.add(15);
        lists.add(6);
        lists.add(8);
        lists.add(9);
        lists.add(10);
        int target = 15;

        // System.out.println(mostWater1(height));
        // System.out.println(pairSum(list, target));
        // System.out.println(pairSum1(lists, target));
        System.out.println(pairSum2(lists, target));

        
    }

    // Pair sum - 2
    //optimised solution -> O(n)
    public static boolean pairSum2(ArrayList<Integer> lists, int target) {
        int bp = -1; //breaking point
        int n = lists.size();
        for(int i=0; i<lists.size(); i++) {
            if(lists.get(i) > lists.get(i+1)) {//braking point
                bp = i;
                break;
            }
        }

        int lp = bp+1; //smaller element
        int rp = bp; //larger element
        while (lp != rp) {
            // Case - 1
            int sum = lists.get(lp) + lists.get(rp);
            if(sum == target) {
                return true;
            }
            // Case - 2
            if(sum < target) {
                lp = (lp+1) % n;
            } else {
                // Case - 3
                rp = (n + rp - 1) % n;
            }
        }
        return false;
    }

    // Pair sum - 1
    // Brute force -> O(n^2)
    public static boolean pairSum1(ArrayList<Integer> list, int target) {
        for(int i=0; i<list.size(); i++) {
            for(int j=i+1; j<list.size(); j++) {
                int sum = list.get(i) + list.get(j);
                if(sum == target) {
                    return true;
                }
            }
        }
        return false;
    }

    // Optimized Solution of Two pointer approach -> O(n)
    public static boolean pairSum(ArrayList<Integer> list, int target) {
        int lp = 0, rp = list.size()-1;
        while (lp < rp) {
            // Case - 1
            if(list.get(lp) + list.get(rp) == target) {
                return true;
            }

            // Case - 2
            if(list.get(lp) + list.get(rp) > target) {
                lp++;
            } else {
                // Case - 3 lp+rp > target
                rp--;
            }
        }
        return false;
    }

    // Container with stored most water -> Flipkart, Danzo
    public static int mostWater(ArrayList<Integer> height) {
        int maxWater = 0;

        // Brute forced approch - O(n^2)
        for(int i=0; i<height.size(); i++) {
            for(int j=1; j<height.size(); j++) {
                int ht = Math.min(height.get(i), height.get(j));
                int wt = j - i;

                int currWater = ht * wt;
                maxWater =  Math.max(maxWater, currWater);
            }
        }
        return maxWater;
    }

    public static int mostWater1(ArrayList<Integer> height) {
        // Optimized solution - O(n) -> Two Pointer 
        int maxWater = 0;
        int lp = 0, rp = height.size()-1;
        while (lp < rp) {
            // Calculate water area
            int ht = Math.min(height.get(lp), height.get(rp));
            int wt = rp - lp;
            int currWater = ht * wt;
            maxWater = Math.max(maxWater, currWater);

            // update ptr
            if(height.get(lp) < height.get(rp)){
                lp++;
            }
            else {
                rp--;
            }
        }
        return maxWater;
    }

    public static void swap(ArrayList<Integer> list, int idx1, int idx2) {
        Integer temp = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, temp);
    }
}
