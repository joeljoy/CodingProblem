package searching;

import java.util.ArrayList;

public class MatrixSearch {
    public static void main(String[] args) {
        MatrixSearch search = new MatrixSearch();

    }
    public int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {
        int n = a.size();
        int rowIndex = 0;
        int colIndex = a.get(0).size() - 1;

        while (rowIndex < n && colIndex > 0) {
            if (a.get(rowIndex).get(colIndex) == b) {
                return 1;
            } else if (a.get(rowIndex).get(colIndex) < b) {
                rowIndex++;
            } else {
                colIndex--;
            }
        }
        return 0;
    }
}
