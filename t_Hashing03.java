import java.util.*;

public class t_Hashing03 {
    //Find itinerary for tickets
    public static String startingPoint(HashMap<String, String> hm){ //O(n) lecture if dought stare it it's easy
        HashMap<String, String> revhm = new HashMap<>(); //created a reversehashmap (revhm) 
        for(String key: hm.keySet()){ 
            revhm.put(hm.get(key), key); //here we puts value as key and key as value (from->to) & (to->from)
        }
        for(String key: hm.keySet()){
            if(!revhm.containsKey(key)){
                return key; //gives starting point
            }
        }
        return null; 
    }
    public static void main(String args[]){
        // //HashSet (Unordered)
        // HashSet<String> hs = new HashSet<>();
        // hs.add("Bengaluru");
        // hs.add("Mumbai");
        // hs.add("Chennai");
        // hs.add("Bengaluru");
        // System.out.println(hs);

        // //Iterate in set using Iterator
        // Iterator i = hs.iterator();
        // while(i.hasNext()){
        //     System.out.println(i.next());
        // }

        // //Iterate using Advance loop
        // for(String s : hs){
        //     System.out.println(s);
        // }

        // //LinkedHashSet (Ordered)
        // LinkedHashSet<String> lhs = new LinkedHashSet<>();
        // lhs.add("Kolkata");
        // lhs.add("Lucknow");
        // lhs.add("Noida");
        // System.out.println(lhs);

        // //TreeSet (Sorted in ascending order)
        // TreeSet<Integer> ts = new TreeSet<>();
        // ts.add(500);
        // ts.add(200);
        // ts.add(50);
        // System.out.println(ts);


        // //Count Distinct Elements
        // int num[] = {4, 3, 2, 5, 6, 7, 3, 4, 2, 1};
        // HashSet<Integer> hs = new HashSet<>();
        // for(int i=0; i<num.length; i++){
        //     hs.add(num[i]);
        // }
        // System.out.println("Answer: " + hs.size());


        // //Union and Intersection (it's very easy)
        // int arr1[] = {7, 3, 9};
        // int arr2[] = {6, 3, 9, 2, 9, 4};
        // HashSet<Integer> hs = new HashSet<>();
        // //Union
        // for(int i=0; i<arr1.length; i++){
        //     hs.add(arr1[i]);
        // }
        // for(int i=0; i<arr2.length; i++){
        //     hs.add(arr2[i]);
        // }
        // System.out.println("Union size: " + hs.size());
        // System.out.println("Union elements: " + hs);
        // //Intersection
        // hs.clear(); //clearing it so that we can start intersection again on the same hs
        // for(int i=0; i<arr1.length; i++){
        //     hs.add(arr1[i]);
        // }
        // int count = 0;
        // for(int i=0; i<arr2.length; i++){
        //     if(hs.contains(arr2[i])){
        //         count++;
        //         System.out.println("Intersection element: " + arr2[i]);
        //         hs.remove(arr2[i]);
        //     }
        // }
        // System.out.println("Intersection size: " + count);


        // HashMap<String, String> hm = new HashMap<>();
        // hm.put("Chennai", "Bengaluru");
        // hm.put("Mumbai", "Delhi");
        // hm.put("Goa", "Chennai");
        // hm.put("Delhi", "Goa");
        // String start = startingPoint(hm);
        // System.out.print(start);
        // for(String key: hm.keySet()){ //stare it you will get
        //     System.out.print(" -> " + hm.get(start)); //hm.get(start) gives value of hm
        //     start = hm.get(start); //and that value now becomes start
        // }
        // System.out.println();


        //Largest Subarray with Sum 0 O(n) - (lecture video must watch for dryrun and understanding)
        int arr[] = {15, -2, 2, -8, 1, 7, 10, 23};
        HashMap<Integer, Integer> hm = new HashMap<>(); //store sum, idx 
        int sum = 0;
        int len = 0;
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
            if(hm.containsKey(sum)){
                len = Math.max(len, i-hm.get(sum)); //hm.get(sum) dry run and see it will give the value from hm ie the idx value 
            }
            else{
                hm.put(sum, i);
            }
        }
        System.out.println("Largest Subarray with Sum 0: " + len);

    }
}
