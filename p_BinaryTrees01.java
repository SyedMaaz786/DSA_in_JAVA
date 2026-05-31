import java.util.LinkedList;
import java.util.Queue;

public class p_BinaryTrees01 {
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
    static class BinaryTree{
        static int idx = -1;
        //1st
        public Node buildTree(int nodes[]){
            idx++;
            //3rd
            if(nodes[idx] == -1){
                return null;
            }
            //2nd
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes); //recursive call
            newNode.right = buildTree(nodes); //recursive call
            return newNode;
        }



        //Preorder traversal - Recursive approach O(n)
        public void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
        }


        
        //Inorder traversal - Recursive approach O(n)
        public void inOrder(Node root){
            if(root == null){
                return;
            }
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }



        //Postorder traversal - Recursive approach O(n)
        public void postOrder(Node root){
            if(root == null){
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }



        //Level order traversal - Iterative approach O(n)
        public void levelOrder(Node root){
            //7th
            if(root == null){
                return ;
            }
            //1st
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null); //for printing nextline

            while(!q.isEmpty()){
                Node currNode = q.remove();
            
                if(currNode == null){
                    System.out.println();
                    //5th
                    if(q.isEmpty()){
                        break;
                    }
                    //6th
                    else{
                        q.add(null); //for printing nextline for other nodes
                    }
                }
                //2nd
                else{
                    System.out.print(currNode.data + " ");
                    //3rd
                    if(currNode.left != null){
                        q.add(currNode.left);
                    }
                    //4th
                    if(currNode.right != null){
                        q.add(currNode.right);
                    }
                }
            }
        }
    }
    public static void main (String args[]){
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println(root.data);


        // tree.preOrder(root);

        // tree.inOrder(root);

        // tree.postOrder(root);

        tree.levelOrder(root);


    }
}
