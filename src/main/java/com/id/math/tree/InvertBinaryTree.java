package com.id.math.tree;


import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class InvertBinaryTree {

    public <T> void invertTree(BinaryTreeNode<T> root) {
        if (root == null) {
            return;
        }
        BinaryTreeNode<T> tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
    }

    @Test
    public void test() {
        BinaryTreeNode<Integer> t1 = createTree();
        BinaryTreeNode<Integer> t2 = createTree();
        assertTrue(new IsSameTreeCheck().isSameTree(t1, t2));
        invertTree(t2);
        assertFalse(new IsSameTreeCheck().isSameTree(t1, t2));
        invertTree(t2);
        assertTrue(new IsSameTreeCheck().isSameTree(t1, t2));
    }

    private static BinaryTreeNode<Integer> createTree() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(11);
        BinaryTreeNode<Integer> n2 = new BinaryTreeNode<>(22);
        BinaryTreeNode<Integer> n3 = new BinaryTreeNode<>(33);
        BinaryTreeNode<Integer> n4 = new BinaryTreeNode<>(44);
        BinaryTreeNode<Integer> n5 = new BinaryTreeNode<>(55);
        BinaryTreeNode<Integer> n6 = new BinaryTreeNode<>(66);

        root.left = n2;
        root.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.left = n6;
        return root;
    }
}
