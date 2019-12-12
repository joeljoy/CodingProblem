package searching;

import java.util.Arrays;

public class PeakElement {

    public static void main(String[] args) {
        PeakElement element = new PeakElement();
        int[] a = {5, 17, 100, 11};
        System.out.println(element.solve(a));
    }

    public int solve(int[] A) {
        int i = 1;
        while (i < A.length - 1) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                return A[i];
            }
            i++;
        }
        int max = A[0];
        i = 1;
        while (i < A.length) {
            max = Math.max(max, A[i]);
            i++;
        }
        return max;
    }
}
