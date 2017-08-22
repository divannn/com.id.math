package com.id.math.list;

public class CheckCycle {

    public static void main(String[] args) {
        Node head = new Node<>(1);
        Node n2 = new Node<>(2);
        Node n3 = new Node<>(3);
        Node n4 = new Node<>(4);

        head.next = n2;
        n2.next = n3;
        n3.next = n4;

        n4.next = n2;
        System.err.println("has cycle: " + hasCycle(head));
    }

    public static boolean hasCycle(Node head) {
        Node fast = head;
        Node slow = head;

        while (fast != null && slow != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

}
