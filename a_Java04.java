import java.util.*;
public class a_Java04 {
    public static void main(String args[]) {  //While loop
        // int count = 0;
        // while (count < 2){
        //     System.out.println("Hello World");
        //     count ++;
        // }


        // //While loope to print numbers from 1-10
        // int number = 1;  
        // while(number<11){
        //     System.out.print(number); //println on the different line
        //     number++;                 //print on the same line
        // }


        // //Printing numbers from 1-n using user input.
        // int num = 1;
        // Scanner sc = new Scanner(System.in);  
        // int numb = sc.nextInt();
        // while(num <= numb ){
        //     System.out.println( num );
        //     num ++;
        // }


        // //Sum of n numbers(meaning ex - n=5, 1+2+3+4+5=15)
        // Scanner s = new Scanner(System.in);  
        // int input = s.nextInt();
        // int i = 0; // This is nothing but counter
        // int sum = 0;
        // while (i <= input){
        //     sum = sum + i;
        //     i++;
        // }
        // System.out.println(sum);


        // //for loop
        // for (int j=1; j<=5; j++){   
        //     System.out.println("Maaz");
        // }


        // //square pattern 
        // for (int line=1; line<=4; line++){  
        //     System.out.println("* * * *");
        // }


        // //reversing a number (check notes dry run if dought)
        // int n = 123456;  
        // while (n > 0){
        //     int reverse = n%10;  // reminder (to get the last digit)
        //     System.out.print(reverse);
        //     n = n/10;  // to remove the last digit from the number, this gives quotient which is used in next iteration above to get reminder
        // }


        // //reversing n numbers (uses input from user)
        // Scanner sc = new Scanner(System.in);
        // int input = sc.nextInt();
        // while (input > 0) {
        //     int reverse = input%10;
        //     System.out.println(reverse);
        //     input = input / 10;
        // }


        // //do while loop
        // int counter = 1;                
        // do {                             //In do while same logic first do then condition
        //     System.out.println("Heyy");
        //     counter++;
        // } while (counter <=4 );


        // //Break - To exit
        // for (int i=1; i<=5; i++) {
        //     if (i == 3) {
        //         break;
        //     }
        //     System.out.println(i);
        // }

        // //Break if the user enters 10 
        // Scanner sc = new Scanner(System.in);
        // while (true) {
        //     int input = sc.nextInt();
        //     if (input == 10) {
        //         System.out.println("Sorry, 10 is not allowed");
        //         break;
        //     }
        //     System.out.println(input);
        // }

        
        // //Continue - To skip 
        // for (int l=0; l<=5; l++){        
        //     if (l == 3){
        //         continue;
        //     }
        //     System.out.println(l);
        // }

        
        // //Prime number or not (Divisible by 1 and itself)
        // Scanner sc = new Scanner(System.in);  
        // int input = sc.nextInt();

        // boolean isPrime = true;

        // if (input<=1) {       
        //     isPrime = false;
        // }
        // for (int i=2; i<input; i++) {   //Here we are initialising i=2 because we need to remove the edge cases of a number being divided by 1 and itself, ie why we are not initialising i with 1 and condition i<input will kickout the another edge case of dividing by itself.
        //     if (input%i==0) {           //if it is getting divisible by other numbers, then its not a prime. To make code more optimised we can give i<Math.sqrt(input) this is for condition
        //         isPrime = false;
        //     }
        // }
        // if (isPrime == true) {
        //     System.err.println("Input is a Prime number");
        // }
        // else {
        //     System.out.println("Input is NOT a Prime number");
        // }

    }
           
}
