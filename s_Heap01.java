import java.util.ArrayList;
import java.util.PriorityQueue;

public class s_Heap01 {
    //add in heap (this is min heap, for max heap just change the > in add while loop and in heapify if change it to <)
    static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data){ //O(logn)
            arr.add(data);
            int x = arr.size()-1; // x is child idx
            int y = (x-1)/2; // y is parent idx (formula)
            while(arr.get(x) < arr.get(y)){ //agar mere child(x) ki value parent(y) se kam hatiye usse swap krna kivo katho min uppar aana
                //swap
                int temp = arr.get(x);
                arr.set(x, arr.get(y));
                arr.set(y, temp);

                x = y; //updating child and parent after swapping
                y = (x-1)/2;
            }
        }
        //peek in heap
        public int peek(){
            return arr.get(0); //returns the root value which is min 
        }
        //remove in heap (this is a little difficult lecture for dryrun and understanding)
        private void heapify(int i){
            int left = 2*i+1;
            int right = 2*i+2;
            int minIdx = i;
            if(left < arr.size() && arr.get(minIdx) > arr.get(left)){ //these 2 if are if the idx goes out of bound
                minIdx = left;
            }
            if(right < arr.size() && arr.get(minIdx) > arr.get(right)){
                minIdx = right;
            }
            if(minIdx != i){ //if the root value after removing is greater meaning if it violated the min heap property where the root should be min then swap
                //swap
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                heapify(minIdx); // recursive call for next nodes
            }
        }
        public int remove(){
            int data = arr.get(0);
            //step1 - swap first & last
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);
            //step2 - delete last
            arr.remove(arr.size()-1);
            //step3 - heapify
            heapify(0);

            return data;
        }
        //isEmpty
        public boolean isEmpty(){
            return arr.size() == 0; //if arr.size() == 0 return true else false
        }
    }
    //Heap sort - Ascending order, O(nlogn) ( notes and lecture for understanding and dryrun)
    public static void heapify(int arr[], int i, int n){
        int left = 2*i+1;
        int right = 2*i+2;
        int maxIdx = i;
        if(left < n && arr[maxIdx] < arr[left]){
            maxIdx = left;
        }
        if(right < n && arr[maxIdx] < arr[right]){
            maxIdx = right;
        }
        if(maxIdx != i){
            //swap
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;

            heapify(arr, maxIdx, n);
        }
    }
    public static void heapSort(int arr[]){
        //step1 - build maxHeap
        int n = arr.length;
        for(int i=n/2; i>=0; i--){
            heapify(arr, i, n);
        }
        //step2 - push largest at end
        for(int i=n-1; i>=0; i--){
            //swap
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, 0, i);
        }
    }
    //K Nearest Neighbors
    //1st
    static class Point implements Comparable<Point>{
        int x;
        int y;
        int distSq;
        int idx;
        
        public Point(int x, int y, int distSq, int idx){
            this.x = x;
            this.y = y;
            this.distSq = distSq;
            this.idx = idx;
        }
        @Override
        public int compareTo(Point p2){
            return this.distSq - p2.distSq;
        }
    }
    public static void main(String args[]){
        // Heap h = new Heap();
        // h.add(3);
        // h.add(4);
        // h.add(1);
        // h.add(5);
        // while(!h.isEmpty()){
        //     System.out.println(h.peek());
        //     h.remove();
        // }


        // int arr[] = {5, 4, 3, 2, 1};
        // heapSort(arr);
        // //print
        // for(int i=0; i<arr.length; i++){
        //     System.out.print(arr[i] + " ");
        // }
        // System.out.println();


        // int pts[][] = {{3, 3}, {5, -1}, {-2, 4}};
        // int k = 2; 
        // //2nd
        // PriorityQueue<Point> pq = new PriorityQueue<>();
        // for(int i=0; i<pts.length; i++){
        //     //4th
        //     int distSq = pts[i][0]*pts[i][0] + pts[i][1]*pts[i][1]; //distSq = x^2 + y^2
        //     //3rd
        //     pq.add(new Point(pts[i][0], pts[i][1], distSq, i)); //pts[i][0] = x-axis and pts[i][1] = y-axis
        // }
        // //5th
        // for(int i=0; i<k; i++){
        //     System.out.println("Neighbour: " + pq.remove().idx);
        // }


        //Connect N ropes with minimum cost (it's very easy)
        int ropes[] = {2, 3, 3, 4, 6};
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<ropes.length; i++){
            pq.add(ropes[i]); //add ropes in pq
        }
        int cost = 0;
        while(pq.size() > 1){ //until my pq contains one last ele
            int min = pq.remove(); //this min and min2 gives 2 smallest ropes 
            int min2 = pq.remove();
            cost += min + min2; //add with cost initialised with zero above 
            pq.add(min+min2);  //add combined min+min2 again in the pq 
        }
        System.out.println("Cost of connecting n ropes: " + cost);
    }
}
