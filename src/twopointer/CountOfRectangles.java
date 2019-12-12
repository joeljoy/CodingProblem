package twopointer;

public class CountOfRectangles {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        CountOfRectangles rectangles = new CountOfRectangles();
        System.out.println(rectangles.solve(a, 5));
    }

    public int solve(int[] A, int B) {
        long count = 0, mod = (long) (1e9 + 7);
        int left = 0, right = A.length - 1;
        while (left < A.length && right >= 0) {
            if ((long) A[left] * A[right] < B) {
                count = (count + right + 1) % mod;
                left++;
            } else right--;
        }
        return (int) count;
    }
}
