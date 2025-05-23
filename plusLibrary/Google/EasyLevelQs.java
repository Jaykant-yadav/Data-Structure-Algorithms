package plusLibrary.Google;

public class EasyLevelQs {
    public static int[] getRow(int n) {
        int ans[] = new int[n+1];
        ans[0] = 1;
        for(int i=1; i<=n; i++) {
            for(int j = i; j>0; j--) {
                ans[j] = ans[j] + ans[j-1];
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] row = getRow(3);
        for(int num : row) {
            System.out.print(num + " ");
        }
    }
}
