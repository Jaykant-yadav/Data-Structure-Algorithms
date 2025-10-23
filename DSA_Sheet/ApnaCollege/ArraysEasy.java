package DSA_Sheet.ApnaCollege;
import java.util.*;
public class ArraysEasy {
    // Single Element -> 
    // Brute force -> TC -> O(n)+O(m) -> O(n+m) , SC -> O(n)
    public static int singleEle(int nums[]){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        System.out.println(map);

        for(int n : map.keySet()){
            if(map.get(n) == 1){
                return n;
            }
        }

        return -1;
    }

    // Using Frequency -> O(n^2)
    public static int singleEle2(int nums[]){
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        for(int i=0; i<n; i++){
            int freq = 0;
            for(int j=0; j<n; j++){
                if(nums[i] == nums[j]){
                    freq++;
                }
            }

            if(freq == 1){
                return nums[i];
            }
        }

        return -1;
    }

    // Using XOR -> O(n)
    public static int singleEle3(int nums[]){
        int XOR = 0;
        for(int i=0; i<nums.length; i++){
            XOR ^= nums[i];
        }

        return XOR;
    }

    // Majority Element
    // Using Hashmap -> TC - O(n) && SC -> O(n)
    public static int majorityEle(int nums[]){
        HashMap<Integer, Integer> Hs = new HashMap<>();
        int n = nums.length;
        for(int i=0; i<nums.length; i++){
            Hs.put(nums[i], Hs.getOrDefault(nums[i], 0)+1);
            if(Hs.get(nums[i]) > n/2){
                return nums[i];
            }
        }
        return -1;
    }

    // Using Freq -> O(n^2)
    public static int majorityEle2(int nums[]){
        int n = nums.length-1;
        for(int i=0; i<nums.length; i++){
            int freq = 0;
            for(int j=0; j<nums.length; j++){
                if(nums[i] == nums[j]){
                    freq++;
                }
            }

            if(freq > n/2){
                return nums[i];
            }
        }

        return -1;
    }

    // Using sorting -> O(n log n)
    public static int majorityEle3(int nums[]){
        int n = nums.length;
        Arrays.sort(nums);
        return nums[n/2];
    }

    // Using Freq
    public static int majorityEle4(int nums[]){
        Arrays.sort(nums);
        int freq = 1, ans = nums[0];
        int n = nums.length;
        for(int i=1; i<nums.length; i++){
            if(nums[i] == nums[i-1]){
                freq++;
            }else{
                freq = 1;
                ans = nums[i];
            }

            if(freq > n/2){
                return ans;
            }
        }
        return ans;
    }

    // Moore's voting Algorithms -> O(n) & O(1)
    public static int majorityEle5(int nums[]){
        int freq = 0, ans = 0;
        for(int i=0; i<nums.length; i++){
            if(freq == 0){
                ans = nums[i];
            }

            if(ans == nums[i]){
                freq++;
            }else{
                freq--;
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        // int nums[] = {2, 2, 1, 1, 1, 2, 2};
        int nums[] = {1,3,1,1,4,1,1,5,1,1,6,2,2};
        System.out.println(majorityEle5(nums));
    }
}
