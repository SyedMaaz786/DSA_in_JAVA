import java.util.*;

public class t_Hashing03 {
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


        //Union and Intersection (it's very easy)
        int arr1[] = {7, 3, 9};
        int arr2[] = {6, 3, 9, 2, 9, 4};
        HashSet<Integer> hs = new HashSet<>();
        //Union
        for(int i=0; i<arr1.length; i++){
            hs.add(arr1[i]);
        }
        for(int i=0; i<arr2.length; i++){
            hs.add(arr2[i]);
        }
        System.out.println("Union size: " + hs.size());
        System.out.println("Union elements: " + hs);
        //Intersection
        hs.clear(); //clearing it so that we can start intersection again on the same hs
        for(int i=0; i<arr1.length; i++){
            hs.add(arr1[i]);
        }
        int count = 0;
        for(int i=0; i<arr2.length; i++){
            if(hs.contains(arr2[i])){
                count++;
                System.out.println("Intersection element: " + arr2[i]);
                hs.remove(arr2[i]);
            }
        }
        System.out.println("Intersection size: " + count);
    }
}
