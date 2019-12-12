package linkedlist;

class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class RemoveNthNode {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node = new ListNode(2);
        head.next = node;
        ListNode node1 = new ListNode(3);
        node.next = node1;
        ListNode node2 = new ListNode(4);
        node1.next = node2;
        ListNode node3 = new ListNode(5);
        node2.next = node3;
        node3.next = null;

        RemoveNthNode nthNode = new RemoveNthNode();
        ListNode res = nthNode.removeNthFromEnd(head,2);
    }

    public ListNode removeNthFromEnd(ListNode A, int B) {
        int size = 0;
        ListNode temp = A;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        if (B < size) {
            int length = size - B;
            ListNode current = A;
            ListNode prev = current;
            while (length != 0) {
                prev = current;
                current = current.next;
                length--;
            }
            prev.next = current.next;
            return A;
        } else {
            ListNode head = A.next;
            A.next = null;
            return head;
        }
    }
}
