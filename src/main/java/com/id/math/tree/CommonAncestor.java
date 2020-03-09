package com.id.math.tree;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommonAncestor {

    /**
     * Given two nodes that already exist in a binary search tree, find the lowest common ancestor.
     * Use ints just to ease comparing.
     *
     * @param root root elem
     * @param one  1st node
     * @param two  2nd node
     * @return LCA for two nodes in binary search tree or null if there is no such
     */
    private static BinaryTreeNode<Integer> lcaInBinarySearchTree(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> one, BinaryTreeNode<Integer> two) {
        if (root == null || one == null || two == null) {
            return null;
        }
        // Check if one and two are in the same sub-tree.
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

    /**
     * Find lower common ancestor of two arbitrary nodes presented in binary tree.
     *
     * @param root of the
     * @param one  1st node
     * @param two  2nd node
     * @return node that us LCA for both nodes
     */
    private static <T> BinaryTreeNode<T> lca2(BinaryTreeNode<T> root, BinaryTreeNode<T> one, BinaryTreeNode<T> two) {
        if (root == null) {
            return null;
        }
        if (one == root || two == root) {
            return root;
        }
        BinaryTreeNode<T> left = lca2(root.left, one, two);
        BinaryTreeNode<T> right = lca2(root.right, one, two);
        if (left != null && right != null) {
            return root;  // if both nodes and on different sides - we found LCA.
        }
        return left != null ? left : right;
    }

    /**
     * Find lower common ancestor of two arbitrary nodes presented in binary tree.
     * Each node knows it parent only.
     *
     * @param one 1st node
     * @param two 2nd node
     * @return node that us LCA for both nodes
     */
    private static <T> NodeWithParent<T> lca3(NodeWithParent<T> one, NodeWithParent<T> two) {
        if (one == null || two == null) {
            return null;
        }
        NodeWithParent<T> curr = one;
        int dist1 = 0;
        while (curr != null) {
            curr = curr.parent;
            dist1++;
        }
        curr = two;
        int dist2 = 0;
        while (curr != null) {
            curr = curr.parent;
            dist2++;
        }

        NodeWithParent<T> lo;
        NodeWithParent<T> hi;
        if (dist1 - dist2 >= 0) {
            lo = one;
            hi = two;
        } else {
            lo = two;
            hi = one;
        }
        int diff = Math.abs(dist1 - dist2);
        while (diff != 0) {
            lo = lo.parent;
            diff--;
        }

        while (lo != hi) {
            lo = lo.parent;
            hi = hi.parent;
        }
        return lo;
    }

    @Test
    public void testLCA1() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(44);
        BinaryTreeNode<Integer> n2 = new BinaryTreeNode<>(22);
        BinaryTreeNode<Integer> n3 = new BinaryTreeNode<>(56);
        BinaryTreeNode<Integer> n4 = new BinaryTreeNode<>(11);
        BinaryTreeNode<Integer> n5 = new BinaryTreeNode<>(33);
        BinaryTreeNode<Integer> n6 = new BinaryTreeNode<>(66);
        BinaryTreeNode<Integer> n7 = new BinaryTreeNode<>(77);

        root.left = n2;
        root.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.right = n6;
        n6.right = n7;

        assertEquals(n2, lcaInBinarySearchTree(root, n4, n5));
        assertEquals(n6, lcaInBinarySearchTree(root, n6, n7));
        assertEquals(root, lcaInBinarySearchTree(root, n5, n7));
        assertEquals(n5, lcaInBinarySearchTree(root, n5, n5));
    }

    @Test
    public void testLCA2() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> n2 = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> n3 = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> n4 = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> n5 = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> n6 = new BinaryTreeNode<>(6);
        BinaryTreeNode<Integer> n7 = new BinaryTreeNode<>(7);

        root.left = n2;
        root.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.right = n6;
        n6.right = n7;

        assertEquals(n2, lca2(root, n4, n5));
        assertEquals(n6, lca2(root, n6, n7));
        assertEquals(root, lca2(root, n5, n7));
        assertEquals(n5, lca2(root, n5, n5));
    }

    @Test
    public void testLCA3() {
        NodeWithParent<Integer> root = new NodeWithParent<>(null, 1);
        NodeWithParent<Integer> n2 = new NodeWithParent<>(root, 2);
        NodeWithParent<Integer> n3 = new NodeWithParent<>(root, 3);
        NodeWithParent<Integer> n4 = new NodeWithParent<>(n2, 4);
        NodeWithParent<Integer> n5 = new NodeWithParent<>(n2, 5);
        NodeWithParent<Integer> n6 = new NodeWithParent<>(n3, 6);
        NodeWithParent<Integer> n7 = new NodeWithParent<>(n6, 7);

        assertEquals(n2, lca3(n4, n5));
        assertEquals(n6, lca3(n6, n7));
        assertEquals(root, lca3(n5, n7));
        assertEquals(n5, lca3(n5, n5));
    }

}
