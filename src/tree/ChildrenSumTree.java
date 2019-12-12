package tree;

public class ChildrenSumTree {

    public TreeNode solve(TreeNode A) {
        sum(A);
        return A;
    }

    private void sum(TreeNode A) {
        int leftVal = 0;
        int rightval = 0;
        int diff = 0;

        if (A == null || (A.left == null && A.right == null)) {
            return;
        }
        sum(A.left);
        sum(A.right);

        if (A.left != null) {
            leftVal = A.left.val;
        }

        if (A.right != null) {
            rightval = A.right.val;
        }

        diff = (rightval + leftVal) - A.val;
        if (diff > 0) {
            A.val += diff;
        } else if (diff < 0) {
            increment(A, -diff);
        }
    }

    private void increment(TreeNode a, int diff) {
        if (a.left != null) {
            a.left.val += diff;
            increment(a.left, diff);
        } else if (a.right != null) {
            a.right.val += diff;
            increment(a.right, diff);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(151);
        root.left = new TreeNode(172);
//        root.left.left = new TreeNode(11);
        root.left.right = new TreeNode(148);
//        root.left.left.left = new TreeNode(7);
//        root.left.left.right = new TreeNode(2);

        root.right = new TreeNode(88);
//        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(86);
//        root.right.right.left = new TreeNode(5);
//        root.right.right.right = new TreeNode(1);

        ChildrenSumTree tree = new ChildrenSumTree();
        TreeNode res = tree.solve(root);
        System.out.println(res);
    }
}
