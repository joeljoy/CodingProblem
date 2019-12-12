import java.util.Arrays;

public class LongestIncreasingSubSequence {

    public static void main(String[] args) {
        int[] a = {2, 5, 1, 3, 4, 8, 3, 6, 7};
        System.out.println(Arrays.toString(getLongestSubsequents(a)));
    }

    private static int[] getLongestSubsequents(int[] A) {
        int[] lis = new int[A.length];
        for (int i = 2; i < A.length; i++) {
            int maxSoFar = -1;
            for (int j = 1; j < i; j++) {
                if (A[j] < A[i]) {
                    int localMax = lis[j] + 1;
                    if (localMax > maxSoFar) {
                        maxSoFar = localMax;
                    }
                }
            }
            lis[i] = maxSoFar == -1 ? 1 : maxSoFar;

        }
        return lis;
    }
}
