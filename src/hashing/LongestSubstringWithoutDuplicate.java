package hashing;

import java.util.HashSet;

public class LongestSubstringWithoutDuplicate {
    public int lengthOfLongestSubstring(String A) {
        HashSet<Character> set = new HashSet<>();
        int longestLength = Integer.MIN_VALUE;
        int i = 0;
        int j = 0;
        while (j < A.length() && i <= j) {
            if (!set.contains(A.charAt(j))) {
                set.add(A.charAt(j));
                j++;
            } else {
                while (set.contains(A.charAt(j))) {
                    set.remove(A.charAt(i));
                    i++;
                }
            }
            int length = j - i;
            if (longestLength < length) {
                longestLength = length;
            }
        }
        return longestLength;
    }
}
