package w1.task3;


import w1.task3.WeightedGraph.Edge;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Finds MST using Prim's algorithm.
 *
 * @author idanilov
 *         <p/>
 *         Input: edges.txt
 *         Correct answers are: 3612829
 */
public class Prim {

	private Edge[] edgeTo;        // edgeTo[v] = shortest edge from tree vertex to non-tree vertex
	private int[] distTo;      // distTo[v] = weight of shortest such edge
	private boolean[] marked;     // marked[v] = true if v on tree, false otherwise
	private IndexMinPQ<Integer> pq;

	public Prim(WeightedGraph G) {
		int n = G.V() + 1;//don't use 0 index for simplicity.
		edgeTo = new WeightedGraph.Edge[n];
		distTo = new int[n];
		marked = new boolean[n];
		pq = new IndexMinPQ<>(n);
		for (int v = 0; v < n; v++) {
			distTo[v] = Integer.MAX_VALUE;
		}

		prim(G, 1);
		/*for (int v = 0; v < n; v++)      // run from each vertex to find
		{
			if (!marked[v]) {
				prim(G, v);      // minimum spanning forest
			}
		}*/

	}


	private void prim(WeightedGraph G, int s) {
		distTo[s] = 0;
		pq.insert(s, distTo[s]);
		while (!pq.isEmpty()) {
			int v = pq.delMin();
			scan(G, v);
		}
	}

	// scan vertex v
	private void scan(WeightedGraph G, int v) {
		marked[v] = true;
		for (Edge e : G.adj(v)) {
			int w = e.other(v);
			if (marked[w]) {
				continue;         // v-w is obsolete edge
			}
			if (e.weight() < distTo[w]) {
				distTo[w] = e.weight();
				edgeTo[w] = e;
				if (pq.contains(w)) {
					pq.change(w, distTo[w]);
				} else {
					pq.insert(w, distTo[w]);
				}
			}
		}
	}

	// return iterator of edges in MST
	private Iterable<Edge> edges() {
		ArrayList<Edge> mst = new ArrayList<>();
		for (int v = 0; v < edgeTo.length; v++) {
			Edge e = edgeTo[v];
			if (e != null) {
				mst.add(e);
			}
		}
		return mst;
	}

	// return weight of MST
	private int weight() {
		int weight = 0;
		for (Edge e : edges()) {
			weight += e.weight();
		}
		return weight;
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.err.println("WeightedGraph:");
		WeightedGraph g = WeightedGraph.readGraph(
				w1.task3.Prim.class.getResourceAsStream("edges.txt"));
		//KCluster.class.getResourceAsStream("6.txt")); //additional test cases.

		Prim prim = new Prim(g);
		System.err.println("W:" + prim.weight());
/*
		for (Line next : prim.edges()) {
			System.err.println(">>> " + next);
		}
*/

	}

}
