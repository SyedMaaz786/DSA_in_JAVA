import java.util.ArrayList;

public class i_ArrayList01 {
    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<Boolean> list3 = new ArrayList<>();

        //add operation TC:O(1)
        list.add(1); 
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(5, 20); //O(n)  Where 1 is the index 20 is the element ie (index,element)
        // System.out.println(list);
        // System.out.println(list.size());

        // //get operation TC:O(1)
        // int element = list.get(0);
        // System.out.println(element);

        // //delete operation TC:O(n)
        // list.remove(5);
        // System.out.println(list);

        // //set element at index TC:O(n)
        // list.set(4, 10);
        // System.out.println(list);

        // //contains element TC:O(n)
        // System.out.println(list.contains(1));
        // System.out.println(list.contains(99));


        // //print reverse of an ArrList O(n)
        // for (int i=list.size()-1; i>=0; i--) {
        //     System.out.print(list.get(i) + " ");
        // }
        // System.out.println();


        // //print the maximum number O(n)
        // int max = Integer.MIN_VALUE;
        // for (int i=0; i<list.size(); i++) {
        //     if(max < list.get(i)) {
        //         max = list.get(i);
        //     }
        // }
        // System.out.println("My max number is " + max);        
    }
}
