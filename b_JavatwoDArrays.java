import java.util.*;
public class b_JavatwoDArrays {
    // //fnx to find min and max number in the arr
    // public static void findMinMax(int twoD[][]) {
    //     int min = twoD[0][0];
    //     int max = twoD[0][0];
    //     for (int i=0; i<twoD.length; i++) {
    //         for (int j=0; j<twoD[0].length; j++) {
    //             if (twoD[i][j] < min) {
    //                 min = twoD[i][j];
    //             }
    //             if (twoD[i][j] > max) {
    //                 max = twoD[i][j];
    //             }
    //         }
    //     }
    //     System.out.println("Min is:" + min);
    //     System.out.println("Max is:" + max);
    // }
    // // fnx for finding the pos of the element
    // public static boolean search(int twoD[][], int key) {  
    //     for (int i=0; i<twoD.length; i++) {
    //         for (int j=0; j<twoD[0].length; j++) {
    //             if (twoD[i][j] == key) {
    //                 System.out.println("Key found at " + i + "," + j);
    //                 return true;
    //             }
    //         }
    //     }
    //     System.out.println("Key NOT found");
    //     return false;
    // }
    // // fnx for twoDArr.
    // public static void main(String args[]) {
    //     int twoD[][] = new int [3][3];
    //     int n = twoD.length, m = twoD[0].length;
    //     Scanner sc = new Scanner(System.in);
    //     for (int i=0; i<n; i++) {   //for rows
    //         for (int j=0; j<m; j++) {  //for cols
    //             twoD[i][j] = sc.nextInt();  //taking i/p
    //         }
    //     }
    //     sc.close();
    //     //output
    //     for (int i=0; i<n; i++) {
    //         for (int j=0; j<m; j++) {
    //             System.out.print(twoD[i][j]);
    //         }
    //         System.out.println();
    //     }
    //     search(twoD, 4);
    //     findMinMax(twoD);
    // }


    // //Spiral matrix
    // public static void printSpiral(int matrix[][]) {
    //     int startRow = 0;
    //     int startCol = 0;
    //     int endRow = matrix.length-1;
    //     int endCol = matrix[0].length-1;
    //     while (startRow <= endRow && startCol <=endCol) {
    //         //top
    //         for (int j=startCol; j<=endCol; j++) {
    //             System.out.print(matrix[startRow][j] + " ");
    //         }
    //         //right
    //         for (int i=startRow+1; i<=endRow; i++) {
    //             System.out.print(matrix[i][endCol] + " ");
    //         }
    //         //bottom
    //         for (int j=endCol-1; j>=startCol; j--) {
    //             if (startRow == endRow) {
    //                 break;
    //             }
    //             System.out.print(matrix[endRow][j] + " ");
    //         }
    //         //left
    //         for (int i=endRow-1; i>=startRow+1; i--) {
    //             if (startCol == endCol) {
    //                 break;
    //             }
    //             System.out.print(matrix[i][startCol] + " ");
    //         }
    //         startCol++;
    //         startRow++;
    //         endCol--;
    //         endRow--;
    //     }
    //     System.out.println();
    // }
    // public static void main(String args[]) {
    //     int matrix[][] = {{1,2,3,4},
    //                       {5,6,7,8},
    //                       {9,10,11,12},
    //                       {13,14,15,16}}; 
    //     printSpiral(matrix);                  
    // }


    // //Diagonal sum (Check notes from phone for logic) - O(n2)
    // public static int printDiagonal(int matrix[][]) {
    //     int sum = 0;
    //     for (int i=0; i<matrix.length; i++) {
    //         for (int j=0; j<matrix[0].length; j++){
    //             // primary diagonal
    //             if (i == j) {
    //                 sum = sum + matrix[i][j];
    //             }
    //             // secondary diagonal
    //             else if (i+j == matrix.length-1) {
    //                 sum = sum + matrix[i][j];
    //             }
    //         }
    //     }
    //     return sum;
    // }
    // public static void main(String args[]) {
    //     int matrix[][] = {{1,2,3,4},
    //                       {5,6,7,8},
    //                       {9,10,11,12},
    //                       {13,14,15,16}};
    //     System.out.println(printDiagonal(matrix));   
    // }


    // //Diagonal sum - O(n)
    // public static int printDiagonal(int matrix[][]) {
    //     int sum = 0;
    //     int n = matrix.length;
    //     for (int i=0; i<n; i++) {
    //         //primary diagonal
    //         sum = sum + matrix[i][i];
    //         //secondary diagonal
    //         if (i != n - 1 - i) { // avoid double checking
    //             sum = sum + matrix[i][n - 1 - i];  // dont scratch your head just remember n-1-i
    //         }
    //     }
    //     return sum;
    // }
    // public static void main(String args[]) {
    //     int matrix[][] = {{1,2,3,4},
    //                       {5,6,7,8},
    //                       {9,10,11,12},
    //                       {13,14,15,16}};
    //     System.out.println(printDiagonal(matrix));
    // }


    // // Searching an element in sorted matrix (This is top to bottom, You can also check for bottom to top) - O(n)
    // public static boolean staircaseSearch(int matrix[][], int key ){
    //     int row = 0, col = matrix[0].length-1;  //logic to start from top right element ie 40 for this 
    //     while(row < matrix.length && col>=0) {  //logic so that we dont go beyond our matrix rows and cols
    //         if (matrix[row][col] == key) {
    //             System.out.print("Key found at (" + row + "," + col + ")");
    //             return true;
    //         }
    //         else if (key < matrix[row][col]) {
    //             col--; //to go on the left
    //         }
    //         else {
    //             row ++; //to go on the bottom
    //         }
    //     }
    //     System.out.println("Key NOT found");
    //     return false;
    // }
    // public static void main(String args[]) {
    //     int matrix[][] = {{10, 20, 30, 40},
    //                       {15, 25, 35, 45},
    //                       {27, 29, 37, 48},
    //                       {32, 33, 39, 50}};
    //     int key = 33;
    //     staircaseSearch(matrix, key);                 



}
