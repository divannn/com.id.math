package w6;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Represents description of 2-SAT probem.
 */
public class SatProblem {

	private final int N;
	private List<Integer>[] graph;

	public SatProblem(int N) {
		this.N = N;
		int n = 2 * N;
		graph = new List[n];

		for (int i = 0; i < n; i++) {
			graph[i] = new ArrayList<>();
		}
	}

	public int N() {
		return N;
	}

	public List<Integer>[] G() {
		return graph;
	}

	private static int index(int v) {
		return (Math.abs(v) - 1) * 2;
	}

	private void addEdge(int v1, int v2) {
		int ind1 = index(v1);
		int x1 = v1 > 0 ? ind1 : ind1 + 1;
		int nx1 = v1 > 0 ? ind1 + 1 : ind1;

		int ind2 = index(v2);
		int x2 = v2 > 0 ? ind2 : ind2 + 1;
		int nx2 = v2 > 0 ? ind2 + 1 : ind2;

		graph[nx1].add(x2);
		graph[nx2].add(x1);
	}

	public static SatProblem read(InputStream is) {
		int N = 0;
		Scanner fileScanner = new Scanner(is);
		if (fileScanner.hasNextInt()) {
			N = fileScanner.nextInt();
			//System.err.println("N " + N);
		}
		SatProblem result = new SatProblem(N);

		while (fileScanner.hasNextLine()) {
			String str = fileScanner.nextLine();
			Scanner lineScanner = new Scanner(str);
			if (lineScanner.hasNextInt()) {
				int v1 = lineScanner.nextInt();
				if (lineScanner.hasNextInt()) {
					int v2 = lineScanner.nextInt();
					//System.err.println(">>   " + (v1) + " " + (v2));
					result.addEdge(v1, v2);
				}
			}
			lineScanner.close();
		}
		fileScanner.close();
		return result;
	}

}
