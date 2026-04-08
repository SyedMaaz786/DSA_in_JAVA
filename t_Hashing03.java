import java.util.*;

public class t_Hashing03 {
    public static void main(String args[]){
        //HashSet (Unordered)
        HashSet<String> hs = new HashSet<>();
        hs.add("Bengaluru");
        hs.add("Mumbai");
        hs.add("Chennai");
        hs.add("Bengaluru");
        System.out.println(hs);

        //Iterate in set using Iterator
        Iterator i = hs.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }

        //Iterate using Advance loop
        for(String s : hs){
            System.out.println(s);
        }

        //LinkedHashSet (Ordered)
        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.add("Kolkata");
        lhs.add("Lucknow");
        lhs.add("Noida");
        System.out.println(lhs);

        //TreeSet (Sorted in ascending order)
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(500);
        ts.add(200);
        ts.add(50);
        System.out.println(ts);
    }
}
