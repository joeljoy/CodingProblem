package Sorting;

public class MinSwaps {

    public static void main(String[] args) {
        int[] a = {1, 12, 10, 3, 14, 10, 5};
        MinSwaps swaps = new MinSwaps();
        System.out.println(swaps.solve(a, 8));
    }

    public int solve(int[] A, int B) {
        int minGap;
        int gapSize = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] <= B) {
                gapSize++;
            }
        }
        int currentCount = 0;
        for (int i = 0; i < gapSize; i++) {
            if (A[i] > B) {
                currentCount++;
            }
        }
        minGap = currentCount;
        int i = 1;
        int j = i + gapSize - 1;
        while (j < A.length) {
            if (A[j] > B) {
                currentCount++;
            }
            if (A[i - 1] > B) {
                currentCount--;
            }
            j++;
            i++;
            minGap = Math.min(currentCount, minGap);
        }
        return minGap;
    }
}
