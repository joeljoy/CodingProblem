package linkedlist;

public class RemoveDuplicatesSortedII {
    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(3);
        head.next.next = new ListNode(8);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(11);
        head.next.next.next.next.next.next = new ListNode(11);
        head.next.next.next.next.next.next.next = new ListNode(12);
        head.next.next.next.next.next.next.next.next = new ListNode(15);
        head.next.next.next.next.next.next.next.next.next = new ListNode(18);
        head.next.next.next.next.next.next.next.next.next.next = new ListNode(19);

        RemoveDuplicatesSortedII sortedII = new RemoveDuplicatesSortedII();
        ListNode res = sortedII.deleteDuplicates(head);
        System.out.println();
    }

    public ListNode deleteDuplicates(ListNode A) {
        if (A == null || A.next == null) return A;
        int currentValue = Integer.MIN_VALUE;
        ListNode newNode = null;
        ListNode ptr = null;
        ListNode current = A;
        boolean duplicate = false;
        while (current != null) {
            if (current.val != currentValue) {
                if (!duplicate) {
                    ListNode temp = new ListNode(currentValue);
                    if (newNode == null) {
                        newNode = temp;
                        ptr = temp;
                    } else {
                        ptr.next = temp;
                        ptr = temp;
                    }
                }
                if (current.next == null) {
                    ListNode temp = new ListNode(current.val);
                    if (newNode == null) {
                        newNode = temp;
                        ptr = temp;
                    } else {
                        ptr.next = temp;
                        ptr = temp;
                    }
                }
                currentValue = current.val;
                duplicate = false;
            } else {
                duplicate = true;
            }
            current = current.next;
        }
        return newNode.next;

    }
}
