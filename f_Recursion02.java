import java.util.*;

public class f_Recursion02 {
    //Tiling problem (Check notes of dought) this is not optimised as it maked recursive call repeately for the same number so go with dp
    public static int placeTile(int n) {   //for 2 X n (length X Breadth)
        if (n == 0 || n == 1) { //Base case
            return 1; // if n == 0 , no tiles 1 way or n == 1 2x1 is the tile size and size of the box is 2x1 so number of ways = 1.
        }
        //implementation
        return placeTile(n-1) + placeTile(n-2); //1st recursive call if i place tile vertically(1 will be the space occupied) call for remaining space n-1 and similarly if i place the tile horizontally(2 will be the space occupied) call for remaining space n-2 
    }
    
    //Remove duplicates (this sol is the most optimised and better)
    public static String removeDuplicates(String str) {
        StringBuilder sb = new StringBuilder(); //optimised because we have used sb
        boolean visited[] = new boolean[128]; //128 size so that we can store any ASCII values

        for(int i=0; i<str.length(); i++){
            char currchar = str.charAt(i);
            // int idx = currchar - 'a'; //only if i/p characters are small and no special chars

            if(visited[currchar] == false){ //if not visited usse visit karao
                visited[currchar] = true;
                sb.append(currchar); //badme append karao
            }
        }
        char arr[] = sb.toString().toCharArray(); //create a char arr and store all in it
        Arrays.sort(arr); //sort the arr

        return new String(arr); //return new string because fnx expects string format 
    }

    //Friends pairing (check ma'am lecture if dought)
    public static int friendsPairing(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        return friendsPairing(n-1) + (n-1) * friendsPairing(n-2); //check new notes for understanding this 2 recursive calls
    }

    //print binary string w/o consecutive 1's
    public static void printBinString(int n, int lastPlace, String str) {
        if (n == 0) { //if i/p (n) is 0 then print empty string and return nothing
            System.out.println(str);
            return;
        }
        //implementation
        if (lastPlace == 0) {
            printBinString(n-1, 0, str + "0");  //logic is if my lastnum is 0, i can add 0 and 1 
            printBinString(n-1, 1, str + "1");
        }
        else {
            printBinString(n-1, 0, str + "0");  //else if lastnum is 1 then i can add only 0 becauase two 1's should not come
        }
    }
    
    //allOccurence
    public static void allOccurence(int arr[], int key, int i){
        if(i == arr.length){
            return;
        }

        if(arr[i] == key){
            System.out.print(i + " ");
        }
        allOccurence(arr, key, i+1);
    }

    //convert english numbers into digits
    public static void convertToDigit(int numb){
        String str[] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        if(numb == 0){
            return;
        }
        
        int lastdigit = numb % 10;
        convertToDigit(numb / 10);// this call keeps executing until the numb becomes 0, and when numb is 0 bc hits while returning back backtracking the values are printed
        System.out.print(str[lastdigit] + " ");
    }

    //print substring with same characters at the start and end
    public static int countSubString(String s, int i, int j){ //remember for loop(iteration) is the most optimised way to solve this question(nested for loop)
        if(i == s.length()){  //(0,0)→(0,1)→(0,2)→(0,3) ← j==n, jump to (1,1) (dry run for n=3)
            return 0;                            //(1,1)→(1,2)→(1,3) ← j==n, jump to (2,2)
        }                                                     //(2,2)→(2,3) ← j==n, jump to (3,3)
                                                                    //(3,3) ← i==n, return 0 
        if(j == s.length()){
            return countSubString(s, i+1, i+1); // both i+1 because for next row and col j is i itself ex after row (0,0) next row(1,1) i and j is same 
        }
        //1st
        int count = 0;
        if(s.charAt(i) == s.charAt(j)){
            count = 1;
        }

        return count + countSubString(s, i, j+1);
    }

    //findLength of a string
    public static int findLength(String s){
        if(s.length() == 0){
            return 0;
        }

        return 1 + findLength(s.substring(1)); //check new noted for understanding its simple
    }

    //tower of hanoi (it's easy check new notes)
    public static void towerOfHanoi(int n, String src, String helper, String dest){
        if(n == 1){ //if disks(n) is 1 simply move from src to dest(no helper needed)
            System.out.println("Move " + n + " from " + src + " to " + dest);
            return;
        }
        //step-1 
        towerOfHanoi(n-1, src, dest, helper);
        //step-2
        System.out.println("Move " + n + " from " + src + " to " + dest);
        //step-3
        towerOfHanoi(n-1, helper, src, dest);
    }
    public static void main(String args[]) {
        // System.out.println(placeTile(3));
        // String str = "aab@c4d@eEf@E";
        // System.out.println(removeDuplicates(str));
        // System.out.println(friendsPairing(4));
        // printBinString(2, 0, "");
        // int arr[] = {3,2,4,5,6,2,7,2,2};
        // int key = 2;
        // allOccurence(arr, 2, 0);
        // int numb = 2002;
        // convertToDigit(numb);
        // String s = "abcab";
        // System.out.println(countSubString(s, 0, 0));
        // String s = "java";
        // System.out.println(findLength(s));
        // String s = "j";
        // System.out.println(s.substring(1));
        int n = 1;
        towerOfHanoi(n, "S", "H", "D");


    }
}
