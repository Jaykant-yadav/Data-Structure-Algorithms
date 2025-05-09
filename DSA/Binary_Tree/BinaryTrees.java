package DSA.Binary_Tree;

import java.util.*;

import DSA.Stacks.stack;

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
            if (nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
    }

    // PreOrder Traversal
    public static void preOrder(Node root) { // O(n)
        if (root == null) {
            return;
        }
        System.out.print(root.data + " "); // root
        preOrder(root.left);// left
        preOrder(root.right);// right
    }

    // InOrder Traversal
    public static void InOrder(Node root) {// O(n)
        if (root == null) {
            return;
        }
        InOrder(root.left); // left
        System.out.print(root.data + " "); // root
        InOrder(root.right);// right
    }

    // PostOrder Traversal
    public static void postOrder(Node root) {// O(n)
        if (root == null) {
            return;
        }
        postOrder(root.left);// left
        postOrder(root.right);// right
        System.out.print(root.data + " "); // root
    }

    // Level Order Traversal
    public static void levelOrder(Node root) {// O(n)
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node currNode = q.remove();
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

    // Height of the tree
    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Count Of Node
    public static int count(Node root) {
        if (root == null) {
            return 0;
        }

        int leftCount = count(root.left);
        int rightCount = count(root.right);
        return leftCount + rightCount + 1;
    }

    // Sum of Nodes
    public static int sumOfNodes(Node root) {
        if (root == null) {
            return 0;
        }

        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);
        return leftSum + rightSum + root.data;
    }

    // Diameter of a trees
    public static int diameterOfTree(Node root) {// O(n^2)
        if (root == null) {
            return 0;
        }

        int leftDiam = diameterOfTree(root.left);
        int leftHeight = height(root.left);
        int rightDiam = diameterOfTree(root.right);
        int rightHeight = height(root.right);

        int selfDiam = leftHeight + rightHeight + 1;
        return Math.max(Math.max(leftDiam, rightDiam), selfDiam);
    }

    static class Info {
        int diameter;
        int height;

        Info(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }
    }

    public static Info diameter2(Node root) { // O(n)
        if (root == null) {
            return new Info(0, 0);
        }

        Info leftInfo = diameter2(root.left);
        Info rightInfo = diameter2(root.right);

        int currDiam = leftInfo.height + rightInfo.height + 1;
        int maxDiam = Math.max(Math.max(leftInfo.diameter, rightInfo.diameter), currDiam);

        int ht = Math.max(leftInfo.height, rightInfo.height) + 1;

        return new Info(maxDiam, ht);
    }

    // Subtree Of Another Tree
    public static boolean isSubtree(Node root, Node subRoot) {
        if (root == null || subRoot == null) {
            return false;
        }
        if (root.data == subRoot.data) {
            if (isIdentical(root, subRoot)) {
                return true;
            }
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public static boolean isIdentical(Node node, Node subRoot) {
        if (node == null && subRoot == null) {
            return true;
        } else if (node == null || subRoot == null || node.data != subRoot.data) {
            return false;
        }

        if (!isIdentical(node.left, subRoot.left)) {
            return false;
        }

        if (!isIdentical(node.right, subRoot.right)) {
            return false;
        }
        return true;
    }

    // Top view of a tree
    static class Info2 {
        Node node;
        int hd; // horizontal distance from the root

        public Info2(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void topView(Node root) {
        if (root == null) {
            return;
        }
        // level order traversal
        // but we need to keep track of the horizontal distance from the root
        Queue<Info2> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();

        int min = 0, max = 0;
        q.add(new Info2(root, 0));
        q.add(null);

        while (!q.isEmpty()) {
            Info2 currInfo = q.remove();
            if (currInfo == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if (!map.containsKey(currInfo.hd)) { // first time we are seeing this horizontal distance
                    map.put(currInfo.hd, currInfo.node);
                }

                if (currInfo.node.left != null) {
                    q.add(new Info2(currInfo.node.left, currInfo.hd - 1));
                    min = Math.min(min, currInfo.hd - 1);
                }

                if (currInfo.node.right != null) {
                    q.add(new Info2(currInfo.node.right, currInfo.hd + 1));
                    max = Math.max(max, currInfo.hd + 1);
                }

            }

            for (int i = min; i <= max; i++) {
                System.out.println(map.get(i).data + " ");
            }
        }
    }

    // Kth Level Of a Tree
    public static void KLevel(Node root, int level, int k) {
        if(root == null) {
            return;
        }

        if(level == k) {
            System.out.print(root.data + " ");
        }

        KLevel(root.left, level+1, k);
        KLevel(root.right, level+1, k);
    }

    // Lowest Common Ancestor
    public static boolean getPath(Node root, int n, ArrayList<Node> path) {
        if(root == null) {
            return false;
        }

        path.add(root);

        if(root.data == n) {
            return true;
        }

        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);

        if(foundLeft || foundRight) {
            return true;
        }

        path.remove(path.size()-1);
        return false;
    }

    public static Node lca(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        // Last common ancestor
        int i = 0;
        for(; i<path1.size() && i<path2.size(); i++) {
            if(path1.get(i) != path2.get(i)) {
                break;
            }
        }

        // last equal node -> i-1th
        Node lca = path1.get(i-1);
        return lca;
    }
    public static void main(String[] args) {
        /*
         * int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
         * BinaryTree tree = new BinaryTree();
         * Node root = tree.buildTree(nodes);
         */
        // System.out.println(root.data);

        /*
         * preOrder(root);
         * System.out.println();
         * InOrder(root);
         * System.out.println();
         * postOrder(root);
         * System.out.println();
         * levelOrder(root);
         */

        /*
         * 1
         * / \
         * 2 3
         * / \ / \
         * 4 5 6 7
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        /*
         * 2
         * / \
         * 4 5
         */
        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);

        /*
         * System.out.println(height(root));
         * System.out.println(count(root));
         * System.out.println(sumOfNodes(root));
         */
        // System.out.println(diameter2(root).height);
        // System.out.println(isSubtree(root, subRoot));
        // topView(root);
        // KLevel(root, 1, 3);

        int n1 = 4, n2 = 5;
        System.out.println(lca(root, n1, n2).data);
    }
}
