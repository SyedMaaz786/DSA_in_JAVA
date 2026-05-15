public class f_Recursion02 {
    //Tiling problem (Check notes of dought) this is not optimised as it maked recursive call repeately for the same number so go with dp
    public static int placeTile(int n) {   //for 2 X n (length X Breadth)
        if (n == 0 || n == 1) { //Base case
            return 1; // if n == 0 , no tiles 1 way or n == 1 2x1 is the tile size and size of the box is 2x1 so number of ways = 1.
        }
        //implementation
        return placeTile(n-1) + placeTile(n-2); //1st recursive call if i place tile vertically(1 will be the space occupied) call for remaining space n-1 and similarly if i place the tile horizontally(2 will be the space occupied) call for remaining space n-2 
    }
    
    //Remove duplicates
    public static void removeDuplicates(String str, int idx, StringBuilder newstr, boolean map[]) {
        if (idx == str.length()) { 
            System.out.println(newstr);
            return;
        }
        //implementation
        char currChar = str.charAt(idx);
        if (map[currChar - 'a'] == true) { //duplicate
            removeDuplicates(str, idx+1, newstr, map);  //go to next char
        }
        else {
            map[currChar - 'a'] = true;  //occuring 1st time then add in the newstr
            removeDuplicates(str, idx, newstr.append(currChar), map);
        }
    }

    //Friends pairing (check ma'am lecture if dought)
    public static int friendsPairing(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        //implementation
        //single 
        int fnm1 = friendsPairing(n-1);
        //pair 
        int fnm2 = friendsPairing(n-2);
        int pairWays = (n-1) * fnm2;
        //total ways
        int totWays = fnm1 + pairWays;
        return totWays;
    }

    //print binary string w/o consecutive 1's
    public static void printBinString(int n, int lastPlace, String str) {
        if (n == 0) {
            System.out.println(str);
            return;
        }
        //implementation
        if (lastPlace == 0) {
            printBinString(n-1, 0, str + "0");  //logic is if my lastnum is 0 i can add 0 and 1 
            printBinString(n-1, 1, str + "1");
        }
        else {
            printBinString(n-1, 0, str + "0");  //else will have lastnum 1 then i can add only 0 becauase two 1's should not come
        }
    }
    public static void main(String args[]) {
        System.out.println(placeTile(3));
        // String str = "aabbccddeeff";
        // removeDuplicates(str, 0, new StringBuilder(""), new boolean[26]);
        // System.out.println(friendsPairing(2));
        // printBinString(2, 0, "");
    }
}
