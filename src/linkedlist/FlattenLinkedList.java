package linkedlist;

class ListNode1 {
    int val;
    ListNode1 right, down;

    ListNode1(int x) {
        val = x;
        right = down = null;
    }
}

public class FlattenLinkedList {
    ListNode1 flatten(ListNode1 root) {
        if (root == null || root.right == null) {
            return root;
        }

        root.right = flatten(root.right);

        root = merge(root, root.right);
        return root;
    }

    private ListNode1 merge(ListNode1 a, ListNode1 b) {
        if (a == null) return b;
        if (b == null) return a;
        ListNode1 result;
        if (a.val < b.val) {
            result = a;
            result.down = merge(a.down, b);
        } else {
            result = b;
            result.down = merge(a, b.down);
        }
        return result;
    }
}
