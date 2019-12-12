package tree;

public class SymmetricBt {
    public int isSymmetric(TreeNode A) {
        return checkSymmetric(A, A) ? 1 : 0;
    }

    private boolean checkSymmetric(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return true;
        }
        if (A != null && B != null && A.val == B.val) {
            return checkSymmetric(A.left, B.right) && checkSymmetric(A.right, B.left);
        }
        return false;
    }
}
