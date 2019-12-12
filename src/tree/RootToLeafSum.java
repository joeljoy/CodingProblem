package tree;

import java.util.ArrayList;
import java.util.Arrays;

public class RootToLeafSum {

    private ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {
        findPath(A, 0, new ArrayList<>(), B);
        return result;
    }

    private void findPath(TreeNode A, int val, ArrayList<Integer> list, int B) {
        if (A == null) {
            return;
        }

        val += A.val;
        list.add(A.val);

        if (A.left == null && A.right == null && val == B){
            ArrayList<Integer> temp = new ArrayList<>(list);
            result.add(temp);
        }

        findPath(A.left, val, list, B);
        findPath(A.right, val, list, B);
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
//        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        RootToLeafSum leaf = new RootToLeafSum();
        ArrayList<ArrayList<Integer>> res = leaf.pathSum(root, 22);
        for (ArrayList<Integer> list : res) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
