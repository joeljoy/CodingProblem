package Sorting;

import java.util.Arrays;

public class MaxMin {
    public int solve(int[] A, int B) {
        Arrays.sort(A);
        int bthMax = A[A.length - B];
        int bthMin = A[B - 1];
        return bthMax - bthMin;
    }
}
