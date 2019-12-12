package heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class MergeKSortedLL {
    public ListNode mergeKLists(ArrayList<ListNode> a) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode i : a) {
            pq.add(i);
        }
        ListNode head = null;
        ListNode ptr = head;
        while (!pq.isEmpty()) {
            ListNode top = pq.poll();
            if (top.next != null) {
                pq.add(top.next);
            }
            if (head == null) {
                head = top;
                ptr = head;
            } else {
                ptr.next = top;
                ptr = top;
            }
        }
        return head;
    }
}
