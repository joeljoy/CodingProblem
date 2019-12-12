package hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class DiffK2 {
    public static void main(String[] args) {
        int[] a = {34, 63, 64, 38, 65, 83, 50, 44, 18, 34, 71, 80, 22, 28, 20, 96, 33, 70, 0, 25, 64, 96, 18, 2, 53, 100, 24, 47, 98, 69, 60, 55, 8, 38, 72, 94, 18, 68, 0, 53, 18, 30, 86, 55, 13, 93, 15, 43, 73, 68, 29};
        int[] b = {77, 28, 19, 21, 67, 15, 53, 25, 82, 52, 8, 94, 50, 30, 37, 39, 9, 43, 35, 48, 82, 53, 16, 20, 13, 95, 18, 67, 77, 12, 93, 0};
        DiffK2 diffK2 = new DiffK2();
        System.out.println(diffK2.diffPossible(b, 53));
    }

    public int diffPossible(final int[] A, int B) {
        HashMap<Integer, Integer> set = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            set.put(A[i], i);
        }
        for (int i = 0; i < A.length; i++) {
            int number = A[i] + B;
            if (set.containsKey(number)) {
                if (i != set.get(number))
                    return 1;
            }
        }
        return 0;
    }
}
