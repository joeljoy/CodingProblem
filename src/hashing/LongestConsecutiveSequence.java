package hashing;

import java.util.HashSet;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] a = {100, 4, 200, 1, 3, 2};
        LongestConsecutiveSequence sequence = new LongestConsecutiveSequence();
        System.out.println(sequence.longestConsecutive(a));
    }

    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int longestConsecutive(final int[] A) {
        int count = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int a : A) {
            set.add(a);
        }

        for (int i = 0; i < A.length; i++) {
            if (!set.contains(A[i] - 1)) {
                int j = A[i];
                while (set.contains(j)) {
                    j++;
                }
                if (count < (j - A[i])) {
                    count = j - A[i];
                }
            }
        }
        return count;
    }
}
