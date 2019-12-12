import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        NextPermutation p = new NextPermutation();
        int[] a = {1, 2, 3};
        int[] b = {3, 2, 1};
        int[] c = {1, 1, 5};
        int[] d = {20, 50, 113};
        int[] e = {1, 9, 8, 10, 2};
        int[] res = p.nextPermutation(e);
        System.out.println(Arrays.toString(res));
    }

    public int[] nextPermutation(int[] A) {
        int index = -1;
        for (int i = A.length - 1; i > 0; i--) {
            if (A[i] > A[i - 1]) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            Arrays.sort(A);
            return A;
        }

        int i = index;
        int j = A.length - 1;

        while (i < j) {
            int t = A[i];
            A[i] = A[j];
            A[j] = t;

            i++;
            j--;
        }

        int t = A[index];
        A[index] = A[index - 1];
        A[index - 1] = t;
        return A;
    }
}
