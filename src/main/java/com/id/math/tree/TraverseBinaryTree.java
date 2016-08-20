package com.id.math.tree;

public class TraverseBinaryTree {

    public static void main(String[] args) {
        BinaryTreeNode<Integer> tree = createTree();
        System.err.println("\npre-order:");
        printPreOrder(tree);
        System.err.println("\npost-order:");
        printTreePostOrder(tree);
        System.err.println("\nin-order:");
        printTreeInOrder(tree);

        //int depth = depth(tree);
        //System.err.println(">>> " + depth);
        /*xxx(tree, 0);
        for (Entry e : l.entrySet()) {
            System.err.println("level: " + e.getKey() + "  " + e.getValue());
        }*/
    }

    private static void printPreOrder(BinaryTreeNode root) {
        if (root != null) {
            System.err.print(root.data);
            printPreOrder(root.left);
            printPreOrder(root.right);
        }
    }

    private static void printTreePostOrder(BinaryTreeNode root) {
        if (root != null) {
            printTreePostOrder(root.left);
            printTreePostOrder(root.right);
            System.err.print(root.data);
        }
    }

    private static void printTreeInOrder(BinaryTreeNode root) {
        if (root != null) {
            printTreeInOrder(root.left);
            System.err.print(root.data);
            printTreeInOrder(root.right);
        }
    }

    /*
    static LinkedHashMap<Integer, ArrayList> l = new LinkedHashMap<Integer, ArrayList>();

    private static void xxx(BinaryTreeNode root, int depth) {
        if (root != null) {
            depth++;
            ArrayList arr = l.get(new Integer(depth));
            if (arr == null) {
                arr = new ArrayList();
                l.put(new Integer(depth), arr);
            }
            arr.add(root.data);

            xxx(root.left, depth);
            System.err.println(root.data + "   " + depth);
            xxx(root.right, depth);
        }
    }

    private static void yyy(BinaryTreeNode root, int depth) {
        if (root != null) {
            xxx(root.left, depth);
            System.err.println(root.data + "   " + depth);
            xxx(root.right, depth);

        }
    }*/

    private static BinaryTreeNode<Integer> createTree() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> n2 = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> n3 = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> n4 = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> n5 = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> n6 = new BinaryTreeNode<>(6);

        root.left = n2;
        root.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.right = n6;
        return root;
    }
}
