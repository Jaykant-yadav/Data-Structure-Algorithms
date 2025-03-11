//Leetcode link -> https://leetcode.com/problems/container-with-most-water/submissions/1497625370/
//Yt Link -> https://www.youtube.com/watch?v=EbkMABpP52U&list=PLfqMhTWNBTe137I_EPQd34TsgV6IO55pt&index=14
public class mostWaterContainer {
    //Brute Force - O(n2) 
    public static int mostWater(int height[]){
        int maxWater = 0;
        for(int i=0; i<height.length; i++) {
            for(int j=i+1; j<height.length; j++) {
                int width = j - i;
                int ht= Math.min(height[i], height[j]);
                int area = width * ht;
                maxWater = Math.max(maxWater, area);
            }
        }
        return maxWater;
    }

    //Two Pointer - O(n) -> Linear time
    public static int mostWater2(int height[]){
        int maxWater = 0;
        int leftPointer = 0, rightPointer = height.length-1;

        while (leftPointer < rightPointer) {
            int width = rightPointer - leftPointer;
            int ht = Math.min(height[leftPointer], height[rightPointer]);
            int currWater = width * ht;
            maxWater = Math.max(maxWater, currWater);

            if(height[leftPointer] < height[rightPointer]){
                leftPointer++;
            }else {
                rightPointer--;
            }
        }
        return maxWater;
    }
    public static void main(String[] args) {
        int height[] = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        // System.out.println(mostWater(height));
        System.out.println(mostWater2(height));
    }
}
