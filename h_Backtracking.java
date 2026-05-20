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


    //Find subsets (refer notes very important)
    public static void findSubsets(String str, String ans, int i) {  //we created a empty String ans inside which the values are stored
        //base case
        if (i == str.length()) {
            System.out.println(ans);
            return;
        }
        //recursion (each time both of this recursive calls are executed at a time, check recursion tree made in new notes)
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
        ans.deleteCharAt(ans.length() - 1);  //same as subset1 and 2 on leetcode for ArrayList
        //No choice
        printSubsets(str, ans, i+1);
    }


    //find Permutations (For this explain the dry run from notes in interview) (similar to subsets but string here)
    public static void findPermutations(String str, StringBuilder sb, boolean used[]){ //we have used leetcode backtracking approach
        if(sb.length() == str.length()){
            System.out.println(sb.toString());
            return;
        }
        for(int i=0; i<str.length(); i++){
            if(used[i]){ //used is true then skip
                continue;
            }
            else{ 
                used[i] = true; //make it true
                sb.append(str.charAt(i)); //append that ele
            }
            findPermutations(str, sb, used); //recursive call
            sb.deleteCharAt(sb.length()-1); //backtracking step
            used[i] = false;
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
        //diagonal left up
        for (int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        //diagonal right up
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

    
    //Sudoku  (for flow check leetcode)
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
        int nextRow = row, nextCol = col+1; //row is same col will be incremented
        if(col+1 == 9) { //when we are about to cross the grid, go to next row now col will be from starting ie 0
            nextRow = row+1;
            nextCol = 0; 
        }
        if(sudoku[row][col] !=0) {
            return sudokuSolver(sudoku, nextRow, nextCol);
        }
        for (int digit=1; digit<=9; digit ++) {
            if(isSafe(sudoku, row, col, digit)){
                sudoku[row][col] = digit;
                //soln exists
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


    //rat in a maze
    public static void ratMaze(int maze[][]){
        int n = maze.length;
        boolean visited[][] = new boolean[n][n];
        helper(maze, 0, 0, "", visited);
    }
    public static void helper(int maze[][], int row, int col, String path, boolean visited[][]){
        int n = maze.length;
        if(row < 0 || col < 0 || row >= n || col >= n){ //bc: out of bound
            return;
        }
        if(maze[row][col] == 0){ //bc: blocked cell check question(we can't enter 0 cell)
            return;
        }
        if(visited[row][col]){ //already visited
            return;
        }
        if(row == n-1 && col == n-1){
            System.out.println(path);
            return;
        }
        visited[row][col] = true;
        //down
        helper(maze, row+1, col, path + "D", visited); 
        //up
        helper(maze, row-1, col, path + "U", visited);
        //left
        helper(maze, row, col-1, path + "L", visited);
        //right 
        helper(maze, row, col+1, path + "R", visited);
        visited[row][col] = false; //backtracking step
    }


    //knight tour
    static int N = 8;

    static int xMoves[] = {2, 1, -1, -2, -2, -1, 1, 2};
    static int yMoves[] = {1, 2, 2, 1, -1, -2, -2, -1};

    public static boolean isSafe(int board[][], int row, int col){
        return (row >= 0 && col >= 0 && 
                row < N && col < N &&
                board[row][col] == -1);
    }
    public static boolean solveKnightTour(int board[][], int row, int col, int moveNo){
        if(moveNo == N * N){ //bc: visited all cells
            return true; 
        }
        for(int k=0; k<8; k++){
            int nextRow = row + xMoves[k];
            int nextCol = col + yMoves[k];

            if(isSafe(board, nextRow, nextCol)){
                board[nextRow][nextCol] = moveNo;

                if(solveKnightTour(board, nextRow, nextCol, moveNo + 1)){ //recursive call
                    return true;
                }
                board[nextRow][nextCol] = -1; //backtrack
            }
        }
        return false;
    } 
    public static void printBoard(int board[][]){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                System.out.print(board[i][j] + " ");
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
        // String str = "abc";
        // boolean used[] = new boolean[str.length()];
        // findPermutations(str, new StringBuilder(), used);
        
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
        // int sudoku[][] = {
        // {0, 0, 8, 0, 0, 0, 0, 0, 0},
        // {4, 9, 0, 1, 5, 7, 0, 0, 2},
        // {0, 0, 3, 0, 0, 4, 1, 9, 0},
        // {1, 8, 5, 0, 6, 0, 0, 2, 0},
        // {0, 0, 0, 0, 2, 0, 0, 6, 0},
        // {9, 6, 0, 4, 0, 5, 3, 0, 0},
        // {0, 3, 0, 0, 7, 2, 0, 0, 4},
        // {0, 4, 9, 0, 3, 0, 0, 5, 7},
        // {8, 2, 7, 0, 0, 9, 0, 1, 3}
        // };
        // if(sudokuSolver(sudoku, 0, 0)) {
        //     System.out.println("Solution exists");
        //     printSudoku(sudoku);
        // }
        // else {
        //     System.out.println("Solution doesn't exists");
        // }
        // int maze[][] = { { 1, 0, 0, 0 },
        //                  { 1, 1, 0, 1 },
        //                  { 0, 1, 0, 0 },
        //                  { 1, 1, 1, 1 } };
        // ratMaze(maze);
        int board[][] = new int[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                board[i][j] = -1;
            }
        }
        board[0][0] = 0;
        if(solveKnightTour(board, 0, 0, 1)){
            printBoard(board);
        }
        else{
            System.out.println("Solution doesn't exist");
        }
    }
}
