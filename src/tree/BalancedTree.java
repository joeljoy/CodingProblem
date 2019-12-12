package tree;

public class BalancedTree {

    public int isBalanced(TreeNode A) {
        return balanced(A) ? 1 : 0;
    }

    private boolean balanced(TreeNode A) {
        if (A == null) return true;
        return balanced(A.left) && balanced(A.right) &&
                Math.abs(getHeight(A.right) - getHeight(A.left)) <= 1;
    }

    private int getHeight(TreeNode A) {
        if (A == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(A.left), getHeight(A.right));
    }
}
