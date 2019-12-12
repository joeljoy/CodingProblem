package practise_challenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class SortWith {

    public static void main(String[] args) {
        SortWith sortWith = new SortWith();
        int[] a = {5, 17, 100, 11};
        int[] b = {1, 10};
        System.out.println(Arrays.toString(sortWith.solve(a, b)));
    }

    public int[] solve(int[] A, int[] B) {
        int[] res = new int[A.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        int k = 0;
        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i])) {
                int c = map.get(A[i]);
                c += 1;
                map.put(A[i], c);
            } else {
                map.put(A[i], 1);
            }
        }

        for (int i = 0; i < B.length; i++) {
            if (map.containsKey(B[i])) {
                int len = map.get(B[i]);
                for (int j = 0; j < len; j++) {
                    res[k] = B[i];
                    k++;
                }
                map.remove(B[i]);
            }
        }

        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
            if (map.get(A[i]) != null) {
                res[k] = A[i];
                k++;
            }
        }
        return res;
    }
}
