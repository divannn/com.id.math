package com.id.math.tree;

import org.junit.Assert;
import org.junit.Test;

public class IsValidBinarySearchTree {

    /**
     * Algorithm: DFS
     * @time O(n)
     * @space O(n) (recursion)
     *
     * @param root - root of tree
     * @return true if tree is valid binary search tree
     */
    public boolean isValidBinarySearchTree(BinaryTreeNode<Integer> root) {
        return validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean validate(BinaryTreeNode<Integer> root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if (root.data <= min || root.data >= max) {
            return false;
        }
        return validate(root.left, min, root.data) && validate(root.right, root.data, max);
    }

    @Test
    public void testEqual() {
        Assert.assertTrue(isValidBinarySearchTree(createTree()));
    }

    @Test
    public void testNotEqual() {
        Assert.assertFalse(isValidBinarySearchTree(createTree2()));
    }

    private static BinaryTreeNode<Integer> createTree() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(44);
        BinaryTreeNode<Integer> n2 = new BinaryTreeNode<>(22);
        BinaryTreeNode<Integer> n3 = new BinaryTreeNode<>(55);
        BinaryTreeNode<Integer> n4 = new BinaryTreeNode<>(11);
        BinaryTreeNode<Integer> n5 = new BinaryTreeNode<>(33);
        BinaryTreeNode<Integer> n6 = new BinaryTreeNode<>(66);

        root.left = n2;
        root.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.right = n6;
        return root;
    }

    private static BinaryTreeNode<Integer> createTree2() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> n2 = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> n3 = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> n4 = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> n5 = new BinaryTreeNode<>(4);

        root.left = n2;
        root.right = n3;

        n2.left = n4;
        n2.right = n5;

        return root;
    }

}