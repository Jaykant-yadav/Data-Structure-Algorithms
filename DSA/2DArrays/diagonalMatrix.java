public class diagonalMatrix {
    //Brute force
    public static int diagonalMatrixes(int matrix[][]){ // O(n^2)
        int sum = 0;
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                //primary diagonal (pd)
                if(i == j) {
                    sum += matrix[i][j];
                } else if(i+j == matrix.length-1){ //Secondary diagonal (sd)
                    sum += matrix[i][j];
                }
            }
        }
        return sum;
    }

    //Optimal Solution
    public static int diagonalMatrixess(int matrix[][]){ // O(n)
        int sum = 0;
        for(int i=0; i<matrix.length; i++) {
            //pd
            sum += matrix[i][i];
            //sd
            if(i != matrix.length-1-i){
                sum += matrix[i][matrix.length-1-i];
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        int matrix[][] = {{1, 2, 3, 4}, 
                          {5, 6, 7, 8}, 
                          {9, 10, 11, 12}, 
                          {13, 14, 15, 16}};
        System.out.println(diagonalMatrixes(matrix));
        System.out.println(diagonalMatrixess(matrix));
    }
}
