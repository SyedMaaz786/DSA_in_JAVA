import java.util.LinkedList;

public class j_Singly_LinkedList01 {
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
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("'null'");
    }
    //fnx for adding elements at specific idx (check new notes)
    public void add(int idx, int data) {
        if (idx == 0) {   //for idx = 0 it means head then call addFirst
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size ++;

        Node temp = head;  //Here temp stores the head value
        int i = 0;
        while(i < idx-1){ //idx-1 means prev
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }
    //fnx for removingFirst element from LL (check new notes)
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
            size = 0;  //when head and tail is referencing to null then, we are assigning size back to zero so that size is tracked correctly
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
        //1st
        Node temp = head; 
        for (int i=0; i<size-2; i++) { //size-2 gives last node to be deleted
            temp = temp.next;
        }
        int val = temp.next.data; //this gives me my tail data ie last element
        temp.next = null;
        tail = temp;
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

    //reverse a linked list O(n)
    public void reverse() {
        //initialising 3 var ie prev, curr, next
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while (curr != null) {  //byheart this steps
            //step1
            next = curr.next;
            //step2
            curr.next = prev;  //reverse main step
            //step3
            prev = curr;
            //step4
            curr = next;
        }
        head = prev;
    }

    //delete nth node from the end
    public void deleteNthNode(int n) {
        //calculate size of the LL
        int sz = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            sz++;
        }
        //corner case
        if (n == sz) {
            head = head.next; //removeFirst
            return;
        }
        //sz-n -> Main formula to find the nth node which is to be deleted
        int i = 1;
        int iToFind = sz-n;
        Node prev = head;
        while (i < iToFind) {  //traversing from starting to the nth node 
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;  //then assigning the next value to the next of next so that the middle next value ie nth node will be moven to the garbage collector by Java
        return;
    }

    //palindrome 
    //Slow-Fast(turtle-rabbit) Approach
    public Node findMid(Node head) {
        Node turtle = head;
        Node rabbit = head;
        while (rabbit != null && rabbit.next != null) {
            turtle = turtle.next; //+1
            rabbit = rabbit.next.next; //+2
        }
        return turtle; //turtle is the midNode
    }
    public boolean checkPalindrome() {
        if (head == null || head.next == null) {
            return true;
        }
        //step1 - find mid
        Node midNode = findMid(head);  

        //step2 - reverse 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev; //right is the head now for righthalf 
        Node left = head;  //left is the head now for lefthalf

        //step3 - check if lefthalf == right half
        while(right != null) {
            if(left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }


    //Merge Sort on ll O(logn)

    //2nd
    private Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next; //when a even sized ll divides we need the last element of the leftside as mid
        while (fast != null && fast.next != null) {
            slow = slow.next;  //+1
            fast = fast.next.next; //+2
        }
        return slow; //mid node
    }

    //3rd
    private Node merge(Node leftHead, Node rightHead) {
        Node mergedLL = new Node(-1); //create a ll with dummy value
        Node temp = mergedLL;  //temp stores the values now
        while (leftHead!= null && rightHead != null) {
            if (leftHead.data <= rightHead.data) {  //if it is true then the temp will store the values in ascending order followed by -1
                temp.next = leftHead;  //stare it, it is easy
                leftHead = leftHead.next; 
                temp = temp.next;
            }
            else {
                temp.next = rightHead;
                rightHead = rightHead.next;
                temp = temp.next;
            }
        }
        //for the leftover ele on leftside same as merge sort in divide and conquer
        while (leftHead != null) {
            temp.next = leftHead;
            leftHead = leftHead.next;
            temp = temp.next;
        }
        //for the leftover ele on rightside
        while (rightHead != null) {
            temp.next = rightHead;
            rightHead = rightHead.next;
            temp = temp.next;
        }
        return mergedLL.next;  //to remove the dummy value -1 we created above
    }

    //1st
    public Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        //step1 - Find mid
        Node mid = getMid(head);
        //step2 - lefthead, righthead
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);  //recursive call
        Node newRight = mergeSort(rightHead);  //recursive call
        //step3 - Merge
        return merge(newLeft, newRight);
    }


    //ZigZag merge
    public void zigZag() {
        //step1 - Find mid
        Node slow = head;
        Node fast = head.next; //to get last ele from 1st half ie leftside
        while(fast != null && fast.next != null) {
            slow = slow.next; //+1
            fast = fast.next.next; //+2
        }
        Node mid = slow; //before we were returning mid, because it used to be a diff fnx here we are just assigning mid as slow directly
        //step2 - reverse 2nd half (3 var, 4 steps)
        Node curr = mid.next;  //for 2nd half
        mid.next = null;  //both left and right have null now, they are divided now
        Node prev = null;
        Node next;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr; 
            curr = next;
        }
        //step3 - zigzag merge
        Node lh = head; //lh -> lefthead
        Node rh = prev; //rh -> righthead
        Node tempL, tempR;
        while(lh != null && rh != null) {
            //zigzag
            tempL = lh.next;
            lh.next = rh;
            tempR = rh.next;
            rh.next = tempL;
            //update
            lh = tempL;
            rh = tempR;
        }
    }
    public static void main(String args[]) {
        j_Singly_LinkedList01 ll = new j_Singly_LinkedList01();
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
        ll.reverse();
        ll.print();
        ll.deleteNthNode(2); //idx value to be passed
        ll.print();
        System.out.println(ll.checkPalindrome());
        //merge sort 
        ll.addLast(1);
        ll.addFirst(4);
        ll.addFirst(5);
        ll.addFirst(6);
        ll.print();
        ll.head = ll.mergeSort(ll.head);
        ll.print();
        ll.zigZag();
        ll.print();
    }
}

