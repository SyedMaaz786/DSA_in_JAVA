import java.util.*;

import org.w3c.dom.Node;
public class n_Queue01 {

    //Queue using Array
    static class QueueA {
        int arr[];
        int size;
        int rear;

        QueueA(int n){  //constructor 
            arr = new int[n]; //n is the size of the arr we will declare in main fnx
            size = n; //so the size will be n simple
            rear = -1;  //starting rear with invalid idx ie before 0
        }

        public boolean isEmpty() { //You can make the fnx static but it will give warning
            return rear == -1;
        }

        //add fnx O(1)
        public void add(int data){
            if(rear == size-1){  //reached last
                System.out.println("Queue is full");
                return;
            }
            rear = rear + 1; //traversing each idx (at first iteration as rear was init -1 it will go on 0th idx now)
            arr[rear] = data;  //adding value at each idx
        }

        //remove fnx O(n)
        public int remove(){  
            //4th
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            //1st
            int front = arr[0]; //idx 0 is front 
            //3rd
            for(int i=0; i<rear; i++){ //for loop, Check GPT it is easy
                arr[i] = arr[i+1];
            }
            rear = rear - 1;
            //2nd
            return front;
        }

        //peek fnx
        public int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[0]; //peek is front 
        }
    }


    // Circular Queue using array 
    static class QueueB {
        int arr[];
        int size;
        int rear;
        int front;

        QueueB(int n){
            arr = new int[n];
            size = n;
            rear = -1; 
            front = -1;
        }
        public boolean isEmpty() {
            return rear == -1 && front == -1;
        }
        public boolean isFull() {
            return (rear + 1) % size == front; //remember it like this as soon as we do rear+1 samnech front hayatho is full
        }

        //add fnx O(1) - remember when the queue is 1234 and you want to add 5 at the 0th idx ie front you need to first remove one ele
        public void add(int data){
            //1st
            if(isFull()){
                System.out.println("Queue is full");
                return;
            }
            //2nd
            //add 1st element
            if(front == -1){  //special case
                front = 0; //if front is -1 the move front to 0th idx and add ele their
            }
            //3rd
            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        //remove fnx O(1)
        public int remove() {
            //3rd
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            //1st
            int result = arr[front];
            //4th
            //removing last element
            if(rear == front){ //special case (check new notes)
                rear = front = -1; //only 1 ele en queue after removing it set front and rear back to -1 ie how empty queue is represented at the starting
            }
            else {
                front = (front + 1) % size; 
            }
            //2nd
            return result;
        }

        //peek fnx O(1)
        public int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[front];
        }

    }


    //Queue using LinkedList
    static class QueueC{
        public class Node {
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public Node head = null;
    public Node tail = null; 

        public boolean isEmpty() {
            return head == null && tail == null;
        }

        //add fnx O(n)
        public void add(int data){
            //1st
            Node newNode = new Node(data);
            //3rd
            if(head == null){  //add 1st ele
                head = tail = newNode;
                return;
            }
            //2st
            tail.next = newNode;
            tail = newNode;
        }

        //remove fnx O(n)
        public int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            //1st
            int front = head.data;
            //3rd
            if(tail == head){ //single element
                tail = head = null;
            }
            else {
                head = head.next;
            }
            //2nd
            return front;
        }

        //peek fnx O(n)
        public int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            return head.data;
        }
    }

    
    //Queue using two stacks (lecture if dought)
    static class QueueD{
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public boolean isEmpty(){
            return s1.isEmpty();
        }
        //add fnx O(n) (you just need a view of lecture it's very easy)
        public void add(int data){
            while(!s1.isEmpty()){  //until s1 gets empty
                s2.push(s1.pop());  //s2 mai dalna s1 se nikalko
            }
            s1.push(data);  //elements assigned in s2 will be assigned back to s1 
            while(!s2.isEmpty()){
                s1.push(s2.pop());  //vice versa uppar ka
            }
        }
        //remove fnx O(1)
        public int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            return s1.pop();  //becoz our whole add fnx is designed in such a way that top of the s1 contains front
        }
        //peek fnx O(1)
        public int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            return s1.peek();
        }
    }


    //stack using 2 queue's (need to check lecture + focus, especially for pop)
    static class QueueE {
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        public boolean isEmpty(){
            return q1.isEmpty() && q2.isEmpty();
        }
        //push fnx O(1)
        public void push(int data){
            if(!q1.isEmpty()){  //jo bhi queue non empty hai(jisme already values hee) usme data add krna
                q1.add(data);
            }
            else{
                q2.add(data);
            }
        }
        //pop fnx O(n)
        public int pop(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            int top = -1;
            //case 1
            if(!q1.isEmpty()){ //q1 mai ele haitho
                while(!q1.isEmpty()){ //jaltak q1 empty ni hojata 
                    top = q1.remove(); //q1 se ele nikalte jao
                    if(q1.isEmpty()){ 
                        break;
                    }
                    else{
                        q2.add(top); //q2 mai dalo
                    }
                }
            }
            //case 2 (vise versa of case 1)
            else{
                while(!q2.isEmpty()){
                    top = q2.remove();
                    if(q2.isEmpty()){
                        break;
                    }
                    else{
                        q1.add(top);
                    }
                }
            }
            return top;
        }
        //peek fnx (copy pop code and remove only if condition) O(n)
        public int peek(){
             if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            int top = -1;
            //case 1
            if(!q1.isEmpty()){
                while(!q1.isEmpty()){
                    top = q1.remove();
                    q2.add(top);
                }
            }
            //case 2
            else{
                while(!q2.isEmpty()){
                    top = q2.remove();
                    q1.add(top);
                }
            }
            return top;
        }
    }


    //First Non Repeating character O(n) (lecture it is easy)
    public static void printNonRepeating(String str){
        int freq[] = new int[26];
        Queue<Character> q = new LinkedList<>();

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch-'a']++;  //converts char to int and gives their freq and idx

            while(!q.isEmpty() && freq[q.peek()-'a'] > 1){
                q.remove();
            }
            if(q.isEmpty()){
                System.out.print(-1 + " ");
            }
            else{
                System.out.print(q.peek() + " ");
            }
        }
        System.out.println();
    }


    //Interleave 2 halves of a queue O(n) (girls ki choti) GPT will explain very easy
    public static void interLeave(Queue<Integer> q){
        Queue<Integer> firstHalf = new LinkedList<>();
        int size = q.size();

        for(int i=0; i<size/2; i++){
            firstHalf.add(q.remove());  //after the loop we will get firstHalf=1234 and q=5678
        }
        while(!firstHalf.isEmpty()){ //These 3 lines are the main logic dry run for 1234 you will get it
            q.add(firstHalf.remove()); //firstHalf se remove krko q mai dal 
            q.add(q.remove()); //phir q se remove krko phir q maich daal, ie where we get this interleave fashion, note remove will remove front and add will add at rear
        }
    }


    //Queue reverse
    public static void reverse(Queue<Integer> q){
        Stack<Integer> s = new Stack<>();
        while(!q.isEmpty()){
            s.push(q.remove());  //q se nikalko s mai dalo
        }
        while(!s.isEmpty()){
            q.add(s.pop()); //s se nikalko q mai dalo ,hoga reverse
        }
    }


    //implementing stack using deque
    static class StackB {
        Deque<Integer> dq = new LinkedList<>();

        public int push(int data){
            dq.addLast(data);
            return data;
        }
        public int pop(){
            return dq.removeLast();
        }
        public int peek(){
            return dq.getLast();
        }
    }


    //implementing queue using deque
    static class QueueF {
        Deque<Integer> dq = new LinkedList<>();

        public int add(int data){
            dq.addLast(data);
            return data;
        } 
        public int remove(){
            return dq.removeFirst();
        }
        public int peek(){
            return dq.getFirst();
        }
    }


    public static void main(String args[]){
        // QueueA q = new QueueA(5);
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // while(!q.isEmpty()){
        //     System.out.println(q.peek());
        //     q.remove();
        // }


        // QueueB q = new QueueB(5);
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // // 1 2 3 
        // System.out.println(q.remove());
        // //1 
        // q.add(4);
        // System.out.println(q.remove());
        // //2
        // q.add(5);
        // while(!q.isEmpty()){
        //     System.out.println(q.peek());
        //     q.remove();
        // }



        // QueueC q = new QueueC();
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // while(!q.isEmpty()){
        //     System.out.println(q.peek());
        //     q.remove();
        // }


        // //Queue using JCF(Java collection framework)
        // Queue<Integer> q = new LinkedList<>();  //LinkedList because queue is a interface and we cannot create direct object using queue
        // // Queue<Integer> q = new ArrayDeque<>();  //ArrayDeque can also be used 
        // q.add(1);  
        // q.add(2);
        // q.add(3);
        // q.add(4);
        // while(!q.isEmpty()){
        //     System.out.println(q.peek());
        //     q.remove();
        // }


        // QueueD q = new QueueD();
        // q.add(3);
        // q.add(2);
        // q.add(1);

        // while(!q.isEmpty()){
        //     System.out.println(q.peek());
        //     q.remove();
        // }


        // Stack<Integer> s = new Stack<>();
        // s.push(2);
        // s.push(4);
        // s.push(6);
        // while(!s.isEmpty()){
        //     System.out.println(s.peek());
        //     s.pop();
        // }


        // String str = "aabccxb";
        // printNonRepeating(str);


        // Queue<Integer> q = new LinkedList<>();
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // q.add(4);
        // q.add(5);
        // q.add(6);
        // q.add(7);
        // q.add(8);
        // interLeave(q);
        // while(!q.isEmpty()){
        //     System.out.print(q.remove() + " ");
        // }
        // System.out.println();


        // Queue<Integer> q = new LinkedList<>();
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // q.add(4);
        // q.add(5);
        // reverse(q);
        // while(!q.isEmpty()){
        //     System.out.print(q.remove() + " ");
        // }
        // System.out.println();


        // //Deque
        // Deque<Integer> dq = new LinkedList<>();
        // dq.addFirst(3); // 2
        // dq.addFirst(2); // 1 2
        // dq.addFirst(1); // 1 2 3 
        // dq.addLast(4); // 1 2 3 4
        // dq.addLast(5); // 1 2 3 4 5
        // dq.addLast(6); // 1 2 3 4 5 6
        // System.out.println(dq);
        // dq.removeFirst(); // 2 3 4 5 6
        // dq.removeLast(); //2 3 4 5
        // System.out.println(dq);
        // System.out.println(dq.getFirst());
        // System.out.println(dq.getLast());


        // StackB s = new StackB();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // System.out.println("Peek = " + s.peek());
        // System.out.println(s.pop());
        // System.out.println(s.pop());
        // System.out.println(s.pop());


        QueueF q = new QueueF();
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.peek());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
        

    }
}
