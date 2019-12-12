package tree;

/*Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
        An example is the root-to-leaf path 1->2->3 which represents the number 123.
        Find the total sum of all root-to-leaf numbers % 1003*/

import java.util.ArrayList;

public class SumRootLeaf {

    private ArrayList<Integer> sumList = new ArrayList<>();

    public int sumNumbers(TreeNode A) {
        return findSum(A, 0);
    }

    private int findSum(TreeNode a, int intermediate) {
        if (a == null)
            return 0;

        intermediate = (intermediate * 10) + a.val;

        if (a.left == null && a.right == null) {
            return intermediate;
        }

        return (findSum(a.left, intermediate) + findSum(a.right, intermediate)) % 1003;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(8);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(6);

        SumRootLeaf leaf = new SumRootLeaf();
        System.out.println(leaf.sumNumbers(root));
    }
}
