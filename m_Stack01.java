import java.util.ArrayList;
import java.util.Stack;
public class m_Stack01 {
    // Stack implementation with Arraylist
    static class StackA{
        static ArrayList<Integer> list = new ArrayList<>();

        // 1 - Empty fnx
        public boolean isEmpty() {
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
            int top = list.get(list.size()-1); // gives the last in element ie top
            list.remove(list.size()-1);
            return top;
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
        public static Node head = null;

        // 1 - Empty fnx
        public boolean isEmpty() {
            return head == null;
        }
        // 2 - push fnx
        public void push(int data) {
            Node newNode = new Node(data);
            if (isEmpty() == true){  
                head = newNode;
                return;
            }
            newNode.next = head;  //when we add new node then we do this to place it at the starting
            head = newNode;
        }
        // 3 - pop fnx 
        public int pop() {
            if (isEmpty() == true){
                return -1;
            }
            int top = head.data;  // ex 3 -> 2 -> 1 (3 is the top and head so pop it meaning print it and then move to next to do the same)
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
        if(s.isEmpty() == true){
            s.push(data);
            return;
        }
        //recursion
        int top = s.pop();  //stores the top value by removing it from our s obj 
        pushAtBottom(s, data); //recursive call
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
        StringBuilder result = new StringBuilder("");
        while(s.isEmpty() != true){  //loop untill the stack we created above is empty
            char curr = s.pop();
            result.append(curr);
        }
        return result.toString();
    }


    //reverse the stack
    public static void reverseStack(Stack<Integer> s){
        //base case 
        if(s.isEmpty() == true){
            return;  //returns empty stack in which the reversing will be dont below
        }
        //recursion
        int top = s.pop();  
        reverseStack(s);     //recursive call
        pushAtBottom(s, top);  //backtrack, but here print the values from the bottom

        //for printing 
        while(s.isEmpty() != true){  //loop until stack is empty
            System.out.println(s.pop());
        }
    }
    public static void main(String args[]) {
        // StackA s = new StackA();
        // s.push(1);
        // s.push(2);
        // s.push(3); //last element to be pushed will be the 1st element which will be printed

        // while(s.isEmpty() != true){  //loop untill stack gets empty
        //     System.out.println(s.peek());
        //     s.pop();
        // }


        // StackB s = new StackB();
        // s.push(1);
        // s.push(2);
        // s.push(3); //last element to be pushed will be the 1st element which will be printed

        // while(s.isEmpty() != true){  //loop untill stack gets empty
        //     System.out.println(s.peek());
        //     s.pop();
        // }


        // // Stack implementation using JavaCollectionFramework
        // Stack<Integer> s = new Stack<>();
        // s.push(1);
        // s.push(2);
        // s.push(3); //last element to be pushed will be the 1st element which will be printed

        // while(s.isEmpty() != true){  //loop untill stack gets empty
        //     System.out.println(s.peek());
        //     s.pop();
        // }


        // Stack<Integer> s = new Stack<>();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // pushAtBottom(s, 4);
        // while(s.isEmpty() != true){
        //     System.out.println(s.peek());
        //     s.pop();
        // }


        // String str = "abc";
        // String result = reverseString(str);
        // System.out.println(result);


        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        // 3, 2, 1
        reverseStack(s);
        // 1, 2, 3
    }
}
