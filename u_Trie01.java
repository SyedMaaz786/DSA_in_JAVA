public class u_Trie01 {
    static class Node{
        //creating a trie
        Node children[] = new Node[26]; //'a' -'z'
        boolean eow = false;

        public Node(){
            for(int i=0; i<26; i++){
                children[i] = null;
            }
        }
    }
    public static Node root = new Node();


    //Insert in trie O(L) L-length of the word
    public static void insert(String word){
        Node curr = root; //init curr with root
        for(int i=0; i<word.length(); i++){
            int idx = word.charAt(i) - 'a'; //gives idx of that particular letter
            if(curr.children[idx] == null){ //agar wo letter ka idx null haya konbi nai hee wahan tho add krna use new node dalko
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx]; //and update curr now for next letter
        }
        curr.eow = true; //word complete hoga tho eow true hojata
    }
    //Search in trie O(L) 
    public static boolean search (String key){
        Node curr = root;
        for(int i=0; i<key.length(); i++){
            int idx = key.charAt(i) - 'a';
            if(curr.children[idx] == null){
                return false;
            }
            else{
                curr = curr.children[idx];
            }
        }
        return curr.eow == true;
    }
    //Word Break Problem O(L) (search GPT recursive call + lecture for for loop init from 1)
    public static boolean wordBreak(String key){
        if(key.length() == 0){
            return true;
        }
        for(int i=1; i<=key.length(); i++){
            if(search(key.substring(0, i)) && //search call will check whether the key part exist's in the trie (0,i) means ele between 0 to ith idx
               wordBreak(key.substring(i))){ //wordBreak fnx will break the word and give recursively till last word (i) means ele after ith idx
                return true;
            }
        }
        return false;
    }
    public static void main(String args[]){
        // String words[] = {"the", "a", "there", "their", "any", "thee"};
        // for(int i=0; i<words.length; i++){
        //     insert(words[i]);
        // }
        // System.out.println(search("thee"));
        // System.out.println(search("thor"));


        String arr[] = {"i", "like", "sam", "samsung", "mobile", "ice"};
        for(int i=0; i<arr.length; i++){
            insert(arr[i]);
        }
        String key = "ilikesamsung";
        System.out.println(wordBreak(key));
    }
}
