package tree;

public class BuildTree {

    private int pIndex;

    public static void main(String[] args) {
//        int[] in = {2, 1, 3};
//        int[] pre = {2, 3, 1};
        int[] in = {4, 2, 5, 1, 6, 3, 7};
        int[] pre = {4, 5, 2, 6, 7, 3, 1};
        BuildTree tree = new BuildTree();
        TreeNode res = tree.buildTree(in, pre);
        System.out.println();
    }

    public TreeNode buildTree(int[] A, int[] B) {
        pIndex = B.length - 1;
        return create(A, B, 0, A.length - 1);
    }

    private TreeNode create(int[] in, int[] pre, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }

        TreeNode node = new TreeNode(pre[pIndex]);
        pIndex--;
        if (inStart == inEnd) {
            return node;
        }
        int index = getIndexFromInorder(in, inStart, inEnd, node.val);
        node.right = create(in, pre, index + 1, inEnd);
        node.left = create(in, pre, inStart, index - 1);
        return node;
    }

    private int getIndexFromInorder(int[] in, int inStart, int inEnd, int a) {
        for (int i = 0; i < in.length; i++) {
            if (in[i] == a) {
                return i;
            }
        }
        return -1;
    }
}
