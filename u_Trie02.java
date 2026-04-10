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
    

    //Uniquely Identified O(L) (lecture for unserdtanding and dryrun also insert and class Node is diff here)
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
        if(root == null){
            return;
        }
        if(root.freq == 1){ //if freq is 1 print 
            System.out.println(ans);
            return;
        }
        for(int i=0; i<root.children.length; i++){
            if(root.children[i] != null){ //if their is a valid data
                findPrefix(root.children[i], ans+(char)(i+'a')); //recursive call (ans+(char)(i+'a') this converts idx to char)
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
            curr = curr.children[idx];
        }
        return true;
    }
    //Unique Substrings (check lecture for understanding and dryrun also notes) it's easy
    public static int countNodes(Node root){
        if(root == null){
            return 0;
        }
        int count = 0;
        for(int i=0; i<26; i++){
            if(root.children[i] != null){
                count += countNodes(root.children[i]); //recursive call
            }
        }
        return count + 1;
    }
    //Longest word with all prefixes (it's easy check lecture for understanding and dryrun)
    public static String ans = "";
    public static void longestWord(Node root, StringBuilder temp){
        if(root == null){
            return;
        }
        for(int i=0; i<26; i++){
            if(root.children[i] != null && root.children[i].eow == true){
                char ch = (char)(i+'a');
                temp.append(ch);
                if(temp.length() > ans.length()){
                    ans = temp.toString();
                }
                longestWord(root.children[i], temp); //recursive call
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
