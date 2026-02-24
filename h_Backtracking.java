public class h_Backtracking {
    public static void changeArr(int arr[], int i, int val) {
        //base case
        if (i == arr.length) {
            printArr(arr);
            return;
        }
        //recursion
        arr[i] = val; //Here we are placing values from 0 index. This is printed while going up
        changeArr(arr, i+1, val+1); //values will be placed on next index and so on ...
        //backtracking
        arr[i] = arr[i] - 2; //This is printed while coming down
    }
    public static void printArr(int arr[]) {
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String args[]) {
        int arr[] = new int[5];
        changeArr(arr, 0, 1);
        printArr(arr);
    }
}
