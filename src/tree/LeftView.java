package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LeftView {
    public ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(A);
        queue.add(null);
        boolean isNewLevel = true;
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node == null) {
                isNewLevel = true;
            } else {
                if (isNewLevel) {
                    result.add(node.val);
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                    queue.add(null);
                    isNewLevel = false;
                }
            }
        }
        return result;
    }
}
