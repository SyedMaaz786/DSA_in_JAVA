import java.util.Arrays;

public class w_Dp01 {
    //Fibonacci using DP (recursion 2^n and DP O(n))
    //memoization
    public static int fibDp(int n, int dp[]){
        if(n == 0 || n == 1){ //base case for fibonacci
            return n;
        }
        if(dp[n] != 0){ // dp[] is init 0 below at all places below, so now if anywhere it is a valid value that means fib of that is calculated
            return dp[n];
        }
        dp[n] = fibDp(n-1, dp) + fibDp(n-2, dp); // recursive call for the fib which is not yet calc and store it in dp[n] itself and simply return it
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
    public static int countWaysDp(int n, int dp[]){
        if(n == 0){ //if a person is standing on the 0th step meaning 1st step return 1 
            return 1;
        }
        if(n < 0){ //if -ve steps which is invalid return 0
            return 0;
        }
        if(dp[n] != -1){ //already calc
            return dp[n];
        }
        dp[n] = countWaysDp(n-1, dp) + countWaysDp(n-2, dp); //recursive call for non-calc 
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
    public static int knapsack(int val[], int wt[], int C, int n, int dp[][]){ //C is capacity, n is the particular item
        if(C == 0 || n == 0){
            return 0;
        }
        if(dp[n][C] != -1){ //valid simply return
            return dp[n][C];
        }
        if(wt[n-1] <= C){ //valid
            //include
            int ans1 = val[n-1] + knapsack(val, wt, C-wt[n-1], n-1, dp); //lecture + stare it 
            //exclude
            int ans2 = knapsack(val, wt, C, n-1, dp); //we are doing this ans1 and ans2 because what if the next upcoming wt if added will give more profit than the current wt
            dp[n][C] = Math.max(ans1, ans2); //this will give us the max value which we could get
            return dp[n][C]; //store it first and then return (uppar ki line dekh dp[n][C])
        }
        else{
            dp[n][C] = knapsack(val, wt, C, n-1, dp); //invalid meaning wt is more than capacity
            return dp[n][C]; //store it first and return (uppar ki line dekh dp[n][C])
        }
    }
    public static void main(String args[]){
        // int n = 5;
        // int dp[] = new int[n+1]; // 0, 0, 0, 0, 0, 0 (imp n+1 because we will store 0 also in fib, so it goes like 0,1,1,2,3 and so on)
        // System.out.println(fibDp(n, dp));
        // System.out.println(fibTab(n, dp));


        // int n = 5;
        // int dp[] = new int[n+1];
        // Arrays.fill(dp, -1); //init dp[] with -1, -1, -1, -1, -1, -1
        // System.out.println(countWaysDp(n, dp));
        // System.out.println(countWaysTab(n, dp));


        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};
        int C = 7;
        int dp[][] = new int[val.length+1][C+1]; //row = n(particular item),col = C, (+1 because to hit base case ie 0) 2d arr for this problem using memoization because 2 variables item and capacity is changing everytime so to keep that info 2d is optimum
        for(int i=0; i<dp.length; i++){ //loops to fill rows and col 2d arr
            for(int j=0; j<dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        System.out.println(knapsack(val, wt, C, val.length, dp));
    }
}
