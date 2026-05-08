import java.util.ArrayList;
import java.util.Collections;

public class i_ArrayList02 {
    //Swap 2 numbers
    // public static void swap(ArrayList<Integer> list, int idx0, int idx1) {
    //     int temp = list.get(idx0);
    //     list.set(idx0, list.get(idx1));
    //     list.set(idx1, temp);
    // }
    // public static void main(String args[]) {
    //     ArrayList<Integer> list = new ArrayList<>();
    //     list.add(2);
    //     list.add(5);
    //     list.add(9);
    //     list.add(3);
    //     list.add(6);
        
    //     int idx0 = 0, idx1 = 1;
    //     System.out.println(list);
    //     swap(list, idx0, idx1);
    //     System.out.println(list);


    //     //Sorting in Arraylist (Ascending)
    //     Collections.sort(list);
    //     System.out.println("Ascending " + list);

    //     //Sorting in Arraylist (Descending)
    //     Collections.sort(list, Collections.reverseOrder()); //reverseOrder is a comparator fnx inbuilt
    //     System.out.println("Descending " + list);


    //     //multi dimensional ArrayList 
    //     ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
    //     ArrayList<Integer> listt = new ArrayList<>();
    //     ArrayList<Integer> listt2 = new ArrayList<>();
    //     ArrayList<Integer> listt3 = new ArrayList<>();

    //     listt.add(1); listt.add(2); listt.add(3);
    //     mainList.add(listt); 
    //     listt2.add(2); listt2.add(4); listt2.add(6);
    //     mainList.add(listt2);
    //     listt3.add(3); listt3.add(6); listt3.add(9);
    //     mainList.add(listt3);
    //     System.out.println(mainList);

    //     for (int i=0; i<mainList.size(); i++) {
    //         ArrayList<Integer> currList = mainList.get(i);
    //         for (int j=0; j<currList.size(); j++) {
    //             System.out.print(currList.get(j) + " ");
    //         }
    //         System.out.println();
    //     }
    //  }

//----------------------------------------------------------------------------------------------------------


// //Container with max water    brute force (O(n2))
// public static int storeWater(ArrayList<Integer> height) {
//     int maxWater = 0;
//     for (int i=0; i<height.size(); i++) { //here i and j are the idxs not the height arr values
//         for (int j=i+1; j<height.size(); j++) {
//             int ht = Math.min(height.get(i), height.get(j));  //And height.get is the value
//             int width = j-i;
//             int currWater = ht * width;
//             maxWater = Math.max(maxWater, currWater);
//         }
//     }
//     return maxWater;
// }


// // Container with max water 2 pointer approach O(n) - Check mam's lecture if dought and notes aswell
// public static int storeWater(ArrayList<Integer> height) {
//     int maxWater = 0;
//     int lp = 0;
//     int rp = height.size()-1;
//     while (lp < rp) {  //here lp and rp are the idxs values not the actual height arr values
//         int ht = Math.min(height.get(lp), height.get(rp)); //And height.get is the value
//         int width = rp - lp;
//         int currWater = ht * width;
//         maxWater = Math.max(maxWater, currWater);
//         if (height.get(lp) < height.get(rp)) {
//             lp++;
//         }
//         else {
//             rp--;
//         }
//     }
//     return maxWater;
// }
// public static void main(String args[]) {
//     ArrayList<Integer> height = new ArrayList<>();
//     //1, 8, 6, 2, 5, 4, 8, 3, 7
//     height.add(1);
//     height.add(8);
//     height.add(6);
//     height.add(2);
//     height.add(5);
//     height.add(4);
//     height.add(8);
//     height.add(3);
//     height.add(7);
//     System.out.println(storeWater(height));
// }



// //print pair sum should be equal to the target (Brute force) O(n2)
// public static boolean pairSum(ArrayList<Integer> list, int target) {
//     for (int i=0; i<list.size(); i++) {
//         for (int j=i+1; j<list.size(); j++) {
//             if (list.get(i) + list.get(j) == target) {
//                 return true;
//             }
//         }
//     }
//     return false;
// }
// public static void main(String args[]) {
//         ArrayList<Integer> list = new ArrayList<>();

//         // 1, 2, 3, 4, 5, 6
//         list.add(1);
//         list.add(2);
//         list.add(3);
//         list.add(4);
//         list.add(5);
//         list.add(6);

//         int target = 5;
//         System.out.println(pairSum(list, target));
//     }



// //print pair sum should be equal to the target (2 pointer approach) O(n) This is easy if dought watch lecture video
// public static boolean pairSum(ArrayList<Integer> list, int target) {
//     int lp = 0;
//     int rp = list.size()-1;
//     while (lp != rp) {
//         int sum = list.get(lp) + list.get(rp);
//         //case 1
//         if (sum == target) {
//             return true;
//         }
//         //case 2
//         if (sum < target) {
//             lp ++;
//         }
//         else {
//         //case
//             rp--;
//         }
//     }
//     return false; 
// }
// public static void main(String args[]) {
//         ArrayList<Integer> list = new ArrayList<>();

//         // 1, 2, 3, 4, 5, 6
//         list.add(1);
//         list.add(2);
//         list.add(3);
//         list.add(4);
//         list.add(5);
//         list.add(6);

//         int target = 5;
//         System.out.println(pairSum(list, target));
//     }



// //pair sum 2  O(n)
// public static boolean pairSum(ArrayList<Integer> list, int target) {
//     int bp = -1; //breaking point invalid idx we are taking
//     int n = list.size();
//     for (int i=0; i<list.size()-1; i++) {
//         if (list.get(i) > list.get(i+1)) {  //stare it here we got the breaking point check notes if dought
//             bp = i;
//             break;
//         }
//     }
//     int lp = bp+1; //smallest
//     int rp = bp; //largest
//     while (lp !=  rp) {
//         //case 1
//         if (list.get(lp) + list.get(rp) == target) {
//             return true;
//         }
//         //case 2
//         if (list.get(lp) + list.get(rp) < target) {
//             lp = (lp+1) % n;  //byheart this
//         }
//         else {
//         //case 3
//             rp = (n+rp-1) % n; //byheart this
//         }
//     }
//     return false;
// }
// public static void main(String args[]) {
//     ArrayList<Integer> list = new ArrayList<>();

//     // 11, 15, 6, 8, 9, 10 - Sorted & Rotated
//     list.add(11);
//     list.add(15);
//     list.add(6);
//     list.add(8);
//     list.add(9);
//     list.add(10);

//     int target = 16;
//     System.out.println(pairSum(list, target));
// }


}