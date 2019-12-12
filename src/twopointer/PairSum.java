package twopointer;

import java.util.Arrays;

public class PairSum {
    public int solve(int[] A, int B) {
        Arrays.sort(A);
        int i = 0;
        int j = A.length - 1;
        int count = 0;
        while (i < j) {
            if (A[i] + A[j] == B) {
                count++;
                i++;
                j--;
            } else if (A[i] + A[j] > B) {
                j--;
            } else {
                i++;
            }
        }
        return count;
    }
}
