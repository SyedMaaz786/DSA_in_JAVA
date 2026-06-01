import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import org.w3c.dom.Node;

public class j {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    static class Info{
        int hd;
        Node node;

        public Info(int hd, Node node){
            this.hd = hd;
            this.node = node;
        }
    }
    public static Node lca(Node root, int n1, int n2){
        if(root == null || root.data == n1 || root.data == n2){
            return root;
        }
        Node left = lca(root.left, n1, n2);
        Node right = lca(root.right, n1, n2);

        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }

        return root;
    }

    public static int helper(Node root, int n){
        if(root == null){
            return -1;
        }
        if(root.data == n){
            return 0;
        }
        int left = helper(root.left, n);
        int right = helper(root.right, n);

        if(left == -1 && right == -1){
            return -1;
        }
        else if(left == -1){
            return right + 1;
        }
        else{
            return left + 1;
        }
    }
    public static int minDist(Node root, int n1, int n2){
        Node lca = lca(root, n1, n2);
        int dist1 = helper(lca, n1);
        int dist2 = helper(lca, n2);
        return dist1 + dist2;
    }
    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int n1 = 4;
        int n2 = 7;
        System.out.println(minDist(root, n1, n2));

    }
}