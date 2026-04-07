import java.util.ArrayList;
import java.util.LinkedList;

public class t_Hashing02 {
    //1st
    static class HashMap<K,V> { //Here K,V are generic meaning key and value can be string,int,boolean,double or any type
        private class Node {
            K key;
            V value;

            public Node(K key, V value){ //Node ka constructor
                this.key = key;
                this.value = value;
            }
        }
        //2nd
        private int n; //n
        private int N; //N (buckets.length)
        private LinkedList<Node> bucket[]; 

        @SuppressWarnings("unchecked")
        public HashMap() { //HashMap ka constructor
            this.n = 0;
            this.N = 4;
            this.bucket = new LinkedList[4];
            for(int i=0; i<4; i++){
                this.bucket[i] = new LinkedList<>();
            }
        }
        //Hashfnx
        //3rd
        private int hashFnx(K key){
            int hc = key.hashCode();
            return Math.abs(hc) % N; //abs if -ve value convert it to +ve, % with N gives remainder less than its N and that is what we want
        }
        
        //5th
        private int searchInLL(K key, int bi){
            LinkedList<Node> ll = bucket[bi];
            int di = 0;
            for(int i=0; i<ll.size(); i++){
                Node node = ll.get(i);
                if(node.key.equals(key)){ //while adding pairs check if key exists if exists return it's idx, ie dataidx(di)
                    return di;
                }
                di++;
            }
            return -1; //if doesn't exists return -1
        }
        //rehash
        //7th
        @SuppressWarnings("unchecked")
        private void rehash(){
            LinkedList<Node> oldBucket[] = bucket; //stored all the values of bucket in old bucket
            bucket = new LinkedList[2*N]; //ab bucket ka size double krya
            N = 2*N; //update krya N ku 
            for(int i=0; i<bucket.length; i++){ //loop for traversing through my new bucket 
                bucket[i] = new LinkedList<>(); //and initialising it with empty ll
            }
            n = 0; //reset size
            for(int i=0; i<oldBucket.length; i++){ //this 2 loops for adding the nodes (pairs) in new bucket (stare it you will get)
                LinkedList<Node> ll = oldBucket[i];
                for(int j=0; j<ll.size(); j++){
                    Node node = ll.get(j);
                    put(node.key, node.value);
                }
            }

        }
        //put
        //4th
        public void put(K key, V value){ //O(lambda) -> O(1)
            int bi = hashFnx(key); //gives bucket idx from to that range for our case 0-3
            //6th
            int di = searchInLL(key, bi); //checks whether this is the first time we are adding the pais or they already exists
            if(di != -1){  //agar already wo key hai tho uski value update krna
                Node node = bucket[bi].get(di); //node var mai wo bucket (arr) ka idx se pair ki value nikalna meaning node ki value di(dataidx) se
                node.value = value; //then update the value
            }
            else{
                bucket[bi].add(new Node(key, value)); //naitho add the new pair in the bucket
                n++;
            }
            double lambda = (double)n/N;
            if(lambda > 2.0){
                rehash();
            }
        }
        
        //containsKey 
        //8th
        public boolean containsKey(K key){ //it's easy, same as putfnx, if pair is their return true else return false
            int bi = hashFnx(key);
            int di = searchInLL(key, bi);
            if(di != -1){
                return true;
            }
            else {
                return false;
            }
        }
        //get 
        //9th
        public V get(K key){ //(This fnx gives values)
            int bi = hashFnx(key); 
            int di = searchInLL(key, bi); 
            if(di != -1){ 
                Node node = bucket[bi].get(di); 
                return node.value;
            }
            else{
                return null;
            }
        }
        //remove
        //10th
        public V remove(K key){
            int bi = hashFnx(key); 
            int di = searchInLL(key, bi); 
            if(di != -1){ 
                Node node = bucket[bi].remove(di); 
                n--;
                return node.value;
            }
            else{
                return null;
            }
        }
        //print keys
        //11th
        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();
            for(int i=0; i<bucket.length; i++){
                LinkedList<Node> ll = bucket[i];
                for (Node node : ll) {
                    keys.add(node.key);
                }
            }
            return keys;
        }
        //print both keys and values
        //13th 
        public void printMap() {
            for(int i=0; i<bucket.length; i++){
                LinkedList<Node> ll = bucket[i];
                for (Node node : ll) {
                    System.out.println("key: " + node.key + ", value: " + node.value);
                }
            }
        }
        //isEmpty
        public boolean isEmpty(){
            return n == 0; //returns true if nodes bucket is empty
        }

    }
    public static void main(String args[]){
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("Syed", 23);
        hm.put("Maaz", 24);
        hm.put("Khan", 25);

        ArrayList<String> keys = hm.keySet(); //for keys only (this is imp, below one's not that imp)
        for (String key : keys) {
            System.out.println(key);
        }
        for (String key : hm.keySet()) { // we are passing key using keySet
            int value = hm.get(key); //get gives us value
            System.out.println("key: " + key + ", value: " + value);
        }
        System.out.println();
        hm.printMap(); // for printing both key and value
    }



}

