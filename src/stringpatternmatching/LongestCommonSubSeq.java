package stringpatternmatching;

public class LongestCommonSubSeq {

    public String longestCommonPrefix(String[] A) {
        int minLength = findMinLength(A);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < minLength; i++) {
            char current = A[0].charAt(i);
            for (int j = 1; j < A.length; j++) {
                if (A[j].charAt(i) != current) {
                    return result.toString();
                }
            }
            result.append(current);
        }
        return result.toString();
    }

    private int findMinLength(String[] a) {
        int min = Integer.MAX_VALUE;
        for (String current : a) {
            min = Math.min(min, current.length());
        }
        return min;
    }
}
