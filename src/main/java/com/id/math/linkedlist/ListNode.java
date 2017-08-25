package com.id.math.linkedlist;

public class ListNode<T> {
    ListNode next;
    T data;

    public ListNode(T data) {
        this.data = data;
    }

    public String listToString() {
        StringBuilder sb = new StringBuilder();
        ListNode curr = this;
        while (curr != null) {
            sb.append(curr.toString());
            if (curr.next != null) {
                sb.append("->");
            }
            curr = curr.next;
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);

        head.next = n2;
        n2.next = n3;
        n3.next = n4;

        System.err.println(head.listToString());

        printReverse(head);

    }

    private static void printReverse(ListNode head) {
        if (head == null) {
            return;
        }
        printReverse(head.next);

        System.err.println(" " + head);
    }
}
