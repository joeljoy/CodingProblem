package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Combination {
    public List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        Combination combination = new Combination();
        combination.solve(a, 2);
    }

    public List<List<Integer>> solve(int[] a, int k) {
        generateCombinations(a, 0, 0, new ArrayList<>(), k);
        return result;
    }

    private void generateCombinations(int[] a, int index, int pos, List<Integer> curr, int k) {
        if (index == k) {
            result.add(curr);
            return;
        }
        if (pos == a.length) return;
        List<Integer> add = new ArrayList<>(curr);
        add.add(a[pos]);
        generateCombinations(a, index + 1, pos + 1, add, k);
        List<Integer> remove = new ArrayList<>(add);
        remove.remove(remove.size() - 1);
        generateCombinations(a, index, pos + 1, remove, k);
    }
}
