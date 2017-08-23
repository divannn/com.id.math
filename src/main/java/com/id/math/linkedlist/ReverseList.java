package com.id.math.linkedlist;

public class ReverseList {
    public static void main(String[] args) {
        ListNode head = new ListNode<Integer>(1);
        ListNode n2 = new ListNode<Integer>(2);
        ListNode n3 = new ListNode<Integer>(3);
        ListNode n4 = new ListNode<Integer>(4);

        head.next = n2;
        n2.next = n3;
        n3.next = n4;

        print(head);
        head = reverse(head);
        print(head);
    }

    private static void print(ListNode head) {
        while (head != null) {
            System.err.print(head.data + " ");
            head = head.next;
        }
        System.err.println();
    }

    private static ListNode reverse(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        ListNode next;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }

}
