package tree;

public class BstInRange {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(15);
        root.left = new TreeNode(12);
        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(14);
        root.left.left.left = new TreeNode(8);

        root.right = new TreeNode(20);
        root.right.left = new TreeNode(16);
        root.right.right = new TreeNode(27);

        BstInRange bstInRange = new BstInRange();
        System.out.println(bstInRange.solve(root, 12, 20));
    }

    public int solve(TreeNode A, int B, int C) {
        if (A == null) return 0;
        if (A.val >= B && A.val <= C) {
            return solve(A.left, B, C) + 1 + solve(A.right, B, C);
        } else if (A.val > C) {
            return solve(A.left, B, C);
        } else {
            return solve(A.right, B, C);
        }
    }
}
