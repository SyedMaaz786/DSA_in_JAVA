import java.util.*;

public class o_Greedyalgo01 {
    public static void main(String args[]) {
    // //Activity Selection (if sorted on basis of end)
    //     int start[] = {1, 3, 0, 5, 8, 5};
    //     int end[] = {2, 4, 6, 7, 9, 9};

    //     //end time is sorted
    //     int maxAct = 0;
    //     ArrayList<Integer> ans = new ArrayList<>();

    //     //1st activity 
    //     maxAct = 1;
    //     ans.add(0);
    //     int lastEnd = end[0];
    //     for(int i=1; i<end.length; i++){
    //         if(start[i] >= lastEnd){  //main logic stare the code you will get it
    //             maxAct++;
    //             ans.add(i);
    //             lastEnd = end[i];
    //         }
    //     }
    //     System.out.println("Max activities : " + maxAct);
    //     for(int i=0; i<ans.size(); i++){
    //         System.out.print("A" + ans.get(i) + " ");
    //     }
    //     System.out.println();



    // //Activity Selection (if not sorted)
    //     int start[] = {1, 3, 0, 5, 8, 5};
    //     int end[] = {2, 4, 6, 7, 9, 9};

    //     //sorting (create a 2d arr first)
    //     int activities[][] = new int[start.length][3]; //row , col
    //     for(int i=0; i<start.length; i++){  //loop for filling the values in 2d arr 0-idx 1-start 2-end
    //         activities[i][0] = i; //idx
    //         activities[i][1] = start[i]; //start
    //         activities[i][2] = end[i]; //end
    //     }

    //     //lambda fnx -> shortform
    //     Arrays.sort(activities, Comparator.comparingInt(o -> o[2])); //sort the 2nd idx ie end

    //     int maxAct=0;
    //     ArrayList<Integer> ans = new ArrayList<>();

    //     maxAct = 1;
    //     ans.add(activities[0][0]);
    //     int lastEnd = activities[0][2];  // [2] bcoz it stores end 
    //     for(int i=1; i<end.length; i++){
    //         if(activities[i][1] >= lastEnd){  // [1] bcoz it stores start 
    //             maxAct++;
    //             ans.add(activities[i][0]);  // remember in ans we are adding the idx so [o]
    //             lastEnd = activities[i][2];
    //         }
    //     }
    //     System.out.println("Max activities : " + maxAct);
    //     for(int i=0; i<ans.size(); i++){
    //         System.out.print("A" + ans.get(i) + " ");
    //     }
    //     System.out.println();



    //Fractional knapsack
    int val[] = {60, 100, 120};
    int weight[] = {10, 20, 30};
    int W = 50;

    double ratio[][] = new double[val.length][2]; //row , col

    for(int i=0; i<val.length; i++){  // loop for storing the values in the 2d arr
        ratio[i][0] = i;  // [0] for idx
        ratio[i][1] = val[i]/(double)weight[i]; // [1] for ratio - (val/weight) is the form check notes
    }

    //ascending order
    Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));  // [1] sort ratio

    int capacity = W;
    int finalVal = 0;
    for(int i=ratio.length-1; i>=0; i--){ //reverse loop 
        int idx = (int)ratio[i][0];
        if(capacity >= weight[idx]){  //capacity is more then add items - Include full item
            finalVal += val[idx];
            capacity -= weight[idx];
        }
        else{ //capacity is less, then add only, how much capacity is left that much items - Include fractional item
            finalVal += (ratio[i][1] * capacity);  //This is the formula - val*capacity
            capacity = 0;
            break;
        }
    }
    System.out.println("Final value : " + finalVal);



    }
}



        

