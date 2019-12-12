package searching;

import java.util.Arrays;

public class MatrixMedian {

    public static void main(String[] args) {
        int[][] a = {
                {1, 3, 5},
                {2, 6, 9},
                {3, 6, 9}
        };
        int[][] b = {
                {3, 7, 7},
                {2, 9, 9},
                {3, 3, 4},
                {2, 7, 10},
                {1, 7, 7},
                {4, 9, 10},
                {5, 7, 10},
                {5, 6, 9},
                {1, 1, 2}};
        MatrixMedian matrixMedian = new MatrixMedian();
        System.out.println(matrixMedian.findMedian(b));
    }

    public int findMedian(int[][] A) {
        int m = A.length;
        int n = A[0].length - 1;
        int low = A[0][0];
        int high = A[0][n];
        for (int i = 1; i < A.length; i++) {
            low = Math.min(low, A[i][0]);
            high = Math.max(high, A[i][n]);
        }

        int desiredMedian = (A.length) * (A[0].length) / 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int allMedian = 0;
            int medianInArray = 0;
            for (int i = 0; i < A.length; i++) {
                medianInArray = Arrays.binarySearch(A[i], mid);
                if (medianInArray < 0) {
                    medianInArray = Math.abs(medianInArray) - 1;
                } else {
                    int j = medianInArray;
                    while (j < A[i].length && A[i][j] == mid) {
                        medianInArray++;
                        j++;
                    }
                }
                allMedian += medianInArray;
            }
            if (allMedian <= desiredMedian) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
