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
