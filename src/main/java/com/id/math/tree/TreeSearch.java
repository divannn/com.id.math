package com.id.math.tree;

public class TreeSearch {

    /**
     * Search in binary search tree.
     *
     * @param root
     * @param target
     * @return
     */
    //use ints just to ease comparing.
    public static boolean binarySearch(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> target) {
        BinaryTreeNode<Integer> current = root;
        while (current != null) {
            if (current.data > target.data) {
                current = current.left;
            } else if (current.data < target.data) {
                current = current.right;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * Given two values that already exist in a binary search tree, find the lowest common ancestor.
     *
     * @param root
     * @param one
     * @param two
     * @return
     */
    //use ints just to ease comparing.
    public static BinaryTreeNode<Integer> lca(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> one, BinaryTreeNode<Integer> two) {
        // Check if one and two are in the root tree.
        while (root != null) {
            if (root.data < one.data && root.data < two.data) {
                root = root.right;
            } else if (root.data > one.data && root.data > two.data) {
                root = root.left;
            } else {
                return root;
            }
        }
        return null;
    }


}