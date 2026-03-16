public class n_Queue01 {

    //Queue using Array
    static class QueueA {
        static int arr[];
        static int size;
        static int rear;

        QueueA(int n){  //constructor 
            arr = new int[n]; 
            size = n;
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
            rear = rear + 1; //traversing each idx
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
            return (rear + 1) % size == front;
        }

        //add fnx O(1)
        public void add(int data){
            //2nd
            if(isFull()){
                System.out.println("Queue is full");
                return;
            }
            //3rd
            //add 1st element
            if(front == -1){  //special case
                front = 0;
            }
            //1st
            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        //remove fnx O(1)
        public int remove() {
            //3rd
            if(isEmpty()){
                System.out.println("Queue is full");
                return -1;
            }
            //1st
            int result = arr[front];
            //4th
            //removing last element
            if(rear == front){ //special case
                rear = front = -1;
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
    public static void main(String args[]){
        // QueueA q = new QueueA(5);
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // while(!q.isEmpty()){
        //     System.out.println(q.peek());
        //     q.remove();
        // }


        QueueB q = new QueueB(5);
        q.add(1);
        q.add(2);
        q.add(3);
        // 1 2 3 
        System.out.println(q.remove());
        //1 
        q.add(4);
        System.out.println(q.remove());
        //2
        q.add(5);
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
