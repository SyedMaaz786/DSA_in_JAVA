import java.util.*;

public class t_Hashing01 {
    public static void main(String srgs[]){
        //Create 
        HashMap<String, Integer> hm = new HashMap<>();

        //Insert O(1)
        hm.put("India", 100);
        hm.put("China", 200);
        hm.put("Bhutan", 50);
        System.out.println(hm);

        //Get O(1)
        System.out.println(hm.get("India"));

        //ContainsKey O(1)
        System.out.println(hm.containsKey("India"));

        //Remove O(1)
        System.out.println(hm.remove("India", 100));
        System.out.println(hm);

        //Size
        System.out.println(hm.size());

        //isEmpty
        System.out.println(hm.isEmpty());

        //clear
        hm.clear();
        System.out.println(hm);

        hm.put("India", 100);
        hm.put("China", 200);
        hm.put("Bhutan", 50);

        //iterate
        for(String key: hm.keySet()){ 
            System.out.println("key: " + key + ", value:" + hm.get(key)); //hm.get(key) → fetches the VALUE corresponding to that key
        }

    }
}
