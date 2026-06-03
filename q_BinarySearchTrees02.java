import java.util.*;

import org.w3c.dom.Node;
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
        root.left = createBST(inorder, st, mid-1);
        root.right = createBST(inorder, mid+1, end);
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
        Info left = largestBST(root.left);
        Info right = largestBST(root.right);
        int size = left.size + right.size + 1;
        int min = Math.min(root.data, Math.min(left.min, right.min));
        int max = Math.max(root.data, Math.max(left.max, right.max));

        // not valid BST
        if(left.max >= root.data || right.min <= root.data){
            return new Info(false, size, min, max);
        }
        // valid BST
        if(left.isBST && right.isBST){
            maxBST = Math.max(maxBST, size); //size is updated
            maxBSTValue = Math.max(maxBSTValue, root.data);
            return new Info(true, size, min, max);
        }
        else{
            return new Info(false, size, min, max);
        }
    }

    // //Two sum BST's (easy check gpt why set, inorder)
    // static HashSet<Integer> set = new HashSet<>();
    // static int totPairs = 0;
    
    // public static int countPairs(Node bst1, Node bst2, int target){
    //     inOrder(bst1);
    //     helper(bst2, target);
    //     return totPairs;
    // }
    // public static void inOrder(Node root){
    //     if(root == null){
    //         return;
    //     }
    //     inOrder(root.left);
    //     set.add(root.data);
    //     inOrder(root.right);
    // }
    // public static void helper(Node root, int target){
    //     if(root == null){
    //         return;
    //     }
    //     if(set.contains(target - root.data)){
    //         totPairs++;
    //     }
    //     helper(root.left, target);
    //     helper(root.right, target);
    // }

    //Find the closest element in Binary Search Tree
    static int closest;

    public static int closestValue(Node root, int target){
        closest = root.data; // we assume closet is curr node
        helper(root, target);
        return closest;
    }
    public static void helper(Node root, int target){
        if(root == null){
            return;
        }

        if(Math.abs(root.data - target) < //check GPT very easy
           Math.abs(closest - target)){
            closest = root.data;
        }

        if(target < root.data){ //basic check if target is smaller than the root search in the left subtree
            helper(root.left, target);
        }
        else{ //if bigger then search in the right subtree
            helper(root.right, target);
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




        
        // /*      50
        //       /    \
        //     30      60
        //    /  \    /  \
        //   5   20  45   70
        //                  / \
        //                 65  80  */
        // Node root = new Node(50);
        // root.left = new Node(30);
        // root.left.left = new Node(5);
        // root.left.right = new Node(20);

        // root.right = new Node(60);
        // root.right.left = new Node(45);
        // root.right.right = new Node(70);
        // root.right.right.left = new Node(65);
        // root.right.right.right = new Node(80);
        // Info info = largestBST(root);
        // System.out.println("Largest BST size is: " + maxBST);
        // System.out.println("Max Node Value in the given BST is : " + maxBSTValue);


        // Node bst1 = new Node(5);
        // bst1.left = new Node(3);
        // bst1.right = new Node(7);
        // bst1.left.left = new Node(2);
        // bst1.left.right = new Node(4);
        // bst1.right.left = new Node(6);
        // bst1.right.right = new Node(8);

        // Node bst2 = new Node(10);
        // bst2.left = new Node(6);
        // bst2.right = new Node(15);
        // bst2.left.left = new Node(3);
        // bst2.left.right = new Node(8);
        // bst2.right.left = new Node(11);
        // bst2.right.right = new Node(18);      
        // System.out.println(countPairs(bst1, bst2, 16));  



        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(11);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.right = new Node(20);
        System.out.println(closestValue(root, 15));
        System.out.println(closestValue(root, 19));
    }
}
