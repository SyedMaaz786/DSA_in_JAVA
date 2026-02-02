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




}
