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


//// inverted half pyramid
// public static void half_pyr_inv (int totRows, int totCols) { //dry run you will get it
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
//     half_pyr_inv(4, 4);
// }


// //floyds triangle pattern
// public static void floyds (int totRows, int totCols) { //dry run you will get it
//     int num = 1; //counter to get next number
//     for (int i=1; i<=totRows; i++) {    
//         for (int j=1; j<=totCols; j++) { 
//             if (j <= i) {       
//                 System.out.print(num);
//                 num ++;    
//             }
//             else {
//                 System.out.print(" ");
//             }
//         }
//         System.out.println();
//     }
// }
// public static void main (String args[]) {
//     floyds(4, 4);
// }


// //0-1 triangle pattern
// public static void zeroToOne (int totRows, int totCols) {
//     for (int i=1; i<=totRows; i++) {
//         for (int j=1; j<=totCols; j++) {
//             if (j <= i) {
//                 System.out.print(((i+j) % 2 == 0) ? "1": "0");  //if even "1" else "0"
//             } 
            
//         }
//         System.out.println();
//     }
// }
// public static void main (String args[]) {
//     zeroToOne(5, 5);
// }


// //Butterfly pattern (check phone pic for logic)
// public static void Butterfly (int n) {
//     //1st half
//     for (int i=1; i<=n; i++) {  //Here i is runned from 1 to n, i for printing how many number of rows
//         //stars(i)
//         for (int j=1; j<=i; j++) {  //j for printing how many number of cols
//             System.out.print("*");
//         }
//         //spaces(2*n-i)
//         for (int j=1; j<=2*(n-i); j++) {
//             System.out.print(" ");
//         }
//         //stars(i)
//         for (int j=1; j<=i; j++) {
//             System.out.print("*");
//         }
//         System.out.println();
//     }
//     //2nd half
//     for (int i=n; i>=1; i--) {  //Here i is runned from n to 1
//         //stars(i)
//         for (int j=1; j<=i; j++) {  //j for printing how many number of cols
//             System.out.print("*");
//         }
//         //spaces(2*n-i)
//         for (int j=1; j<=2*(n-i); j++) {
//             System.out.print(" ");
//         }
//         //stars(i)
//         for (int j=1; j<=i; j++) {
//             System.out.print("*");
//         }
//         System.out.println();
//     }
// }    
// public static void main (String args[]) {
//     Butterfly(4);
// }


// // //Solid Rhombus
// public static void solid_rhombus (int n) {
//     for (int i=1; i<=n; i++) {
//         for (int j=1; j<=(n-i); j++){
//             System.out.print(" ");
//         }
//         for (int j=1; j<=n; j++) {
//             System.out.print("*");
//         }
//         System.out.println();
//     }
// }
// public static void main (String args[]) {
//     solid_rhombus(5);
// }


}
