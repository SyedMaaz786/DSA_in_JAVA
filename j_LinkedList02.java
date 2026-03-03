public class j_LinkedList02 {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;

    //Detecting cycle in ll (Floyd's cycle detecting algo)
    public static boolean isCycle() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next; //+1
            fast = fast.next.next; //+2
            if (slow == fast) {
                return true; //cycle exists
            }
        }
        return false; //cycle doesn't exists
    }

    //removing cycle in ll
    public static void removeCycle() {
        //step1 - Detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                cycle = true;
                break;
            }
        }
        if (cycle == false) {
            return;
        }
        //step2 - Finding the meeting point
        slow = head; //init slow with head
        Node prev = null;  //init prev with null
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        //step3 - Remove cycle -> last.next=null
        prev.next = null;

    }
    public static void main(String args[]) {
        //here we nodes
        Node first = new Node(1); 
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);

        //here we have connected the nodes and created the ll
        head = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = second; //creates a cycle of (1 -> 2 -> 3 -> 4 -> 5 -> 2)

        System.out.println(isCycle());  //true cycle present 
        removeCycle();
        System.out.println(isCycle());  //false cycle removed
    }
}
