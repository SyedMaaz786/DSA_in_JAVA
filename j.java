import java.util.*;

public class j {
    public static void bin(int n, int lp, String str){
        if(n == 0){
            System.out.println(str);
            return;
        }
        if(lp == 0){
            bin(n-1, 0, str + "0");
            bin(n-1, 1, str + "1");
        }
        else{
            bin(n-1, 0, str + "0");
        }
    }
    public static void main(String args[]){
        bin(2, 0, "");
    }
}

