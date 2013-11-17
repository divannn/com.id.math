package w6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//[ID] not mine.
/**
 * Calculates 2-SAT problem by mapping it finding SCC (strongly connected components via DFS).
 * <p/>
 * Input: 2sat1.txt - sat.
 * Input: 2sat2.txt - unsat.
 * Input: 2sat3.txt - sat.
 * Input: 2sat4.txt - sat.
 * Input: 2sat5.txt - nonsat.
 * Input: 2sat6.txt - nonsat.
 * <p/>
 *
 * Note: Requires 1GB of heap memory to finish 5 and 6 inputs.
 */
public class TwoSat {

	static void dfs1(List<Integer>[] graph, boolean[] used, List<Integer> order, int u) {
		used[u] = true;
		for (int v : graph[u]) {
			if (!used[v]) {
				dfs1(graph, used, order, v);
			}
		}
		order.add(u);
	}

	static void dfs2(List<Integer>[] reverseGraph, int[] comp, int u, int color) {
		comp[u] = color;
		for (int v : reverseGraph[u]) {
			if (comp[v] == -1) {
				dfs2(reverseGraph, comp, v, color);
			}
		}
	}

	public static boolean[] solve2Sat(List<Integer>[] graph) {
		int n = graph.length;
		boolean[] used = new boolean[n];
		List<Integer> order = new ArrayList<>();
		for (int i = 0; i < n; ++i) {
			if (!used[i]) {
				dfs1(graph, used, order, i);
			}
		}

		List<Integer>[] reverseGraph = new List[n];
		for (int i = 0; i < n; i++) {
			reverseGraph[i] = new ArrayList<>();
		}
		for (int i = 0; i < n; i++) {
			for (int j : graph[i]) {
				reverseGraph[j].add(i);
			}
		}

		int[] comp = new int[n];
		Arrays.fill(comp, -1);
		for (int i = 0, color = 0; i < n; ++i) {
			int u = order.get(n - i - 1);
			if (comp[u] == -1) {
				dfs2(reverseGraph, comp, u, color++);
			}
		}

		for (int i = 0; i < n; ++i) {
			if (comp[i] == comp[i ^ 1]) {
				return null;
			}
		}

		boolean[] res = new boolean[n / 2];
		for (int i = 0; i < n; i += 2) {
			res[i / 2] = comp[i] > comp[i ^ 1];
		}

		return res;
	}

	private static boolean[] test1() {
		int n = 6;
		List<Integer>[] g = new List[n];
		for (int i = 0; i < n; i++) {
			g[i] = new ArrayList<>();
		}
		// (a || b) && (b || !c)
		// (x1 | x2) & (x2 | !x3)
		// !a => b
		// !b => a
		// !b => !c
		// c => b
		int a = 0, na = 1, b = 2, nb = 3, c = 4, nc = 5;
		g[na].add(b);
		g[nb].add(a);
		g[nb].add(nc);
		g[c].add(b);

		return solve2Sat(g);
	}

	public static void main(String[] args) {
		//boolean[] r1 = test1();
		//System.err.println(Arrays.toString(r1));

		SatProblem p1 = SatProblem.read(TwoSat.class.getResourceAsStream("2sat6.txt"));
		boolean[] solution = solve2Sat(p1.G());
		if (solution == null) {
			System.err.println("NOT SATISFIABLE");
		} else {
			System.err.println("SATISFIABLE");
			//System.err.println(Arrays.toString(solution));
		}
	}
}
