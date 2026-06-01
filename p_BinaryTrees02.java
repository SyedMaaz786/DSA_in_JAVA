import java.util.*;

import org.w3c.dom.Node;

public class p_BinaryTrees02 {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    //Height of a tree O(n)
    public static int height(Node root){
        if(root == null){
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh) + 1;  //+1 because we are doing 1234 based lvl traversal not 01234 based 
    }
    //Count of nodes in a tree O(n)
    public static int count(Node root){
        if(root == null){
            return 0;
        }
        int lc = count(root.left);
        int rc = count(root.right);
        return lc + rc + 1; //+1 is the root node himself
    }
    //Sum of nodes in a tree O(n)
    public static int sum(Node root){
        if(root == null){
            return 0; 
        }
        return sum(root.left) + sum(root.right) + root.data; //leftnode + rightnode + rootnode itself = tot sum of the nodes
    }
    //Diameter of a tree O(n2), Approach1 
    public static int diameter1(Node root){ //It's easy lecture if dought
        if(root == null){
            return 0;
        }
        int ld = diameter1(root.left); //simple 4 recursive calls
        int lh = height(root.left);
        int rd = diameter1(root.right);
        int rh = height(root.right);
        
        int selfd = lh + rh + 1; //formula +1 here also because we are doing 123 based lvl traversal

        return Math.max(Math.max(ld, rd), (selfd)); //inner max compares [ld , rd] and outer max compares [(ld,rd) , selfd]
    }
    //Diameter of a tree O(n), Approach2
    static class Info{
        int d;
        int h;

