import java.util.*;
public class q_BinarySearchTrees02 {
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
    public static void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.println(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    //Convert BST to balanced BST
    //2nd
    public static void getInOrder(Node root, ArrayList<Integer> inorder){
        if(root == null){
            return;
        }
        getInOrder(root.left, inorder);
        inorder.add(root.data);
        getInOrder(root.right, inorder);
    }
    //3rd
    public static Node createBST(ArrayList<Integer> inorder, int st, int end){
        if(st > end){
            return null;
        }
        int mid = (st + end) / 2;
        Node root = new Node(inorder.get(mid));
        createBST(inorder, st, mid-1);
        createBST(inorder, mid+1, end);
        return root;
    }
    //1st
    public static Node balanceBST(Node root){
        ArrayList<Integer> inorder = new ArrayList<>();
        //1 - create getInOrder fnx and call it here
        getInOrder(root, inorder);
        //2 - create createBST fnx and call it here
        root = createBST(inorder, 0, inorder.size()-1);
        return root;  
    }
    public static void main(String args[]){
        /*      8
              /   \
             6     10      normal BST
            /       \
           5         11 
          /           \
         3             12  */
        Node root = new Node(8);
        root.left = new Node(6);        
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);
        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);
        /*   8
           /   \
          5     11     Balanced BST
         / \   /  \
        3   6 10  12  */
        root = balanceBST(root);
        preOrder(root);
    }
}
