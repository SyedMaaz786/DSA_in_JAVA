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
        System.out.println(diameter2(root).d);
    }
}