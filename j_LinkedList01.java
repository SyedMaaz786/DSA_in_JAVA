import java.util.LinkedList;

public class j_LinkedList01 {
    public static class Node {  //create a class first
        int data;  //data type
        Node next;  //reference var

        public Node(int data) { //constructor
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    //fnx for addFirst O(n)
    public void addFirst(int data) {
        //step1 - create new node
        Node newNode = new Node(data);
        size ++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        //step2 - newnode next = head
        newNode.next = head;
        //step3 - head = newnode
        head = newNode;
    }
    //fnx for addLast O(n)
    public void addLast(int data) {
        //step1 - create new node
        Node newNode = new Node(data);
        size ++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        //step2 - tail next = new node
        tail.next = newNode;
        //step3 - tail = newnode
        tail = newNode;
    }
    //fnx for printing LL O(n)
    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " pointing to ");
            temp = temp.next;
        }
        System.out.println("'null'");
    }
    //fnx for adding elements at specific idx
    public void add(int idx, int data) {
        if (idx == 0) {   //for idx = 0 it means head then call addFirst
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size ++;
        Node temp = head;
        int i = 0; //imp
        while (i < idx-1) {  //imp
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }
    //fnx for removingFirst element from LL
    public int removeFirst() {  
        //2nd
        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        //3rd
        else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;  //when head and tail is referencing to null then, we are size assigning back to zero so that size is tracked correctly
            return val;
        }
        //1st
        int val = head.data;  
        head = head.next;
        size --;
        return val;
    }
    //fnx for removingLast element from LL 
    public int removeLast() {
        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        //prev : i = size-2 (GPT if dought)
        Node prev = head;
        for (int i=0; i<size-2; i++) {  
            prev = prev.next;
        }
        int val = prev.next.data; //this gives me my tail data ie last element
        prev.next = null;
        size --;
        return val;
    }

    //iterative search
    public int itrSearch(int key) {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.data == key) {  //key Found case
                return i;  //returns the idx of the element
            }
            temp = temp.next;
            i++;
        }
        return -1;  //key not Found case
    }

    //recursive search
    public int recSearch(Node head, int key) {
        //base case
        if (head == null) {
            return -1;
        }
        if (head.data == key) {
            return 0;
        }
        //recursive call
        int idx = recSearch(head.next, key);
        if (idx == -1) {
            return -1;
        }
        return idx + 1;
    }

    public static void main(String args[]) {
        j_LinkedList01 ll = new j_LinkedList01();
        ll.print();
        ll.addFirst(2);
        ll.print();
        ll.addFirst(1);
        ll.print();
        ll.addLast(3);
        ll.print();
        ll.addLast(4);
        ll.print();
        ll.add(2, 9);
        ll.print();
        System.out.println("LL size is: " + ll.size);
        ll.removeFirst();
        ll.print();
        ll.removeLast();
        ll.print();
        System.out.println(ll.itrSearch(2));
        System.out.println(ll.itrSearch(10));
        System.out.println(ll.recSearch(head, 2));
        System.out.println(ll.recSearch(head, 10));
    }
}

