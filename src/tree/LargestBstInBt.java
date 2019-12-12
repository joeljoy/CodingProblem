package tree;

public class LargestBstInBt {

    public int solve(TreeNode A) {
        if (isBst(A)) {
            return size(A);
        } else {
            return Math.max(solve(A.left), solve(A.right));
        }
    }

    private boolean isBst(TreeNode a) {
        return isBstUtil(a, null, null);
    }

    private boolean isBstUtil(TreeNode a, TreeNode l, TreeNode r) {
        if (a == null) return true;
        if (l != null && a.val <= l.val) {
            return false;
        }
        if (r != null && a.val >= r.val) {
            return false;
        }
        return isBstUtil(a.left, l, a) && isBstUtil(a.right, a, r);
    }

    int size(TreeNode node) {
        if (node == null)
            return 0;
        else
            return (size(node.left) + 1 + size(node.right));
    }
}
