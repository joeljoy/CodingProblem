package Sorting;

import java.util.Arrays;

public class TeamDistribution {
    public String solve(int[] A) {
        Arrays.sort(A);
        int mid = (A.length / 2);
        if (A[mid] > A[mid - 1]) {
            return "Yes";
        } else {
            return "No";
        }
    }
}
