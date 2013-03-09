package com.id.math.cursera_algo1.w5;

import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Graph {
	//number of vertices.
	private int n;//start index from 1.
	private LinkedList<Node>[] arr;

	public Graph(int N) {
		n = N + 1;//don't use 0 index for simplicity.
		arr = new LinkedList[n];
		for (int i = 1; i < n; i++) {
			arr[i] = new LinkedList<Node>();
		}
	}

	public int getN() {
		return n;
	}

	public LinkedList<Node> getAjacentVertices(int v) {
		return arr[v];
	}

	public void addEdge(int fromV, int toV, int w) {
		Node node = new Node(toV, w);
		arr[fromV].add(node);
	}

	@Override
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
	}

	public static Graph readGraph(InputStream is, int vertexNumber) {
		Graph result = new Graph(vertexNumber);
		Scanner fileScanner = new Scanner(is);
		int i = 0;
		while (fileScanner.hasNextLine() && i < vertexNumber) {
			String str = fileScanner.nextLine();
			Scanner lineScanner = new Scanner(str);//default delimiter is whitespace.
			int v = -1;//suppose we have only positive numbers.
			if (lineScanner.hasNext()) {
				v = lineScanner.nextInt();
			}
			if (v != -1) {
				//System.err.print("row " + v + ":");
				while (lineScanner.hasNext()) {
					String nextTuple = lineScanner.next();
					if (nextTuple != null && !nextTuple.equals("")) {
						//System.err.print(nextTuple + "|");
						String[] pair = nextTuple.split(",");
						int destV = Integer.parseInt(pair[0]);
						int weight = Integer.parseInt(pair[1]);
						result.addEdge(v, destV, weight);
					}
				}
			}
			//System.err.println();
			lineScanner.close();
			i++;
		}
		fileScanner.close();
		return result;
	}

	public static class Node {
		public int vertex;
		public int weight;

		public Node(int vertex, int count) {
			this.vertex = vertex;
			this.weight = count;
		}
	}


}
