import java.util.PriorityQueue;

public class r_PriorityQueue01 {
    public static void main(String args[]){
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //Priority queue arranges elements in ascending order lowest element highest priority
        pq.add(3); //O(logn)                   //for descending order just add comparator=reverse
        pq.add(2);
        pq.add(1);

        while(!pq.isEmpty()){
            System.out.println(pq.peek()); //O(1)
            pq.remove(); //O(logn)
        }
    }
    
}
