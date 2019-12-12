package linkedlist;

public class RemoveDuplicatesFromSorted {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next.next = null;

        RemoveDuplicatesFromSorted sorted = new RemoveDuplicatesFromSorted();
        ListNode res1 = sorted.removeDuplicates(head);
        ListNode res2 = sorted.deleteDuplicates(head);
        System.out.println();
    }

    public ListNode deleteDuplicates(ListNode A) {
        ListNode current = A;
        ListNode prev = A;
        while (current != null && current.next != null) {
            current = current.next;
            if (current.val == prev.val) {
                prev.next = current.next;
                current = prev;
            } else {
                prev = current;
            }
        }
        return A;
    }

    ListNode removeDuplicates(ListNode A) {
        if (A == null || A.next == null)
            return A;

        ListNode newHead = A;
        ListNode curr = newHead;

        while (curr != null && curr.next != null) {
            ListNode next = curr.next;
            if (next.val == curr.val) {
                curr.next = next.next;
            } else {
                curr = next;
            }
        }

        return newHead;
    }
}
