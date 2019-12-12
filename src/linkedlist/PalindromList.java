package linkedlist;

public class PalindromList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(2);
//        head.next.next.next.next = new ListNode(1);
//        head.next.next.next.next.next = new ListNode(1);
        PalindromList list = new PalindromList();
        System.out.println(list.lPalin(head));
    }

    public int lPalin(ListNode A) {
        ListNode slow = A;
        ListNode fast = A;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode pivot = reverse(slow);
        return compareList(A, pivot);
    }

    private int compareList(ListNode a, ListNode b) {
        ListNode pt1 = a;
        ListNode pt2 = b;

        while (pt1 != null && pt2 != null) {
            if (pt1.val == pt2.val) {
                pt1 = pt1.next;
                pt2 = pt2.next;
            } else {
                return 0;
            }
        }
        return 1;
    }

    private ListNode reverse(ListNode slow) {
        ListNode prev = null;
        ListNode current = slow;
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
