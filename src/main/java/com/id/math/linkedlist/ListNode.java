package com.id.math.linkedlist;

public class ListNode<T> {
    ListNode next;
    T data;

    public ListNode(T data) {
        this.data = data;
    }

    public String print() {
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

}
