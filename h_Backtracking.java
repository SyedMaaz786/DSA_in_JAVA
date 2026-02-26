public class h_Backtracking {
    //Backtracking on arr
    public static void changeArr(int arr[], int i, int val) {
        //base case
        if (i == arr.length) {
            printArr(arr);
            return;
        }
        //recursion
        arr[i] = val; //Here we are placing values from 0 index. This is printed while going up
        changeArr(arr, i+1, val+1); //values will be placed on next index and so on ...
        //backtracking
        arr[i] = arr[i] - 2; //This is printed while coming down
    }
    public static void printArr(int arr[]) {
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    //Find subsets
    public static void findSubsets(String str, String ans, int i) {  //we created a empty String ans inside which the values are stored
        //base case
        if (i == str.length()) {
            System.out.println(ans);
            return;
        }
        //recursion
        //Yes Choice
        findSubsets(str, ans + str.charAt(i), i+1);
        //No Choice
        findSubsets(str, ans, i+1);
    }


    //Find subsets using StringBuilder
    public static void printSubsets(String str, StringBuilder ans, int i) {
        //base case
        if (i == str.length()) {
            System.out.println(ans);
            return;
        }
        //recursion
        //Yes choice
        printSubsets(str, ans.append(str.charAt(i)), i+1);
        //Backtrack
        ans.deleteCharAt(ans.length() - 1);  //This line is used because we used StringBuilder which is mutable and hence it will not create a new string object for next step (GPT)
        //No choice
        printSubsets(str, ans, i+1);
    }


    //find Permutations (For this explain the dry run in interview)
    public static void findPermutations(String str, String ans) {
        //base case 
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }
        //recursion
        for (int i=0; i<str.length(); i++) {
            char curr = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i + 1); //Check this line in GPT
            findPermutations(newStr, ans + curr);
        }
    }


    //Queens problem
    public static boolean isSafe(char board[][], int row, int col) {
        //vertical up
        for (int i=row-1; i>=0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        //diagonal left
        for (int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        //diagonal right
        for (int i=row-1, j=col+1; i>=0 && j<board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
    //for all possible soln
    public static void nQueens(char board[][], int row) {
        //base case 
        if (row == board.length) {
            printBoard(board);
            count ++;  //This is the optimisation to print the tot numb of ways to get the sol
            return;
        }
        //recursion
        //col loop to print Q
        for (int col=0; col<board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                nQueens(board, row+1); //fnx call
                board[row][col] = '_'; //backtracking step
            }    

        }
    }
    
    // //for one soln
    // public static boolean nQueens(char board[][], int row) {
    //     //base case 
    //     if (row == board.length) {
    //         printBoard(board);
    //         count ++;  //This is the optimisation to print the tot numb of ways to get the sol
    //         return true;
    //     }
    //     //recursion
    //     //col loop to print Q
    //     for (int col=0; col<board.length; col++) {
    //         if (isSafe(board, row, col)) {
    //             board[row][col] = 'Q';
    //             if (nQueens(board, row+1)) { //fnx call
    //                 return true;
    //             }
    //             board[row][col] = '_'; //backtracking step
    //         }    

    //     }
    //     return false;
    // }

    public static void printBoard(char board[][]) {
        System.out.println("----Chess Board----");
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    static int count = 0;


    //Grid ways (for going right and down only)
    public static int gridWays(int i, int j, int n, int m) {
        //base case
        if (i == n-1 && j == m-1) {  //condition for last cell
            return 1;
        }
        else if (i == n || j == n) {  //boundary condition
            return 0;
        }
        //recursion
        int way1 = gridWays(i+1, j, n, m); //going down
        int way2 = gridWays(i, j+1, n, m); //going right
        return way1 + way2;
        }

    
    //Sudoku 
    public static boolean isSafe(int sudoku[][], int row, int col, int digit) {
        //row
        for (int j=0; j<9; j++) {
            if(sudoku[row][j] == digit) {
                return false;
            }
        }
        //col
        for (int i=0; i<9; i++) {
            if(sudoku[i][col] == digit) {
                return false;
            }
        }
        //grid
        int sr = (row/3) * 3;
        int sc = (col/3) * 3;
        for (int i=sr; i<sr+3; i++){
            for (int j=sc; j<sc+3; j++) {
                if(sudoku[i][j] == digit) {
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean sudokuSolver(int sudoku[][], int row, int col) {
        //base case
        if(row == 9) {
            return true;
        }
        //recursion
        int nextRow = row, nextCol = col+1;
        if(col+1 == 9) {
            nextRow = row+1;
            nextCol = 0; 
        }
        if(sudoku[row][col] !=0) {
            return sudokuSolver(sudoku, nextRow, nextCol);
        }
        for (int digit=1; digit<=9; digit ++) {
            if(isSafe(sudoku, row, col, digit)){
                sudoku[row][col] = digit;
                //soln exists (GPT if dought)
                if(sudokuSolver(sudoku, nextRow, nextCol)) {  //recursive fnx call
                    return true;
                }
                sudoku[row][col] = 0; //backtracking step
            }
        }
        return false;
    }
    public static void printSudoku(int sudoku[][]) {
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        // int arr[] = new int[5];
        // changeArr(arr, 0, 1);
        // printArr(arr);
        // String str = "abc";
        // printSubsets(str,new StringBuilder() , 0);
        // findSubsets(str, "", 0);
        // findPermutations(str, "");
        // int n = 4;
        // char board[][] = new char[n][n];
        // //Initializing value in board
        // for (int row=0; row<n; row++) {
        //     for (int col=0; col<n; col++) {
        //         board[row][col] = '_';
        //     }
        // }
        // nQueens(board, 0);
        // System.out.println("Total numb of ways to solve nQueens problem is: " + count);
        // if (nQueens(board, 0)) {
        //     System.out.println("Solution is possible");
        // }
        // else {
        //     System.out.println("Solution is not possible");
        // }
        // int n = 3, m = 3;
        // System.out.println(gridWays(0, 0, n, m));
        int sudoku[][] = {
        {0, 0, 8, 0, 0, 0, 0, 0, 0},
        {4, 9, 0, 1, 5, 7, 0, 0, 2},
        {0, 0, 3, 0, 0, 4, 1, 9, 0},
        {1, 8, 5, 0, 6, 0, 0, 2, 0},
        {0, 0, 0, 0, 2, 0, 0, 6, 0},
        {9, 6, 0, 4, 0, 5, 3, 0, 0},
        {0, 3, 0, 0, 7, 2, 0, 0, 4},
        {0, 4, 9, 0, 3, 0, 0, 5, 7},
        {8, 2, 7, 0, 0, 9, 0, 1, 3}
        };
        if(sudokuSolver(sudoku, 0, 0)) {
            System.out.println("Solution exists");
            printSudoku(sudoku);
        }
        else {
            System.out.println("Solution doesn't exists");
        }
    }
}
