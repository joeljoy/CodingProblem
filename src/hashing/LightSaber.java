package hashing;

import java.util.HashMap;

public class LightSaber {
    public static void main(String[] args) {
        int[] a = { 3, 3, 3, 3, 3, 4, 2, 1, 1, 3, 1, 2, 1, 1, 4, 4, 1, 1, 1, 2, 1, 2, 3, 3, 3, 2, 2, 2, 4};
        int[] b = {2, 0, 4, 0};
        LightSaber saber = new LightSaber();
        System.out.println(saber.solve(a, b));
    }

    public int solve(int[] A, int[] B) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i])) {
                int c = map.get(A[i]);
                c += 1;
                map.put(A[i], c);
            } else {
                map.put(A[i], 1);
            }
        }
        int minRemoval = 0;
        for (int i = 0; i < B.length; i++) {
            int item = i + 1;
            if (B[i] != 0 && map.get(item) != null) {
                int count = map.get(item);
                if (count < B[i]) {
                    return -1;
                } else
                    minRemoval += count - B[i];
            } else if (B[i] == 0) {
                if (map.get(item) != null) {
                    minRemoval += map.get(item);
                }
            } else {
                return -1;
            }
        }
        return minRemoval;
    }
}
