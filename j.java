import java.util.*;

public class j {
    public static void pairs(int numbers[]){
        int tp = 0;
        for(int i=0; i<numbers.length; i++){
            for(int j=i+1; j<numbers.length; j++){
                System.out.println(numbers[i] + "," + numbers[j]);
                tp++;
            }
            System.out.println();
        }
        System.out.println(tp);
        
    }
    public static void main(String args[]){
        int numbers[] = {2, 3, 4, 5, 6, 7, 8, 9};
        pairs(numbers);
    }
}
