import java.util.Arrays;

public class w_Dp01 {
    //Fibonacci using DP (recursion 2^n and DP O(n))
    //memoization
    public static int fibMem(int n, int dp[]){
        if(n == 0 || n == 1){ //base case for fibonacci
            return n;
        }
        if(dp[n] != 0){ // dp[] is init 0 below at all places below, so now if anywhere it is a valid value that means fib of that is calculated
            return dp[n];
        }
        dp[n] = fibMem(n-1, dp) + fibMem(n-2, dp); // recursive call for the fib which is not yet calc and store it in dp[n] itself and simply return it
        return dp[n];
    }
    //tabulation
    public static int fibTab(int n, int dp[]){
        dp[0] = 0; //init these so that we can calc fib of of others and store it in the dp[]
        dp[1] = 1;
        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        } 
        return dp[n]; 
    }
    //Climbing stairs 
    //memoization
    public static int countWaysMem(int n, int dp[]){
        if(n == 0){ //if a person is standing on the 0th step meaning 1st step return 1 
            return 1;
        }
        if(n < 0){ //if -ve steps which is invalid return 0
            return 0;
        }
        if(dp[n] != -1){ //already calc
            return dp[n];
        }
        dp[n] = countWaysMem(n-1, dp) + countWaysMem(n-2, dp); //recursive call for non-calc 
        return dp[n];
    }
    //tabulation
    public static int countWaysTab(int n, int dp[]){
        dp[0] = 1;
        for(int i=1; i<n; i++){
            if(i == 1){
                dp[i] = dp[i-1]; //this condition because dp[i-2] for i==1 will give -ve value 
            }
            else{
                dp[i] = dp[i-1] + dp[i-2];
            }
        }
        return dp[n];
    }
    //0-1 Knapsack
    //memoization
    public static int knapsackMem(int val[], int wt[], int C, int n, int dp[][]){ //C is capacity, n is the particular item
        if(C == 0 || n == 0){
            return 0;
        }
        if(dp[n][C] != -1){ //valid simply return
            return dp[n][C];
        }
        if(wt[n-1] <= C){ //valid
            //include
            int ans1 = val[n-1] + knapsackMem(val, wt, C-wt[n-1], n-1, dp); //lecture + stare it 
            //exclude
            int ans2 = knapsackMem(val, wt, C, n-1, dp); //we are doing this ans1 and ans2 because what if the next upcoming wt if added will give more profit than the current wt
            dp[n][C] = Math.max(ans1, ans2); //this will give us the max value which we could get
            return dp[n][C]; //store it first and then return (uppar ki line dekh dp[n][C])
        }
        else{
            dp[n][C] = knapsackMem(val, wt, C, n-1, dp); //invalid meaning wt is more than capacity
            return dp[n][C]; //store it first and return (uppar ki line dekh dp[n][C])
        }
    }
    // //this is to print our dp 2d arr of tabulation this is optional just to view it we wrote it
    // public static void print(int dp[][]){
    //     for(int i=0; i<dp.length; i++){
    //         for(int j=0; j<dp[0].length; j++){
    //             System.out.print(dp[i][j] + " ");
    //         }
    //         System.out.println();
    //     }
    //     System.out.println();
    // }
    //tabulation (check lecture + very carefully, it's easy but stare + focus is required)
    public static int knapsackTab(int val[], int wt[], int C, int n, int dp[][]){
        for(int i=0; i<dp.length; i++){ //init 0th col with 0
            dp[i][0] = 0;
        }
        for(int j=0; j<dp[0].length; j++){ //init 0th row with 0
            dp[0][j] = 0;
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<C+1; j++){
                if(wt[i-1] <= j){ //valid
                    //include
                    int ans1 = val[i-1] + dp[i-1][j-wt[i-1]];
                    //exclude
                    int ans2 = dp[i-1][j];
                    dp[i][j] = Math.max(ans1, ans2); 
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
                
            }
        }
        // print(dp); //this is optional just to view our dp 2d arr we have printed this
        return dp[n][C];
    }
    //Target sum 
    //tabulation
    public static boolean targetSum(int arr[], int sum, boolean dp[][]){
        for(int i=0; i<dp.length; i++){ //init 0st col with true
            dp[i][0] = true;
        }
        //i = item and j = sum 
        for(int i=1; i<arr.length+1; i++){
            for(int j=1; j<sum+1; j++){
                //include (valid)
                if(arr[i-1] <= j && dp[i-1][j-arr[i-1]] == true){
                    dp[i][j] = true;
                }
                //exclude
                else if(dp[i-1][j] == true){
                    dp[i][j] = true;
                }
                //not valid no need to check as we wrote elseif so else will run automatically
            }
        }
        return dp[arr.length][sum];
    }
    //Unbounded knapsack
    //tabulation
    public static int unboundedKnapsack(int val[], int wt[], int C, int n, int dp[][]){
        for(int i=0; i<dp.length; i++){ //init 0th col with 0
            dp[i][0] = 0;
        }
        for(int j=0; j<dp[0].length; j++){ //init 0th row with 0
            dp[0][j] = 0;
        }

        for(int i=1; i<val.length+1; i++){
            for(int j=1; j<C+1; j++){
                if(wt[i-1] <= j){ //valid
                    //include
                    int ans1 = val[i-1] + dp[i][j-wt[i-1]]; //dp[i] is the only change for unbounded knapsack
                    //exclude
                    int ans2 = dp[i-1][j];
                    dp[i][j] = Math.max(ans1, ans2);
                }
                else{ //invalid
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][C];
    }
    public static void main(String args[]){
        // int n = 5;
        // int dp[] = new int[n+1]; // 0, 0, 0, 0, 0, 0 (imp n+1 because we will store 0 also in fib, so it goes like 0,1,1,2,3 and so on)
        // System.out.println(fibMem(n, dp));
        // System.out.println(fibTab(n, dp));


        // int n = 5;
        // int dp[] = new int[n+1];
        // Arrays.fill(dp, -1); //init dp[] with -1, -1, -1, -1, -1, -1
        // System.out.println(countWaysMem(n, dp));
        // System.out.println(countWaysTab(n, dp));


        // int val[] = {15, 14, 10, 45, 30};
        // int wt[] = {2, 5, 1, 3, 4};
        // int C = 7;
        // int dp[][] = new int[val.length+1][C+1]; //row = n(particular item),col = C, (+1 because to hit base case ie 0) 2d arr for this problem using memoization because 2 variables item and capacity is changing everytime so to keep that info 2d is optimum
        // for(int i=0; i<dp.length; i++){ //loops to fill rows and col 2d arr
        //     for(int j=0; j<dp[0].length; j++){
        //         dp[i][j] = -1;
        //     }
        // }
        // System.out.println(knapsackMem(val, wt, C, val.length, dp));
        // System.out.println(knapsackTab(val, wt, C, val.length, dp));


        // int arr[] = {4, 2, 7, 1, 3};
        // int sum = 10;
        // boolean dp[][] = new boolean[arr.length+1][sum+1];
        // System.out.println(targetSum(arr, sum, dp));


        
        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};
        int C = 7;
        int dp[][] = new int[val.length+1][C+1];
        System.out.println(unboundedKnapsack(val, wt, C, val.length, dp));
    }
}
