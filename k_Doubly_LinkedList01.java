import org.w3c.dom.Node;

public class k_Doubly_LinkedList01 {
    public class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    //addFirst in DLL
    public void addFirst(int data) {
        //step1 - create new node
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }

        //step2 - newNode.next = head
        newNode.next = head;

        //step3 - head.prev = newNode
        head.prev = newNode;

        //step4 - head = newNode
        head = newNode;
    }

    //addLast in DLL
    public void addLast(int data) {
        //step1 - create newNode
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        //step2 - tail next = newNode, newNode prev = tail
        tail.next = newNode;
        newNode.prev = tail;

        //step3 - tail = newNode
        tail = newNode;
    }

    //removeFirst in DLL
    public int removeFirst() {
        //2nd 
        if (head == null) {
            System.out.println("DLL is empty");
            return Integer.MIN_VALUE;
        }
        //3rd 
        if (size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        //1st
        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val;
    }

    //removeLast in DLL
    public int removeLast() {
        //2nd 
        if (head == null) {
            System.out.println("DLL is empty");
            return Integer.MIN_VALUE;
        }
        //3rd 
        if (size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        //1st 
        int val = tail.data;
        tail = tail.prev;
        tail.next = null;
        size--;
        return val; 
    }

    //reverse a DLL
    public void reverse() {
        //3 var, 4 steps
        Node prev = null;
        Node curr = head;  
        Node next;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;  //extra line for DLL
            prev = curr;
            curr = next;
        }
        head = prev;
    }
    //print
    public void print() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String args[]) {
        k_Doubly_LinkedList01 dll = new k_Doubly_LinkedList01();
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.print();
        System.out.println(dll.size);
        dll.addLast(4);
        dll.print();
        dll.removeFirst();
        dll.print();
        dll.removeLast();
        dll.print();
        dll.reverse();
        dll.print();
    }
}

