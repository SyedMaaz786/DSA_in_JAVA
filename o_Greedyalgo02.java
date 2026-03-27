import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class o_Greedyalgo02 {
    static class Job{
        int id;
        int deadline;
        int profit;

        public Job(int i, int d, int p){
            id = i;
            deadline = d;
            profit = p;
        }
    }
    public static void main(String args[]){
        //Job Sequencing
        int jobsInfo[][] = {{4, 20}, {1, 10}, {1, 40}, {1, 30}};

        ArrayList<Job> jobs = new ArrayList<>();

        for(int i=0; i<jobsInfo.length; i++){
            jobs.add(new Job(i, jobsInfo[i][0], jobsInfo[i][1])); //loop for adding idx i, [0] means deadline, [1] means profit
        }
        Collections.sort(jobs, (obj1, obj2) -> obj2.profit-obj1.profit); //(obj1, obj2) -> obj2.profit-obj1.profit) is the lambda fnx for arranging profit in descending order (for ascending just change objects (obj1.profit-obj2.profit))

        ArrayList<Integer> seq = new ArrayList<>();
        int time = 0;
        for(int i=0; i<jobs.size(); i++){
            Job curr = jobs.get(i);
            if(curr.deadline > time){ //stare it easy
                seq.add(curr.id);
                time++;
            }
        }
        System.err.println("Max Jobs : " + seq.size());
        for(int i=0; i<seq.size(); i++){
            System.out.print(seq.get(i) + " ");
        }
        System.out.println();
    }
}