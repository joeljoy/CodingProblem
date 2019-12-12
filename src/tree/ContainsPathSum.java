package tree;

import java.util.ArrayList;

public class ContainsPathSum {

    private boolean isFound = false;

    public int hasPathSum(TreeNode A, int B) {
        isFound = false;
        findPath(A, 0, B);
        return isFound ? 1 : 0;
    }

    private void findPath(TreeNode A, int val, int B) {
        if (A == null) {
            return;
        }

        val += A.val;

        if (A.left == null && A.right == null && val == B) {
            isFound = true;
        }
        findPath(A.left, val, B);
        findPath(A.right, val, B);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
//        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(7);
//        root.left.left.right = new TreeNode(2);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
//        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        ContainsPathSum sum = new ContainsPathSum();
        System.out.println(sum.hasPathSum(root, 22));
    }

}
