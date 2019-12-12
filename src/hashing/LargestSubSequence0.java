package hashing;

import java.util.Arrays;
import java.util.HashMap;

public class LargestSubSequence0 {
    public static void main(String[] args) {
        LargestSubSequence0 sequence0 = new LargestSubSequence0();
//        int[] a = {1 ,2 ,-2 ,4 ,-4};
//        int[] a = {-8, 8, -1, -16, -28, -27, 15, -14, 14, -27, -5, -6, -25, -11, 28, 29, -3, -25, 17, -25, 4, -20, 2, 1, -17, -10, -25};
//        int[] a = {-19, 8, 2, -8, 19, 5, -2, -23};
        int[] a = {15, -25, 10, -8, -15, 14, -11, 12, 25, 26, -15, -23, -7, -7, 20, 21, -7, -15};
        int[] res = sequence0.lszero(a);
        System.out.println(Arrays.toString(res));
    }

    public int[] lszero(int[] A) {
        HashMap<Long, Integer> map = new HashMap<>();
        long sum = 0L;
        int maxSequence = Integer.MIN_VALUE;
        int start = Integer.MAX_VALUE;
        int end = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (sum == 0) {
                if (i > maxSequence) {
                    maxSequence = i;
                    start = -1;
                    end = i;
                }
            }
            if (map.containsKey(sum)) {
                int currSeq = i - map.get(sum) - 1;
                if (currSeq > maxSequence) {
                    maxSequence = currSeq;
                    start = map.get(sum);
                    end = i;
                } else if (currSeq == maxSequence) {
                    if (map.get(sum) <= start) {
                        start = map.get(sum);
                        end = i;
                    }
                }
            } else {
                map.put(sum, i);
            }
        }
        if (start == Integer.MAX_VALUE || end == Integer.MAX_VALUE) {
            return new int[0];
        }
        return Arrays.copyOfRange(A, start + 1, end + 1);
    }
}
