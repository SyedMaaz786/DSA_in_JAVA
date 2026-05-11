import java.util.*;

public class j {
    public static void zeroOne(int rows, int cols){
        for(int i=1; i<=rows; i++){
            for(int j=1; j<=i; j++){
                System.out.print(((i+j) % 2 == 0) ? '1' : '0');
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        zeroOne(2,2);
    }

}
