package Sorting;

import java.util.Arrays;

public class GameOfBottles {
    public int solve(int[] A) {
        Arrays.sort(A);
        int count = A.length;
        for (int i = 0; i < A.length -1; i++) {
            if (A[i] < A[i + 1]) {
                count--;
            }
        }
        return count;
    }
}
