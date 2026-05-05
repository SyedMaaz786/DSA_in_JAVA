import java.util.Arrays;
import java.util.HashSet;

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

        for(int i=1; i<=n+1; i++){
            for(int j=1; j<=C+1; j++){
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
        for(int i=1; i<=arr.length+1; i++){
            for(int j=1; j<=sum+1; j++){
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

        for(int i=1; i<=val.length+1; i++){
            for(int j=1; j<=C+1; j++){
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
    //coin change
    public static int coinChange(int coins[], int sum, int dp[][], int n){
        for(int i=0; i<dp.length; i++){ //init 0th col with 1
            dp[i][0] = 1;
        }
        for(int j=0; j<dp[0].length; j++){ 
            dp[0][j] = 0;
        }

        for(int i=1; i<=coins.length+1; i++){
            for(int j=1; j<=sum+1; j++){
                if(coins[i-1] <= j){ //valid
                    //include
                    int ans1 = dp[i][j-coins[i-1]];
                    //exclude
                    int ans2 = dp[i-1][j];
                    dp[i][j] = ans1 + ans2; //sum if total ways kind of questions (compare if max, min or anyother type of questions)
                }
                else{ //invalid
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
    //rod cutting 
    public static int rodCutting(int length[], int price[], int rodLength, int dp[][], int n){
        for(int i=0; i<dp.length; i++){ //init 0th col with 0
            dp[i][0] = 0;
        }
        for(int j=0; j<dp[0].length; j++){ //init 0th row with 0
            dp[0][j] = 0;
        }

        for(int i=1; i<=length.length+1; i++){
            for(int j=1; j<=rodLength+1; j++){
                if(length[i-1] <= j){ //valid
                    //include
                    int ans1 = price[i-1] + dp[i][j-length[i-1]];
                    //exclude
                    int ans2 = dp[i-1][j];
                    dp[i][j] = Math.max(ans1, ans2);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][rodLength];
    }
    // // Longest common subsequence
    // //recursion
    // public static int lcs(String str1, String str2, int n, int m){
    //     if(n == 0 || m == 0){
    //         return 0;
    //     }
    //     if(str1.charAt(n-1) == str2.charAt(m-1)){ //same
    //         return lcs(str1, str2, n-1, m-1) + 1;
    //     }
    //     else{ //diff
    //         int ans1 = lcs(str1, str2, n-1, m);
    //         int ans2 = lcs(str1, str2, n, m-1);
    //         return Math.max(ans1, ans2);
    //     }
    // }
    // //memoization
    // public static int lcs2(String str1, String str2, int dp[][], int n, int m){
    //     if(n == 0 || m == 0){
    //         return 0;
    //     }
    //     if(dp[n][m] != -1){
    //         return dp[n][m];
    //     }
    //     if(str1.charAt(n-1) == str2.charAt(m-1)){ //same
    //         return dp[n][m] = lcs2(str1, str2, dp, n-1, m-1) + 1;
    //     }
    //     else{//diff
    //         int ans1 = lcs2(str1, str2, dp, n-1, m);
    //         int ans2 = lcs2(str1, str2, dp, n, m-1);
    //         return dp[n][m] = Math.max(ans1, ans2);
    //     }
    // }
    // //tabulation (lecture for dryrun and understanding)
    // public static int lcs3(String str1, String str2, int dp[][], int n, int m){
    //     for(int i=1; i<=str1.length(); i++){
    //         for(int j=1; j<=str2.length(); j++){
    //             if(str1.charAt(i-1) == str2.charAt(j-1)){ //same
    //                 dp[i][j] = dp[i-1][j-1] + 1; //up and left (diagonally)
    //             }
    //             else{ //diff
    //                 int ans1 = dp[i-1][j]; //up
    //                 int ans2 = dp[i][j-1]; //left
    //                 dp[i][j] = Math.max(ans1, ans2);
    //             }
    //         }
    //     }
    //     return dp[n][m];
    // }
    //Longest common substring
    public static int longestCommonSubstring(String str1, String str2, int dp[][]){
        int ans = 0;
        for(int i=1; i<=str1.length(); i++){
            for(int j=1; j<=str2.length(); j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){ //same
                    dp[i][j] = dp[i-1][j-1] + 1; 
                    ans = Math.max(ans, dp[i][j]); //ans gives longest substring (ie continous)
                }
                else{
                    dp[i][j] = 0; //set back to 0 if substring is breaking
                }
            }
        }
        return ans;
    }
    //Longest increasing subsequence
    //2nd
    public static int lcs(int arr1[], int arr2[]){
        int dp[][] = new int[arr1.length+1][arr2.length+1];
        for(int i=0; i<dp.length; i++){ //init 0th col and row with 0
            for(int j=0; j<dp[0].length; j++){
                dp[i][j] = 0;
            }
        }
        
        for(int i=1; i<=arr1.length; i++){
            for(int j=1; j<=arr2.length; j++){
                if(arr1[i-1] == arr2[j-1]){ //same
                    dp[i][j] = dp[i-1][j-1] + 1; //check in the remaining rows + cols by going up and left
                }
                else{ //diff
                    int ans1 = dp[i-1][j]; 
                    int ans2 = dp[i][j-1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        return dp[arr1.length][arr2.length];
    }
    //1st
    public static int lis(int arr1[]){
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<arr1.length; i++){
            set.add(arr1[i]);
        }
        int arr2[] = new int[set.size()]; //another arr2[] we created of size set to store unique els
        int i = 0;
        for(int num : set){ //foreach loop to fill values in arr2[] 
            arr2[i] = num;
            i++;
        }
        Arrays.sort(arr2); //ascending
        return lcs(arr1, arr2);
    }
    //Edit distance (it's easy, check lecture for understanding + dryrun)
    public static int editDistance(String str1, String str2, int dp[][]){
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                if(i == 0){
                    dp[i][j] = j; //init 0th row with 1,2,3...
                }
                if(j == 0){
                    dp[i][j] = i; //init 0th col with 1,2,3...
                }
            }
        }

        for(int i=1; i<=str1.length(); i++){
            for(int j=1; j<=str2.length(); j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){ //same
                    dp[i][j] = dp[i-1][j-1]; 
                }
                else{ //diff
                    int ans1 = dp[i][j-1] + 1; //add
                    int ans2 = dp[i-1][j] + 1; //del
                    int ans3 = dp[i-1][j-1] + 1; //replace
                    dp[i][j] = Math.min(ans1, Math.min(ans2, ans3));
                }
            }
        }
        return dp[str1.length()][str2.length()];
    }
    //String conversion
    public static int stringConversion(String str1, String str2, int dp[][]){
        for(int i=0; i<dp.length; i++){
            dp[i][0] = 0;
        }
        for(int j=0; j<dp[0].length; j++){
            dp[0][j] = 0;
        }

        for(int i=1; i<=str1.length(); i++){
            for(int j=1; j<=str2.length(); j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){ //same
                    dp[i][j] = dp[i-1][j-1] + 1; //diag
                }
                else{
                    int ans1 = dp[i][j-1]; //add
                    int ans2 = dp[i-1][j]; //del
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        return dp[str1.length()][str2.length()];
    }
    //Wildcard matching (it's a hard lvl problem and includes too many cases, so lecture for understanding + dryrun)
    public static boolean wildcardMatch(String s, String p, boolean dp[][]){
        dp[0][0] = true; //init i=j=0 true
        for(int i=1; i<s.length()+1; i++){
            dp[i][0] = false; //if s = some value and j = "", then there is nothing to match so false
        }
        for(int j=1; j<p.length()+1; j++){
            if(p.charAt(j-1) == '*'){
                dp[0][j] = dp[0][j-1]; //if jth(ie last) char at p is *, then check for the rest p char
            }
        }
        for(int i=1; i<s.length()+1; i++){
            for(int j=1; j<p.length()+1; j++){
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){ //ith char == jth char || jth char == ?
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i][j-1] || dp[i-1][j]; //match it with empty || match it with the last char 
                }
                else{
                    dp[i][j] = false;
                }
            }
        }
        return dp[s.length()][p.length()];
    }
    //Catalan's number
    //recursion
    public static int catalanRec(int n){
        if(n == 0 || n == 1){ //catalan 1 and 0 is 1, check notes
            return 1;
        }
        int ans = 0;
        for(int i=0; i<=n-1; i++){
            ans += catalanRec(i) * catalanRec(n-i-1); //(n-i-1) pattern problems logic remember
        }
        return ans;
    }
    //memoization
    public static int catalanMem(int n, int dp[]){
        if(n == 0 || n == 1){
            return 1;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        int ans = 0;
        for(int i=0; i<=n-1; i++){
            ans += catalanMem(i, dp) * catalanMem(n-i-1, dp);
        }
        return dp[n] = ans;
    }
    //tabulation
    public static int catalanTab(int n, int dp[]){
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<=n; i++){
            for(int j=0; j<i; j++){
                dp[i] += dp[j] * dp[i-j-1];
            }
        }
        return dp[n];
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


        
        // int val[] = {15, 14, 10, 45, 30};
        // int wt[] = {2, 5, 1, 3, 4};
        // int C = 7;
        // int dp[][] = new int[val.length+1][C+1];
        // System.out.println(unboundedKnapsack(val, wt, C, val.length, dp));


        // int coins[] = {2, 5, 3, 6};
        // int sum = 10;
        // int dp[][] = new int[coins.length+1][sum+1];
        // System.out.println(coinChange(coins, sum, dp, coins.length));


        // int length[] = {1, 2, 3, 4, 5, 6, 7, 8};
        // int price[] = {1, 5, 8, 9, 10, 17, 17, 20};
        // int rodLength = 8;
        // int dp[][] = new int[length.length+1][rodLength+1];
        // System.out.println(rodCutting(length, price, rodLength, dp, length.length));


        // String str1 = "abcdge";
        // String str2 = "abedg";
        // System.out.println(lcs(str1, str2, str1.length(), str2.length()));


        // String str1 = "abcdge";
        // String str2 = "abedg";
        // int dp[][] = new int[str1.length()+1][str2.length()+1];
        // for(int i=0; i<dp.length; i++){ //init 0th col and row with 0
        //     for(int j=0; j<dp[0].length; j++){
        //         dp[i][j] = -1;
        //     }
        // }
        // System.out.println(lcs2(str1, str2, dp, str1.length(), str2.length()));


        // String str1 = "abcdge";
        // String str2 = "abedg";
        // int dp[][] = new int[str1.length()+1][str2.length()+1];
        // for(int i=0; i<dp.length; i++){ //init oth col and row with 0
        //     for(int j=0; j<dp[0].length; j++){
        //         dp[i][j] = 0;
        //     }
        // }
        // System.out.println(lcs3(str1, str2, dp, str1.length(), str2.length()));


        // String str1 = "ABCDE";
        // String str2 = "ABCCE";
        // int dp[][] = new int [str1.length()+1][str2.length()+1];
        // for(int i=0; i<dp.length; i++){  //init oth col and row with 0
        //     for(int j=0; j<dp[0].length; j++){
        //         dp[i][j] = 0;
        //     }
        // }
        // System.out.println(longestCommonSubstring(str1, str2, dp));


        // int arr1[] = {50, 3, 10, 7, 40, 80};
        // System.out.println(lis(arr1));


        // String str1 = "intention";
        // String str2 = "execution";
        // int dp[][] = new int[str1.length()+1][str2.length()+1];
        // System.out.println(editDistance(str1, str2, dp));


        // String str1 = "pear";
        // String str2 = "sea";
        // int dp[][] = new int[str1.length()+1][str2.length()+1];
        // int lcs = stringConversion(str1, str2, dp);
        // int del = str1.length() - lcs; // deletion
        // int add = str2.length() - lcs; // addition
        // System.out.println(del);
        // System.out.println(add);
        // System.out.println(del + add); //total operations


        // String s = "baaabab";
        // String p = "*****ba*****ab";
        // boolean dp[][] = new boolean[s.length()+1][p.length()+1];
        // System.out.println(wildcardMatch(s, p, dp));


        // //rec
        // int n = 4;
        // System.out.println(catalanRec(n));
        // //mem
        // int dp[] = new int[n+1];
        // // Arrays.fill(dp, -1);
        // // System.out.println(catalanMem(n, dp));
        // //tab
        // System.out.println(catalanTab(n, dp));
    }
}
