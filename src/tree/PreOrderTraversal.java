package tree;

import java.util.ArrayList;

public class PreOrderTraversal {

    ArrayList<Integer> list;

    public int[] preorderTraversal(TreeNode A) {
        list = new ArrayList<>();
        preOrder(A);
        return listToArray();
    }

    private void preOrder(TreeNode A) {
        if (A != null) {
            preOrder(A.left);
            list.add(A.val);
            preOrder(A.right);
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
