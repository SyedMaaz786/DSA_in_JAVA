import java.util.*;

public class m_Stack02 {

    // isValid parentheses //O(n)
    public static boolean isValid(String str){ 
        Stack<Character> s = new Stack<>();

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);

            //opening 
            if(ch == '(' || ch == '{' || ch == '['){
                s.push(ch);  //push to stack 
            }
            //closing
            else {
                if(s.isEmpty()){
                    return false;
                }
                if( (s.peek() == '(' && ch == ')') //if ( == )
                    || (s.peek() == '{' && ch == '}') //if { == }
                    || (s.peek() == '[' && ch == ']')) { //if [ == ]
                        s.pop();
                }
                else {
                    return false;
                }
            }
        }
        if(s.isEmpty()){  //at last stack is empty means we have traversed all elements and is a valid str
            return true;
        }
        else {
            return false;  //at last if we had elements left in the stack means invalid str
        }
    }


    // isDuplicate parentheses //O(n)
    public static boolean isDuplicate(String str){
        Stack<Character> s = new Stack<>();

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);

            //closing
            if(ch == ')') {
                int count = 0;
                while(s.peek() != '(') { // With this condition i want to pop the elements until i get opening 
                    s.pop();  
                    count++;  //and count the elements
                }
                if(count < 1){
                    return true; //duplicate
                }
                else {
                    s.pop();  //opening pair 
                }
            }
            //opening
            else {
                s.push(ch);
            }
        }
        return false;
    } 


    //Stack Span Problem
    public static void stockSpan(int stocks[], int span[]){
        Stack<Integer> s = new Stack<>();
        span[0] = 1;  // 0th idx ie 1st day span is 1 
        s.push(0);

        for(int i=1; i<stocks.length; i++){
            int currPrice = stocks[i];
            while(!s.isEmpty() && currPrice >= stocks[s.peek()]){  //check lecture and byheart condition for curr
                s.pop();
            }
            if(s.isEmpty()){
                span[i] = i+1; // remember the last element 100 for our ex or check notes
            }
            else {
                int prevHigh = s.peek();
                span[i] = i - prevHigh; //check notes for this formula byheart this
            }
            s.push(i);
        }

    }
    public static void main(String args[]){
        // String str = "({})[]"; //true
        // System.out.println(isValid(str));


        // String str = "((a+b))";
        // System.out.println(isDuplicate(str));
        // String str2 = "(a+b)";
        // System.out.println(isDuplicate(str2));


        int stocks[] = {100, 80, 60, 70, 60, 85, 100};
        int span[] = new int[stocks.length];
        stockSpan(stocks, span);
        for(int i=0; i<span.length; i++){
            System.out.println(span[i] + " ");
        }
    }
}
