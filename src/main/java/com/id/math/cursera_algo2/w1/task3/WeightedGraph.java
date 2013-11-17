package w1.task3;

import java.io.InputStream;
import java.util.LinkedList;
import java.util.Scanner;

public class WeightedGraph {

	private final int V;
	private final int E;
	private LinkedList<Edge>[] adj;

	public WeightedGraph(int V, int E) {
		this.V = V;
		this.E = E;
		int n = V + 1;//don't use 0 index for simplicity.
		adj = new LinkedList[n];
		for (int i = 1; i < n; i++) {
			adj[i] = new LinkedList<Edge>();
		}
	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

	public void addEdge(Edge e) {
		int v = e.either(), w = e.other(v);
		adj[v].add(e);
		adj[w].add(e);
	}

	public Iterable<Edge> adj(int v) {
		return adj[v];
	}

	/*@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			for (int i = 1; i < arr.length; i++) {
				sb.append(i + " : ");
				LinkedList<Node> list = arr[i];
				Iterator<Node> it = list.iterator();
				while (it.hasNext()) {
					Node n = it.next();
					sb.append("(" + n.vertex + "," + n.weight + ")").append(" ");
				}
				sb.append("\n\r");
			}
			return sb.toString();
		}*/

	public Iterable<Edge> edges() {
		LinkedList<Edge> list = new LinkedList<Edge>();
		for (int v = 0; v < V; v++) {
			int selfLoops = 0;
			for (Edge e : adj(v)) {
				if (e.other(v) > v) {
					list.add(e);
				}
				// only add one copy of each self loop
				else if (e.other(v) == v) {
					if (selfLoops % 2 == 0) {
						list.add(e);
					}
					selfLoops++;
				}
			}
		}
		return list;
	}

	public static WeightedGraph readGraph(InputStream is) {
		int V = 0;
		Scanner fileScanner = new Scanner(is);
		if (fileScanner.hasNextInt()) {
			V = fileScanner.nextInt();
			System.err.println("V " + V);
		}
		int E = 0;
		if (fileScanner.hasNextInt()) {
			E = fileScanner.nextInt();
			System.err.println("E " + E);
		}
		WeightedGraph result = new WeightedGraph(V, E);

		while (fileScanner.hasNextLine()) {
			String str = fileScanner.nextLine();
			Scanner lineScanner = new Scanner(str);
			if (lineScanner.hasNextInt()) {
				int v1 = lineScanner.nextInt();
				if (lineScanner.hasNextInt()) {
					int v2 = lineScanner.nextInt();
					if (lineScanner.hasNextInt()) {
						int weight = lineScanner.nextInt();
						result.addEdge(new Edge(v1, v2, weight));
						//System.err.println(">>   " + v1 + " " + v2 + "  " + weight);
					}
				}
			}
			lineScanner.close();
		}
		fileScanner.close();
		return result;
	}

	public static class Edge implements Comparable<Edge> {
		private final int v, w;
		private final int weight;

		public Edge(int v, int w, int weight) {
			this.v = v;
			this.w = w;
			this.weight = weight;
		}

		public int weight() {
			return weight;
		}

		public int either() {
			return v;
		}

		public int other(int vertex) {
			if (vertex == v) {
				return w;
			} else {
				return v;
			}
		}

		public int compareTo(Edge that) {
			if (this.weight < that.weight) {
				return -1;
			} else if (this.weight > that.weight) {
				return +1;
			} else {
				return 0;
			}
		}
	}

}
