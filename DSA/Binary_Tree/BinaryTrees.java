import java.util.*;
public class BinaryTrees {
    // Node Class
    static class Node{
        int data;
        Node left;
        Node right;

        // Constructors
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree{
        static int idx = -1;
        // Build Tree
        public static Node buildTree(int node[]){ //O(n)
            idx++;
            if(node[idx] == -1) {
                return null;
            }

            Node newNode = new Node(node[idx]);
            newNode.left = buildTree(node); //left Node
            newNode.right = buildTree(node); //right Node

            return newNode;
        }

        // PreOrder Traversal
        public static void preOrder(Node root) { // O(n)
            if(root == null) {
                return;
            }
            System.out.print(root.data + " "); //root
            preOrder(root.left); //left
            preOrder(root.right); //right
        }

        // InOrder Traversal
        public static void InOrder(Node root) { // O(n)
            if(root == null) {
                return;
            }

            InOrder(root.left); //left
            System.out.print(root.data + " "); //root
            InOrder(root.right); // right
        }
 
        // PostOrder Traversal
        public static void PostOrder(Node root) { // O(n)
            if(root == null) {
                return;
            }

            PostOrder(root.left);
            PostOrder(root.right);
            System.out.print(root.data + " ");
        }

        // Level Order Traversal
        public static void levelOrderTraversal(Node root) {
            // check root null or not
            if(root == null) {
                return;
            }

            // create Queue
            Queue<Node> q = new LinkedList<>();
            // add root or for next add null
            q.add(root);
            q.add(null);

            // loop
            while (!q.isEmpty()) {
                Node currNode = q.remove(); // q of one one element go outside
                if(currNode == null) {
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }else {
                        q.add(null);
                    }
                } else {
                    System.out.print(currNode.data + " ");
                    if(currNode.left != null) {
                        q.add(currNode.left);
                    }

                    if(currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }

        }
    }

    
    public static void main(String[] args) {
        int node[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(node);
        // System.out.println(root.data);

        // tree.preOrder(root);
        // tree.InOrder(root);
        // tree.PostOrder(root);
        tree.levelOrderTraversal(root);

    }
}