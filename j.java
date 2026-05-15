import java.util.*;

public class j {
    public static int occ(int arr[], int key, int i){
        if(i == arr.length){
            return -1;
        }
        int ans = occ(arr, key, i+1);
        if(ans == -1 && arr[i] == key){
            return i;
        }
        return ans;
    }
    public static void main(String args[]){
        int arr[] = {1, 2, 3, 4, 3};
        System.out.println(occ(arr, 3, 0));
    }
}

