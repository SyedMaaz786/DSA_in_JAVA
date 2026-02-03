import java.util.*;
public class b_JavaArrays02 {
    
// // subarray sum with max sum (Brute Force) - time complexity On3
// public static void maxSubarraySum(int arr[]) {
//     int currSum = 0;
//     int maxSum = Integer.MIN_VALUE;
//     for (int i=0; i<arr.length; i++) {
//         for (int j=i; j<arr.length; j++) {
//             currSum = 0;
//             for (int k=i; k<=j; k++) {
//                 currSum = currSum + arr[k];
//             }
//             System.out.println(currSum);
//             if (currSum > maxSum) {
//                 maxSum = currSum;
//             }
//         }
//     }
//     System.out.println("max sum = " + maxSum);
// }
// public static void main (String args[]) {
//     int arr[] = {1,2,3,4};
//     maxSubarraySum(arr);
// }


// // //max subarray sum (prefix sum) - time complexity On2
// public static void maxSubarraySum(int arr[]) {
//     int currSum = 0;
//     int maxSum = Integer.MIN_VALUE;
//     int prefix[] = new int[arr.length];

//     //calc prefix array
//     prefix[0] = arr[0];
//     for (int i=1; i<prefix.length; i++) {
//         prefix[i] = prefix[i-1] + arr[i];  //Here we are defining the prefix[0] = arr[0] in the start itself because if we start the loop from i=0, then we will get -1 as the index value which invalid
//     }                                      //logic to sum the values and store it in the prefix arr 
//     for (int i=0; i<arr.length; i++) {
//         for (int j=i; j<arr.length; j++) {
//             currSum = i == 0 ? prefix[j] : prefix[j] - prefix[i-1];
//             if (currSum > maxSum) {
//                 maxSum = currSum;
//             }
//         }
//     }
//     System.out.println("max sum: " + maxSum);
// }
// public static void main (String args[]) {
//     int arr[] = {1,2,3,4};
//     maxSubarraySum(arr);
// }


// // // //max subarray sum (kadane's) - time complexity On
// public static void maxSubarraySum (int arr[]) {
//     int currSum = 0;
//     int maxSum = Integer.MIN_VALUE;

//     for (int i=0; i<arr.length; i++) {
//         currSum = currSum + arr[i];
//         if (currSum < 0){
//             currSum = 0;
//         }
//         maxSum = Math.max(currSum, maxSum);
//     }
//     System.out.println("Max subarray sum is: " + maxSum);
// }
// public static void main (String args[]) {
//     int arr[] = {1,-2,3,-4,5,-6};
//     maxSubarraySum(arr);
// }


// //Trapped water
// public static int trappedRainWater (int height[]) {
//     //calc left max height using auxillary arr
//     int leftMax[] = new int[height.length];
//     leftMax[0] = height[0];
//     for (int i=1; i<height.length; i++) {
//         leftMax[i] = Math.max(height[i], leftMax[i-1]);
//     }
//     //calc right max height using auxillary arr
//     int rightMax[] = new int[height.length];
//     rightMax[height.length-1] = height[height.length-1];
//     for (int i=height.length-2; i>=0; i--) {
//         rightMax[i] = Math.max(height[i], rightMax[i+1]);
//     }
//     //loop
//     int trappedWater = 0;
//     for (int i=0; i<height.length; i++) {
//         //waterlevel = min(left max height, right max height)
//         int waterLevel = Math.min(leftMax[i], rightMax[i]);
//         //trapped water = waterlevel - height[i]
//         trappedWater = trappedWater + waterLevel - height[i];
//     }
//     return trappedWater;

// }
// public static void main (String args[]) {
//     int height[] = {4,2,0,6,3,2,5};
//     System.err.println(trappedRainWater(height));
// }


//BuyAndSellStock
public static int BuyAndSellStock (int prices[]) {
    int buyPrice = Integer.MAX_VALUE;
    int maxProfit = 0;
    for (int i=0; i<prices.length; i++) {
        if (buyPrice < prices[i]) {  //profit
            int profit = prices[i] - buyPrice;
            System.out.println("Profit is " + profit + " when price = " + prices[i]);
            maxProfit = Math.max(maxProfit, profit);
        } 
        else {
            buyPrice = prices[i];
            System.out.println("You can buy it at " + buyPrice);
        }
    }
    return maxProfit;
}
public static void main(String args[]) {
    int prices[] = {7,1,5,3,6,4};
    System.out.println("Maximum profit is " + BuyAndSellStock(prices));
}




}
