package com.id.math.sort;

import com.id.math.util.ArrayUtils;
import org.junit.Before;
import org.junit.Test;


/**
 * @author idanilov
 */
public class CompareSortsTest {

    private int[] data;
    private static final int NUM = 5000;

    @Before
    public void setUp() {
        data = generate(NUM);
    }

    private int[] generate(int n) {
        int result[] = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = (int) Math.round(Math.random() * 100);
        }
        return result;
    }

    @Test
    public void testBubble() {
        new BubbleSort().sort(data);
    }

    @Test
    public void testInsertion() {
        new InsertionSort().sort(data);
    }

    @Test
    public void testSelection() {
        new SelectionSort().sort(data);
    }

    @Test
    public void testQuick() {
        new QuickSort().sort(data);
    }

    @Test
    public void testPyramidal() {
        int[] result = new PyramidalSort().sort(data);
        System.err.println("Result:" + data.length);
        ArrayUtils.printArray(result);
        //		for (int i = result.length - 1; i > result.length - 2000; i--) {
        //			System.err.print(result[i] + " ");
        //		}
        //		System.err.println();
    }
}
