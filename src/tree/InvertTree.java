package tree;

public class InvertTree {
    public TreeNode invertTree(TreeNode A) {
        if (A != null) {
            TreeNode temp = A.left;
            A.left = A.right;
            A.right = temp;
            invertTree(A.left);
            invertTree(A.right);
        }
        return A;
    }
}