        public Info(int d , int h){
            this.d = d;
            this.h = h;
        }
    }
    public static Info diameter2(Node root){ //Check lecture's dryrun if dought
        if(root == null){
            return new Info(0, 0);
        }
        Info leftInfo = diameter2(root.left);
        Info rightInfo = diameter2(root.right);

        int d = Math.max(Math.max(leftInfo.d, rightInfo.d), (leftInfo.h + rightInfo.h + 1));  //formula (leftInfo.h + rightInfo.h + 1) this is nothing but selfd
        int h = Math.max(leftInfo.h, rightInfo.h) + 1; //formula

        return new Info(d, h);
    }
    //Subtree of another tree
    //2nd
    public static boolean isIdentical(Node node, Node subRoot){
        if(node == null && subRoot == null){ //if both are null they are identical
            return true;
        }
        else if(node == null || subRoot == null || node.data != subRoot.data){ //if anyone condition is not identical then return false
            return false;
        }
        if(!isIdentical(node.left, subRoot.left)){ //if left side tree is not identical return false
            return false;
        }
        if(!isIdentical(node.right, subRoot.right)){ //if right side tree is not identical return false
            return false;
        }
        return true; //if none of the statements above were true then it is identical so return true
    }
    //1st
    public static boolean isSubtree(Node root, Node subRoot){
        if(root == null){
            return false;
        }
        if(root.data == subRoot.data){
            if(isIdentical(root, subRoot)){
                return true;
            }
        }
        // boolean leftAns = isSubtree(root.left, subRoot); //this is same as writing everything in the return statement it self whcih we have done below
        // boolean rightAns = isSubtree(root.right, subRoot);
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot); //if either of the statement is true it returns true (Here this is a recursive call in the return statement itself) This is same as writing the above commented statement
    }
    //Top View (You need to stare the code it's not that difficult, lecture if dought)
    static class Info2{
        int hd;
        Node node;

        public Info2(int hd, Node node){
            this.hd = hd;
            this.node = node;
        }
    }
    public static void topView(Node root){
        //level order traversal
        Queue<Info2> q = new LinkedList<>(); //because lvl order traversal
        HashMap<Integer, Node> map = new HashMap<>(); //key = hd, value = node

        int min = 0, max = 0;
        q.add(new Info2(0, root)); //initially hd = 0 , root is node value
        q.add(null);

        while(!q.isEmpty()){
            Info2 curr = q.remove();
            if(curr == null){
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }
            else{
                if(!map.containsKey(curr.hd)){ //first time hd is occuring (*imp - For bottom view just remove this if)
                map.put(curr.hd, curr.node);
                }
                if(curr.node.left != null){  //it's easy as level order keep staring
                q.add(new Info2(curr.hd-1, curr.node.left)); //and condition is also easy keep staring
                min = Math.min(min, curr.hd-1); //as hd goes left update min
                }
                if(curr.node.right != null){
                q.add(new Info2(curr.hd+1, curr.node.right));
                max = Math.max(max, curr.hd+1);
                }
            }
        }
        for(int i=min; i<=max; i++){
            System.out.print(map.get(i).data + " ");
        }
        System.out.println();
    }
    //kth level (very easy) O(1)
    public static void kLevel(Node root, int level, int k){
        if(root == null){
            return;
        }
        if(level == k){
            System.out.print(root.data + " ");
            return;
        }
        else{
            kLevel(root.left, level+1, k);
            kLevel(root.right, level+1, k);
        }
    }
    // Lowest common ancestor - approach 1, O(n) (it's easy stare + lecture)
    public static boolean getPath(Node root, int n, ArrayList<Node> path){
        if(root == null){
            return false;
        }
        //3rd
        path.add(root);
    
        if(root.data == n){
            return true;
        }

        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);

        if(foundLeft || foundRight){
            return true;
        }

        path.remove(path.size()-1); 
            return false;
    }
    //1st
    public static Node lca(Node root, int n1, int n2){
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        // last common ancestor
        //2nd
        int i=0;
        for(; i<path1.size() && i<path2.size(); i++){
            if(path1.get(i) != path2.get(i)){
                break;
            }
        }
        // last equal node -> i-1th node
        Node lca = path1.get(i-1); //we can do path1 or path2 same we will get 
        return lca;
    }
    // Lowest common ancestor - approach 2 (imp check lecture dryrun)
    public static Node lca2(Node root, int n1, int n2){
        if(root == null || root.data == n1 || root.data == n2){
            return root;
        }
        //1st
        Node leftLca = lca2(root.left, n1, n2);
        Node rightLca = lca2(root.right, n1, n2);

        if(leftLca == null){ //if left is null value exists in rightLca
            return rightLca;
        }
        if(rightLca == null){ //if right is null value exista in leftLca
            return leftLca;
        }
        return root; // This is if leftLca and rightLca returns some valid value then uska root will be ans for our tree 1
    }
    //Minimum Distance between 2 nodes (it's easy check lecture for understanding)
    //1st
    public static int lcaDist(Node root, int n){
        if(root == null){
            return -1;
        }
        if(root.data == n){
            return 0;
        }

        int leftDist = lcaDist(root.left, n);
        int rightDist = lcaDist(root.right, n);

        if(leftDist == -1 && rightDist == -1){
            return -1;
        }
        else if(leftDist == -1){
            return rightDist + 1;
        }
        else{
            return leftDist + 1;
        }
    }
    //2nd
    public static int minDist(Node root, int n1, int n2){
        Node lca = lca2(root, n1, n2); //this problem is implemented using lca code as helper fnx
        int dist1 = lcaDist(lca, n1);
        int dist2 = lcaDist(lca, n2);
        return dist1 + dist2;
    }
    //Kth ancestors of node (easy similar to minDist)
    public static int kAncestor(Node root, int n, int k){
        if(root == null){
            return -1;
        }
        if(root.data == n){
            return 0;
        }
        int leftDist = kAncestor(root.left, n, k);
        int rightDist = kAncestor(root.right, n, k);

        if(leftDist == -1 && rightDist == -1){
            return -1;
        }
        int max = Math.max(leftDist, rightDist); //valid value (imp - check gpt tell why max here)
        if(max+1 == k){
            System.out.println(root.data);
        }
        return max+1;
    }
    //Transform to sum tree (it's easy lecture for understanding)
    public static int transform(Node root){
        if(root == null){
            return 0;
        }
        //1st
        int leftChild = transform(root.left);
        int rightChild = transform(root.right);
        //2nd
        int data = root.data;
        //4th
        int newLeft = root.left == null ? 0 : root.left.data;
        int newRight = root.right == null ? 0 : root.right.data;

        root.data = leftChild + newLeft + rightChild + newRight;
        //3nd
        return data;
    }
    public static void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void main(String args[]){
        /*
                    1
                   / \
                  2   3
                 / \ / \
                4  5 6  7
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        // System.out.println(height(root));
        // System.out.println(count(root));
        // System.out.println(sum(root));
        // System.out.println(diameter1(root));
        // System.out.println(diameter2(root).d);


        // Node subRoot = new Node(2);
        // subRoot.left = new Node(4);
        // subRoot.right = new Node(5);
        // System.out.println(isSubtree(root, subRoot));


        // topView(root);

        
        // int k = 2;
        // kLevel(root, 1, k);


        // int n1 = 4, n2 = 5;
        // System.out.println(lca(root, n1, n2).data);


        // int n1 = 4, n2 = 7;
        // System.out.println(lca2(root, n1, n2).data);


        // int n1 = 4, n2 = 6;
        // System.out.println(minDist(root, n1, n2));


        // int n = 5, k = 2;
        // kAncestor(root, n, k);


        transform(root);
        preOrder(root);


    }
}