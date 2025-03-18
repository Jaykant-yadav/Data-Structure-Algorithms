package DSA.backtracking;

import DSA.Strings.string;

public class backtrack {

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void changeArr(int arr[], int i, int val) {
        // base case
        if (i == arr.length) {
            printArr(arr);
            return;
        }

        // recursion
        arr[i] = val;
        changeArr(arr, i + 1, val + 1);// fnx call step
        arr[i] = arr[i] - 2;// backtracking step
    }

    public static void findSubsets(String str, String ans, int i) {
        // Base case
        if (i == str.length()) {
            if (ans.length() == 0) {
                System.out.println("null");
            } else {
                System.out.println(ans);
            }
            return;
        }

        // recursion
        // yes choice
        findSubsets(str, ans + str.charAt(i), i + 1);

        // No Choice
        findSubsets(str, ans, i + 1);
    }

    // find permutations -> O(n * n!)
    public static void findPermutations(String str, String ans) {
        // base case
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        // recursion
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            // abcde = ab + de
            String newStr = str.substring(0, i) + str.substring(i + 1);
            findPermutations(newStr, ans + curr);
        }
    }

    // N Queens
    public static boolean isSafe(char board[][], int row, int col) {
        // vertical up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // diag left up
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // diag right up
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    static int count = 0;

    public static void nQueens(char board[][], int row) {
        // Base case
        if (row == board.length) {
            // printBoard(board);
            count++;
            return;
        }
        // Column
        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q'; // To sit queen row,j
                nQueens(board, row + 1); // call row + 1 -> function call
                board[row][j] = 'X';// delete Q row, J -> Backtracking step
            }
        }
    }

    // N - Queens (One solutions)
    public static boolean nQueensOneSoln(char board[][], int row) {
        // Base case
        if (row == board.length) {
            // printBoard(board);
            count++;
            return true;
        }
        // Column
        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q'; // To sit queen row,j
                if (nQueensOneSoln(board, row + 1)) {
                    return true;
                } // call row + 1 -> function call
                board[row][j] = 'X';// delete Q row, J -> Backtracking step
            }
        }

        return false;
    }

    public static void printBoard(char board[][]) {
        System.out.println("--------- Chess board ---------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Find Grid Ways -> O(2)
    public static int gridWays(int i, int j, int n, int m) {
        // Base case
        if (i == n - 1 && j == m - 1) { // Condition for last cell
            return 1;
        } else if (i == n || j == n) { // Boundry
            return 0;
        }

        int Ways1 = gridWays(i + 1, j, n, m);
        int Ways2 = gridWays(i, j + 1, n, m);

        return Ways1 + Ways2;
    }

    // Sudoku Solver
    public static boolean isSafe(int sudoku[][], int row, int col, int digit) {
        // Column
        for(int i=0; i<=8; i++) {
            if(sudoku[i][col] == digit) {
                return false;
            }
        }

        // Row
        for(int j=0; j<=8; j++) {
            if(sudoku[row][j] == digit) {
                return false;
            }
        }

        // grid
        int sr = (row/3) * 3;
        int sc = (col/3) * 3;
        // 3x3 grid
        for(int i=sr; i<sr+3; i++) {
            for(int j=sc; j<sc+3; j++) {
                if(sudoku[i][j] == digit) {
                    return false;
                }
            }
        }

        return true;
    }
    public static boolean sudokuSolver(int sudoku[][], int row, int col) {  
        // Base Case
        if(row == 9 && col == 0) {
            return true;
        }
        // Recursion
        int nextRow = row, nextCol = col + 1;
        if(col + 1 == 9) {
            nextRow = row + 1;
            nextCol = 0;
        }

        if(sudoku[row][col] != 0) {
            return sudokuSolver(sudoku, nextRow, nextCol);
        }

        for(int digit=1; digit<=9; digit++) {
            if(isSafe(sudoku, row, col, digit)){
                sudoku[row][col] = digit;
                if(sudokuSolver(sudoku, nextRow, nextCol)){ //soln exits
                    return true;
                }
                sudoku[row][col] = 0;
            }
        }

        return false;
    }

    public static void printSudoku(int sudoku[][]) {
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // int arr[] = new int[5];
        // changeArr(arr, 0, 1);
        // printArr(arr);

        // String str = "abc";
        // findSubsets(str, "", 0);
        // findPermutations(str, "");

        // N Queens Problems
        int n = 4;
        char board[][] = new char[n][n]; // board N X N
        // initialize
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'X';
            }
        }

        // nQueens(board, 0);
        if (nQueensOneSoln(board, 0)) {
            // System.out.println("Solution is possible");
            // printBoard(board);
        } else {
            System.out.println("solution is not possible");
        }
        // System.out.println("Total ways to solve n queens = " + count);

        // System.out.println(gridWays(0, 0, 3, 3));

        int sudoku[][] = { { 0, 0, 8, 0, 0, 0, 0, 0, 0 },
                { 4, 9, 0, 1, 5, 7, 0, 0, 2 },
                { 0, 0, 3, 0, 0, 4, 1, 9, 0 },
                { 1, 8, 5, 0, 6, 0, 0, 2, 0 },
                { 0, 0, 0, 0, 2, 0, 0, 6, 0 },
                { 9, 6, 0, 4, 0, 5, 3, 0, 0 },
                { 0, 3, 0, 0, 7, 2, 0, 0, 4 },
                { 0, 4, 9, 0, 3, 0, 0, 5, 7 },
                { 8, 2, 7, 0, 0, 9, 0, 1, 3 }
        };

        if(sudokuSolver(sudoku, 0, 0)) {
            System.out.println("solution exists");
            printSudoku(sudoku);
        } else {
            System.out.println("solution does not exits");
        }

    }
}
