package com.id.math.cursera_algo1.w3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
	//number of vertices.
	private final int n;
	private final LinkedList<Node>[] arr;

	private ArrayList<Pair> edges = new ArrayList<Pair>(1000);

	public Graph(int N) {
		n = N;
		arr = new LinkedList[n];
		for (int i = 0; i < N; i++) {
			arr[i] = new LinkedList<Node>();
		}
	}

	public LinkedList<Node> getAjacentVertices(int v) {
		return arr[v];
	}

	public int edgesSize() {
		return edges.size();
	}

	public Pair getEdge(int ind) {
		return edges.get(ind);
	}

	public void addEdge(int v1, int v2) {
		Node node = new Node(v2);
		arr[v1 - 1].add(node);

		//---------------------------
		Pair p = new Pair(v1, v2);
		int ind = edges.indexOf(p);
		if (ind >= 0) {
			p = edges.get(ind);
			//p.num++;
		} else {
			edges.add(p);
		}
	}

	public void removeEdge(Pair p) {
		edges.remove(p);
	}

	public void merge(Pair p, int ind) {
		edges.remove(ind);
		/*int xxx = ind;
		while (xxx >= 0) {
			edges.remove(xxx);
			xxx = edges.indexOf(p);
		}*/
		Iterator<Pair> it = edges.iterator();
		while (it.hasNext()) {
			Pair n = it.next();
			if (p.v2 == n.v1 || p.v2 == n.v2) {
				if (p.v2 == n.v1) {
					int has = edges.indexOf(new Pair(p.v1, n.v2));
					if (has >= 0) {
						Pair existed = edges.get(has);
						existed.num += n.num;
						it.remove();
					} else {
						n.v1 = p.v1;
					}
				} else if (p.v2 == n.v2) {
					int has = edges.indexOf(new Pair(p.v1, n.v1));
					if (has >= 0) {
						Pair existed = edges.get(has);
						existed.num += n.num;
						it.remove();
					} else {
						n.v2 = p.v1;
					}
				}
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			sb.append(i + 1 + " : ");
			LinkedList<Node> n = arr[i];
			Iterator<Node> it = n.iterator();
			while (it.hasNext()) {
				sb.append(it.next().vertexNum + " ");
			}
			sb.append("\n\r");
		}
		return sb.toString();
	}

	public String toString2() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < edges.size(); i++) {
			sb.append(i + 1 + " : (" + edges.get(i));
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

	public static class Pair {
		public int v1;//vertex 1
		public int v2;//vertex 2

		public int num; //number of edges (multigraph)

		public Pair(int v1, int v2) {
			this(v1, v2, 1);
		}

		public Pair(int v1, int v2, int num) {
			this.v1 = v1;
			this.v2 = v2;
			this.num = num;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) {
				return true;
			}
			if (o == null || getClass() != o.getClass()) {
				return false;
			}
			Pair pair = (Pair) o;
			/*if (v1 != pair.v1) {
				return false;
			}
			if (v2 != pair.v2) {
				return false;
			}
			return true;
			*/
			if ((v1 == pair.v1 || v1 == pair.v2)
					&& (v2 == pair.v1 || v2 == pair.v2)) {
				return true;
			}
			return false;
		}

		@Override
		public int hashCode() {
			int result = v1;
			result = 31 * result + v2;
			return result;
		}

		@Override
		public String toString() {
			return "Pair{" +
					"v1=" + v1 +
					", v2=" + v2 +
					", num=" + num +
					'}';
		}
	}
}
