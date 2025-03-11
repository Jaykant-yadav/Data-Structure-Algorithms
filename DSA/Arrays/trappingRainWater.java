package DSA.Arrays;

public class trappingRainWater {
    //Time Complexity -> O(n)
    public static int trappedRainwater(int height[]){
        int n = height.length;
        //calculate left max boundry - Array
        int leftmax[] = new int[height.length];
        leftmax[0] = height[0];
        for(int i=1; i<n; i++){
            leftmax[i] = Math.max(height[i], leftmax[i-1]);
        }

        //calculate right max boundry - Array
        int rightmax[] = new int[height.length];
        rightmax[n-1] = height[n-1];
        for(int i=n-2; i>=0; i--){
            rightmax[i] = Math.max(height[i], rightmax[i+1]);
        }

        int trappedWater = 0;
        //loop
        for(int i=0; i<height.length; i++) {
            //waterlevel = min(leftmax bound, rightmax bound)
            int waterLevel = Math.min(leftmax[i], rightmax[i]);

            //trapped water = waterLevel - height[i]
            trappedWater += waterLevel - height[i];
        }

        return trappedWater;
    }
    public static void main(String args[]){
        int height[] = {4, 2, 0, 6, 3, 2, 5};
        System.out.println(trappedRainwater(height));
    }
}
