import java.util.ArrayList;
import java.util.Collections;

public class i_ArrayList02 {
    //Swap 2 numbers
    public static void swap(ArrayList<Integer> list, int idx0, int idx1) {
        int temp = list.get(idx0);
        list.set(idx0, list.get(idx1));
        list.set(idx1, temp);
    }
    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(5);
        list.add(9);
        list.add(3);
        list.add(6);
        
        int idx0 = 0, idx1 = 1;
        System.out.println(list);
        swap(list, idx0, idx1);
        System.out.println(list);


        //Sorting in Arraylist (Ascending)
        Collections.sort(list);
        System.out.println("Ascending " + list);

        //Sorting in Arraylist (Descending)
        Collections.sort(list, Collections.reverseOrder()); //reverseOrder is a comparator fnx inbuilt
        System.out.println("Descending " + list);
    }
}
