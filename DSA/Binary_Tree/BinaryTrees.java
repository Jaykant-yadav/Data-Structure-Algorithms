package DSA.Binary_Tree;
import java.util.*;
public class BinaryTrees { 
    // Tree Build Code - O(n)
    static class Node { 
        int data;
        Node left;
        Node right;
        // Constructor
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;
        public static Node buildTree(int nodes[]) {
            idx++;
            if(nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode; 
        }
    }

    // PreOrder Traversal
    public static void preOrder(Node root) { //O(n)
        if(root == null) {
            return;
        }
        System.out.print(root.data + " "); //root
        preOrder(root.left);//left
        preOrder(root.right);//right
    }

    // InOrder Traversal
    public static void InOrder(Node root) {// O(n)
        if(root == null) {
            return;
        }
        InOrder(root.left); //left
        System.out.print(root.data + " "); //root
        InOrder(root.right);//right
    }

    // PostOrder Traversal
    public static void postOrder(Node root) {// O(n)
        if(root == null) {
            return;
        }
        postOrder(root.left);//left
        postOrder(root.right);//right
        System.out.print(root.data + " "); //root
    }

    // Level Order Traversal
    public static void levelOrder(Node root) {// O(n)
        if(root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()) {
            Node currNode = q.remove();
            if(currNode == null) {
                System.out.println();
                if(q.isEmpty()) {
                    break;
                } else {
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

    // Height of the tree
    public static int height(Node root) {
        if(root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Count Of Node
    public static int count(Node root) {
        if(root == null) {
            return 0;
        }

        int leftCount = count(root.left);
        int rightCount = count(root.right);
        return leftCount + rightCount + 1;
    }

    // Sum of Nodes
    public static int sumOfNodes(Node root) {
        if(root == null) {
            return 0;
        }

        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);
        return leftSum + rightSum + root.data;
    }

    public static void main(String[] args) {
        /* int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes); */
        // System.out.println(root.data);

        /* preOrder(root);
        System.out.println();
        InOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
        levelOrder(root); */

        /*              1
         *            /   \
         *           2     3
         *          / \   / \
         *         4   5 6   7
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(height(root));
        System.out.println(count(root));
        System.out.println(sumOfNodes(root));
    }
}
