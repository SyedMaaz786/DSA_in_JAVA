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
    public static boolean isSorted(int arr[], int i) {
        if (i == arr.length-1) { //Base case
            return true;
        }
        if (arr[i] > arr[i+1]) {
            return false;
        }
        return isSorted(arr, i+1);
    }
    public static void main(String args[]) {
        // int n = 10;
        // printDec(n);
        // printInc(n);
        // System.out.println(fact(n));
        // System.out.println(sum(n));
        // System.out.println(fib(n));
        int arr[] = {1,2,3,4};
        System.out.println(isSorted(arr, 0));
    }
}
