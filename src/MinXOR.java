import java.util.Arrays;

public class MinXOR {

    public int findMinXor(int[] A) {
        Arrays.sort(A);
        int minXor = Integer.MAX_VALUE;
        for (int i = 0; i < A.length - 1; i++) {
            int xor = A[i] ^ A[i + 1];
            minXor = Math.min(xor, minXor);
        }
        return minXor;
    }
}
