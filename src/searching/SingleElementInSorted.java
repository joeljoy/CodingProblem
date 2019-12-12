package searching;

public class SingleElementInSorted {

    public static void main(String[] args) {
        SingleElementInSorted sorted = new SingleElementInSorted();
        int[] a = {1, 1, 2, 2, 3};
        System.out.println(sorted.solve(a));
    }

    public int solve(int[] A) {
        return search(A, 0, A.length - 1);
    }

    private int search(int[] a, int start, int end) {
        if (start > end) return -1;
        int mid = start + (end - start) / 2;
        if (start == end) {
            return a[start];
        } else if (mid % 2 == 0) {
            if (a[mid + 1] == a[mid]) {
                return search(a, mid + 2, end);
            } else {
                return search(a, start, mid);
            }
        } else {
            if (a[mid - 1] == a[mid]) {
                return search(a, mid + 1, end);
            } else {
                return search(a, start, mid - 1);
            }
        }
    }
}
