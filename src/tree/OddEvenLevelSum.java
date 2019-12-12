package tree;

public class OddEvenLevelSum {

    private int oddSum;
    private int evenSum;

    public int solve(TreeNode A) {
        oddSum = 0;
        evenSum = 0;
        recur(A, 1);
        return evenSum - oddSum;
    }

    private void recur(TreeNode A, int level) {
        if (A == null) return;
        if (level % 2 == 0) {
            oddSum += A.val;
        } else {
            evenSum += A.val;
        }
        recur(A.left, level + 1);
        recur(A.right, level + 1);
    }
}
