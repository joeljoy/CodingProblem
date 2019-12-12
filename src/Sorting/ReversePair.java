package Sorting;

public class ReversePair {
    public static void main(String[] args) {
        ReversePair pair = new ReversePair();
        int[] a = {2, 4, 3, 5, 1};
        System.out.println(pair.solve(a));
    }

    public int solve(int[] A) {
        int[] temp = new int[A.length];
        return sortAndCount(A, temp, 0, A.length - 1);
    }

    private int sortAndCount(int[] A, int[] temp, int start, int end) {
        int count = 0;
        if (start < end) {
            int mid = (start + end) / 2;
            count += sortAndCount(A, temp, start, mid);
            count += sortAndCount(A, temp, mid + 1, end);
            count += merge(A, temp, start, mid + 1, end);
        }
        return count;
    }

    private int merge(int[] A, int[] temp, int start, int mid, int end) {
        int count = 0;
        int l = start, r = mid;

        while (l < mid && r <= end) {
            if ((long) A[l] > 2 * (long) A[r]) {
                count += (mid - l);
                r++;
            } else l++;
        }
        int k = start;
        r = mid;
        l = start;

        while (l < mid && r <= end) {
            if (A[l] > A[r]) temp[k++] = A[r++];
            else temp[k++] = A[l++];
        }
        while (l < mid) {
            temp[k++] = A[l++];
        }
        while (r <= end) {
            temp[k++] = A[r++];
        }
        for (int i = start; i <= end; i++) {
            A[i] = temp[i];
        }
        return count;
    }
}
