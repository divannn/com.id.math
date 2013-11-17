package w4;


import java.io.FileNotFoundException;

/**
 * Finds all-shortest paths using Floyd-Warshall algorithm.
 *
 * @author idanilov
 *         <p/>
 *         Input1: g1.txt - negative cycle.
 *         Input1: g2.txt - negative cycle.
 *         Input1: g3.txt - -19.
 */
public class FloydWarshall {

	private int[][][] d;
	private WeightedGraph2 graph;

	public FloydWarshall(WeightedGraph2 G) {
		graph = G;
		int n = G.V() + 1;//don't use 0 index for simplicity.
		d = new int[n][n][n];
		//System.err.println("init ---");
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < n; j++) {
				d[i][j][0] = (i == j) ? 0 : G.M()[i][j];
				//System.err.print(d[i][j][0] + " ");
			}
			//System.err.println();
		}
	}

    //brute-force space consuming version.
    //Requires lots  of memory: pass -Xmx8000m to JVM.
	private void solve() {
		for (int k = 1; k <= graph.V(); k++) {
			for (int i = 1; i <= graph.V(); i++) {
				for (int j = 1; j <= graph.V(); j++) {
					long sum = (long) d[i][k][k - 1] + d[k][j][k - 1];
					if (sum > Integer.MAX_VALUE) {//handle overflow.
						sum = Integer.MAX_VALUE;
					}
					d[i][j][k] = Math.min(d[i][j][k - 1], (int) sum);
				}
			}
		}
	}

    //finds shorthess path among all.
	private int findShortestPath() throws IllegalStateException {
		int min = Integer.MAX_VALUE;
        //check last 2D array (for k = |V|).
		for (int i = 1; i <= graph.V(); i++) {
			for (int j = 1; j <= graph.V(); j++) {
				//System.err.print(fw.d[i][j][g.V()] + " ");
                //check for negative cycle (diagonal elements)
				if (i == j && d[i][j][graph.V()] < 0) {
					throw new IllegalStateException("Negative cycle!");
				}
				if (d[i][j][graph.V()] < min) {
					min = d[i][j][graph.V()];
				}
			}
			//System.err.println();
		}
		return min;
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.err.println("WeightedGraph:");
		WeightedGraph2 g = WeightedGraph2.readGraph(
				//FloydWarshall.class.getResourceAsStream("g1.txt"));
                //FloydWarshall.class.getResourceAsStream("g2.txt"));
                FloydWarshall.class.getResourceAsStream("g3.txt"));

		FloydWarshall fw = new FloydWarshall(g);
		fw.solve();

		try {
			int min = fw.findShortestPath();
			System.err.println("Shortest path: " + min);
		} catch (IllegalStateException e) {
			System.err.println("Negative cycle!! Sorry...");
		}
	}


}
