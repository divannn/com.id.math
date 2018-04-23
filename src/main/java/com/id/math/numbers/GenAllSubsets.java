package com.id.math.numbers;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GenAllSubsets {

    /**
     * Generate all subsets of given set.
     */
    public static List<List> genSubsets(char set[]) {
        int n = set.length;
        int numOfSubsets = 1 << n;
        List<List> result = new ArrayList<>(numOfSubsets);

        // loop for all 2^n subsets
        for (int i = 0; i < numOfSubsets; i++) {
            List<Character> curSubset = new ArrayList<>(n);
            // Gen current subset
            for (int j = 0; j < n; j++) {
                // map each bit of current number to array element
                if ((i & (1 << j)) > 0) {
                    curSubset.add(set[j]);
                }
            }
            result.add(curSubset);
        }

        return result;
    }

    @Test
    public void test() {
        char set[] = {'a', 'b', 'c', 'd'};
        List<List> r = genSubsets(set);
        assertEquals(16, r.size());
        assertTrue(r.get(0).size() == 0);
    }

    public static void main(String[] args) {
        char set[] = {'a', 'b', 'c', 'd'};
        List<List> r = genSubsets(set);
        for (List list : r) {
            System.err.println(list);
        }
    }

}
