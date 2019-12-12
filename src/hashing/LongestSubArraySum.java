package hashing;

import java.util.HashMap;

public class LongestSubArraySum {

    public int solve(int[] A, int B) {
        HashMap<Integer, Integer> set = new HashMap<>();
        int sum = 0;
        int maxLength = -1;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (sum == B) {
                maxLength = i + 1;
            }

            if (!set.containsKey(sum)) {
                set.put(sum, i);
            }

            if (set.containsKey(sum - B)) {
                int length = i - set.get(sum - B);
                if (length > maxLength) {
                    maxLength = length;
                }
            }
        }
        return maxLength;
    }
}
