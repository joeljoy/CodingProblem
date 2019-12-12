package practise_challenge;

import java.util.Arrays;

public class DivideArray {
    public static void main(String[] args) {
//        int[] a = {2, 0, 0, 6, 8, 7, 3, 0, 0, 4};
        int[] a = {1, 6, 5, 7, 1, 2, 8, 0, 5, 5};
//        int[] a = {1, 3, 7, 1};
        DivideArray array = new DivideArray();
        System.out.println(array.solve(a));
    }

    public int solve(int[] A) {
        Arrays.sort(A);
        int[] preSum = new int[A.length];
        int result = 0;
        preSum[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            preSum[i] = preSum[i - 1] + A[i];
        }

        int[] sufSum = new int[A.length];
        sufSum[A.length - 1] = A[A.length - 1];
        for (int i = A.length - 2; i >= 0; i--) {
            sufSum[i] = sufSum[i + 1] + A[i];
        }

        for (int i = 1; i < A.length; i++) {
            int current = sufSum[i] * preSum[i - 1];
            if (current > result) {
                result = current;
            }
        }

        if (sufSum[0] > result) {
            result = sufSum[0];
        }
        return result;
    }
}
