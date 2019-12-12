package tree;

import java.util.Stack;

public class KthSmallestElement {
    public int kthsmallest(TreeNode A, int B) {
        return inorder(A, B);
    }

    private int inorder(TreeNode A, int B) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = A;
        int count = 1;
        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.add(current);
                current = current.left;
            }
            current = stack.pop();
            count++;
            if (count == B) {
                return current.val;
            }
            current = current.right;
        }
        return -1;
    }
}
