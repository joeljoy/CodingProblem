package twopointer;

import java.util.Arrays;

public class CountingTriangles {
    public int nTriang(int[] A) {
        Arrays.sort(A);
        long count = 0;
        for (int k = A.length - 1; k >= 0; k--) {
            int i = 0;
            int j = k - 1;
            while (i < j) {
                if (A[i] + A[j] > A[k]) {
                    count += j - i;
                    j--;
                } else {
                    i++;
                }
            }
        }
        return (int) (count % 1000000007);
    }
}
