package com.id.math.chess;

import java.util.Arrays;

/**
 * Fit queens in square board so no one hit each other.
 * Board is enumerated like this:
 * 
 * N-1 |-|-|-|-|-|
 *  .  |-|-|-|-|-|
 *  .  |-|-|-|-|-|
 *  .  |-|-|-|-|-|
 *  0  |-|-|-|-|-|
 *      0 . . . N-1
 *    
 * Horizontals on verticals are enumerated from 0 to (N-1).
 * @author idanilov
 * 
 */
public class Queens {

	//board size
	private static final int N = 8;

	//marks cell as empty.
	private static final int EMPTY_MARKER = -1;

	// index is number of queen and number of vertical where queen is placed.
	// value is horizontal where queen is placed.
	// I.e. "board[x] == y" means:
	// x - vertical column, y - horizontal row. 
	private int[] board;

	//number of valid combinations.
	private int successCount;

	public Queens() {
		board = new int[N];
		clearBoard(0);
		generate(0);
		System.err.println("Success combinations:" + " " + successCount);
	}

	/**
	 * Clears board from start vertical to the last vertical
	 * @param start - first vertical.
	 */
	private void clearBoard(int start) {
		Arrays.fill(board, start, board.length, EMPTY_MARKER);
	}

	private void generate(int start) {
		if (start == N) {
			return;
		}
		for (int j = 0; j < N; j++) {
			if (check(start, j)) {
				board[start] = j;
				if (start == N - 1) {
					successCount++;
					printResult();
				}
				generate(start + 1);
				clearBoard(start);
			}
		}
	}

	private boolean check(int x, int y) {
		int[] existing = existingQueens();
		for (int i = 0; i < existing.length; i++) {
			if (hit(x, y, i, existing[i])) {
				return false;
			}
		}
		return true;
	}

	/**
	 * (x1, y1) - first queen.
	 * (x2, y2) - second queen.
	 * x - vertical.
	 * y - horizontal.
	 * @return true if some queen hit other queen.
	 */
	private boolean hit(int x1, int y1, int x2, int y2) {
		//horizontal hit.
		if (x1 == x2) {
			return true;
		}
		//horizontal hit.
		if (y1 == y2) {
			return true;
		}
		//diagonal hit.
		if ((x1 + y1 == x2 + y2) || (x1 - y1 == x2 - y2)) {
			return true;
		}
		return false;
	}

	/**
	 * @return array of queens on board.
	 */
	private int[] existingQueens() {
		for (int i = N - 1; i >= 0; i--) {
			if (board[i] != EMPTY_MARKER) {
				return Arrays.copyOf(board, i + 1);
			}
		}
		return new int[0];
	}

	private void printResult() {
		System.err.print(">>> ");
		for (int i = 0; i < N; i++) {
			System.err.print("(" + i + "," + board[i] + ")");
		}
		System.err.println();
	}

	public static void main(String[] args) {
		new Queens();
	}

}
