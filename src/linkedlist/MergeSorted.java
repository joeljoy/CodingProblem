package linkedlist;

public class MergeSorted {
    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode ptrA = A;
        ListNode ptrB = B;
        ListNode head = null;
        ListNode ptrC = null;
        while (ptrA != null && ptrB != null) {
            ListNode temp;
            if (ptrA.val < ptrB.val) {
                temp = new ListNode(ptrA.val);
                ptrA = ptrA.next;
            } else {
                temp = new ListNode(ptrB.val);
                ptrB = ptrB.next;
            }
            if (head == null) {
                head = temp;
                ptrC = head;
            } else {
                ptrC.next = temp;
                ptrC = temp;
            }
        }

        while (ptrA != null) {
            ListNode temp = new ListNode(ptrA.val);
            if (head == null) {
                head = temp;
                ptrC = head;
            } else {
                ptrC.next = temp;
                ptrC = temp;
            }
            ptrA = ptrA.next;
        }

        while (ptrB != null) {
            ListNode temp = new ListNode(ptrB.val);
            if (head == null) {
                head = temp;
                ptrC = head;
            } else {
                ptrC.next = temp;
                ptrC = temp;
            }
            ptrB = ptrB.next;
        }
        return head;
    }
}
