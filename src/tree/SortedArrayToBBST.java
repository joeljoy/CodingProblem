package tree;

import java.util.List;

public class SortedArrayToBBST {
    public TreeNode sortedArrayToBST(final List<Integer> a) {
        return create(a, 0, a.size() - 1);
    }

    private TreeNode create(List<Integer> a, int start, int end) {
        if (start <= end) {
            int mid = start + (end - start) / 2;
            TreeNode root = new TreeNode(a.get(mid));
            root.left = create(a, start, mid);
            root.right = create(a, mid + 1, end);
            return root;
        } else {
            return null;
        }
    }
}
