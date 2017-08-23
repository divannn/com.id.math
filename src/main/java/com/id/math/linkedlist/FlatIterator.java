package com.id.math.linkedlist;

import java.util.Arrays;
import java.util.Iterator;

/***
 *
 * @param <E>
 */
public class FlatIterator<E> implements Iterator<E> {

    private final Iterator<Iterator<E>> root;
    private Iterator<E> curr;

    public FlatIterator(Iterator<Iterator<E>> root) {
        this.root = root;
        if (root != null && root.hasNext()) {
            curr = root.next();
        }
    }

    @Override
    public boolean hasNext() {
        if (curr == null) {
            return false;
        }
        if (curr.hasNext()) {
            return true;
        } else {
            while (root.hasNext()) {
                curr = root.next();
                if (curr.hasNext()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public E next() {
        if (curr == null) {
            return null;
        }
        if (curr.hasNext()) {
            return curr.next();
        } else {
            while (root.hasNext()) {
                curr = root.next();
                if (curr.hasNext()) {
                    return curr.next();
                }
            }
        }
        return null;
    }

    @Override
    public void remove() {
        if (curr == null) {
            return;
        }
        if (curr.hasNext()) {
            curr.remove();
        } else {
            while (root.hasNext()) {
                curr = root.next();
                if (curr.hasNext()) {
                    curr.remove();
                }
            }
        }
    }


    public static void testIter() {
        FlatIterator<Integer> fi = createFlatIterator();

        while (fi.hasNext()) {
            Integer next = fi.next();
            System.err.println("> " + next);
        }

    }

    public static void testRemove() {
        FlatIterator<Integer> fi = createFlatIterator();

        while (fi.hasNext()) {
            Integer next = fi.next();
            //just remove some items
            if (null == next || 8 == next || 4 == next) {
                System.err.println("-removed " + next);
            }
        }
    }

    private static FlatIterator<Integer> createFlatIterator() {
        Iterator<Integer> it0 = Arrays.asList((Integer) null).iterator();
        Iterator<Integer> it1 = Arrays.asList(8, 1, 2, 3).iterator();
        Iterator<Integer> it2 = Arrays.asList(4, 5).iterator();
        Iterator<Integer> it3 = Arrays.asList((Integer) null).iterator();
        Iterator<Iterator<Integer>> it = Arrays.asList(it0, it1, it2, it3).iterator();
        return new FlatIterator<>(it);
    }

    public static void main(String[] args) {
        testIter();
        testRemove();
    }

}
