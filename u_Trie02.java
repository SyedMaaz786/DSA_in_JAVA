import org.w3c.dom.Node;

public class u_Trie02 {
    static class Node{
        Node children[] = new Node[26];
        boolean eow = false;
        int freq;

        public Node(){
            for(int i=0; i<26; i++){
                children[i] = null;
            }
            freq = 1;
        }
    }
    public static Node root = new Node();
    

    //Uniquely Identified O(L) (lecture for understanding and dryrun also insert and class Node is diff here)
    //1st
    public static void insert(String word){
        Node curr = root;
        for(int lvl=0; lvl<word.length(); lvl++){
            int idx = word.charAt(lvl) - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }
            else{
                curr.children[idx].freq++;
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }
    //2nd
    public static void findPrefix(Node root, String ans){
        Node curr = root; //here we could have directly used root var but we assigned root to curr and used to maintain the template of trie code, here curr is just another var referencing to root that's it
        if(curr == null){
            return;
        }
        if(curr.freq == 1){ //if freq is 1 print 
            System.out.println(ans);
            return;
        }
        for(int i=0; i<26; i++){
            if(curr.children[i] != null){ //if their is a valid data
                findPrefix(curr.children[i], ans+(char)(i+'a')); //recursive call (ans+(char)(i+'a') this converts idx to char)
            }
        }
    }
    //check prefix exists or not (startsWith Problem) O(L) - it's easy 
    public static boolean startsWith(String prefix){
        Node curr = root;
        for(int i=0; i<prefix.length(); i++){
            int idx = prefix.charAt(i) - 'a';
            if(curr.children[idx] == null){
                return false;
            }
            else{
                curr = curr.children[idx];
            }
        }
        return true;
    }
    //Unique Substrings (check lecture for understanding and dryrun + old notes and new notes aswell) it's easy
    public static int countNodes(Node root){
        Node curr = root;
        if(curr == null){
            return 0;
        }
        int count = 0;
        for(int i=0; i<26; i++){
            if(curr.children[i] != null){ //we will skip all the idx were null is their ex for app, at 0th idx recursive call for 'a' then skip all coming idx 'p' will be at idx 15 so next resursive call with idx 15 were char is 'p'
                count += countNodes(curr.children[i]); //recursive call for only who is having valid value as we will traverse all 26 idx
            }
        }
        return count + 1; //+1 mai khud ku add krna count k sath
    }
    //Longest word with all prefixes (it's easy check lecture for understanding and dryrun)
    public static String ans = ""; //this String type and var is immutable new obj is crteated if we try to make any changes, rie why while backtracking we delete the char from temp which is type StringBuilder and which is mutable meaning changes are made in the same obj
    public static void longestWord(Node root, StringBuilder temp){
        Node curr = root;
        if(curr == null){
            return;        }
        for(int i=0; i<26; i++){
            if(curr.children[i] != null && curr.children[i].eow == true){
                char ch = (char)(i+'a');
                temp.append(ch);
                if(temp.length() > ans.length()){ //this line is responsible for lexicographically higher word 1st 
                    ans = temp.toString();
                }
                longestWord(curr.children[i], temp); //recursive call
                temp.deleteCharAt(temp.length()-1); //backtrack 
            }
        }
    }
    public static void main(String args[]){
        // String arr[] = {"zebra", "dog", "duck", "dove"};
        // for(int i=0; i<arr.length; i++){
        //     insert(arr[i]);
        // }
        // root.freq = -1;
        // findPrefix(root, "");


        // String words[] ={"apple", "app", "mango", "man", "woman"};
        // String prefix1 = "app"; //true
        // String prefix2 = "moon"; //false
        // for(int i=0; i<words.length; i++){
        //     insert(words[i]);
        // }
        // System.out.println(startsWith(prefix1));
        // System.out.println(startsWith(prefix2));


        // String str = "ababa"; //ans = 10
        // //1st suffix-> insert in trie
        // for(int i=0; i<str.length(); i++){
        //     String suffix = str.substring(i);
        //     insert(suffix);
        // }
        // System.out.println(countNodes(root));


        String words[] = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        for(int i=0; i<words.length; i++){
            insert(words[i]);
        }
        longestWord(root, new StringBuilder(""));
        System.out.println(ans);
    }
}
