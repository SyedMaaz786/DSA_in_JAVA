import java.util.*;
public class b_JavaArrays01 {
//     public static void main (String args[]) {
//         int marks[] = new int[50]; //explicitly declaring size ie 50
//         int numbers[] = {1,2,3};  //Here we are directly specifying the values java will automatically detect the size
//         String myName[] = {"Syed", "Maaz"};
//         System.out.println(marks.length);
//         System.out.println(Arrays.toString(numbers)); //we are using type conversion.
//         System.out.println(Arrays.toString(myName));


//         int marks[] = new int[100];  //Here we have created a array of length 100
//         Scanner sc = new Scanner(System.in);
//         //using indexing we are taking input on that particular arr index.
//         marks[0] = sc.nextInt();  //phy
//         marks[1] = sc.nextInt();  //chem
//         marks[2] = sc.nextInt();  //math
//         System.out.println("Phy = " + marks[0]);
//         System.out.println("Chem = " + marks[1]);
//         System.out.println("Math = " + marks[2]);
//         int percentage = (marks[0] + marks[1] + marks[2]) / 3;   //taking avg
//         System.out.println("Percentage = " + percentage);
//     } 


// //Arrays as fnx parameters
// public static void update (int marks[]) {  //remember this arr[] as parameter in the fnx is used to update the values of the arr in the main fnx.
//     for (int i=0; i<marks.length; i++) {  //looping till length but indexing so only <
//         marks[i] = marks[i] + 1;          //Updating marks by 1
//     }
// }
// public static void main (String args[]) {  //main fnx
//     int marks[] = {97,98,99};
//     update(marks);
//     for (int i=0; i<marks.length; i++) {   //for printing we are again using the for loop here
//         System.out.println(marks[i]);
//     }
// }


// //Linear Search
// //find index of an element in array
// public static int linearSearch (int numbers[], int key) {
//     for (int i=0; i<numbers.length; i++) {
//         if (numbers[i] == key) {
//             return i;
//         }
//     }
//     return -1;
// }
// public static void main (String args[]) {
//     int numbers[] = {2,4,6,8,10};
//     int key = 10;
//     int index = linearSearch(numbers, key);
//     if (index == -1) {
//         System.out.println("Index NOT found");
//     }
//     else {
//         System.out.println("Index is = " + index);
//     }
// }


// //find index value of an element in an array
// public static int linearSearch (String arr[], String key) {
//     for (int i=0; i<arr.length; i++) {
//         if (arr[i] == key) {
//             return i;
//         }
//     }
//     return -1;
// }
// public static void main(String args[]) {
//     String arr[] = {"creatine", "whey", "'chicken"};
//     String key = "creatine";
//     int index = linearSearch(arr, key);
//     if (index == -1) {
//         System.out.println("Take Sattu");
//     }
//     else {
//         System.out.print(arr[index]);
//     }
// }


// //largest number in an arr
// public static int largestNumb (int arr[]) {
//         int largest = Integer.MIN_VALUE; //-infinity (Specifies the smallest value)
//         for (int i=0; i<arr.length; i++) {  //to find smallest just give +infinity ie max_value
//             if (arr[i] > largest) { //we are comparing for each and every element in our arr with the smallest number we defined above ie -∞
//                 largest = arr[i];
//             }
//         }
//         return largest;
// }
// public static void main(String args[]) {
//     int arr[] = {1,2,6,3,5};
//     System.out.println("Largest value = " + largestNumb(arr));
// }


// // Binary Search (for ascending sorted arr)
// // find index value of an element in an array
// public static int binarySearch (int arr[], int key) {
//     int start = 0, end = arr.length - 1;  //length will start from 1 but we need the index which starts from 0 so (-1) GPT if dought
//     while (start <= end ) { //from start to end of the arr
//         int mid = (start + end) / 2;  // formula to get mid value
//         if (arr[mid] == key) {
//             return mid;
//         }
//         if (arr[mid] < key) {
//             start = mid + 1;   //if the middle value is smaller than key search on the right side
//         }
//         else {
//             end = mid - 1;     //if the middle value is larger than key then search on the left side
//         }
//     }
//     return -1;
// }
// public static void main(String args[]) {
//     int arr[] = {2,4,6,8,10,12,14};
//     int key = 10;
//     int index = binarySearch(arr, key);
//     System.out.println(index);
// }


// //Binary search (for descending sorted arr)
// public static int binarySearch (int arr[], int key) {
//     int start = 0, end = arr.length - 1;
//     while (start <= end) {
//         int mid = (start + end) / 2;
//         if (arr[mid] == key) {
//             return mid;
//         }
//         if (arr[mid] > key) {
//             start = mid + 1;
//         }
//         else {
//             end = mid - 1;
//         }
//     }
//     return -1;
// }
// public static void main(String args[]) {
//     int arr[] = {16,14,12,10,8,6,4,2};
//     int key = 14;
//     int index = binarySearch(arr, key);
//     System.out.println("Index value is " + index);
// }


// // //Reverse an array
// public static void reverseArr (int numbers[]) {
//     int start = 0, end = numbers.length-1;
//     while (start < end) {
//         int temp = numbers[start];
//         numbers[start] = numbers[end];
//         numbers[end] = temp;
//         start ++;  //we will swap from start and end value so start will increment and go to next from last end decrement and come one value reverse
//         end --;
//     }
// }
// public static void main(String args[]) {
//     int numbers[] = {1,2,3,4,5,6,7,8,9};
//     reverseArr(numbers);
//     for (int i=0; i<numbers.length; i++) {
//         System.out.print(numbers[i]);
//     }
//     System.out.println();
// }


// //Print Pairs
// public static void printPairs (int numbers[]) {
//     int tp =0;
//     for (int i=0; i<numbers.length; i++) {  //Stare the code you will get it, this basically prints lines until the nth value because we are printing it in the same line dont get confuse and that lines 1st index value we are priniting ie 2
//         for (int j=i+1; j<numbers.length; j++) {  //initialising from 2nd index because we need to print it from 2nd index
//             System.out.print("(" + numbers[i] + "," + numbers[j] + ")");
//             tp ++;
//         }
//         System.out.println();
//     }
//     System.out.println("Total pairs = " + tp);
// }
// public static void main(String args[]) {
//     int numbers[] = {2, 4, 6, 8, 10};
//     printPairs(numbers);
// }


// //print subarrays
// public static void printSubarray (int numbers[]) {
//     int ts = 0;
//     for (int i=0; i<numbers.length; i++) {      //starting index
//         for (int j=i; j<numbers.length; j++) {  //ending index
//             for (int k=i; k<=j; k++) {          //printing elements
//                 System.out.print(numbers[k]);
//             }
//             ts ++;
//             System.out.println();
//         }
//     }
//     System.out.println("Total subarrays = " + ts);
// }
// public static void main (String args[]) {
//     int numbers[] = {2,4,6,8,10};
//     printSubarray(numbers);
// }


// // subarray sum with max sum
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



}
