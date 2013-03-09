package com.id.math.cursera_algo1.w3;


import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Random;
import java.util.Scanner;

/**
 * Counts min cut for graph by Karger's algorithm.
 *
 * @author idanilov
 *         <p/>
 *         Correct answers are:
 */

public class KargerMinCutCount {

	public static void main(String[] args) throws FileNotFoundException {
		int N = 20;
		int min = 1000;
		for (int i = 0; i < 50; i++) {
			Graph g = readGraph(
					//KargerMinCutCount.class.getResourceAsStream("kargerMinCut.txt"), N);
					KargerMinCutCount.class.getResourceAsStream("5.txt"), N);
			//System.err.println("Graph:");
			//System.err.println(g);
			//System.err.println(g.toString2());

			int min_cut = findMinCut(g);
			if (min_cut < min) {
				min = min_cut;
			}
			//System.err.println(g.toString2());
			//System.err.println("Min cut: " + min_cut);
		}
		System.err.println("Min cut: " + min);
	}

	private static int findMinCut(Graph g) {
		while (g.edgesSize() > 1) {
			int edgeInd = chooseRandomly(g.edgesSize());
			//int edgeInd = 0;
			//System.err.println("chosen ind: " + edgeInd);
			Graph.Pair edge = g.getEdge(edgeInd);
			//System.err.println("p : " + edge);
			g.merge(edge, edgeInd);
		}
		return g.getEdge(0).num;
	}

	/*static Random rand = new Random();

	static {
		rand.nextInt();
	}*/

	private static int chooseRandomly(int n) {
		Random rand = new Random();
		int r = rand.nextInt(n);
		return r;
	}

	private static Graph readGraph(InputStream is, int vertexNumber) {
		Graph result = new Graph(vertexNumber);
		Scanner fileScanner = new Scanner(is);
		int i = 0;
		while (fileScanner.hasNextLine() && i < vertexNumber) {
			String str = fileScanner.nextLine();
			Scanner lineScanner = new Scanner(str);
			int v = -1;//suppose we have only positive numbers.
			if (lineScanner.hasNext()) {
				v = lineScanner.nextInt();
			}
			if (v != -1) {
				while (lineScanner.hasNextInt()) {
					int nextInt = lineScanner.nextInt();
					result.addEdge(v, nextInt);
				}
			}
			lineScanner.close();
			i++;
		}
		fileScanner.close();
		return result;
	}

}
