package tree;

import java.util.ArrayList;

public class PostOrder {
    private ArrayList<Integer> list;

    public int[] postorderTraversal(TreeNode A) {
        list = new ArrayList<>();
        postOrder(A);
        return listToArray();
    }

    private void postOrder(TreeNode a) {
        if (a != null) {
            postOrder(a.left);
            postOrder(a.right);
            list.add(a.val);
        }
    }

    private int[] listToArray() {
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
