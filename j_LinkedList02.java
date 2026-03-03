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
        Node turtle = head;
        Node rabbit = head;
        while (rabbit != null && rabbit.next != null) {
            turtle = turtle.next; //+1
            rabbit = rabbit.next.next; //+2
            if (turtle == rabbit) {
                return true; //cycle exists
            }
        }
        return false; //cycle doesn't exists
    }
    public static void main(String args[]) {
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = head; // This is a cycle ll (1->2->3->1)
        System.out.println(isCycle());
    }
}
