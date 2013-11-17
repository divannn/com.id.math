package w2.task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Finds k-Clustering max spacing.
 *
 * @author idanilov
 *         <p/>
 *         Input: edges.txt
 *         Correct answers are: 3612829
 */
public class KCluster {

	private WeightedGraph graph;
	private final int K;
	private ArrayList<KK> clusters = new ArrayList<>();


	//private PriorityQueue pq = new PriorityQueue();

	public KCluster(int K, WeightedGraph G) {
		this.K = K;
		graph = G;
	}

	public void build() {
		for (int i = 1; i <= graph.V(); i++) {
			KK<Integer> next = new KK<>(graph);
			next.add(i);
			clusters.add(next);
		}
		List<WeightedGraph.Edge> edges = graph.edges();
		Collections.sort(edges);

		int k = clusters.size();

		int i = 0;
		while (k != K) {
			System.err.println("------------ " + k);
			for (i = 0; i < edges.size(); i++) {
				WeightedGraph.Edge next = edges.get(i);
				System.err.println("::" + i + " " + next.weight());
				int either = next.either();
				int other = next.other(either);
				KK clus1 = find(either);
				KK clus2 = find(other);
				if (clus1 != clus2) {
					k--;
					clus1.merge(clus2);
					clusters.remove(clus2);
					edges.remove(next);
					break;
				}
			}
		}

		for (i = 0; i < edges.size(); i++) {
			WeightedGraph.Edge next = edges.get(i);
			int either = next.either();
			int other = next.other(either);
			KK clus1 = find(either);
			KK clus2 = find(other);
			if (clus1 != clus2) {
				break;
			}
		}
		System.err.println("DIST:" + (i) + " " + edges.get(i).weight());

		for (KK next : clusters) {
			System.err.println("Cluster: " + next);
		}
	}

	private KK find(Integer value) {
		for (KK next : clusters) {
			if (next.has(value)) {
				return next;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		System.err.println("WeightedGraph:");
		WeightedGraph g = WeightedGraph.readGraph(
				KCluster.class.getResourceAsStream("clustering.txt"));
		//KCluster.class.getResourceAsStream("1.txt")); //additional test cases.

		KCluster kCluster = new KCluster(4, g);
		kCluster.build();
//		List<WeightedGraph.Line> edges = g.edges();
//		Collections.sort(edges);
//
//		for (WeightedGraph.Line next : edges) {
//			System.err.println("::" + next.either() + " " + next.weight());
//		}

	}

}
