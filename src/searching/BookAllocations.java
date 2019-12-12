package searching;

public class BookAllocations {
    public static void main(String[] args) {

    }
    public int books(int[] A, int B) {
        if (B > A.length) return -1;
        int low = A[0];
        for (int i = 1; i < A.length; i++) {
            low = Math.min(low, A[i]);
        }

        int high = 0;
        for (int i = 0; i < A.length; i++) {
            high += A[i];
        }

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (checkPossible(A, mid, B)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean checkPossible(int[] a, int mid, int b) {
        int students = 1;
        int total = 0;
        for (int i = 0; i < a.length; i++) {
            total += a[i];
            if (total > mid) {
                total = a[i];
                students++;
            }
        }
        return students <= b;
    }
}
