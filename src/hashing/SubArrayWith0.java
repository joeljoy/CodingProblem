package hashing;

import java.util.HashMap;
import java.util.HashSet;

public class SubArrayWith0 {
    public int solve(int[] A) {
        HashSet<Long> set = new HashSet<>();
        long sum = 0L;
        for (int i1 : A) {
            sum += i1;
            if (i1 == 0 || sum == 0 || set.contains(sum)) {
                return 1;
            }
            set.add(sum);
        }
        return 0;
    }
}
