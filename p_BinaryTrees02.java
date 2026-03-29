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
        return Math.max(lh, rh) + 1;  //return statement changes for every problem 
    }
    //Count of nodes in a tree O(n)
    public static int count(Node root){
        if(root == null){
            return 0;
        }
        int lc = count(root.left);
        int rc = count(root.right);
        return lc + rc + 1;
    }
    //Sum of nodes in a tree O(n)
    public static int sum(Node root){
        if(root == null){
            return 0;
        }
        int ls = sum(root.left);
        int rs = sum(root.right);
        return ls + rs + root.data;
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
        
        int selfd = lh + rh + 1; //formula

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

        int d = Math.max(Math.max(leftInfo.d, rightInfo.d), (leftInfo.h + rightInfo.h + 1));  //formula
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
    public static void main(String args[]){
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


        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);
        System.out.println(isSubtree(root, subRoot));
    }
}