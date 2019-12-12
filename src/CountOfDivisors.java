import java.lang.management.MemoryType;

public class CountOfDivisors {
    public static void main(String[] args) {
        int[] a = {2, 3, 4, 5};
        int[] b = {10, 20};
        int[] res = solve(b);
        System.out.println("");
    }

    public static int[] solve(int[] A) {
        int[] res = new int[A.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            max = Math.max(A[i], max);
        }
        max++;
        int[] count = new int[max];
        for (int i = 0; i < max; i++) {
            count[i] = 1;
        }
        for (int i = 2; i < max; i++) {
            for (int j = 1; j * i < max; j++) {
                count[i * j]++;
            }
        }
        for (int i = 0; i < A.length; i++) {
            res[i] = count[A[i]];
        }
        return res;
    }

    private static int getDivisors(int a) {
        int count = 0;
        int i;
        for (i = 1; i * i <= a; i++) {
            if (a % i == 0) {
                if (a / i == i) {
                    count += 1;
                } else {
                    count += 2;
                }
            }
        }
        return count;
    }
}
