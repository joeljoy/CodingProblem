package sorting2;

import java.util.ArrayList;
import java.util.Collections;

public class SumDifference {
    public int solve(ArrayList<Integer> A) {
        int MOD = 1000000007;
        int n = A.size();
        Collections.sort(A);
        long min_sum = 0, max_sum = 0;
        for (int i = 0; i < n; i++) {
            max_sum = 2 * max_sum + A.get(n - 1 - i);
            max_sum %= MOD;
            min_sum = 2 * min_sum + A.get(i);
            min_sum %= MOD;
        }

        return (int) ((max_sum - min_sum + MOD) % MOD);
    }
}
