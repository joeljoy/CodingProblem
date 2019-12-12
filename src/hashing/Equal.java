package hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Equal {
    public static void main(String[] args) {
        Equal equal = new Equal();
//        int[] a = {3, 4, 7, 1, 2, 9, 8};
//        int[] a = {1, 1, 1, 1, 1};
        int[] a = {0, 0, 1, 0, 2, 1};
        int[] res = equal.equal(a);
        System.out.println(Arrays.toString(res));
    }

    public int[] equal(int[] A) {
        int[] res = new int[4];
        int e = -1;
        int f = -1;
        int g = -1;
        int h = -1;
        HashMap<Integer, Pair> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int sum = A[i] + A[j];
                if (map.containsKey(sum)) {
                    Pair pair = map.get(sum);
                    int a = pair.i;
                    int b = pair.j;
                    int c = i;
                    int d = j;
                    if (a < b && a < c && c < d && b != c && b != d) {
                        if (e == -1) {
                            e = a;
                            f = b;
                            g = c;
                            h = d;
                        } else {
                            if (a < e) {
                                e = a;
                                f = b;
                                g = c;
                                h = d;
                            } else if (a == e) {
                                if (b < f) {
                                    f = b;
                                    g = c;
                                    h = d;
                                } else if (b == f) {
                                    if (c < g) {
                                        g = c;
                                        h = d;
                                    } else if (c == g) {
                                        if (d < h) {
                                            h = d;
                                        }
                                    }
                                }
                            }
                        }

                    }
                } else {
                    map.put(sum, new Pair(i, j));
                }

            }
        }
        res[0] = e;
        res[1] = f;
        res[2] = g;
        res[3] = h;
        return res;
    }

    class Pair {
        int i, j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
