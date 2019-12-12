package linkedlist;

public class IntersectionLinkedList {

    public static void main(String[] args) {
        ListNode common = new ListNode(10);
        common.next = new ListNode(9);
        common.next.next = new ListNode(8);

        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = common;

        ListNode b = new ListNode(4);
        b.next = new ListNode(5);
        b.next.next = new ListNode(6);
        b.next.next.next = common;

        IntersectionLinkedList list = new IntersectionLinkedList();
        ListNode res = list.getIntersectionNode(a, b);
        System.out.println();
    }

    public ListNode getIntersectionNode(ListNode a, ListNode b) {
        int aCount = getCount(a);
        int bCount = getCount(b);

        if (aCount > bCount) {
            return adjustAndCheck(a, b, aCount - bCount);
        } else {
            return adjustAndCheck(b, a, bCount - aCount);
        }
    }

    private ListNode adjustAndCheck(ListNode a, ListNode b, int diff) {
        int count = 1;
        ListNode ptr1 = a;
        ListNode ptr2 = b;
        while (ptr1 != null && count <= diff) {
            ptr1 = ptr1.next;
            count++;
        }

        while (ptr1 != null && ptr2 != null) {
            if (ptr1 == ptr2) {
                return ptr1;
            }
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return null;
    }

    private int getCount(ListNode a) {
        int count = 1;
        ListNode temp = a;
        while (temp != null && temp.next != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}
