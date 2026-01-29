import java.util.*;   // This is the package we have imported to take the input (Scanner)
public class a_Java01 {        //This is the boilerplate code for java
    public static void main(String args[]) {
        System.out.println("Heyy, finally started with JAVA :)");  //Here println is used to print the next print statement in the next line.
        System.out.println("Finally started with JAVA :)");
        System.out.println("****\n***\n**\n*");
        

        int a = 10;
        int b = 20;
        System.out.println("Value of a is " + a + " and value of b is " + b );


        byte A = 1;           
        System.out.println(A);//1 byte
        char B = 'a';
        System.out.println(B);//2 bytes
        boolean C = true;
        System.out.println(C);//1 byte
        float D = 10.5f;         // for float values which are greater we need to add f at the ending.
        System.out.println(D);//4 byte
        long E = 124432;         // long is used if we have larger number to be stored.
        System.out.println(E);//8 byte
        double F = 10.1233;      // double is used if we have large decimal value. 
        System.out.println(F);//8byte
        int G  = 25;             // int is normally used to store the integer value.
        System.out.println(G);//4 byte
        short H = 200;           //short is also used to store a integer or numeric value.
        System.out.println(H);//2 byte
        

        //Sum of a1 and b1

        int a1 = 10;
        int b1 = 20;
        int sum = a1 + b1;
        System.out.println(sum);


        //Taking user input

        Scanner s = new Scanner(System.in);   //s is the object here
        String input = s.next();
        System.out.println(input);
        String name = s.nextLine();
        System.out.println(name);
        int number = s.nextInt();
        System.out.println(number);
        float floatvalue = s.nextFloat();  // similarly the double,boolean,short,long
        System.out.println(floatvalue);
        
    }
}
