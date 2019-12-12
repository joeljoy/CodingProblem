package Sorting;

import java.util.Arrays;

public class AbsoulteDifference {
    public int solve(int[] A) {
        Arrays.sort(A);
        int minValue = Integer.MAX_VALUE;
        for (int i = 1; i < A.length; i++) {
            int currentMin = Math.abs(A[i] - A[i - 1]);
            minValue = Math.min(currentMin, minValue);
        }
        return minValue;
    }
}
