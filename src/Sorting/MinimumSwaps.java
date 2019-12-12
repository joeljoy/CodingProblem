package Sorting;

public class MinimumSwaps {
    public int solve(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] == i) {
                return i - 1;
            }
        }
        return A.length - 1;
    }
}
