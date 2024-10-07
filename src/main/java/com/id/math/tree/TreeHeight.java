package com.id.math.tree;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TreeHeight {

    /**
     * Find height of binary tree.
     *
     * @param root root
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
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(111);
        BinaryTreeNode<Integer> n2 = new BinaryTreeNode<>(222);
        BinaryTreeNode<Integer> n3 = new BinaryTreeNode<>(333);
        BinaryTreeNode<Integer> n4 = new BinaryTreeNode<>(444);
        BinaryTreeNode<Integer> n5 = new BinaryTreeNode<>(555);
        BinaryTreeNode<Integer> n6 = new BinaryTreeNode<>(666);
        BinaryTreeNode<Integer> n7 = new BinaryTreeNode<>(777);

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