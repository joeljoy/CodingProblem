package tree;

public class BalancedBt {

    public int isValidBST(TreeNode A) {
        return validBST(A, Integer.MIN_VALUE, Integer.MAX_VALUE) ? 1 : 0;
    }

    private boolean validBST(TreeNode A, int min, int max) {
        if (A == null) {
            return true;
        }
        if (A.val < min || A.val > max) {
            return false;
        }

        return validBST(A.left, min, A.val) && validBST(A.right, A.val, max);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
//        root.left.left.left = new TreeNode(7);
//        root.left.left.right = new TreeNode(8);
        root.right = new TreeNode(8);
//        root.right.right = new TreeNode(6);

        BalancedBt bt = new BalancedBt();
        System.out.println(bt.isValidBST(root));
    }
}
