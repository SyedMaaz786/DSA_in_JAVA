import java.util.*;
public class a_Java02 {
    public static void main(String args[]) {
        // Sum of a and b using user input

        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        int sum = a + b;
        System.out.println(sum);

        //Product of A and B using user input
        Scanner S = new Scanner(System.in);
        int A = S.nextInt();
        int B = S.nextInt();
        int product = A * B;
        System.out.println(product);

        //Type conversion is implicitly(Automatically done by JAVA).

        Scanner Sc = new Scanner(System.in); 
        float number = Sc.nextInt();
        System.out.println(number);

        //Type casting is explicitly(Manually we do this).

        Scanner SC = new Scanner(System.in);
        float Num = 22.22f;
        int Num2 = (int) Num;
        System.out.println(Num2); 

        char Char = 'a';               //Simple example of type casting 
        System.out.println((int)(Char));
        
        int var1= 20;                  //Arithmetic operator rest all are easy you know it already.
        int var2 = 30;
        System.out.println("The Addition of var1 and var2 is " +(var1+var2));

        int Var1 = 10;                   //unary you can also give var1++ same with negative(--) aswell.
        int Var2 = ++Var1;
        System.out.println("The ans is: " +(Var2));

        int VAR1 = 10;               //Relational operator rest are written in notes check.
        int VAR2 = 20;               //Gives boolean result 
        System.out.println(VAR1==VAR2);

        System.out.println((1<2)&&(2>1));  //logical operator AND(&&)
        System.out.println((1<2)||(2>1));  //OR(||) refer notes for clarification.
        System.out.println(!(1>2));        //NOT(!) operator 

        int Numb = 10;          //Assignment operator
        Numb += 10;             //Here i have written only for +, we also have for -,*,/
        System.out.println(Numb);

    }
}