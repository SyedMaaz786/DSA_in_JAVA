public class h_Backtracking {
    //Backtracking on arr
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


    //Find subsets
    public static void findSubsets(String str, String ans, int i) {  //we created a empty String ans inside which the values are stored
        //base case
        if (i == str.length()) {
            System.out.println(ans);
            return;
        }
        //recursion
        //Yes Choice
        findSubsets(str, ans + str.charAt(i), i+1);
        //No Choice
        findSubsets(str, ans, i+1);
    }


    //Find subsets using StringBuilder
    public static void printSubsets(String str, StringBuilder ans, int i) {
        //base case
        if (i == str.length()) {
            System.out.println(ans);
            return;
        }
        //recursion
        //Yes choice
        printSubsets(str, ans.append(str.charAt(i)), i+1);
        //Backtrack
        ans.deleteCharAt(ans.length() - 1);  //This line is used because we used StringBuilder which is mutable and hence it will not create a new string object for next step (GPT)
        //No choice
        printSubsets(str, ans, i+1);
    }


    //find Permutations (For this explain the dry run in notes)
    public static void findPermutations(String str, String ans) {
        //base case 
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }
        //recursion
        for (int i=0; i<str.length(); i++) {
            char curr = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i + 1); //Check this line in GPT
            findPermutations(newStr, ans + curr);
        }
    }
    public static void main(String args[]) {
        // int arr[] = new int[5];
        // changeArr(arr, 0, 1);
        // printArr(arr);
        String str = "abc";
        // printSubsets(str,new StringBuilder() , 0);
        // findSubsets(str, "", 0);
        findPermutations(str, "");
    }
}
