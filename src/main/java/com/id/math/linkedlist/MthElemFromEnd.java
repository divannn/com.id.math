package com.id.math.linkedlist;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MthElemFromEnd {


    @Test
    public void test1() {
        ListNode<Integer> head = createList();
        assertEquals(7, getMthElemFromEnd(head, 0).data);
        assertEquals(6, getMthElemFromEnd(head, 1).data);
        assertEquals(1, getMthElemFromEnd(head, 6).data);
        assertEquals(2, getMthElemFromEnd(head, 5).data);
        assertEquals(null, getMthElemFromEnd(head, 8));
        assertEquals(null, getMthElemFromEnd(head, 7));
    }

    /**
     * @param head single-linked list
     * @param m    0-based index from the end
     * @return m-th elem from the end of list
     */
    private static ListNode getMthElemFromEnd(ListNode head, int m) {
        ListNode curr = head;
        ListNode res = head;
        int i = 0;
        while (curr != null) {
            curr = curr.next;
            if (i > m) {
                res = res.next;
            }
            i++;
        }
        if (i <= m) {
            res = null;
        }
        return res;
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
}
