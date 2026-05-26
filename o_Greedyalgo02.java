import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class o_Greedyalgo02 { //we made a class of job because we wanted to implement this using OOP concepts 
//     static class Job{
//         int id;
//         int deadline;
//         int profit;

//         public Job(int i, int d, int p){
//             id = i;
//             deadline = d;
//             profit = p;
//         }
//     }
//     public static void main(String args[]){
//         //Job Sequencing
//         int jobsInfo[][] = {{4, 20}, {1, 10}, {1, 40}, {1, 30}};

//         ArrayList<Job> jobs = new ArrayList<>();

//         for(int i=0; i<jobsInfo.length; i++){
//             jobs.add(new Job(i, jobsInfo[i][0], jobsInfo[i][1])); //loop for adding idx i, [0] means deadline, [1] means profit
//         }
//         Collections.sort(jobs, (obj1, obj2) -> obj2.profit-obj1.profit); //(obj1, obj2) -> obj2.profit-obj1.profit) is the lambda fnx for arranging profit in descending order (for ascending just change objects (obj1.profit-obj2.profit))

//         ArrayList<Integer> ans = new ArrayList<>();
//         int time = 0;
//         for(int i=0; i<jobs.size(); i++){
//             Job curr = jobs.get(i);
//             if(curr.deadline > time){ //stare it easy
//                 ans.add(curr.id);
//                 time++;
//             }
//         }
//         System.err.println("Max Jobs : " + ans.size());
//         for(int i=0; i<ans.size(); i++){
//             System.out.print(ans.get(i) + " ");
//         }
//         System.out.println();
//     }



//job sequencing normal greedy approach (in this after sorting the indices change logically so that's why we create a class of jobs and store the id's there)
public static void main(String args[]){
    int jobsInfo[][] = {{4, 20}, {1, 10}, {1, 40}, {1, 30}};

    Arrays.sort(jobsInfo, (a,b) -> b[1] - a[1]); //descending profit based sorting because more profit we want first.
    int time = 0;
    int profit = 0; //optional

    ArrayList<Integer> ans = new ArrayList<>();
    for(int i=0; i<jobsInfo.length; i++){
        if(jobsInfo[i][0] > time){
            ans.add(i);
            profit += jobsInfo[i][1]; //optional
            time++;
        }
    }
    System.out.println("Max Jobs : " + ans.size()); //optional
    System.out.println("Max profit : " + profit); //optional
    
    for(int i=0; i<ans.size(); i++){
        System.out.print(ans.get(i) + " ");
    }
}


    // //Chocola problem - Hard level problem (But it is easy stare the code check notes and lecture)
    // public static void main(String args[]){
    // int rows = 4, cols = 6;
    // Integer verCost[] = {2, 1, 3, 1, 4};
    // Integer horCost[] = {4, 1, 2};

    // Arrays.sort(verCost, Collections.reverseOrder()); //sort it in descending order because we need to perform expensive cuts first
    // Arrays.sort(horCost, Collections.reverseOrder());

    // int v = 0, h = 0;
    // int vp = 1, hp = 1;
    // int cost = 0;

    // while(v < verCost.length && h < horCost.length){
    //     if(verCost[v] < horCost[h]){ //horizontal cut
    //         cost += (horCost[h] * vp); //horizontal cut marne k time po kitte vp aati sab ku touch hota usse * with vp
    //         hp++;
    //         h++;
    //     }
    //     else{ //vertical cuts
    //         cost += (verCost[v] * hp);
    //         vp++;
    //         v++;
    //     }
    // }
    // //Kitte hor bachge usse ek loop
    // while(h < horCost.length){
    //     cost += (horCost[h] * vp);
    //     hp++;
    //     h++;
    // }
    // //kitte ver bachge usse ek loop
    // while(v < verCost.length){
    //     cost += (verCost[v] * hp);
    //     vp++;
    //     v++;
    // }
    // System.out.println("Min cost of cuts : " + cost);

    // }
}