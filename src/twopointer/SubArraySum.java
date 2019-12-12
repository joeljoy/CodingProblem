package twopointer;

import java.util.Arrays;

public class SubArraySum {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = new int[1101];
        for (int i = 0; i < 1101; i++) {
            b[i] = i + 1;
        }
        SubArraySum sum = new SubArraySum();
        int[] res = sum.solve(a, 5);
        System.out.println(Arrays.toString(res));
    }

    public int[] solve(int[] A, int B) {
        long sum = A[0];
        int i = 0;
        int j = 0;
        boolean isFound = false;
        while (i <= j && j < A.length) {
            if (sum == B) {
                isFound = true;
                break;
            } else if (sum < B) {
                j++;
                if (j < A.length) {
                    sum += A[j];
                }
            } else {
                sum -= A[i];
                i++;
            }
        }
        if (isFound) {
            return Arrays.copyOfRange(A, i, j + 1);
        } else {
            return new int[]{-1};
        }
    }
}
