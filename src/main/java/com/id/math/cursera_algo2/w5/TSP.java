package w5;


import java.io.InputStream;
import java.util.Locale;
import java.util.Scanner;

/**
 * Calculates Travel Salesman problem  (TSP)
 * <p/>
 * Input: tsp.txt - 26442.73.
 * <p/>
 * Note: Requires 12GB of heap memory to finish.
 *
 * @autor idanilov
 */
public class TSP {

	private static int numCities;
	private static City[] cities;
	private static double[][] dist;

	public static void main(String[] args) {
		cities = readCities(TSP.class.getResourceAsStream("tsp.txt"));

		initDistances();
		double res = ShortestHamiltonianCycle.getShortestHamiltonianCycle(dist);
		System.err.println("TSP: " + res);
	}

	private static void initDistances() {
		dist = new double[numCities][numCities];
		for (int i = 0; i < numCities; i++) {
			City c1 = cities[i];
			for (int j = 0; j < numCities; j++) {
				City c2 = cities[j];
				dist[i][j] = Math.sqrt(
						(c1.x - c2.x) * (c1.x - c2.x) + (c1.y - c2.y) * (c1.y - c2.y));
				//System.err.print(dist[i][j] + "  ");
			}
			//System.err.println();
		}
	}

	private static City[] readCities(InputStream is) {
		City[] result = null;
		Scanner fileScanner = new Scanner(is);
		if (fileScanner.hasNextInt()) {
			numCities = fileScanner.nextInt();
			result = new City[numCities];
		}
		int i = 0;
		while (fileScanner.hasNextLine()) {
			String str = fileScanner.nextLine();
			Scanner lineScanner = new Scanner(str);
			lineScanner.useLocale(Locale.US);

			if (lineScanner.hasNextDouble()) {
				double nextX = lineScanner.nextDouble();
				if (lineScanner.hasNextDouble()) {
					double nextY = lineScanner.nextDouble();
					result[i] = new City(i, nextX, nextY);
					i++;
				}
			}
			lineScanner.close();
		}
		fileScanner.close();
		return result;
	}

	private static class City {

		private int num;
		private double x;
		private double y;

		public City(int n, double x, double y) {
			this.num = n;
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "City{" +
					"x=" + x +
					", y=" + y +
					'}';
		}
	}

}
