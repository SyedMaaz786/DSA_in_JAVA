import java.util.Scanner;

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
    // public static int CalculateSum(int num1, int num2) {  //parameters which are passed while creating the fnx
    //     int sum = num1 + num2;
    //     return sum;
    // }
    // public static void main (String args[]) {
    //     Scanner sc = new Scanner(System.in);
    //     int a = sc.nextInt();
    //     int b = sc.nextInt();
    //     int sum = CalculateSum(a, b);    //Arguments which are passed while calling the fnx
    //     System.out.println(sum);
    // }
