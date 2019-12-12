package tree;

public class BuildTreeInorderPreOrder {

    private int pIndex;

    public TreeNode buildTree(int[] A, int[] B) {
        pIndex = 0;
        return build(A, B, 0, A.length - 1);
    }

    public TreeNode build(int[] pre, int[] in, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }

        TreeNode node = new TreeNode(pre[pIndex]);
        pIndex++;
        if (inStart == inEnd) {
            return node;
        }
        int index = getIndex(in, inStart, inEnd, node.val);
        node.left = build(pre, in, inStart, index - 1);
        node.right = build(pre, in, index + 1, inEnd);
        return node;
    }

    private int getIndex(int[] in, int inStart, int inEnd, int val) {
        for (int i = inStart; i <= inEnd; i++) {
            if (in[i] == val) {
                return i;
            }
        }
        return -1;
    }
}
