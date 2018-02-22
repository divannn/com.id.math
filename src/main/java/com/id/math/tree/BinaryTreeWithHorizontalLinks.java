package com.id.math.tree;

import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertTrue;

public class BinaryTreeWithHorizontalLinks {

    private static class NodeWithNeighbour<T> extends BinaryTreeNode<T> {

        BinaryTreeNode<T> neighbour;
        int level = 0;//level in the tree.

        public NodeWithNeighbour(T v) {
            super(v);
        }
    }

    /**
     * Прошить бинарное дерево горизонтальными связями.
     * То есть так, чтобы узлы на каждом уровне представляли собой связный список.
     * НАпример для дерева:
     *             1
     *         2      3
     *       4  5       6
     *
     *       Спсики по уровням
     *       1-> null
     *       2 -> 3 -> null
     *       4 -> 5 -> 6 -> null
     * @param root - root of the tree
     */
    private static void buildLinksByLevel(NodeWithNeighbour root) {
        //let's use BFS by level
        LinkedList<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            NodeWithNeighbour curr = (NodeWithNeighbour) queue.remove();
            NodeWithNeighbour next = (NodeWithNeighbour) queue.peek();
            if (next != null && next.level == curr.level) {
                curr.neighbour = next;
            }
            //update level of children.
            if (curr.left != null) {
                queue.add(curr.left);
                ((NodeWithNeighbour) curr.left).level = curr.level + 1;
            }
            if (curr.right != null) {
                queue.add(curr.right);
                ((NodeWithNeighbour) curr.right).level = curr.level + 1;
            }
        }
    }

    @Test
    public void test() {
        NodeWithNeighbour r = createTree();
        buildLinksByLevel(r);
        NodeWithNeighbour<Integer> n2 = (NodeWithNeighbour<Integer>) r.left;
        NodeWithNeighbour<Integer> n3 = (NodeWithNeighbour<Integer>) r.right;
        NodeWithNeighbour<Integer> n4 = (NodeWithNeighbour) n2.left;
        NodeWithNeighbour<Integer> n5 = (NodeWithNeighbour) n2.right;
        NodeWithNeighbour<Integer> n6 = (NodeWithNeighbour) n3.right;
        assertTrue(n2.neighbour == n3);
        assertTrue(n3.neighbour == null);
        assertTrue(n4.neighbour == n5);
        assertTrue(n5.neighbour == n6);
        assertTrue(n6.neighbour == null);
    }

    private static NodeWithNeighbour<Integer> createTree() {
        NodeWithNeighbour<Integer> root = new NodeWithNeighbour<>(1);
        NodeWithNeighbour<Integer> n2 = new NodeWithNeighbour<>(2);
        NodeWithNeighbour<Integer> n3 = new NodeWithNeighbour<>(3);
        NodeWithNeighbour<Integer> n4 = new NodeWithNeighbour<>(4);
        NodeWithNeighbour<Integer> n5 = new NodeWithNeighbour<>(5);
        NodeWithNeighbour<Integer> n6 = new NodeWithNeighbour<>(6);

        root.left = n2;
        root.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.right = n6;
        return root;
    }

}
