package com.id.puzzles;

/**
 * Build NxN matrix containing spiral.
 * Example:
 * input = 4
 * <p>
 * output:
 * 1  2  3  4
 * 12 13 14  5
 * 11 16 15  6
 * 10  9  8  7
 *
 * @company facebook
 */
public class Spiral {

    /**
     * @param n dimension of 2D matrix
     * @return matrix with spiral
     */
    public static int[][] genSpiral(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("N must be > 0");
        }
        int[] dc = new int[]{1, 0, -1, 0};
        int[] dr = new int[]{0, 1, 0, -1};
        int dir = 0, val = 0, r = 0, c = 0, limit = n * n;
        int[][] matrix = new int[n][n];
        while (val++ < limit) {
            matrix[r][c] = val;
            r += dr[dir];
            c += dc[dir];
            if (isInvalid(matrix, r, c)) {
                r -= dr[dir];
                c -= dc[dir];
                dir = (dir + 1) % 4;//clever!
                r += dr[dir];
                c += dc[dir];
            }
        }
        return matrix;
    }

    private static boolean isInvalid(int[][] m, int row, int col) {
        return row < 0 || col < 0 || row >= m.length || col >= m.length || m[row][col] != 0;
    }

    public static void main(String[] args) {
        int[][] m = genSpiral(6);

        for (int[] ints : m) {
            for (int anInt : ints) {
                String item = String.format("%1$3s ", anInt);
                System.err.print(item);
            }
            System.err.println();
        }

    }
}
