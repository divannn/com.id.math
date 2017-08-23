package com.id.math.linkedlist;

import org.junit.Assert;
import org.junit.Test;

/**
 * Reverse a singly linked list.
 */
public class ReverseLinkedList {

    /**
     * Iteration.
     *
     * @param head head of list
     * @return head of reversed list
     */
    private static ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }

    /**
     * Recursion.
     *
     * @param head head of list
     * @return head of reversed list
     */
    private static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    @Test
    public void testIterative1() {
        Assert.assertEquals(null, ReverseLinkedList.reverseList(null));

        ListNode<Integer> original = new ListNode(1);
        ListNode<Integer> reversed = ReverseLinkedList.reverseList(original);
        Assert.assertEquals("1", reversed.print());
    }

    @Test
    public void testRecusrive1() {
        Assert.assertEquals(null, ReverseLinkedList.reverseList2(null));

        ListNode<Integer> original = new ListNode(1);
        ListNode<Integer> reversed = ReverseLinkedList.reverseList2(original);
        Assert.assertEquals("1", reversed.print());
    }

    @Test
    public void testIterartive2() {
        ListNode<Integer> _1 = new ListNode(1);
        ListNode<Integer> _2 = new ListNode(2);
        ListNode<Integer> _3 = new ListNode(3);
        ListNode<Integer> _4 = new ListNode(4);
        _1.next = _2;
        _2.next = _3;
        _3.next = _4;

        String original_str = _1.print();
        ListNode reversed = ReverseLinkedList.reverseList(_1);
        String reversed_str = reversed.print();

        System.err.println(original_str);
        System.err.println(reversed_str);

        Assert.assertEquals("4->3->2->1", reversed_str);
    }


    @Test
    public void testRecursion2() {
        ListNode<Integer> _1 = new ListNode<>(1);
        ListNode<Integer> _2 = new ListNode<>(2);
        ListNode<Integer> _3 = new ListNode<>(3);
        ListNode<Integer> _4 = new ListNode<>(4);
        _1.next = _2;
        _2.next = _3;
        _3.next = _4;

        String original_str = _1.print();
        ListNode reversed = ReverseLinkedList.reverseList2(_1);
        String reversed_str = reversed.print();

        System.err.println(original_str);
        System.err.println(reversed_str);

        Assert.assertEquals("4->3->2->1", reversed_str);
    }

}

