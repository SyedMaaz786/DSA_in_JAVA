import java.util.*;

public class JavaBasics6 {
    public static void printHelloWorld() {      //This is the function we have created named printHelloWorld where void is the return type like int float or anyother which returns nothing
        System.out.println("Hello World executed!");
    }
    public static void main (String args[]) {
        printHelloWorld();                     //Here we are calling our function we create above.

    }
}


//    //function with return type int                            
//     public static int printHelloWorld() {              // if the return type is void we need not have to specify the return      
//         System.out.println("Hello World 3 times");  // if the return type is int we have to specify the return 
//         return 3;
//     }
//     public static void main (String args[]) {
//         printHelloWorld();
//     }


    // //function with parameters being passed
    // public static int CalculateSum(int a, int b) {  //parameters which are passed while creating the fnx
    //     int sum = a + b;
    //     return sum;
    // }
    // public static void main (String args[]) {
    //     Scanner sc = new Scanner(System.in);
    //     int num1 = sc.nextInt();
    //     int num2 = sc.nextInt();
    //     int sum = CalculateSum(num1, num2);    //Arguments which are passed while calling the fnx
    //     System.out.println(sum);
    // }


    // //Swapping values into others
    // public static void main (String args[]) {
    //     int a = 5;
    //     int b = 10;
    //     //Swapping
    //     int temp = a;
    //     a = b;
    //     b = temp;
    //     System.out.println(a);
    //     System.out.println(b);
    // } 


    // //call by value (Java always calls by value) meaning when the values of one fnx is called by another fnx then the original values are not sent instead a copy is sent.
    // public static void swap(int a, int b) {
    //     int temp = a;
    //     a = b;
    //     b = temp;
    // }
    // public static void main (String args[]) {
    //     int a = 5;
    //     int b = 10;
    //     swap(a, b);
    //     System.out.println(a);
    //     System.out.println(b);
    // }


    // //Product of two numbers
    // public static int multiply (int a, int b) {
    //     int product = a * b;
    //     return product;
    // }
    // public static void main (String args[]) {
    //     Scanner sc = new Scanner(System.in);
    //     int num1 = sc.nextInt();
    //     int num2 = sc.nextInt();
    //     int product = multiply(num1, num2);
    //     System.out.println(product);
    // }


    // //Factorial of n number (n!)
    // public static int Factorial(int n) {
    //     int f = 1;  
    //     for (int i=1; i<=n; i++) {
    //         f = f * i;
    //     }
    //     return f;
    // }
    // public static void main (String args[]) {
    //     System.out.println(Factorial(4));  //Here we are calling the fnx directly in the print statement
    // }


    // //Binomial Coefficient (Check notes for the formula and code here)
    // public static int Factorial(int n) {
    //     int f = 1;
    //     for (int i=1; i<=n; i++) {
    //         f = f * i;
    //     }
    //     return f;
    // }
    // public static int BinCoeff (int n, int r) {
    //     int fact_n = Factorial(n);
    //     int fact_r = Factorial(r);
    //     int fact_nmr = Factorial(n-r);

    //     int BinCoeff = fact_n / (fact_r * fact_nmr);
    //     return BinCoeff;
    // }
    // public static void main(String args []) {
    //     System.out.println(BinCoeff(5, 2));
    // }



