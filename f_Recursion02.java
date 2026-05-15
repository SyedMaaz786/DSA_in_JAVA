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
    public static void main(String args[]) {
        // System.out.println(placeTile(3));
        // String str = "aab@c4d@eEf@E";
        // System.out.println(removeDuplicates(str));
        // System.out.println(friendsPairing(4));
        printBinString(2, 0, "");
    }
}
