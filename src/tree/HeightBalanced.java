package tree;

public class HeightBalanced {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.left.right = new TreeNode(5);

        HeightBalanced balanced = new HeightBalanced();
        System.out.println(balanced.isBalanced(root));
    }

    public int isBalanced(TreeNode A) {
        if (A == null) return 1;
        int lHeight = getHeight(A.left);
        int rHeight = getHeight(A.right);
        int diff = Math.abs(lHeight - rHeight);
        return diff <= 1 && isBalanced(A.left) == 1 && isBalanced(A.right) == 1 ? 1 : 0;
    }

    private int getHeight(TreeNode treeNode) {
        if (treeNode == null) return 0;
        return 1 + Math.max(getHeight(treeNode.left), getHeight(treeNode.right));
    }
}
