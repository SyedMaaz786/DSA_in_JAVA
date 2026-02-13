public class f_Recursion01 {
    //Decreasing Order
    public static void printDec(int n) {
        if (n == 1) { //Base case 
            System.out.println(n);
            return;
        }
        System.out.print(n + " ");
        printDec(n-1);
    }
    //Increasing Order
    public static void printInc(int n) {
        if (n == 1) {  //Base case
            System.out.print(n + " ");
            return;
        }
        printInc(n-1);
        System.out.print(n + " ");
    }
    //Factorial of n
    public static int fact(int n){
        if (n == 0) {  //Base case
            return 1;
        }
        int fnm1 = fact(n-1);  
        int fn = n * fnm1;  //Values are calculated and printed while coming back
        return fn;
    }
    //Sum of first n natural numbers
    public static int sum(int n) {
        if (n == 1) {
            return 1;
        }
        int snm1 = sum(n-1);
        int sn = n + snm1;
        return sn;
    }
    //Fibonacci number
    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int fnm1 = fib(n-1);
        int fnm2 = fib(n-2);
        int fn = fnm1 + fnm2;
        return fn;
    }
    //Check if arr is sorted
    public static boolean isSorted(int arr[], int i) {  //Where i is the index
        if (i == arr.length-1) { //Base case
            return true;
        }
        if (arr[i] > arr[i+1]) {
            return false;
        }
        return isSorted(arr, i+1);
    }
    //First occurence index
    public static int firstOcc(int arr[], int key, int i) {
        if (i == arr.length) {  //Base case
            return -1;
        }
        if (arr[i] == key) {   
            return i;
        }
        return firstOcc(arr, key, i+1);  
    }
    //Last occurence index
    public static int lastOcc(int arr[], int key, int i) {  
        if (i == arr.length) {  //Base case
            return -1;
        }
        int isFound = lastOcc(arr, key, i+1);
        if (isFound == -1 && arr[i] == key) {
            return i;
        }
        return isFound;
    }
    //print x power n
    public static int power(int x, int n) { //Where x is the base and n is the power
        if (n == 0) {  //Base case
            return 1;
        }
        int xnm1 = power(x, n-1);
        int xn = x * xnm1;
        return xn;
    }
    //Optimised power code (Check notes if dought) Ologn
    public static int optimisedPower(int x, int n) {
        if (n == 0) { //Base case
            return 1;
        }
        // if n is even
        int halfPower = optimisedPower(x, n/2);
        int halfPowersq = halfPower * halfPower;
        // if n is odd
        if (n % 2 == 1) {
            halfPowersq = x * halfPowersq;
        }
        return halfPowersq;
    }
    public static void main(String args[]) {
        // int n = 10;
        // printDec(n);
        // printInc(n);
        // System.out.println(fact(n));
        // System.out.println(sum(n));
        // System.out.println(fib(n));
        // int arr[] = {1,2,3,4};
        // System.out.println(isSorted(arr, 0));
        // int arr[] = {2,4,6,8,6,8};
        // System.out.println(firstOcc(arr, 8, 0));
        // int arr[] = {2,4,6,8,6};
        // System.out.println(lastOcc(arr, 6, 0));
        System.out.println(optimisedPower(2, 10));
    }
}
