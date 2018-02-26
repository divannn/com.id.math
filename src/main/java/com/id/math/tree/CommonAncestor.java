package com.id.math.tree;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommonAncestor {

    /**
     * Given two nodes that already exist in a binary search tree, find the lowest common ancestor.
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


    /**
     * Find lower common acnestor of two arbitrary nodes preseneted in binary tree.
     *
     * @param one
     * @param two
     * @return node that us LCA for both nodes
     */
    public static <T> NodeWithParent<T> lca2(NodeWithParent<T> one, NodeWithParent<T> two) {
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
    public void testLCA2() {
        NodeWithParent<Integer> root = new NodeWithParent<>(null, 1);
        NodeWithParent<Integer> n2 = new NodeWithParent<>(root, 2);
        NodeWithParent<Integer> n3 = new NodeWithParent<>(root, 3);
        NodeWithParent<Integer> n4 = new NodeWithParent<>(n2, 4);
        NodeWithParent<Integer> n5 = new NodeWithParent<>(n2, 5);
        NodeWithParent<Integer> n6 = new NodeWithParent<>(n3, 6);
        NodeWithParent<Integer> n7 = new NodeWithParent<>(n6, 7);

        root.left = n2;
        root.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.right = n6;
        n6.left = n7;

        assertEquals(n2, lca2(n4, n5));
        assertEquals(n6, lca2(n6, n7));
        assertEquals(root, lca2(n5, n7));
    }

}
