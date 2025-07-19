import java.util.*;
public class BinaryTrees {
    // Node Class
    static class Node {
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

    static class BinaryTree {
        static int idx = -1;

        // Build Tree
        public static Node buildTree(int node[]) { // O(n)
            idx++;
            if (node[idx] == -1) {
                return null;
            }

            Node newNode = new Node(node[idx]);
            newNode.left = buildTree(node); // left Node
            newNode.right = buildTree(node); // right Node

            return newNode;
        }

        // PreOrder Traversal
        public static void preOrder(Node root) { // O(n)
            if (root == null) {
                return;
            }
            System.out.print(root.data + " "); // root
            preOrder(root.left); // left
            preOrder(root.right); // right
        }

        // InOrder Traversal
        public static void InOrder(Node root) { // O(n)
            if (root == null) {
                return;
            }

            InOrder(root.left); // left
            System.out.print(root.data + " "); // root
            InOrder(root.right); // right
        }

        // PostOrder Traversal
        public static void PostOrder(Node root) { // O(n)
            if (root == null) {
                return;
            }

            PostOrder(root.left);
            PostOrder(root.right);
            System.out.print(root.data + " ");
        }

        // Level Order Traversal
        public static void levelOrderTraversal(Node root) { // O(n)
            // check root null or not
            if (root == null) {
                return;
            }

            // create Queue
            Queue<Node> q = new LinkedList<>();
            // add root or for next add null
            q.add(root);
            q.add(null);

            // loop
            while (!q.isEmpty()) {
                Node currNode = q.remove(); // q of one one element go outside and store in currNode
                if (currNode == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(currNode.data + " ");
                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }

                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }
        }

    }

    
    // Count of Nodes of a Tree
    public static int countOfNodes(Node root) { // O(n)
        if (root == null) {
            return 0;
        }
        
        int leftCount = countOfNodes(root.left);
        int rightCount = countOfNodes(root.right);
        return (leftCount + rightCount) + 1;
    }
    
    // Sum of Nodes
    public static int sumOfNodes(Node root) {
        if(root == null) {
            return 0;
        }

        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);
        return (leftSum + rightSum) + root.data;
    }
    
    // Height of a Tree
    public static int heightOfTree(Node root) { // O(n)
        if (root == null) {
            return 0;
        }
        int rightHeight = heightOfTree(root.right);
        int leftHeight = heightOfTree(root.left);

        return Math.max(rightHeight, leftHeight) + 1;
    }

    // Diameter of a tree - O(n^2)
    // Approach - I
    public static int diameterOfaTree(Node root){ 
        if(root == null){
            return 0;
        }

        int leftDia = diameterOfaTree(root.left); //left Dia
        int rightDia = diameterOfaTree(root.right); //right Dia
        int leftHeight = heightOfTree(root.left); //left Height
        int rightHeight = heightOfTree(root.right); //right Height
        int selfDia = leftHeight + rightHeight + 1; // leftHight + RightHeight + 1 = SelfDia
        return Math.max(selfDia, Math.max(rightDia, leftDia)); // 
    }

    // Approach - II - O(n)
    static class Info{
        int diam;
        int ht;

        public Info(int diam, int ht){
            this.diam = diam;
            this.ht = ht;
        }
    }

    public static Info diameterOfaTree2(Node root){ //O(n)
        if(root == null){
            return new Info(0, 0);
        }
        Info leftInfo = diameterOfaTree2(root.left);
        Info rightInfo = diameterOfaTree2(root.right);

        int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht + rightInfo.ht + 1);
        int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;

        return new Info(diam, ht);
    }


    // Subtree Of Another Tree
    public static boolean Subtrees(Node root, Node subRoot){
        if(root == null){
            return false;
        }

        if(root.data == subRoot.data){
            if(isIdentical(root, subRoot)){
                return true;
            }
        }

        return Subtrees(root.left, subRoot) || Subtrees(root.right, subRoot);
    }

    private static boolean isIdentical(Node root, Node subRoot){
        if(root == null && subRoot == null){
            return true;
        }else if(root == null || subRoot == null || root.data != subRoot.data){
            return false;
        }

        if(!isIdentical(root.left, subRoot.left)){
            return false;
        }

        if(!isIdentical(root.right, subRoot.right)){
            return false;
        }

        return true;
    }


    public static void kthLevel(Node root, int level, int k){
        if(root == null){
            return;
        }

        if(level == k){
            System.out.print(root.data + " ");
        }

        kthLevel(root.left, level+1, k);
        kthLevel(root.right, level+1, k);
    }
    public static void main(String[] args) {
        int node[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
        // Node root = tree.buildTree(node);
        // System.out.println(root.data);

        // tree.preOrder(root);
        // tree.InOrder(root);
        // tree.PostOrder(root);
        // tree.levelOrderTraversal(root);
        /*
         *       1
         *      / \
         *     2   3
         *    /\   /\
         *   4  5 6  7
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        /* 
         *      2
         *     / \
         *    4   5
         */
        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);
        // System.out.println(heightOfTree(root));
        // System.out.println(countOfNodes(root));
        // System.out.println(sumOfNodes(root));
       /*  System.out.println(diameterOfaTree(root));
        System.out.println(diameterOfaTree2(root).diam);
        System.out.println(diameterOfaTree2(root).ht); */

        // System.out.println(Subtrees(root, subRoot));
        kthLevel(root, 1, 3);

    }
}