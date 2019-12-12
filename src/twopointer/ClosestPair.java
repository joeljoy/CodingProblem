package twopointer;

import java.util.Arrays;

public class ClosestPair {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 4, 6, 8};
        int[] c = {5, 10, 20};
        int[] d = {1, 2, 30};
        int[] e = {1};
        int[] f = {2, 4};
        ClosestPair pair = new ClosestPair();
        int[] res = pair.solve(e, f, 4);
        System.out.println(Arrays.toString(res));
    }

    public int[] solve(int[] A, int[] B, int C) {
        int i = 0;
        int j = B.length - 1;
        int minDiff = Integer.MAX_VALUE;
        int currentI = Integer.MAX_VALUE;
        int currentJ = Integer.MAX_VALUE;
        while (i < A.length && j > -1) {
            int current = A[i] + B[j] - C;
            if (Math.abs(current) < minDiff) {
                minDiff = Math.abs(current);
                currentI = i;
                currentJ = j;
            } else if (Math.abs(current) == minDiff) {
                if (i < currentI) {
                    currentI = i;
                } else if (i == currentI) {
                    if (j < currentJ) {
                        currentJ = j;
                    }
                }
            }

            if (A[i] + B[j] > C) {
                j--;
            } else {
                i++;
            }
        }

        int[] res = new int[2];
        res[0] = A[currentI];
        res[1] = B[currentJ];
        return res;
    }
}
