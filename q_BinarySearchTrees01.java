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
        //2nd
        if(root == null){
            root = new Node(val); //depending on the value it goes and puts the new valu either left or right
            return root;
        }
        //1st
        if(val < root.data){
            root.left = insert(root.left, val);
        }
        else {
            root.right = insert(root.right, val);
        }
        //3rd
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
        if(root == null){[
            return null;
        ]}
        if(val < root.data){ //first search the node we want to delete
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
    // Validate BST
    public static boolean isValidBST(Node root, Node min, Node max){
        if(root == null){
            return true;
        }
        if(min != null && min.data >= root.data){ //check in main fnx we are initialising min and max to null so, if min != null and min(ie left side) contains bigger value return false 
            return false;
        }
        else if(max != null && max.data <= root.data){ //same as if bas condition uska reverse
            return false;
        }
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max); // for passing the values as min and max for recursion call remember like (min to root to max) and remember both should return true for a valid BST
    }
    // Mirror a BST - O(n) (it's very easy) notes for pseudo code 
    public static Node mirror(Node root){
        if(root == null){
            return null;
        }
        Node leftST = mirror(root.left);
        Node rightST = mirror(root.right);

        root.left = rightST; //Swapping
        root.right = leftST;
        return root;
    }
    public static void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
        //Sorted Array to balanced BST - O(n) (it's very easy)
    public static Node createBST(int arr[], int st, int end){
        if(st > end){
            return null;
        }
        int mid = (st + end) / 2;
        Node root = new Node(arr[mid]); //this will create a new node that will be the mid of arr as root node
        root.left = createBST(arr, st, mid-1);
        root.right = createBST(arr, mid+1, end);
        return root; //remember below we must write preorder fnx 
    }
    public static void main(String args[]){
        // int values[] = {5, 1, 3, 4, 2, 7};
        // Node root = null;
        // for(int i=0; i<values.length; i++){
        //     root = insert(root, values[i]);
        // }
        // inOrder(root);
        // System.out.println();


        // if(search(root, 1)){
        //     System.out.println("Found");
        // }
        // else {
        //     System.out.println("Not found");
        // }


        // root = delete(root, 1);
        // inOrder(root);


        // printInOrder(root, 3, 5);


        // printRoot2LeafPath(root, new ArrayList<>());


        // if(isValidBST(root, null, null)){
        //     System.out.println("Valid");
        // }
        // else {
        //     System.out.println("Not valid");
        // }


        // //Normal BST
        // /*       
        //         8
        //        / \
        //       5   10
        //      / \    \
        //     3   6    11
        // */
        // Node root = new Node(8);  
        // root.left = new Node(5);
        // root.right = new Node(10);
        // root.left.left = new Node(3);
        // root.left.right = new Node(6);
        // root.right.right = new Node(11);
        // //Mirror BST
        // /*
        //         8
        //        / \
        //      10   5
        //      /   / \
        //     11  6   3
        // */
        // root = mirror(root);
        // preOrder(root);


        int arr[] = {3, 5, 6, 8, 10, 11, 12};
        Node root = createBST(arr, 0, arr.length-1);
        preOrder(root);
    }
}
