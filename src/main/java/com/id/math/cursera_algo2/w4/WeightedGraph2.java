package w4;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Adjacency matrix graph representation.
 */
public class WeightedGraph2 {

	private final int V;
	private final int E;
	private final int[][] m;

	public WeightedGraph2(int V, int E) {
		this.V = V;
		this.E = E;
		int n = V + 1;//don't use 0 index for simplicity.
		m = new int[n][n];

		//init cells with +Infinity.
		for (int i = 1; i < n; i++) {
			Arrays.fill(m[i], Integer.MAX_VALUE);
		}
	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

	public int[][] M() {
		return m;
	}

	private void addEdge(Edge e) {
		int v1 = e.either(), v2 = e.other(v1);
		m[v1][v2] = e.weight;
	}

	/*@Override
	   public String toString() {
		   StringBuilder sb = new StringBuilder();
		   for (int i = 1; i < arr.length; i++) {
			   sb.append(i + " : ");
			   LinkedList<ListNode> linkedlist = arr[i];
			   Iterator<ListNode> it = linkedlist.iterator();
			   while (it.hasNext()) {
				   ListNode n = it.next();
				   sb.append("(" + n.vertex + "," + n.weight + ")").append(" ");
			   }
			   sb.append("\n\r");
		   }
		   return sb.toString();
	   }*/

	public static WeightedGraph2 readGraph(InputStream is) {
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
		WeightedGraph2 result = new WeightedGraph2(V, E);

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
						System.err.println(">>   " + v1 + " " + v2 + "  " + weight);
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
