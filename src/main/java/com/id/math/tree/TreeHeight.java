package com.id.math.tree;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TreeHeight {


    /**
     * Find height of binary tree.
     *
     * @param root
     * @return height of tree staring from 1
     */
    public static <T> int treeHeight(BinaryTreeNode<T> root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(treeHeight(root.left), treeHeight(root.right));
    }


    @Test
    public void test() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> n2 = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> n3 = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> n4 = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> n5 = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> n6 = new BinaryTreeNode<>(6);
        BinaryTreeNode<Integer> n7 = new BinaryTreeNode<>(7);

        root.left = n2;
        root.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.right = n6;
        n6.left = n7;

        assertEquals(4, treeHeight(root));
        assertEquals(1, treeHeight(n7));
    }

}
