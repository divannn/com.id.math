package com.id.math.linkedlist;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

/**
 * Remove duplicates from unordered linked list.
 */
public class RemoveDupsFromLinkedList {

    //using extra memory
    //@time O(n)
    private static <T> ListNode<T> removeDups1(ListNode<T> head) {
        HashSet<T> set = new HashSet<>();
        ListNode previous = null;
        ListNode<T> curr = head;
        while (curr != null) {
            if (set.contains(curr.data)) {
                previous.next = curr.next;
            } else {
                set.add(curr.data);
                previous = curr;
            }
            curr = curr.next;
        }
        return head;
    }

    //no extra memory
    //@time O(n*n)
    private static <T> ListNode<T> removeDups2(ListNode<T> head) {
        ListNode curr = head;
        while (curr != null) {
            /* Remove all future nodes that have the same value */
            ListNode runner = curr;
            while (runner.next != null) {
                if (runner.next.data == curr.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            curr = curr.next;
        }
        return head;
    }

    @Test
    public void test_rem1() {
        ListNode<Integer> _1 = new ListNode(1);
        ListNode<Integer> _2 = new ListNode(2);
        ListNode<Integer> _3 = new ListNode(3);
        ListNode<Integer> _4 = new ListNode(4);
        _1.next = _2;
        _2.next = _3;
        _3.next = _4;

        String original_str = _1.listToString();
        ListNode newList = removeDups1(_1);
        String new_str = newList.listToString();

        System.err.println(original_str);
        System.err.println(new_str);
        Assert.assertEquals("1->2->3->4", new_str);

        ListNode newList2 = removeDups2(_1);
        String new_str2 = newList.listToString();
        Assert.assertEquals("1->2->3->4", new_str2);
    }

    @Test
    public void test_rem2() {
        ListNode<Integer> _1 = new ListNode(1);
        ListNode<Integer> _2 = new ListNode(2);
        ListNode<Integer> _3 = new ListNode(2);
        ListNode<Integer> _4 = new ListNode(4);
        ListNode<Integer> _5 = new ListNode(2);
        _1.next = _2;
        _2.next = _3;
        _3.next = _4;
        _4.next = _5;

        String original_str = _1.listToString();
        ListNode newList = removeDups1(_1);
        String new_str = newList.listToString();

        System.err.println(original_str);
        System.err.println(new_str);
        Assert.assertEquals("1->2->4", new_str);


        ListNode newList2 = removeDups2(_1);
        String new_str2 = newList2.listToString();
        Assert.assertEquals("1->2->4", new_str2);
    }

}

