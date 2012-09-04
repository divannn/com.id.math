package com.id.math.list;

public class ReverseList {
    public static void main(String[] args) {
        Node n1 = new Node<Integer>(1);
        Node n2 = new Node<Integer>(2);
        Node n3 = new Node<Integer>(3);
        Node n4 = new Node<Integer>(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        Node head = n1;
        print(head);
        head = reverse(n1);
        print(head);
    }

    private static void print(Node head) {
        while (head != null) {
            System.err.print(head.data + " ");
            head = head.next;
        }
        System.err.println();
    }

    private static Node reverse(Node head) {
        Node previous = null;
        Node current = head;
        Node next;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }

}