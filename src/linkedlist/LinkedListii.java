package linkedlist;

import java.util.LinkedList;

public class LinkedListii {

    static ListNode head = null;

    public static void insert_node(int position, int value) {
        // @params position, integer
        // @params value, integer
        if (head == null) {
            head = new ListNode(value);
        } else {
            ListNode ptr = head;
            int count = 1;
            while (ptr.next != null && count != position) {
                ptr = ptr.next;
                count++;
            }
            ListNode next = ptr.next;
            ListNode temp = new ListNode(ptr.val);
            ptr.val = value;
            ptr.next = temp;
            temp.next = next;
        }
    }

    public static void delete_node(int position) {
        // @params position, integer
        if (head == null) {
            return;
        } else {
            ListNode current = head;
            ListNode prev = current;
            int count = 1;
            while (current.next != null && count != position) {
                prev = current;
                current = current.next;
                count++;
            }
            prev.next = current.next;
        }
    }

    public static void print_ll() {
        // Output each element followed by a space
        ListNode ptr = head;
        while (ptr != null) {
            System.out.println(ptr.val + " ");
            ptr = ptr.next;
        }
    }
}
