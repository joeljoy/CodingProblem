package greedy;

import java.util.Arrays;

public class MiceNHoles {
    public int mice(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int result = 0;
        for (int i = 0; i < A.length; i++) {
            result = Math.max(result, Math.abs(A[i] - B[i]));
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {-10, -79, -79, 67, 93, -85, -28, -94};
        int[] b = {-2, 9, 69, 25, -31, 23, 50, 78};
        MiceNHoles holes = new MiceNHoles();
        System.out.println(holes.mice(a, b));
    }
}
