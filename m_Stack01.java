import java.util.ArrayList;
import java.util.Stack;

import org.w3c.dom.Node;
public class m_Stack01 {
    // Stack implementation with Arraylist
    static class StackA{
        static ArrayList<Integer> list = new ArrayList<>();

        // 1 - Empty fnx
        public boolean isEmpty() {  //You can make the fnx static but it will give warning
            return list.size() == 0;
        }

        // 2 - push fnx
        public void push(int data) {
            list.add(data);
        }
        // 3 - pop fnx
        public int pop() {
            if (isEmpty() == true){
                return -1;
            }
            return list.remove(list.size()-1); //removes top ele
        }
        //4 - peek fnx  (this is nothing but top)
        public int peek() {
            if (isEmpty() == true){
                return -1;
            }
            return list.get(list.size()-1); //returns top
        }
    }

    // Stack implementation with LinkedList
    static class StackB {
        static class Node {
            int data;
            Node next;

            public Node(int data) {
                this.data = data;
                this.next = null;
            }
        }
        public static Node head; //stack implementation happens only using head so no tail needed
        public static int size;

        // 1 - Empty fnx
        public boolean isEmpty() {
            return head == null;
        }
        // 2 - push fnx (easy check new notes)
        public void push(int data) {
            //1st
            Node newNode = new Node(data);
            //3rd
            if (isEmpty() == true){  //for adding 1st ele in stack
                head = newNode;
                return;
            }
            //2nd
            newNode.next = head;  //when we add new node then we do this for linking 
            head = newNode;
        }
        // 3 - pop fnx 
        public int pop() {
            if (isEmpty() == true){
                return -1;
            }
            int top = head.data;  // ex 3 -> 2 -> 1 (3 is the top and head.data will give 1st ele and then head.next goes to other ele, return that as pop operation)
            head = head.next;
            return top;
        }
        // 4 - peek fnx
        public int peek() {
            if (isEmpty() == true){
                return -1;
            }
            return head.data;
        }
    }

    // PushAtBottom
    public static void pushAtBottom (Stack<Integer> s, int data){
        //base case
        //2nd
        if(s.isEmpty() == true){
            s.push(data);
            return;
        }
        //recursion
        //1st
        int top = s.pop();  //stores the top value by removing it from our s obj 
        pushAtBottom(s, data); //recursive call
        //3rd
        s.push(top); //backtrack, prints top values back in the stack
    }


    //reverseString using stack 
    public static String reverseString(String str){
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while(idx < str.length()){
            s.push(str.charAt(idx));
            idx++;
        }
        StringBuilder sb = new StringBuilder(); //sb because the fnx expects string as the return type
        while(!s.isEmpty()){  //loop untill the stack we created above is empty
            sb.append(s.pop());
        }
        return sb.toString();
    }


    //reverse the stack (many ways are their to solve this ques, but calling pushAtBottom is optimised one)
    public static void reverseStack(Stack<Integer> s){
        //base case 
        if(s.isEmpty() == true){
            return;  //returns empty stack in which the reversing will be dont below
        }
        //recursion
        int top = s.pop();  
        reverseStack(s);     //recursive call
        pushAtBottom(s, top);  //backtrack, (here we have used pushAtBottom as a helper fnx) but here print the values from the bottom
    }
    public static void main(String args[]) {
        // StackA s = new StackA();
        // s.push(1);
        // s.push(2);
        // s.push(3); //last element to be pushed will be the 1st element which will be printed

        // while(!s.isEmpty()){  //loop untill stack gets empty
        //     System.out.println(s.peek());
        //     s.pop();
        // }


        // StackB s = new StackB();
        // s.push(1);
        // s.push(2);
        // s.push(3); //last element to be pushed will be the 1st element which will be printed

        // while(!s.isEmpty()){  //loop untill stack gets empty
        //     System.out.println(s.peek());
        //     s.pop();
        // }


        // // Stack implementation using JavaCollectionFramework
        // Stack<Integer> s = new Stack<>();
        // s.push(1);
        // s.push(2);
        // s.push(3); //last element to be pushed will be the 1st element which will be printed

        // while(!s.isEmpty()){  //loop untill stack gets empty
        //     System.out.println(s.peek());
        //     s.pop();
        // }


        // Stack<Integer> s = new Stack<>();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // pushAtBottom(s, 4);
        // while(!s.isEmpty()){
        //     System.out.println(s.peek());
        //     s.pop();
        // }


        // String str = "syed maaz";
        // System.out.println(reverseString(str));


        // Stack<Integer> s = new Stack<>();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // reverseStack(s);
        // while(!s.isEmpty()){
        //     System.out.println(s.peek());
        //     s.pop();
        // }

        // Next Greater Right O(n) - (imp)
        int arr[] = {6, 8, 0, 1, 3};
        Stack<Integer> s = new Stack<>();
        int nextGreater[] = new int[arr.length];

        for(int i=arr.length-1; i>=0; i--){
            // 1 - while 
            //2nd
            while(!s.isEmpty() && arr[s.peek()] <= arr[i]){
                s.pop();
            }

            // 2 - if else
            //1st
            if(s.isEmpty()) {
                nextGreater[i] = -1;
            }
            else {
                nextGreater[i] = arr[s.peek()];
            }

            // 3 - push to stack
            s.push(i);
        }
        for(int i=0; i<nextGreater.length; i++){
            System.out.print(nextGreater[i] + " ");
        }
        System.out.println();
        // for next greater left, next smaller right, next smaller left check notes for the conditions to be changed
    }
}
