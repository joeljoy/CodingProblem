package tree;

import java.util.ArrayList;
import java.util.HashSet;

public class LeftViewII {

    private ArrayList<Integer> result;
    private HashSet<Integer> set;

    public ArrayList<Integer> solve(TreeNode A) {
        result = new ArrayList<>();
        set = new HashSet<>();
        preOrder(A, 0);
        return result;
    }

    private void preOrder(TreeNode A, int level) {
        if (A == null) {
            return;
        }
        if (!set.contains(level)) {
            set.add(level);
            result.add(A.val);
        }

        preOrder(A.left,level+1);
        preOrder(A.right,level+1);
    }
}
