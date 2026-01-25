import java.util.*;
public class JavaBasics5 {
    public static void main (String args[]){

        // for (int i = 1; i<=4; i++ ){      // star pattern program, This is a nested loop
        //     for (int j = 1; j<=i; j++){   //inner loop 
        //         System.out.print("*");    //i and the outer for loop is used to print the number of lines
        //     }
        //     System.out.println();
        // }



                                      
        //     for (int i = 1; i<=4; i++){        //Inverted star pattern prog
        //     for (int j = 1; j<=4-i+1; j++){    //j<=4-i+1 is the logic to print howmany stars needs to be printed in each line.
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }





        // int n = 4;
        // for (int i = 1; i<=n; i++){              //Half pyramid
        //     for (int j = 1; j<=i; j++){
        //         System.out.print(j);
        //     }
        //     System.out.println();
        // }





        // int n = 4;
        // char ch = 'A';

        // for (int i = 1; i<=n; i++){     //Same logic of two for loops as used above because the shape is pyramid
        //     for (int j = 1; j<=i; j++){  
        //         System.out.print(ch);   //after the inner for loop fails and the loop goes back to the outer loop and starts the iteration again after outer loop when inner loop starts it will start from next alphabet because we have incremented the ch++.
        //         ch++;
        //     }
        //     System.out.println();
        // }





    }

}