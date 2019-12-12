package tree;

import java.util.HashSet;
import java.util.Stack;

public class CommonNodes {
    public int solve(TreeNode A, TreeNode B) {
        HashSet<Integer> set = new HashSet<>();
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = A;
        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.add(current);
                current = current.left;
            }

            TreeNode top = stack.pop();
            set.add(top.val);
            current = top.right;
        }

        current = B;
        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.add(current);
                current = current.left;
            }

            TreeNode top = stack.pop();
            if (set.contains(top.val)) {
                sum += top.val;
            }
            current = top.right;
        }
        return sum;
    }
}
