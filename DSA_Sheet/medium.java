package DSA_Sheet;

public class medium {
    public static void setZeroes(int matrix[][]) { // O(n*m) * (n + m) + (n * m)
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) { // O(n * m)
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) { // find in matrix zero
                    rowZero(i, matrix); // insert -1 in row respectively condition replace 1 .
                    colZero(j, matrix); // insert -1 in col respectively condition replace 1 .
                }
            }
        }

        for (int i = 0; i < m; i++) { // O(n * m)
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1) { // replace -1 to 0
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void rowZero(int i, int matrix[][]) { // insert in row -1
        for (int j = 0; j < matrix[0].length; j++) { // O(n)
            if (matrix[i][j] != 0) {
                matrix[i][j] = -1;
            }
        }
    }

    public static void colZero(int j, int matrix[][]) { // insert in col -1
        for (int i = 0; i < matrix.length; i++) { // O(m)
            if (matrix[i][j] != 0) {
                matrix[i][j] = -1;
            }
        }
    }

    // Approach - II -> Better solution
    public static void setZeroes2(int matrix[][]) {// tc-> O(n ^ 2) sc-> O(n + m)
        int m = matrix.length;
        int n = matrix[0].length;

        int row[] = new int[m]; // create a row array //O(m)
        int col[] = new int[n]; // create a col array //O(n)

        for (int i = 0; i < m; i++) { // O(n)
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1; // insert in row 1.
                    col[j] = 1; // insert in col 1
                }
            }
        }

        for (int i = 0; i < m; i++) { // O(n)
            for (int j = 0; j < n; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    matrix[i][j] = 0; // so row || col = 1 then completely row and col insert in metrix 0
                }
            }
        }
    }

    // Approach - III -> Optimized Solution
    public static void setZeroes3(int matrix[][]) {
        boolean firstRow = false, firstCol = false;
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstRow = true;
                break;
            }
        }

        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstCol = true;
                break;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (firstRow) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }

        if (firstCol) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int matrix[][] = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
        // setZeroes(matrix);
        // setZeroes2(matrix);
        setZeroes3(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
