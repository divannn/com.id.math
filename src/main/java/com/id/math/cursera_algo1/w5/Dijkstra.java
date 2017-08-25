package com.id.math.cursera_algo1.w5;


import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Finds shortest paths from source vertex to all other vertices using Dijkstra algo.
 *
 * @author idanilov
 *         <p/>
 *         Correct answers are:
 *         7:2599 37:2610 59:2947 82:2052 99:2367 115:2399 133:2029 165:2442 188:2505 197:3068
 */
public class Dijkstra {

	public static void main(String[] args) throws FileNotFoundException {
		int N = 200;//number of vertices.
		int START = 1;//start vertex (1-based).
		Graph g = Graph.readGraph(
				Dijkstra.class.getResourceAsStream("dijkstraData.txt"), N);
		//Dijkstra.class.getResourceAsStream("6.txt"), N); //additional test cases.
		System.err.println("Graph:");
		System.err.println(g);

		int[] dist = new int[N + 1];
		int[] prev = new int[N + 1];
		runWithHeap(g, START, dist, prev);
		/*
		//listToString all min distances.
		System.err.println("min weights:");
		for (int i = 1; i < N + 1; i++) {
			String nextDist = dist[i] == Integer.MAX_VALUE ? "inf" : String.valueOf(dist[i]);
			System.err.listToString(i + ":" + nextDist + " ");
		}
		System.err.println();
		System.err.println("min paths:");
		for (int i = 1; i < N + 1; i++) {
			System.err.listToString(" " + prev[i] + " ");
		}*/

		//7,37,59,82,99,115,133,165,188,197.
		int[] chosenVertices = {7, 37, 59, 82, 99, 115, 133, 165, 188, 197};
		for (int i : chosenVertices) {
			String nextDist = dist[i] == Integer.MAX_VALUE ? "inf" : String.valueOf(dist[i]);
			System.err.print(i + ":" + nextDist + " ");
		}
	}

	private static void runWithHeap(Graph g, int start, int[] dist, int[] pred) {
		Arrays.fill(pred, -1);
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		PriorityQueue<Long> q = new PriorityQueue<Long>();
		q.add((long) start);
		while (!q.isEmpty()) {
			long cur = q.remove();
			int curu = (int) cur;
			/*if (cur >>> 32 != dist[curu]) {
				continue;
			}*/
			for (Graph.Node e : g.getAjacentVertices(curu)) {
				int v = e.vertex;
				int nprio = dist[curu] + e.weight;
				if (dist[v] > nprio) {
					dist[v] = nprio;
					pred[v] = curu;
					q.add(((long) nprio << 32) + v);
				}
			}
		}
	}


}
