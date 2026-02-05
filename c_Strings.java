import java.util.*;
public class c_Strings {
    // public static void main(String args[]) {
    //     // char arr[] = {'a', 'b', 'c', 'd'};
    //     // String str = "abcd";
    //     // String str2 = new String("xyz");
    //     // //Strings are IMMUTABLE
    //     // Scanner sc = new Scanner(System.in);
    //     // String name = sc.nextLine();
    //     // System.out.println(name);
    //     // System.out.println(name.length());

    //     //concatenation
    //     String firstName = "Syed";
    //     String lastName = "Maaz";
    //     String fullName = firstName + " " + lastName;
    //     System.out.println(fullName);
    // }


    // //print string elements using charAt
    // //print element at particular index
    // public static void printelementsbyindex(String args[]) {
    //     String str = "Syed Maaz";
    //     System.out.println(str.charAt(5));
    // }
    // //loop to print all elements in the string 
    // public static void printStringelements(String str) {
    //     for (int i=0; i<str.length(); i++) {
    //         System.out.print(str.charAt(i));
    //     }
    //     System.out.println();
    // }
    // public static void main(String args[]) {
    //     String str = "Syed Maaz";
    //     printStringelements(str);
    //     printelementsbyindex(args);
    // }


    // //palindrome
    // public static boolean isPalindrome(String str) {
    //     int n = str.length();
    //     for (int i=0; i<n/2; i++) {  //goes till half length on the string to check, if all the elements on the left side are same as right side
    //         if (str.charAt(i) == str.charAt(n-1-i)) {
    //             System.out.println("It is a palindrome");
    //             return true;
    //         }
    //     }
    //     System.out.println("NOT a palindrome");
    //     return false;
    // }
    // public static void main(String args[]) {
    //     Scanner sc = new Scanner(System.in);
    //     String str = sc.nextLine();
    //     isPalindrome(str);
    // }


    // //shortest distance (for logic check notes from phone)
    // public static float shortestDistance(String str) {
    //     int x = 0, y = 0; //initializing axis
    //     for (int i=0; i<str.length(); i++) {
    //         char dir = str.charAt(i);
    //         //North
    //         if (dir == 'N') {
    //             y++;  //according to the char dir changing the axis
    //         }
    //         else if (dir == 'S') {
    //             y--;
    //         }
    //         else if (dir == 'E') {
    //             x++;
    //         }
    //         else {
    //             x--;
    //         }
    //     }
    //     //distance formula 
    //     int X2 = x*x;
    //     int Y2 = y*y;
    //     return (float)Math.sqrt(X2 + Y2);
    // }
    // public static void main(String args[]) {
    //     String str = "WNEENESENNN";
    //     System.out.println(shortestDistance(str));
    // }


    // //compare
    // public static void main(String args[]) {
    //     String s1 = "Syed";
    //     String s2 = "Syed";
    //     String s3 = new String("Syed");
    //     if (s1 == s2) {  
    //         System.out.println("Same");
    //     }
    //     else {
    //         System.out.println("Different");
    //     }
    //     if (s1 == s3) {
    //         System.out.println("same");
    //     }
    //     else {
    //         System.out.println("Different");
    //     }
    //     //compare in string
    //     if (s1.equals(s3)) {
    //         System.out.println("same");
    //     }
    //     else {
    //         System.out.println("Different");
    //     }
    // }


    // //SubString
    // public static String subString(String str, int startindex, int endindex) {
    //     String substr = "";
    //     for (int i=startindex; i<endindex; i++) {
    //         substr += str.charAt(i);
    //     }
    //     return substr;
    // }
    // public static void main(String args[]) {
    //     String str = "Hello World";
    //     System.out.println(subString(str, 0, 5));
    //     //Inbuilt substring fnx in Java
    //     System.out.println(str.substring(0, 11));
    // }




}
