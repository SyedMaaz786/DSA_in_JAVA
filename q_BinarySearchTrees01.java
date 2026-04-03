import java.util.ArrayList;

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
    // Delete a node
    public static Node delete(Node root, int val){
        if(val < root.data){
            root.left = delete(root.left, val);
        }
        else if(val > root.data){
            root.right = delete(root.right, val);
        }
        else{
            //case 1 - No child
            if(root.left == null && root.right == null){
                return null;
            }
            //case 2 - One child
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            //case 3 - Two children (Inorder successor)
            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data; //delete krna na wo node mai ab IS ki value dalko
            root.right = delete(root.right, IS.data); //IS ku delete krdale 
        }
        return root;
    }
    public static Node findInorderSuccessor(Node root){
        while(root.left != null){ //left most node at the right subtree (check notes) 
            root = root.left;
        }
        return root;
    }
    //Print in range (it's easy)
    public static void printInOrder(Node root, int k1, int k2){
        if(root == null){
            return;
        }
        if(k1 <= root.data && k2 >= root.data){
            printInOrder(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInOrder(root.right, k1, k2);
        }
        else if(k1 < root.data){
            printInOrder(root.left, k1, k2);
        }
        else{
            printInOrder(root.right, k1, k2);
        }
    }
    //Print root to leaf ka path
    //6th
    public static void printPath(ArrayList<Integer> path){
        for(int i=0; i<path.size(); i++){
            System.out.print(path.get(i) + " -> ");
        }
        System.err.println("Null");
    }
    //1st
    public static void printRoot2LeafPath(Node root, ArrayList<Integer> path){
        //5th
        if(root == null){
            return;
        }
        //2nd
        path.add(root.data);
        //4th
        if(root.left == null && root.right == null){
            printPath(path);
        }
        //3rd
        printRoot2LeafPath(root.left, path);
        printRoot2LeafPath(root.right, path);
        path.remove(path.size()-1); //backtracking (remove the last node when it becomes leaf node)
    }
    public static void main(String args[]){
        int values[] = {5, 1, 3, 4, 2, 7};
        Node root = null;
        for(int i=0; i<values.length; i++){
            root = insert(root, values[i]);
        }
        inOrder(root);
        System.out.println();


        // if(search(root, 1)){
        //     System.out.println("Found");
        // }
        // else {
        //     System.out.println("Not found");
        // }


        // root = delete(root, 1);
        // inOrder(root);


        // printInOrder(root, 3, 5);


        printRoot2LeafPath(root, new ArrayList<>());

    }
}
