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
    //Convert BST to balanced BST (check Leetcode once for mature code)
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
    // Size of largest BST in BT (it's easy) notes for the steps and lecture for dryrun
    static class Info{
        boolean isBST;
        int size;
        int min;
        int max;

        public Info(boolean isBST, int size, int min, int max){
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }
    public static int maxBST = 0;
    public static int maxBSTValue = -1;
    public static Info largestBST(Node root){
        if(root == null){
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);
        int size = leftInfo.size + rightInfo.size + 1;
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

        // not valid BST
        if(leftInfo.max >= root.data || rightInfo.min <= root.data){
            return new Info(false, size, min, max);
        }
        // valid BST
        if(leftInfo.isBST && rightInfo.isBST){
            maxBST = Math.max(maxBST, size); //size is updated
            maxBSTValue = Math.max(maxBSTValue, root.data);
            return new Info(true, size, min, max);
        }
        else{
            return new Info(false, size, min, max);
        }
    }
    public static void main(String args[]){
        // /*      8
        //       /   \
        //      6     10      normal BST
        //     /       \
        //    5         11 
        //   /           \
        //  3             12  */
        // Node root = new Node(8);
        // root.left = new Node(6);        
        // root.left.left = new Node(5);
        // root.left.left.left = new Node(3);
        // root.right = new Node(10);
        // root.right.right = new Node(11);
        // root.right.right.right = new Node(12);
        // /*   8
        //    /   \
        //   5     11     Balanced BST
        //  / \   /  \
        // 3   6 10  12  */
        // root = balanceBST(root);
        // preOrder(root);




        
        /*      50
              /    \
            30      60
           /  \    /  \
          5   20  45   70
                         / \
                        65  80  */
        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(20);

        root.right = new Node(60);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);
        Info info = largestBST(root);
        System.out.println("Largest BST size is: " + maxBST);
        System.out.println("Max Node Value in the given BST is : " + maxBSTValue);
    }
}
