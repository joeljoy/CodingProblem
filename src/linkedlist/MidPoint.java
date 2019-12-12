package linkedlist;

public class MidPoint {
    public int solve(ListNode A) {
        ListNode slow = A;
        ListNode fast = A;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.val;
    }
}
