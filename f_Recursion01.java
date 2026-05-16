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
        return n * fact(n-1);  // n * (n-1)!
    }
    //Sum of first n natural numbers
    public static int sum(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sum(n-1);
    }
    //Fibonacci number
    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n-1) + fib(n-2); //2 recursive calls
    }
    //Check if arr is sorted (prefer for loop(iteration) it is preferred
    public static boolean isSorted(int arr[], int i) {  //Where i is the index
        //3rd
        if (i == arr.length-1) { //Base case
            return true;
        }
        //2nd
        if (arr[i] > arr[i+1]) {
            return false;
        }
        //1st
        return isSorted(arr, i+1); //recursive call uske aage wale numbers ku
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
    //Last occurence index (only difference is recursive call at first)
    public static int lastOcc(int arr[], int key, int i) {  
        if (i == arr.length) {  //Base case
            return -1;
        }
        int ans = lastOcc(arr, key, i+1);
        if (ans == -1 && arr[i] == key) {
            return i;
        }
        return ans;
    }
    //print x power n
    public static int power(int x, int n) { //Where x is the base and n is the power
        if (n == 0) {  //Base case
            return 1;
        }
        return x * power(x, n-1); //simple (x*x^n-1) check notes
    }
    //Optimised power code (Check notes if dought) Ologn
    public static int optimisedPower(int x, int n) {
        if (n == 0) { //Base case
            return 1;
        }
        if(n % 2 == 0){ //even number
            return optimisedPower(x, n/2) * optimisedPower(x, n/2);
        }
        else{ //odd number
            return x * optimisedPower(x, n/2) * optimisedPower(x, n/2);
        }
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
