package com.id.math.graphs;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * https://www.algoexpert.io/questions/River%20Sizes
 * You are given a two-dimensional array of potentially unequal height and width. It contains only 0s and 1s.
 * This array represents a map: 0s are land, and 1s are water. A "river" on this map consists of any number of contiguous,
 * adjacent water squares, where "adjacent" means "above", "below", "to the left of", or "to the right of" (that is, diagonal squares are not adjacent).
 * Write a function which returns an array of the sizes of all rivers represented in the input matrix.
 * Note that these sizes do not need to be in any particular order.
 *
 * Example:
 *  [1, 0, 0, 1, 0],
 *  [1, 0, 1, 0, 0],
 *  [0, 0, 1, 0, 1],
 *  [1, 0, 1, 0, 1],
 *  [1, 0, 1, 1, 0],
 *
 * Output: [1, 2, 2, 2, 5] (items can be in any order)
 *
 *@time O(MxN)
 *@space O(MxN)
 *
 */
public class RiverSize {
    public static List<Integer> findRiverSizes(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        //remember visited nodes.
        boolean[][] visited = new boolean[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            visited[i] = new boolean[matrix[i].length];
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (!visited[i][j]) {
                    //represent each point in matrix as graph node (M x N nodes in total) - traverse graph by DFS or BFS.
                    traverseNode(new Node(i, j), matrix, visited, result);
                }
            }
        }
        return result;
    }

    //use DFS to traverse.
    private static void traverseNode(Node currentNode, int[][] matrix, boolean[][] visited, List<Integer> result) {
        int currRiverSize = 0;
        Stack<Node> stack = new Stack<>();
        stack.add(currentNode);
        while (!stack.empty()) {
            Node node = stack.pop();
            if (visited[node.i][node.j]) {
                continue;
            }
            visited[node.i][node.j] = true;
            if (matrix[node.i][node.j] == 0) {
                continue;
            }
            currRiverSize += 1;
            List<Node> unvisitedNeighbours = getUnvisitedNeighbours(node, matrix, visited);
            stack.addAll(unvisitedNeighbours);
        }
        if (currRiverSize > 0) {
            result.add(currRiverSize);
        }
    }

    //maximum can be 4  neighbours (top, left, right, bottom)
    private static List<Node> getUnvisitedNeighbours(Node node, int[][] matrix, boolean[][] visited) {
        List<Node> result = new ArrayList<>(4);
        if (node.i > 0 && !visited[node.i - 1][node.j]) {
            result.add(new Node(node.i - 1, node.j));
        }
        if (node.i < matrix.length - 1 && !visited[node.i + 1][node.j]) {
            result.add(new Node(node.i + 1, node.j));
        }
        if (node.j > 0 && !visited[node.i][node.j - 1]) {
            result.add(new Node(node.i, node.j - 1));
        }
        if (node.j < matrix[node.i].length - 1 && !visited[node.i][node.j + 1]) {
            result.add(new Node(node.i, node.j + 1));
        }
        return result;
    }

    private static class Node {
        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }

        int i;
        int j;
    }

    @Test
    public void test() {
        int[][] m1 = {
                {0},
                {0},
        };
        List<Integer> r1 = findRiverSizes(m1);
        System.err.println(r1);
        int[][] m2 = {
                {1},
                {1},
                {0},
        };
        List<Integer> r2 = findRiverSizes(m2);
        System.err.println(r2);
        int[][] m3 = {
                {1, 0, 0, 1, 0},
                {1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 0},
        };
        List<Integer> r3 = findRiverSizes(m3);
        System.err.println(r3);
    }
}
