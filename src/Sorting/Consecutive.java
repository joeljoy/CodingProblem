package Sorting;

import java.util.Arrays;

public class Consecutive {
    public int solve(int[] A) {
        Arrays.sort(A);
        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] + 1 != A[i] ){
                return 0;
            }
        }
        return 1;
    }
}
