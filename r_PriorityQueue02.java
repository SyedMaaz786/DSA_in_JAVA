import java.util.*;
public class r_PriorityQueue02 {
    //How to create pq for objects of a class 
    static class Student implements Comparable<Student>{ //This Comparable is the interface used to compare objects of a class 
        String name;
        int rank;

        public Student(String name, int rank){
            this.name = name;
            this.rank = rank;
        }
        @Override
        public int compareTo(Student s2){ //compareTo is a fnx of that interface for comparing two objects of a class
            return this.rank - s2.rank;
        }
    }
    public static void main(String args[]){
        PriorityQueue<Student> pq = new PriorityQueue<>();
        pq.add(new Student("A", 4));
        pq.add(new Student("B", 5));
        pq.add(new Student("C", 2));
        pq.add(new Student("B", 1));
        
        while(!pq.isEmpty()){
            System.out.println(pq.peek().name + "->" + pq.peek().rank);
            pq.remove();
        }
    }
    
}
