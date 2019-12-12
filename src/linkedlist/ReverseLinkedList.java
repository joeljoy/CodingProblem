package linkedlist;


import java.util.List;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ReverseLinkedList linkedList = new ReverseLinkedList();
        ListNode res = linkedList.reverseBetween(head, 2, 5);
        System.out.println();
    }

    public ListNode reverseBetween(ListNode A, int B, int C) {
        if (A == null) return null;
        ListNode ptr1 = null;
        ListNode ptr1Prev = null;
        ListNode ptr2 = null;
        ListNode ptr2Next = null;

        ListNode current = A;
        int i = 1;
        while (current != null) {
            if (i < B) {
                ptr1Prev = current;
            }

            if (i == B) {
                ptr1 = current;
            }

            if (i == C) {
                ptr2 = current;
                ptr2Next = current.next;
            }
            i++;
            current = current.next;
        }
        ptr2.next = null;
        ptr2 = reverse(ptr1);

        if (ptr1Prev != null) {
            ptr1Prev.next = ptr2;
        } else {
            A = ptr2;
        }
        ptr1.next = ptr2Next;
        return A;
    }

    private ListNode reverse(ListNode ptr1) {
        ListNode prev = null;
        ListNode current = ptr1;
        ListNode next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
