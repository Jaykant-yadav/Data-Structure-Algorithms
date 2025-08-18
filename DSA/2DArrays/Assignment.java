public class Assignment {
    // Print out the sum of the numbers in the second row of the "nums" array.
    public static void sumOfSecRow(int matrix[][]){
        int sum = 0;
        for(int j=0; j<matrix[0].length; j++){
            sum += matrix[1][j];
        }
        System.out.println("Sum of 2'sec row : " + sum);
    }
    // Print the number of 7's that are in the 2d array.
    public static void countSevenInMatrix(int matrix[][]){
        int sevenCount = 0;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == 7){
                    sevenCount++;
                }
            }
        }

        System.out.println("7's in Matrix : " + sevenCount + " time's");
    }

    // Write a program to Find Transpose of a Matrix.
    // What is Transpose?
    // Transpose of a matrix is the process of swapping the rows to columns. For a 2x3 matrix, 
    public static void transpose(int matrix[][], int row, int col) {
        // Display original matrix
        System.out.println("Original matrix : ");
        printMatrix(matrix);

        // Transpose matrix
        int transpose[][] = new int[col][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        // Print the Transpose matrix
        System.out.println("Transpose matrix : ");
        printMatrix(transpose);

    }

    public static void printMatrix(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int matrix[][] = { { 2, 3, 7 }, { 5, 6, 7 } };
        int row = 2, col = 3;
        // transpose(matrix, row, col);
        // countSevenInMatrix(matrix);
        sumOfSecRow(matrix);

    }
}
