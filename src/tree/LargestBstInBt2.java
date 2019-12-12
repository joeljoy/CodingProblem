package tree;

class Info {
    int size;
    int min;
    int max;
    int ans;
    boolean isBst;

    public Info(int size, int min, int max, int ans, boolean isBst) {
        this.size = size;
        this.min = min;
        this.max = max;
        this.ans = ans;
        this.isBst = isBst;
    }

    public Info() {
    }
}

public class LargestBstInBt2 {
    public int solve(TreeNode A) {
        return largestBst(A).ans;
    }

    private Info largestBst(TreeNode root) {
        if (root == null) {
            return new Info(0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, true);
        }
        if (root.right == null && root.left == null) {
            return new Info(1, root.val, root.val, 1, true);
        }

        Info l = largestBst(root.left);
        Info r = largestBst(root.right);

        Info temp = new Info();
        temp.size = l.size + 1 + r.size;

        if (l.isBst && r.isBst && l.max < root.val && root.val < r.min) {
            temp.min = Math.min(l.min, Math.min(root.val, r.min));
            temp.max = Math.max(r.max, Math.max(root.val, l.max));
            temp.isBst = true;
            temp.ans = temp.size;
            return temp;
        }

        temp.ans = Math.max(l.ans, r.ans);
        temp.isBst = false;
        return temp;
    }
}
