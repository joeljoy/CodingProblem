package Sorting;

public class SmallAfterSelf {
    public int[] solve(int[] A) {
        int[] inv = new int[A.length];
        int[] index = new int[A.length];
        for (int i = 0; i < A.length; i++)
            index[i] = i;
        sortAndMerge(A, 0, A.length - 1, inv, index);
        return inv;
    }

    private static long sortAndMerge(int[] arr, int low, int high, int[] inv, int[] index) {
        long count = 0;
        if (low < high) {
            int mid = (low + high) / 2;
            count += sortAndMerge(arr, low, mid, inv, index);
            count += sortAndMerge(arr, mid + 1, high, inv, index);
            merge(arr, low, high, mid, inv, index);
        }
        return count;
    }

    private static void merge(int[] arr, int start, int high, int mid, int[] inv, int[] index) {
        int i = start;
        int j = mid + 1;
        int k = 0;
        int[] temp = new int[high - start + 1];
        int rightcount = 0;
        while (i <= mid && j <= high) {
            if (arr[index[j]] < arr[index[i]]) {
                temp[k++] = index[j++];
                rightcount++;
            } else {
                temp[k++] = index[i];
                inv[index[i]] += rightcount;
                i++;
            }

        }
        while (i <= mid) {
            temp[k++] = index[i];
            inv[index[i]] += rightcount;
            i++;
        }
        while (j <= high)
            temp[k++] = index[j++];

        System.arraycopy(temp, 0, index, start, high - start + 1);
    }
}