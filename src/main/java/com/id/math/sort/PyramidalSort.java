package com.id.math.sort;

/**
 * @author idanilov
 * @complexity in worse case : O(n*ln(n))
 * @stable false
 */
public class PyramidalSort extends AbstractSort {

    public int[] sort(int[] d) {
        data = ArrayUtils.copy(d);
        buildHeap(data);
        for (int i = data.length - 1; i > 0; i--) {
            ArrayUtils.swap(data, 0, i);//move max element to the end, put last to top and sift it down.
            siftDown(data, 0, i - 1);
        }
        return data;
    }

    /**
     * @param data
     * @param i        index to sift from
     * @param heapSize length of heap
     *                 Array data[i,heapSize) is valid pyramid.
     * @complexity in worse case : O(n*ln(n))
     */
    private static void siftDown(int[] data, int i, int heapSize) {
        int leftChildInd, rightChildInd, largestChildInd;
        while (true) {
            leftChildInd = 2 * i + 1;
            rightChildInd = 2 * i + 2;
            largestChildInd = i;

            if (leftChildInd < heapSize && data[leftChildInd] > data[largestChildInd])
                largestChildInd = leftChildInd;
            if (rightChildInd < heapSize && data[rightChildInd] > data[largestChildInd])
                largestChildInd = rightChildInd;

            if (largestChildInd == i)
                break;
            ArrayUtils.swap(data, largestChildInd, i);
            i = largestChildInd;
        }
    }

    /**
     * @param data
     * @complexity in worse case : O(n) (not O(n*ln(n))) (see additional info about this fact)
     */
    private static void buildHeap(int[] data) {
        //start from the middle of pyramid as leafs are pyramids with size 1.
        for (int i = data.length / 2; i >= 0; i--) {
            siftDown(data, i, data.length);
        }
    }

    public static void main(String[] args) {
        System.err.println("-=PIRAMIDAL SORT=-");
        int[] source = TestData.RANDOM;
        System.err.println("Source:");
        ArrayUtils.printArray(source);

        int[] result = new PyramidalSort().sort(source);
        System.err.println("Result:");
        ArrayUtils.printArray(result);
    }

}
