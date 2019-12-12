package tree;

public class LCA {
    private boolean bFound = false;
    private boolean cFound = false;

    public int lca(TreeNode A, int B, int C) {
        bFound = false;
        cFound = false;
        TreeNode lca = findLca(A, B, C);
        if (bFound && cFound) {
            return lca.val;
        } else {
            return -1;
        }
    }

    private TreeNode findLca(TreeNode a, int b, int c) {
        if (a == null) return null;
        TreeNode temp = null;
        if (a.val == b) {
            bFound = true;
            temp = a;
        }
        if (a.val == c) {
            cFound = true;
            temp = a;
        }

        TreeNode left = findLca(a.left, b, c);
        TreeNode right = findLca(a.right, b, c);

        if (temp != null) {
            return temp;
        }

        if (left != null && right != null) {
            return a;
        }

        if (left != null)
            return left;
        else
            return right;
    }
}
