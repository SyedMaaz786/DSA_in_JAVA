public class l_Circular_LinkedList01 {
    public class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    //add first circular singly ll  (The last node’s next pointer must always point back to the head node. tail.next → head)
    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;

        if(head == null) {
            head = tail = newNode;
            tail.next = head;  //line for circular ll
            return;
        }

        newNode.next = head;

        head = newNode;

        tail.next = head;  //line for circular ll
    }

    //add last circular singly ll  (The last node’s next pointer must always point back to the head node.)
    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        
        if(head == null) {
            head = tail = newNode;
            tail.next = head;  //line for circular ll
            return;
        }

        tail.next = newNode;

        tail = newNode;
        
        tail.next = head;  //line for circular ll

    }

    //add at specific idx circular singly ll
    public void addSpecific(int idx, int data){
        if(idx < 0 || idx > size){
            System.out.println("Invalid index");
            return;
        }
        if (idx == 0){
            addFirst(data);
            return;
        }
        if (idx == size){
            addLast(data);
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;
        for (int i=1; i<idx; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;

        size++;
    }

    // add at specific idx circular singlt ll (if no addfirst and addlast fnx to call)
    public void addSpec(int idx, int data){
        if(idx < 0 || idx > size){
            System.out.println("Invalid index");
            return;
        }
        Node newNode = new Node(data);

        // case 1: empty list
        if(size == 0){
        head = tail = newNode;
        tail.next = head;
        size++;
        return;
        }

        // case 2: insert at beginning
        if(idx == 0){
        newNode.next = head;
        head = newNode;
        tail.next = head;
        size++;
        return;
        }

        Node temp = head;

        for(int i = 1; i < idx; i++){
        temp = temp.next;
        }

        // case 3 & 4: middle or end
        newNode.next = temp.next;
        temp.next = newNode;

        if(idx == size){
        tail = newNode;
        }

        tail.next = head;
        size++;
    }



    //remove first circular singly ll 
    public int removeFirst(){
        if(size == 0){
            System.out.println("List is empty");
            return Integer.MIN_VALUE;
        }
        else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        tail.next = head;  //line for circular ll
        size--;
        return val;
    }

    //remove last circular singly ll
    public int removeLast(){
        if(size == 0){
            System.out.println("List is empty");
            return Integer.MIN_VALUE;
        }
        else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        Node prev = head;
        for (int i=0; i<size-2; i++) {
            prev = prev.next;
        }
        int val = prev.next.data; 
        tail = prev;
        tail.next = head;  //line for circular ll
        size--;
        return val;
    }

    //remove specific circular singly ll
    public int removeSpecific(int idx) {
        if(idx < 0 || idx >= size){
            System.out.println("Invalid index");
            return Integer.MIN_VALUE;
        }
        if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        Node prev = tail;
        for(int i=0; i<idx; i++){
            prev = prev.next;
        }
        int val = prev.next.data;
        if(prev.next == head){ //this is for removing 1st idx ele (ie 0th idx)
            head = head.next;
        }
        if(prev.next == tail){ //this is for removing last idx ele (ie nth idx)
            tail = prev;       //and this is why we gave prev tail value above instead of head ask GPT if dought
        }
        prev.next = prev.next.next;
        size--;
        return val;
    }

    //print 
    public void print() {
        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        while (temp != head);
            System.out.println();
    }
    public static void main(String args[]) {
        l_Circular_LinkedList01 cll = new l_Circular_LinkedList01();
        cll.addFirst(3);
        cll.addFirst(2);
        cll.addFirst(1);
        cll.print();
        cll.addLast(4);
        cll.addLast(5);
        cll.addLast(6);
        cll.print();
        cll.removeFirst();
        cll.print();
        cll.removeLast();
        cll.print();
        cll.addSpecific(2, 30);
        cll.print();
        cll.addSpec(0, 10);
        cll.print();
        cll.removeSpecific(2);
        cll.print();
    }
}
