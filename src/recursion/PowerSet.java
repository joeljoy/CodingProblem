package recursion;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {

    List<List<Integer>> resultList = new ArrayList<>();

    public int[][] subsets(int[] A) {
        generatePowerSet(A, 0, new ArrayList<Integer>());
        return getArraysFromList();
    }

    private void generatePowerSet(int[] arr, int index, List<Integer> current) {
        resultList.add(current);
        for (int i = index; i < arr.length; i++) {
            List<Integer> tempList = new ArrayList<>(current);
            tempList.add(arr[i]);
            generatePowerSet(arr, i+1, tempList);
        }
    }

    private int[][] getArraysFromList() {
        int[][] array = new int[resultList.size()][];
        for (int i = 0; i < resultList.size(); i++) {
            List<Integer> row = resultList.get(i);
            int[] intRow = new int[row.size()];
            for (int g = 0; g < row.size(); g++) {
                intRow[g] = row.get(g);
            }
            array[i] = intRow;
        }
        return array;
    }

    // Driver code
    public static void main(String[] args) {
        int[] a = {12, 13};
        PowerSet set = new PowerSet();
        int[][] res = set.subsets(a);
        System.out.println(res);
    }
}
