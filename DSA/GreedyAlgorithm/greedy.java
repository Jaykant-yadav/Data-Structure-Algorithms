package DSA.GreedyAlgorithm;

import java.util.*;

public class greedy {
    // Unsorted Activity
    public static void activitySelections(int start[], int end[]) { //n(log n)
        // sorting
        int activities[][] = new int[start.length][3];
        for(int i=0; i<start.length; i++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        // lambda function -> shortForm
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        // 1st activity
        maxAct = 1;
        ans.add(activities[0][0]);
        int lastEnd = activities[0][2];
        for(int i=1; i<end.length; i++) {
            if(activities[i][1] >= lastEnd){
                // activity select
                maxAct++;
                ans.add(activities[i][0]);
                lastEnd = activities[i][2];
            }
        }

        System.out.println("Maximum activity : " + maxAct);
        for(int i=0; i<ans.size(); i++) {
            System.out.print("A" +  ans.get(i) + " ");
        }
        System.out.println();
    }
    // Sorted ending time bases activity 
    public static void activitySelection(int start[], int end[]) {//O(n)
        // end bases sorted
        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        // 1st activity
        maxAct = 1;
        ans.add(0);
        int lastEnd = end[0];
        for(int i=1; i<end.length; i++) {
            // Activity selected
            if(start[i] >= lastEnd) {
                maxAct++;
                ans.add(i);
                lastEnd = end[i];
            }
        }

        System.out.println("Maximum activity : " + maxAct);
        for(int i=0; i<ans.size(); i++) {
            System.out.print("A" +  ans.get(i) + " ");
        }
        System.out.println();
    }

    // Fractional Knapsack 
    public static void fractionalKnapsack(int value[], int weight[], int W) {
        double ratio[][] = new double[value.length][2];
        // 0th col => idx; 1st col => ratio
        for (int i = 0; i < value.length; i++) { //ratio calculate
            ratio[i][0] = i;
            ratio[i][1] = value[i]/(double)weight[i];
        }

        // ascending order
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int capacity = W;
        int finalVal = 0;
        for(int i=ratio.length-1; i>=0; i--) {
            int idx = (int)ratio[i][0];
            if(capacity >= weight[idx]) { //include full item
                finalVal += value[idx]; // corrected to use idx
                capacity -= weight[idx]; // deducting the weight from capacity    
            }else {
                // include fractional item
                finalVal += (ratio[i][1] * capacity);
                capacity = 0;
                break; // exit loop after including fractional item
            }
        }

        System.out.println("final value: " + finalVal);


    }
    public static void main(String[] args) {
        /* int start[] = {1, 3, 0, 5, 8, 5};
        int end[] = {2, 4, 6, 7, 9, 9};
        activitySelections(start, end);  */

        int value[] = {60, 100, 120};
        int weight[] = {10, 20, 30};
        int W = 50;
        fractionalKnapsack(value, weight, W);
                
    }
}
