import java.util.*;
public class JavaBasics3 {
    public static void main(String args[]) {

        //if else
        int age = 22;
        if (age>=18) {
            System.out.println("You can vote");
        }
        else{
            System.out.println("Sorry you cannot vote");
        }
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        if (num%2==0) {
            System.err.println("Even");
        }
        else{
            System.out.println("Odd");
        }

        //if elseif 

        Scanner sc = new Scanner(System.in);
        int Age = sc.nextInt();
        if (Age>=18){
            System.out.println("Driving License granted");
        }
        else if(Age>20) {
            System.out.println("Congratulations DL Granted");
        }
        else{
            System.out.println("You are under 18");
        }
        

        //Income Tax 
        Scanner Sc = new Scanner(System.in);
        int income = Sc.nextInt();

        if (income < 500000){
            System.out.println("No tax");
        }
        else if(income > 500000 && income <=1000000){
            System.out.println("You need to pay 20% tax");
        }
        else{
            System.out.println("You need to pay 30% tax");
        }


        //Find the greatest number from the three given numbers.
        Scanner SC = new Scanner(System.in);
        int A = SC.nextInt();
        int B = SC.nextInt();
        int C = SC.nextInt();
        
        if ((A>=B) && (A>=C)){
            System.out.println("A " +A+ " is largest");
        }
        else if(B>=C){
            System.out.println("B " +B+ " is largest");
        }
        else{
            System.out.println("C " +C+ " is largest");
        }

        //ternary Operator

        Scanner sC = new Scanner(System.in);
        
        System.out.println("Please enter 10:");

        int input = sC.nextInt();

        System.out.println(input == 10 ? "input is 10" : "input is not 10");


        //Switch cases

        Scanner scn = new Scanner(System.in);
        
        System.out.println("Enter your amount: ");
        int money = scn.nextInt();

        switch (money) {
            case 2000:
            System.out.println("You get: Creatine");
            break;
            case 5000:
            System.out.println("You get: Protein");
            break;
            case 10000:
            System.out.println("You get: TREN");
            break;

            default:
            System.out.println("You get: SATTU");
            break;
        }

        //Calculator

        Scanner SCN = new Scanner(System.in);

        System.out.println("Enter First Number: ");
        double num1 = SCN.nextDouble();         //double is used because what if the user input is in decimal form like 2.2

        System.out.println("Enter Second Number: ");
        double num2 = SCN.nextDouble();         //num1 and num2 input we are taking.

        System.out.println("Choose an operation: ");
        System.err.println("1: ADDITION (+)");
        System.out.println("2. SUBTRACTION (-)");
        System.out.println("3: MULTIPLICATION (*)");
        System.out.println("4: DIVISION (/)");

        System.err.println("Enter Your Choice: ");  //Another input for the choice.
        int choice = sc.nextInt();

        double result;

        switch (choice) {
            case 1:
            result = num1 + num2;
            System.out.println("Result: " + result);
            break;
            case 2:
            result = num1 - num2;
            System.out.println("Result: " + result);
            break;
            case 3:
            result = num1 * num2;
            System.out.println("Result: " + result);
            break;
            case 4:
            if (num2 != 0){           
                result = num1 / num2;
                System.out.println("Result: " + result);
            }
            else{
                System.out.println("Error: Cannot divide by zero");
            }
            break;
        
            default:
            System.out.println("Invalid choice! Please try again.");
                break;
        }

    }
}
            

    
