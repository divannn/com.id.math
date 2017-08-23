package com.id.math.linkedlist;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MthElemFromEnd {


    private ListNode<Integer> head;

    @Before
    public void setUp() {
        head = createList();
    }

    @Test
    public void testIter() {
        assertEquals(7, getMthElemFromEndIter(head, 0).data);
        assertEquals(6, getMthElemFromEndIter(head, 1).data);
        assertEquals(1, getMthElemFromEndIter(head, 6).data);
        assertEquals(2, getMthElemFromEndIter(head, 5).data);
        assertEquals(null, getMthElemFromEndIter(head, 8));
        assertEquals(null, getMthElemFromEndIter(head, 7));
    }

    @Test
    public void testRecur() {
        assertEquals(7, getMthElemFromEndRecursive(head, 0).data);
        assertEquals(6, getMthElemFromEndRecursive(head, 1).data);
        assertEquals(1, getMthElemFromEndRecursive(head, 6).data);
        assertEquals(2, getMthElemFromEndRecursive(head, 5).data);
        assertEquals(null, getMthElemFromEndRecursive(head, 8));
        assertEquals(null, getMthElemFromEndRecursive(head, 7));
    }

    /**
     * @param head single-linked list
     * @param m    0-based index from the end
     * @return m-th elem from the end of list
     */
    private static ListNode getMthElemFromEndIter(ListNode head, int m) {
        ListNode curr = head;
        ListNode result = head;

        for (int i = 0; i <= m; i++) {
            if (curr == null) {
                return null;//m is out of bounds
            }
            curr = curr.next;
        }
        while (curr != null) {
            curr = curr.next;
            result = result.next;
        }
        return result;
    }

    private static ListNode getMthElemFromEndRecursive(ListNode head, int m) {
        return getMthElemFromEndRecursive(head, m, new Index(-1));
    }

    private static ListNode getMthElemFromEndRecursive(ListNode head, int m, Index ind) {
        if (head == null) {
            return null;
        }
        ListNode node = getMthElemFromEndRecursive(head.next, m, ind);
        ind.index++;
        if (ind.index == m) {
            return head;
        }
        return node;
    }

    private static ListNode<Integer> createList() {
        ListNode head = new ListNode<>(1);
        ListNode n2 = new ListNode<>(2);
        ListNode n3 = new ListNode<>(3);
        ListNode n4 = new ListNode<>(4);
        ListNode n5 = new ListNode<>(5);
        ListNode n6 = new ListNode<>(6);
        ListNode n7 = new ListNode<>(7);

        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        return head;
    }

    private static class Index {
        private int index;

        public Index(int index) {
            this.index = index;
        }
    }
}
