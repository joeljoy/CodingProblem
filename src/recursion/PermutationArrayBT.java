package recursion;

import java.util.ArrayList;
import java.util.List;

public class PermutationArrayBT {

    List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        PermutationArrayBT bt = new PermutationArrayBT();
        int[][] res = bt.solve(a);
        System.out.println(res);
    }

    public int[][] solve(int[] a) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            res.add(a[i]);
        }
        generatePermutations(res, 0, a.length - 1);
        return getArraysFromList();
    }

    private void generatePermutations(List<Integer> a, int left, int right) {
        if (left == right) {
            result.add(a);
            return;
        } else {
            for (int i = left; i <= right; i++) {
                a = swap(a, left, i);
                generatePermutations(a, left + 1, right);
                a = swap(a, left, i);
            }
        }
    }

    private List<Integer> swap(List<Integer> a, int i, int j) {
        Integer temp;
        temp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, temp);
        return a;
    }

    private int[][] getArraysFromList() {
        int[][] array = new int[result.size()][];
        for (int i = 0; i < result.size(); i++) {
            List<Integer> row = result.get(i);
            int[] intRow = new int[row.size()];
            for (int g = 0; g < row.size(); g++) {
                intRow[g] = row.get(g);
            }
            array[i] = intRow;
        }
        return array;
    }

}
