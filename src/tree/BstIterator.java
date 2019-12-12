package tree;

import java.util.Stack;

public class BstIterator {

    private Stack<TreeNode> stack = new Stack<>();

    public BstIterator(TreeNode root) {
        TreeNode current = root;
        while (current != null) {
            stack.add(current);
            current = current.left;
        }
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next() {
        TreeNode top = stack.pop();
        if (top.right != null) {
            TreeNode i = top.right;
            while (i != null) {
                stack.add(i);
                i = i.left;
            }
        }
        return top.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.left.right = new TreeNode(5);

        BstIterator iterator = new BstIterator(root);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
