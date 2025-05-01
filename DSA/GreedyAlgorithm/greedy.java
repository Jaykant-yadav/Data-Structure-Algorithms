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

    // Min Absolute Difference Pairs
    public static int minAbsDiffPairs(int A[], int B[]) { //O(nlogn)
        Arrays.sort(A);
        Arrays.sort(B);

        int minDiff = 0;
        for(int i=0; i<A.length; i++) {
            minDiff += Math.abs(A[i]-B[i]);
        }
        return minDiff;
    }

    // Max length Chain of pairs
    public static void maxLengthChainOfPairs(int pairs[][]) { //O(nlogn)
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

        // First chain 
        int chainLength = 1;
        int chainEnd = pairs[0][1]; //last selected pair end // chain end

        for(int i=1; i<pairs.length; i++) {
            if(pairs[i][0] > chainEnd) {
                chainLength++;
                chainEnd = pairs[i][1];
            }
        }
        System.out.println("Maximum length of chain of pairs: " + chainLength);
    }

    // Indian Coins
    public static void indianCoins(Integer coins[], int amount) {
        Arrays.sort(coins, Comparator.reverseOrder());
        int countOfCoins = 0;
        ArrayList<Integer> usedCoins = new ArrayList<>();
        for (int i = 0; i < coins.length; i++) {
            if(coins[i] <= amount) { // Changed < to <= to include the coin if it equals the amount
                while (coins[i] <= amount) {
                    amount -= coins[i];
                    countOfCoins++;
                    usedCoins.add(coins[i]);
                    System.out.print(coins[i] + " ");
                }
            }
        }
        System.out.println("\nTotal coins used: " + countOfCoins);
    }

    // Job Sequencing Problem
    // Class Object Defined
    static class Job {
        int deadline;
        int profit;
        int id; // 0(A), 1(B), 2(C)

        // Constructor
        public Job(int i, int d, int p) {
            id = i;
            deadline = d;
            profit = p;
        }
    }
    public static void main(String[] args) {
        /* int start[] = {1, 3, 0, 5, 8, 5};
        int end[] = {2, 4, 6, 7, 9, 9};
        activitySelections(start, end);  */

        /* int value[] = {60, 100, 120};
        int weight[] = {10, 20, 30};
        int W = 50;
        fractionalKnapsack(value, weight, W); */

        /* int A[] = {1, 2, 3};
        int B[] = {2, 1, 3};
        int minDiff = minAbsDiffPairs(A, B);
        System.out.println("Minimum Absolute Difference: " + minDiff);
        

        int C[] = {4, 1, 8, 7};
        int D[] = {2, 3, 6, 5};
        int minDiff2 = minAbsDiffPairs(C, D);
        System.out.println("Minimum Absolute Difference for new arrays: " + minDiff2); */
/* 
        int pairs[][] = {{5, 24}, {39, 60}, {5, 28}, {27, 40}, {50, 90}};
        maxLengthChainOfPairs(pairs); */

        /* Integer coins[] = {1, 2, 5, 10, 20, 50, 100, 500, 2000};
        int amount = 1112;
        indianCoins(coins, amount); */
        
        // Job Sequence
        int jobInfo[][] = {{4, 20}, {1, 10}, {1, 40}, {1, 30}};    

        ArrayList<Job> jobs = new ArrayList<>();
        for (int i = 0; i < jobInfo.length; i++) {
            jobs.add(new Job(i, jobInfo[i][0], jobInfo[i][1]));
        }

        // Object Lambda Sorting Function
        Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit); // descending Order of profit

        ArrayList<Integer> seq = new ArrayList<>();
        int time = 0;
        for(int i=0; i<jobs.size(); i++) {
            Job curr = jobs.get(i);
            if (curr.deadline > time) {
                seq.add(curr.id);
                time++;
            }
        }
        System.out.println("Job sequence: " + seq);

        // print Seq 
        System.out.println("Max Jobs: " + seq.size());
        for(int i=0; i<seq.size(); i++) {
            System.out.print(seq.get(i) + " ");
        }
        System.out.println();
    }
}

