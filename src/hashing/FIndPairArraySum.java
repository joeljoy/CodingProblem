package hashing;

import java.util.HashSet;

public class FIndPairArraySum {
    public int solve(int[] A) {
        int count = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            set.add(A[i]);
        }
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (set.contains(A[i] + A[j])) {
                    count++;
                }
            }
        }
        return count;
    }
}
