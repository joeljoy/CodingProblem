package tree;

import java.util.ArrayList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

public class InorderTraversal {

    ArrayList<Integer> list;

    public int[] inorderTraversal(TreeNode A) {
        list = new ArrayList<>();
        inorder(A);
        return listToArray();
    }

    private void inorder(TreeNode A) {
        if (A != null) {
            inorder(A.left);
            list.add(A.val);
            inorder(A.right);
        }
    }

    private int[] listToArray(){
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
