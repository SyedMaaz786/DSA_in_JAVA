public class JavaBasics7 {
// // Advanced pattern (using matrices) 
// // Hollow_rectangle   
//     public static void hollow_rectangle (int totRows, int totCols) {
//         for (int i=1; i<=totRows; i++) { // outer loop for printing lines
//             for (int j=1; j<=totCols; j++) {  //inner loop for printing *
//                 if (i == 1 || i == totRows  || j == 1 || j == totCols) {
//                     System.out.print("*");
//                 }
//                 else {
//                     System.out.print(" ");
//                 } 
//             }
//             System.out.println();  //after traversing one complete line to come to the next line
//         }
//     }
//     public static void main (String args[]) {
//         hollow_rectangle(9,8);
//     }


// // Half-Pyramid
// public static void half_pyr (int totRows, int totCols) { //dry run you will get it
//     for (int i=1; i<=totRows; i++) {     //outer loop i for lines
//         for (int j=1; j<=totCols; j++) { // inner loop j for stars
//             if (j > totCols - i) {       //and keep staring this if condition you will get it 
//                 System.out.print("*");    
//             }
//             else {
//                 System.out.print(" ");
//             }
//         }
//         System.out.println();
//     }
// }
// public static void main (String args[]) {
//     half_pyr(4, 4);
// }


// public static void half_pyr (int totRows, int totCols) { //dry run you will get it
//     for (int i=1; i<=totRows; i++) {     
//         for (int j=1; j<=totCols; j++) { 
//             if (j <= totCols - i + 1) {  //just keep this if similar to above one just few changes    
//                 System.out.print(j);    
//             }
//             else {
//                 System.out.print(" ");
//             }
//         }
//         System.out.println();
//     }
// }
// public static void main (String args[]) {
//     half_pyr(4, 4);
// }


}
