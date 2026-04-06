import java.util.ArrayList;

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
    public static void main(String args[]){
        Heap h = new Heap();
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);
        while(!h.isEmpty()){
            System.out.println(h.peek());
            h.remove();
        }
    }
}
