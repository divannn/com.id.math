package com.id.math.linkedlist;

import org.junit.Assert;
import org.junit.Test;

/**
 * //leetcode
 * Reverse a singly linked list.
 */
public class ReverseLinkedList {

    /**
     * Iteration.
     *
     * @param head head of list
     * @return head of reversed list
     */
    private static ListNode reverseListIter(ListNode head) {
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
    private static ListNode reverseListRecur(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseListRecur(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    @Test
    public void testIterative1() {
        Assert.assertEquals(null, ReverseLinkedList.reverseListIter(null));

        ListNode<Integer> original = new ListNode(1);
        ListNode<Integer> reversed = ReverseLinkedList.reverseListIter(original);
        Assert.assertEquals("1", reversed.listToString());
    }

    @Test
    public void testRecursive1() {
        Assert.assertEquals(null, ReverseLinkedList.reverseListRecur(null));

        ListNode<Integer> original = new ListNode(1);
        ListNode<Integer> reversed = ReverseLinkedList.reverseListRecur(original);
        Assert.assertEquals("1", reversed.listToString());
    }

    @Test
    public void testIterative2() {
        ListNode<Integer> _1 = new ListNode(1);
        ListNode<Integer> _2 = new ListNode(2);
        ListNode<Integer> _3 = new ListNode(3);
        ListNode<Integer> _4 = new ListNode(4);
        _1.next = _2;
        _2.next = _3;
        _3.next = _4;

        String original_str = _1.listToString();
        ListNode reversed = ReverseLinkedList.reverseListIter(_1);
        String reversed_str = reversed.listToString();

        System.err.println(original_str);
        System.err.println(reversed_str);

        Assert.assertEquals("4->3->2->1", reversed_str);
    }

    @Test
    public void testRecursive2() {
        ListNode<Integer> _1 = new ListNode<>(1);
        ListNode<Integer> _2 = new ListNode<>(2);
        ListNode<Integer> _3 = new ListNode<>(3);
        ListNode<Integer> _4 = new ListNode<>(4);
        _1.next = _2;
        _2.next = _3;
        _3.next = _4;

        String original_str = _1.listToString();
        ListNode reversed = ReverseLinkedList.reverseListRecur(_1);
        String reversed_str = reversed.listToString();

        System.err.println(original_str);
        System.err.println(reversed_str);

        Assert.assertEquals("4->3->2->1", reversed_str);
    }

}