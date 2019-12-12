package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ZigZagLevelOrder {

    private ArrayList<ArrayList<Integer>> list;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        ZigZagLevelOrder order = new ZigZagLevelOrder();
        int[][] res = order.zigzagLevelOrder(root);
        for (int[] re : res) {
            System.out.println(Arrays.toString(re));
        }
    }

    public int[][] zigzagLevelOrder(TreeNode A) {
        list = new ArrayList<>();
        zigZag(A);
        return listToArray();
    }

    private void zigZag(TreeNode A) {
        if (A == null) return;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        boolean reverse = false;
        stack1.add(A);

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (!reverse) {
                ArrayList<Integer> temp = new ArrayList<>();
                while (!stack1.isEmpty()) {
                    TreeNode top = stack1.pop();
                    temp.add(top.val);

                    if (top.left != null) {
                        stack2.add(top.left);
                    }
                    if (top.right != null) {
                        stack2.add(top.right);
                    }
                }
                list.add(temp);
            } else {
                ArrayList<Integer> temp = new ArrayList<>();
                while (!stack2.isEmpty()) {
                    TreeNode top = stack2.pop();
                    temp.add(top.val);

                    if (top.right != null) {
                        stack1.add(top.right);
                    }
                    if (top.left != null) {
                        stack1.add(top.left);
                    }
                }
                list.add(temp);
            }
            reverse = !reverse;
        }
    }

    private int[][] listToArray() {
        int[][] array = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            int[] temp = new int[list.get(i).size()];
            for (int j = 0; j < list.get(i).size(); j++) {
                temp[j] = list.get(i).get(j);
            }
            array[i] = temp;
        }
        return array;
    }
}
