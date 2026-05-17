import java.util.*;

public class j {
    static int count = 0;
    public static void findSubset(String str, StringBuilder sb, int i){
        if(i == str.length()){
            count++;
            System.out.print(sb + " ");
            return;
        }
        findSubset(str, sb.append(str.charAt(i)), i+1);
        sb.deleteCharAt(sb.length()-1);
        findSubset(str, sb, i+1);
    }
    public static void main(String args[]){
        String str = "abc";
        findSubset(str, new StringBuilder(), 0);
        System.out.println(count);
    }
    
}

