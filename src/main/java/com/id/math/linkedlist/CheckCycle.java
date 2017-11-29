package com.id.math.linkedlist;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CheckCycle {

    private ListNode<Integer> cycleHead;
    private ListNode<Integer> noCycleHead;


    //using storage.
    public boolean hasCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        while (head != null) {
            if (visited.contains(head)) {
                return true;
            } else {
                visited.add(head);
            }
            head = head.next;
        }
        return false;
    }

    //in place. 2 pointers.
    public static boolean hasCycle2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    @Before
    public void setUp() {
        cycleHead = new ListNode<>(1);
        ListNode n2 = new ListNode<>(2);
        ListNode n3 = new ListNode<>(3);
        ListNode n4 = new ListNode<>(4);

        cycleHead.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;

        noCycleHead = new ListNode<>(1);
        ListNode n22 = new ListNode<>(2);
        ListNode n33 = new ListNode<>(3);
        ListNode n44 = new ListNode<>(4);

        noCycleHead.next = n22;
        n22.next = n33;
        n33.next = n44;
    }

    @Test
    public void test1() {
        assertTrue(hasCycle(cycleHead));
        assertFalse(hasCycle(noCycleHead));
    }

    @Test
    public void test2() {
        assertTrue(hasCycle2(cycleHead));
        assertFalse(hasCycle2(noCycleHead));
    }
}
