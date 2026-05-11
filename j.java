import java.util.*;

public class j {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int in = sc.nextInt();

        boolean isPrime = true;
        for(int i=2; i<in; i++){
            if(in % i == 0){
                isPrime = false;
                System.out.println("no");
            }
        }
        if(isPrime){
            System.out.println("yes");
        }
    }

}
