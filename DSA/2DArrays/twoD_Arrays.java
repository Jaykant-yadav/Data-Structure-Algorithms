import java.util.*;
public class twoD_Arrays {
    //Search Element
    public static boolean search(int matrix[][], int target){
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if(matrix[i][j] == target){
                    System.out.println("found at cell (" + i +"," + j +")");
                    return true;
                }
            }
        }
        System.out.println("cell is not found");
        return false;
    }

    //larget & Smallest Element on the matrix
    public static void larAndSmall(int matrix[][]){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if(matrix[i][j] > max) {
                    max = matrix[i][j];
                }

                if(matrix[i][j] < min) {
                    min = matrix[i][j];
                }
            }
        }

        System.out.println("largest element : " + max);
        System.out.println("smallest element : " + min);
    }

    //
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int matrix[][] = new int[3][3];
        int n = matrix.length; //row
        int m = matrix[0].length; //col

        //input
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                // matrix[i][j] = sc.nextInt();
            }
        }

        //output
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++) {
                System.out.print(matrix[i][j] + " ");
            } System.out.println();
        }

        // search(matrix, 5);
        larAndSmall(matrix);


    }


    
}
