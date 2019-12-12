package twopointer;

public class MinimumAbsoluteDifference {

    public int solve(int[] A, int[] B, int[] C) {
        int i = A.length - 1;
        int j = B.length - 1;
        int k = C.length - 1;
        int minDiff = Integer.MAX_VALUE;
        while (i >= 0 && j >= 0 && k >= 0) {
            int min = Math.min(Math.min(A[i], B[j]), C[k]);
            int max = Math.max(Math.max(A[i], B[j]), C[k]);
            int current = Math.abs(max - min);
            if (current < minDiff) {
                minDiff = current;
            }
            if (max == A[i]) {
                i--;
            } else if (max == B[j]) {
                j--;
            } else {
                k--;
            }
        }
        return minDiff;
    }
}
