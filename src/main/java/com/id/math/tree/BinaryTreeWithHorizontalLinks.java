package com.id.math.tree;

import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class BinaryTreeWithHorizontalLinks {

    private static class NodeWithNeighbour<T> extends BinaryTreeNode<T> {

        BinaryTreeNode<T> neighbour;
        int level = -1;//node level in the tree.

        private NodeWithNeighbour(T v) {
            super(v);
        }
    }

    /**
     * Прошить бинарное дерево горизонтальными связями.
     * То есть так, чтобы узлы на каждом уровне представляли собой связный список.
     * Например, для дерева:
     *          1
     *        /   \
     *      2       3
     *    /  \        \
     *  4    5        6
     * /
     * 7
     * Списки по уровням:
     * 1-> null
     * 2 -> 3 -> null
     * 4 -> 5 -> 6 -> null
     * 7 -> null
     *
     * @param root - root of the tree
     */
    private static void buildLinksByLevel(NodeWithNeighbour<Integer> root) {
        //let's use BFS by level
        LinkedList<NodeWithNeighbour<Integer>> queue = new LinkedList<>();
        root.level = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            NodeWithNeighbour<Integer> curr = queue.remove();
            NodeWithNeighbour<Integer> next = queue.peek();
            if (next != null && next.level == curr.level) {
                curr.neighbour = next;
            }
            //update level of children
            NodeWithNeighbour<Integer> left = (NodeWithNeighbour<Integer>)curr.left;
            if (left != null) {
                queue.add(left);
                left.level = curr.level + 1;
            }
            NodeWithNeighbour<Integer> right = (NodeWithNeighbour<Integer>) curr.right;
            if (right != null) {
                queue.add(right);
                right.level = curr.level + 1;
            }
        }
    }

    @Test
    public void test() {
        NodeWithNeighbour<Integer> r = createTree();
        buildLinksByLevel(r);
        NodeWithNeighbour<Integer> n2 = (NodeWithNeighbour<Integer>) r.left;
        NodeWithNeighbour<Integer> n3 = (NodeWithNeighbour<Integer>) r.right;
        NodeWithNeighbour<Integer> n4 = (NodeWithNeighbour<Integer>) n2.left;
        NodeWithNeighbour<Integer> n5 = (NodeWithNeighbour<Integer>) n2.right;
        NodeWithNeighbour<Integer> n6 = (NodeWithNeighbour<Integer>) n3.right;
        NodeWithNeighbour<Integer> n7 = (NodeWithNeighbour<Integer>) n6.left;
        assertSame(n2.neighbour, n3);
        assertNull(n3.neighbour);
        assertEquals(n4.neighbour, n5);
        assertEquals(n5.neighbour, n6);
        assertNull(n6.neighbour);
        assertNull(n7.neighbour);
    }

    private static NodeWithNeighbour<Integer> createTree() {
        NodeWithNeighbour<Integer> root = new NodeWithNeighbour<>(1);
        NodeWithNeighbour<Integer> n2 = new NodeWithNeighbour<>(2);
        NodeWithNeighbour<Integer> n3 = new NodeWithNeighbour<>(3);
        NodeWithNeighbour<Integer> n4 = new NodeWithNeighbour<>(4);
        NodeWithNeighbour<Integer> n5 = new NodeWithNeighbour<>(5);
        NodeWithNeighbour<Integer> n6 = new NodeWithNeighbour<>(6);
        NodeWithNeighbour<Integer> n7 = new NodeWithNeighbour<>(7);

        root.left = n2;
        root.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.right = n6;
        n6.left = n7;
        return root;
    }

}