import java.util.*;
public class a_Java05 {
    public static void main (String args[]){
        
        // //star pattern program, This is a nested loop
        // for (int i = 1; i<=4; i++ ){         //Outer loop
        //     for (int j = 1; j<=i; j++){      //inner loop 
        //         System.out.print("*");    //i ie the outer for loop is used to print the number of lines
        //     }                                //j ie is inner loop is used to print how many stars in each line
        //     System.out.println();
        // }


        // //Inverted star pattern prog                              
        // for (int i = 1; i<=4; i++){            
        //     for (int j = 1; j<=4-i+1; j++){    //j<=4-i+1 is the logic to print howmany stars needs to be printed in each line.
        //         System.out.print("*");         //if we would have specified n = any number or taken user input for n then the formula would be j<=(n-i+1)
        //     }
        //     System.out.println();
        // }


        // //Half pyramid
        // Scanner sc = new Scanner(System.in);
        // int input = sc.nextInt();

        // for (int i=1; i<=input; i++) {   //Outer loop to print number of lines
        //     for (int j=1; j<=i; j++) {   //Inner loop to print numbers from 1 to input
        //         System.out.print(j);
        //     }
        //     System.out.println();
        // }


        // //Print character half pyramid  
        // Scanner sc = new Scanner(System.in);
        // int input = sc.nextInt();
        // char ch = 'A';

        // for (int i=1; i<=input; i++){     //Same logic of two for loops as used above because the shape is pyramid
        //     for (int j=1; j<=i; j++){     // remember like this for dry run, step1-initialisation, step2-condition, step3-statement block ie printing, step4-increment 
        //         System.out.print(ch);   //after the inner for loop fails and the loop goes back to the outer loop and starts the iteration again after outer loop when inner loop starts it will start from next alphabet because we have incremented the ch++.
        //         ch++;
        //     }
        //     System.out.println();
        // }


    }

}