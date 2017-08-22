package com.id.math.list;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MthElemFromEnd {


    @Test
    public void test1() {
        Node<Integer> head = createList();
        assertEquals(7, getMthElemFromEnd(head, 0).data);
        assertEquals(6, getMthElemFromEnd(head, 1).data);
        assertEquals(1, getMthElemFromEnd(head, 6).data);
        assertEquals(2, getMthElemFromEnd(head, 5).data);
        assertEquals(null, getMthElemFromEnd(head, 8));
        assertEquals(null, getMthElemFromEnd(head, 7));
    }

    private static Node getMthElemFromEnd(Node head, int m) {
        Node curr = head;
        Node res = head;
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

    private static Node<Integer> createList() {
        Node head = new Node<>(1);
        Node n2 = new Node<>(2);
        Node n3 = new Node<>(3);
        Node n4 = new Node<>(4);
        Node n5 = new Node<>(5);
        Node n6 = new Node<>(6);
        Node n7 = new Node<>(7);

        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        return head;
    }
}
