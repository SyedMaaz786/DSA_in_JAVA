public class q_BinarySearchTrees01 {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    // Create BTS
    public static Node insert(Node root, int val){
        //1st
        if(root == null){
            root = new Node(val);
            return root;
        }
        //3rd
        if(val < root.data){
            root.left = insert(root.left, val);
        }
        else {
            root.right = insert(root.right, val);
        }
        //2nd
        return root;
    }
    public static void inOrder(Node root){ //for checking if our BTS is created correct note: if the values are printing in acsending sorted order then it is correct
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
    // Search in BST O(H)
    public static boolean search(Node root, int key){
        if(root == null){
            return false;
        }
        //1st
        if(root.data == key){
            return true;
        }
        if(key < root.data){
            return search(root.left, key);
        }
        else{
            return search(root.right, key);
        }
    }
    public static void main(String args[]){
        int values[] = {5, 1, 3, 4, 2, 7};
        Node root = null;
        for(int i=0; i<values.length; i++){
            root = insert(root, values[i]);
        }
        inOrder(root);
        System.out.println();


        if(search(root, 1)){
            System.out.println("Found");
        }
        else {
            System.out.println("Not found");
        }

    }
}
