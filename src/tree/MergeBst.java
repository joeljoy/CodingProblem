package tree;

import java.util.ArrayList;
import java.util.Stack;

public class MergeBst {

    private ArrayList<Integer> result = new ArrayList<>();

    public ArrayList<Integer> solve(TreeNode A, TreeNode B) {
        result = new ArrayList<>();
        if (A == null) {
            inorder(B);
            return result;
        }
        if (B == null) {
            inorder(A);
            return result;
        }
        TreeNode current1 = A;
        TreeNode current2 = B;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        while ((!stack1.empty() || current1 != null) || !stack2.empty() || current2 != null) {
            while (current1 != null) {
                stack1.add(current1);
                current1 = current1.left;
            }

            while (current2 != null) {
                stack2.add(current2);
                current2 = current2.left;
            }

            if (stack1.isEmpty()) {
                while (!stack2.isEmpty()) {
                    current2 = stack2.pop();
                    current2.left = null;
                    inorder(current2);
                }
                return result;
            }

            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    current1 = stack1.pop();
                    current1.left = null;
                    inorder(current1);
                }
                return result;
            }

            current1 = stack1.pop();
            current2 = stack2.pop();

            if (current1.val < current2.val) {
                result.add(current1.val);
                stack2.push(current2);
                current1 = current1.right;
                current2 = null;
            } else {
                result.add(current2.val);
                stack1.push(current1);
                current2 = current2.right;
                current1 = null;
            }

        }
        return result;
    }

    private void inorder(TreeNode A) {
        if (A != null) {
            inorder(A.left);
            result.add(A.val);
            inorder(A.right);
        }
    }
}
