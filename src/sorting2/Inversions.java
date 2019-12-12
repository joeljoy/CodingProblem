package sorting2;

public class Inversions {

    private int count;

    public static void main(String[] args) {
        int[] a = {2, 4, 1, 3, 5};
        Inversions inversions = new Inversions();
        System.out.println(inversions.countInversions(a));
    }

    public int countInversions(int[] A) {
        count = 0;
        sort(A, 0, A.length - 1);
        return count;
    }

    private void sort(int[] a, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            sort(a, start, mid);
            sort(a, mid + 1, end);
            merge(a, start, mid, end);
        }
    }

    private void merge(int[] a, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;

        while (i <= mid && j <= end) {
            if (a[i] <= a[j]) {
                temp[k] = a[i];
                k += 1;
                i += 1;
            } else {
                count += mid - i + 1;
                temp[k] = a[j];
                k += 1;
                j += 1;
            }
        }

        while (i <= mid) {
            temp[k] = a[i];
            k += 1;
            i += 1;
        }

        while (j <= end) {
            temp[k] = a[j];
            k += 1;
            j += 1;
        }

        for (i = start; i <= end; i += 1) {
            a[i] = temp[i - start];
        }
    }
}
