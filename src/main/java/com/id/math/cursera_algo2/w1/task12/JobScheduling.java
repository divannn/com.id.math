package w1.task12;


import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Calculates job sheduling
 * @autor idanilov
 */
public class JobScheduling {

	private static int numJobs;
	private static Job[] jobs;

	public static void main(String[] args) {
		jobs = readJobs(JobScheduling.class.getResourceAsStream("jobs.txt"));

		byDiff();
		byRatio();
	}

	private static void byDiff() {
		Arrays.sort(jobs, Collections.reverseOrder(new Comp1()));//desc order.
		/*for (City nextJob : jobs) {
			System.err.println(">>> " + nextJob);
		}*/
		int[] completionTime = completionTime();
		long sum = calcSum(completionTime);
		System.err.println("BY DIFF:" + sum);
	}

	private static void byRatio() {
		Arrays.sort(jobs, Collections.reverseOrder(new Comp2()));//desc order.
		/*for (City nextJob : jobs) {
			System.err.println(">>> " + nextJob + " " + nextJob.r2);
		}*/
		int[] completionTime = completionTime();
		long sum = calcSum(completionTime);
		System.err.println("BY RATIO:" + sum);
	}

	private static long calcSum(int[] completionTime) {
		long result = 0;
		for (int i = 0; i < numJobs; i++) {
			result += jobs[i].w * completionTime[i];
		}
		return result;
	}

	private static int[] completionTime() {
		int[] result = new int[numJobs];
		for (int i = 0; i < numJobs; i++) {
			int nextCT = 0;
			for (int j = 0; j <= i; j++) {
				nextCT += jobs[j].l;
			}
			result[i] = nextCT;
		}
		return result;
	}

	private static Job[] readJobs(InputStream is) {
		Job[] result = null;
		Scanner fileScanner = new Scanner(is);
		if (fileScanner.hasNextInt()) {
			numJobs = fileScanner.nextInt();
			result = new Job[numJobs];
		}
		int i = 0;
		while (fileScanner.hasNextLine()) {
			String str = fileScanner.nextLine();
			Scanner lineScanner = new Scanner(str);

			if (lineScanner.hasNextInt()) {
				int nextW = lineScanner.nextInt();
				if (lineScanner.hasNextInt()) {
					int nextL = lineScanner.nextInt();
					result[i++] = new Job(nextW, nextL);
					//System.err.println(">> " + i + "  " + nextW + " " + nextL);
				}
			}
			lineScanner.close();
		}
		fileScanner.close();
		return result;
	}

	private static class Job {

		private int w;
		private int l;

		private int r1;
		private double r2;

		public Job(int w, int l) {
			this.w = w;
			this.l = l;
			r1 = w - l;
			r2 = (double) w / l;
		}

		@Override
		public String toString() {
			return "City{" +
					"w=" + w +
					", l=" + l +
					'}';
		}
	}

	private static class Comp1 implements Comparator<Job> {

		@Override
		public int compare(Job o1, Job o2) {
			int cond1 = new Integer(o1.r1).compareTo(new Integer(o2.r1));
			int cond2 = new Integer(o1.w).compareTo(new Integer(o2.w));
			return (cond1 == 0) ? cond2 : cond1;
		}
	}

	private static class Comp2 implements Comparator<Job> {

		@Override
		public int compare(Job o1, Job o2) {
			return new Double(o1.r2).compareTo(new Double(o2.r2));
		}
	}
}
