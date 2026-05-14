public class d_BitManipulation {
    // public static void main(String args[]) {
    //     System.out.println(5 & 6); //Binary AND
    //     System.out.println(5 | 6); //Binary OR
    //     System.out.println(5 ^ 6); //Binary XOR
    //     System.err.println(~10); // Binary NOT - Check GPT if dought
    //     System.out.println(5 << 2); //Binary left shift 
    //     System.out.println(6 >> 1); //Binary right shift
    // }


    // //check if the number is odd or even (check notes from phone for logic)
    // public static void oddOrEven(int n) {
    //     int bitMask = 1;
    //     if ((n & bitMask) == 0) {
    //         //even
    //         System.out.println(n + " is even");
    //     }
    //     else {
    //         System.out.println(n + " is odd");
    //     }
    // }
    // public static void main(String args[]) {
    //     oddOrEven(1);
    //     oddOrEven(2);
    // }

    // //Don't scratch your head just remember the pattern/flow, this bit manupulation is our last priority
    // //get ith bit (check lecture for logic, it's easy)
    // public static int getIthBit(int n, int i) {
    //     int bitMask = 1<<i;
    //     if ((n & bitMask) == 0) {
    //         return 0;
    //     }
    //     else {
    //         return 1;
    //     }
    // }
    // public static void main(String args[]) {
    //     System.out.println(getIthBit(8, 1));
    // }


    // //set ith bit (is used to convert any bit from 0 to 1 using a specific operator)
    // public static int setIthBit(int n, int i) {
    //     int bitMask = 1<<i;
    //     return n | bitMask;
    // }
    // public static void main(String args[]) {
    //     System.out.println(setIthBit(10, 2));

    // }


    // //clear ith bit (is used to convert any bit from 1 to 0 using a specific operator)
    // public static int clearIthBit(int n, int i) {
    //     int bitMask = ~(1<<i);
    //     return n & bitMask;
    // }
    // public static void main(String args[]) {
    //     System.out.println(clearIthBit(10, 1));
    // }


    // //update ith bit
    // public static int setIthBit(int n, int i) {
    //     int bitMask = 1<<i;
    //     return n | bitMask;
    // }
    // public static int cleatIthBit(int n, int i) {
    //     int bitMask = ~(1<<i);
    //     return n & bitMask;
    // }
    // public static int updateIthBit(int n, int i, int newBit) {
    //     if (newBit == 0) {
    //         return cleatIthBit(n, i);
    //     }
    //     else {
    //         return setIthBit(n, i);
    //     }
    // }
    // public static void main(String args[]) {
    //     System.out.println(updateIthBit(10, 2, 1));
    // }


    // //clearIbits (meaning set bits from the given index i value to ZERO)
    // public static int clearIbits(int n, int i) {
    //     int bitMask = -1<<i;
    //     return n & bitMask; 
    // }
    // public static void main(String args[]) {
    //     System.out.println(clearIbits(15, 2));
    // }


    // //clear bits in a range
    // public static int clearBitsInRange(int n, int i, int j) { //Here i and j is the range
    //     int a = -1<<(j+1);
    //     int b = (1<<i)-1;
    //     int bitMask = a | b;
    //     return n & bitMask;
    // }
    // public static void main(String args[]) {
    //     System.out.println(clearBitsInRange(10, 2, 4));
    // }


    // //isPowerOfTwo
    // public static boolean isPowerOfTwo(int n) {
    //     return (n & (n-1)) == 0; //this is a imp property check notes(new book) if dought
    // }
    // public static void main(String args[]) {
    //     System.out.println(isPowerOfTwo(4));
    //     System.out.println(isPowerOfTwo(5));
    // }


    // //countsetbits
    // public static int countSetBits(int n) {
    //     int count = 0;
    //     while (n > 0) { //runs until my number(n) bits becomes 0
    //         if ((n & 1) ==1) { //checks LSB
    //             count ++;
    //         }
    //         n = n>>1;
    //     }
    //     return count;
    // }
    // public static void main(String args[]) {
    //     System.out.println(countSetBits(10));
    // }


    // //fastexponential code (checks any numbers any power) check GPT for logic
    // public static int fastExpo(int pow, int n) {
    //     int ans = 1;
    //     while (n > 0) {
    //         if ((n & 1) == 1) {
    //             ans = ans * pow;
    //         }
    //         pow = pow * pow;
    //         n = n >> 1;
    //     }
    //     return ans;
    // }
    // public static void main(String args[]) {
    //     System.out.println(fastExpo(2, 4));
    // }


    //swap w/o using 3rd variable 
    // public static void main(String args[]){
    //     int x = 3;
    //     int y = 4;
    //     //swap
    //     x = x^y; //(simply byheart this steps, it's easy, if asked swap w/o using 3rd variable use this, remember the property of xor, that it)
    //     y = x^y;
    //     x = x^y;
    //     System.out.println(x);
    //     System.out.println(y);
    // }


    // //covert uppercase characters to lower case using bit manipulation
    // public static void main(String args[]){
    //     for(char ch='A'; ch<='Z'; ch++){
    //         System.out.print((char)(ch | ' '));
    //     }
    // }


    //convert any number to -ve (we will use ~)
    public static void main(String args[]){ //use this formula (~x = -(x+1))
        int a = 5;
        System.out.println(~4);
    }



}
