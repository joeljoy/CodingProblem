package linkedlist;

public class DetectCycle {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node = new ListNode(2);
        head.next = node;
        ListNode node1 = new ListNode(3);
        node.next = node1;
        ListNode node2 = new ListNode(4);
        node1.next = node2;
        node2.next = node1;

        DetectCycle cycle = new DetectCycle();
        ListNode res = cycle.detectCycle(head);
    }

    public ListNode detectCycle(ListNode a) {
        ListNode slow = a;
        ListNode fast = a;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return getLoop(slow, a);
            }
        }
        return null;
    }

    private ListNode getLoop(ListNode loop, ListNode head) {
        ListNode ptr1 = loop;
        ListNode ptr2 = loop;

        int len = 1;
        while (ptr1.next != ptr2){
            ptr1 = ptr1.next;
            len++;
        }

        ptr1 = head;
        ptr2 = head;
        for (int i = 0; i < len; i++) {
            ptr2 = ptr2.next;
        }
        while (ptr1 != ptr2){
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return ptr1;
    }
}
