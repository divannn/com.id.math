package com.id.math.graphs;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph {

    private int n; //number of vertices.
    private LinkedList<Node>[] adjacencyList;

    public Graph(int N) {
        n = N;
        adjacencyList = new LinkedList[n];
        for (int i = 0; i < N; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public LinkedList<Node> getAdjacentVertices(int v) {
        return adjacencyList[v];
    }

    public void addEdge(int v1, int v2) {
        Node node2 = new Node(v2);
        adjacencyList[v1].add(node2);

        //for undirected graph uncomment
        //Node node1 = new Node(v1);
        //adjacencyList[v2].add(node1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < adjacencyList.length; i++) {
            sb.append(i + 1 + " : ");
            LinkedList<Node> n = adjacencyList[i];
            Iterator<Node> it = n.iterator();
            while (it.hasNext()) {
                sb.append(it.next().vertexNum + " ");
            }
            sb.append("\n\r");
        }
        return sb.toString();
    }

    public static class Node {
        public int vertexNum;
        public int count;

        public Node(int vertexNum) {
            this(vertexNum, 1);
        }

        public Node(int vertexNum, int count) {
            this.vertexNum = vertexNum;
            this.count = count;
        }
    }

}