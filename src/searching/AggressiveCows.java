package searching;

import java.util.Arrays;

public class AggressiveCows {

    public static void main(String[] args) {
        AggressiveCows cows = new AggressiveCows();
        int[] a = {82, 61, 38, 88, 12, 7, 6, 12, 48, 8, 31, 90, 35, 5, 88, 2, 66, 19, 5, 96, 84, 95};
        System.out.println(cows.solve(a, 8));
    }

    public int solve(int[] A, int B) {
        Arrays.sort(A);
        int low = 0;
        int high = A[A.length - 1];
        int max = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (checkCows(mid, A, B)) {
                if (max < mid) {
                    max = mid;
                }
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return max;
    }

    private boolean checkCows(int length, int[] a, int cows) {
        int currentCows = 1;
        int pos = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] - pos >= length) {
                pos = a[i];
                currentCows++;
                if (cows == currentCows)return true;
            }
        }
        return false;
    }
}
