package com.id.math.linkedlist;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * Note: By intersection means phiscal intersectionof references.
 *
 * @leetcode https://leetcode.com/problems/intersection-of-two-linked-lists/
 */
public class FindIntersectionOfTwoLinkedLists {

    /**
     * Solution with counting lengths.
     *
     * @param headA fist list
     * @param headB second list
     * @return intersection node
     * @time O(m + n)
     * @space O(1)
     */
    public ListNode<Integer> solution(ListNode<Integer> headA, ListNode<Integer> headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode<Integer> curA = headA;
        int lenA = 0;
        while (curA != null) {
            curA = curA.next;
            lenA++;
        }

        ListNode<Integer> curB = headB;
        int lenB = 0;
        while (curB != null) {
            curB = curB.next;
            lenB++;
        }

        int diff;//count diff of lists lengths
        if (lenA >= lenB) {
            diff = lenA - lenB;
            curA = headA;
            curB = headB;
        } else {
            diff = lenB - lenA;
            curA = headB;
            curB = headA;
        }

        while (curA != null && diff > 0) {//align bigger list to smaller.
            curA = curA.next;
            diff--;
        }

        while (curA != null) {
            if (curA == curB) {//!compar references
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }

    /**
     * Smart. Wrap both arrays to form twa arrays of equal size (m+n).
     *
     * @param headA fist list
     * @param headB second list
     * @return intersection node
     * @time O(m + n)
     * @space O(1)
     */
    public ListNode<Integer> smart(ListNode<Integer> headA, ListNode<Integer> headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode<Integer> curA = headA;
        ListNode<Integer> curB = headB;

        while (curA != curB) {//!compare references
            if (curA == null) {
                curA = headB;//wrap to 2nd list
            } else {
                curA = curA.next;
            }
            if (curB == null) {
                curB = headA;//wrap to 1st list
            } else {
                curB = curB.next;
            }
        }
        return curA;
    }

    @Test
    public void test1() {
        Pair lists1 = createLists1();
        ListNode<Integer> solution1 = solution(lists1.list1, lists1.list2);
        assertEquals(8, solution1.data.intValue());

        Pair lists2 = createLists2();
        ListNode<Integer> solution2 = solution(lists2.list1, lists2.list2);
        assertNull(solution2);
    }

    @Test
    public void test2() {
        Pair lists1 = createLists1();
        ListNode<Integer> solution1 = smart(lists1.list1, lists1.list2);
        assertEquals(8, solution1.data.intValue());

        Pair lists2 = createLists2();
        ListNode<Integer> solution2 = solution(lists2.list1, lists2.list2);
        assertNull(solution2);
    }


    private static Pair createLists1() {
        ListNode<Integer> head1 = new ListNode<>(4);
        ListNode<Integer> n2 = new ListNode<>(1);
        ListNode<Integer> n3 = new ListNode<>(8);
        ListNode<Integer> n4 = new ListNode<>(4);
        ListNode<Integer> n5 = new ListNode<>(5);
        head1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode<Integer> head2 = new ListNode<>(5);
        ListNode<Integer> n2_1 = new ListNode<>(6);
        ListNode<Integer> n3_1 = new ListNode<>(1);
        head2.next = n2_1;
        n2_1.next = n3_1;
        n3_1.next = n3;
        return new Pair(head1, head2);
    }

    private static Pair createLists2() {
        ListNode<Integer> head1 = new ListNode<>(4);
        ListNode<Integer> n2 = new ListNode<>(1);
        ListNode<Integer> n3 = new ListNode<>(8);
        ListNode<Integer> n4 = new ListNode<>(4);
        ListNode<Integer> n5 = new ListNode<>(5);
        head1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode<Integer> head2 = new ListNode<>(2);
        return new Pair(head1, head2);
    }


    private static class Pair {
        ListNode<Integer> list1;
        ListNode<Integer> list2;

        public Pair(ListNode<Integer> list1, ListNode<Integer> list2) {
            this.list1 = list1;
            this.list2 = list2;
        }
    }
}
