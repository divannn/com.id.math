package com.id.math.linkedlist;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


//leetcode
public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        ListNode oddList = null;
        ListNode currOdd = null;
        ListNode evenList = null;
        ListNode currEven = null;

        boolean isOdd = true;
        boolean isFirstOdd = true;
        boolean isFirstEven = true;

        ListNode curr = head;
        while (curr != null) {
            if (isOdd) {
                if (isFirstOdd) {
                    isFirstOdd = false;
                    oddList = new ListNode(curr.data);
                    currOdd = oddList;
                } else {
                    currOdd.next = curr;
                    currOdd = currOdd.next;
                }
            } else {
                if (isFirstEven) {
                    isFirstEven = false;
                    evenList = new ListNode(curr.data);
                    currEven = evenList;
                } else {
                    currEven.next = curr;
                    currEven = currEven.next;
                }
            }
            curr = curr.next;
            isOdd = !isOdd;

            if (curr == null) {//clear last element.
                if (isOdd) {
                    currOdd.next = null;
                } else {
                    currEven.next = null;
                }
            }
        }

        System.err.println("1: " + oddList.listToString());
        System.err.println("2: " + evenList.listToString());
        currOdd.next = evenList;//join odd & even lists.
        return oddList;
    }

    //faster solution (not mine).
    public ListNode oddEvenList2(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode oddPtr = head;
        ListNode evenPtr = head.next;
        ListNode evenHead = head.next;
        while (evenPtr != null && evenPtr.next != null) {
            oddPtr.next = evenPtr.next;
            oddPtr = oddPtr.next;
            evenPtr.next = oddPtr.next;
            evenPtr = evenPtr.next;
        }
        oddPtr.next = evenHead;//join odd & even lists.
        return head;
    }

    @Test
    public void testNull() {
        ListNode transformed = new OddEvenLinkedList().oddEvenList2(null);
        assertEquals(null, transformed);
    }

    @Test
    public void test1Node() {
        ListNode n = new ListNode(1);
        ListNode transformed = new OddEvenLinkedList().oddEvenList2(n);
        assertEquals("1", transformed.listToString());
    }

    @Test
    public void test2Nodes() {
        ListNode n1 = new ListNode(1);
        ListNode transformed1 = new OddEvenLinkedList().oddEvenList2(n1);
        assertEquals("1", transformed1.listToString());

        ListNode n2 = new ListNode(2);
        n1.next = n2;
        ListNode transformed2 = new OddEvenLinkedList().oddEvenList2(n1);
        assertEquals("1->2", transformed2.listToString());
    }

    @Test
    public void test2() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        System.err.println("initial list: " + n1.listToString());
        ListNode transformed = new OddEvenLinkedList().oddEvenList2(n1);
        System.err.println("transformed list: " + transformed.listToString());
        assertEquals("1->3->5->2->4", transformed.listToString());
    }

    @Test
    public void test3() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        System.err.println("initial list: " + n1.listToString());
        ListNode transformed = new OddEvenLinkedList().oddEvenList2(n1);
        System.err.println("transformed list: " + transformed.listToString());
        assertEquals("1->3->5->2->4->6", transformed.listToString());
    }
}

