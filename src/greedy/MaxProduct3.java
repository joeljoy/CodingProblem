package greedy;

import java.util.Arrays;

public class MaxProduct3 {
    public int maxp3(int[] A) {
        Arrays.sort(A);
        int top3 = A[A.length - 1] * A[A.length - 2] * A[A.length - 3];
        int top1Least2 = A[0] * A[1] * A[A.length - 1];
        return Math.max(top3, top1Least2);
    }
}
