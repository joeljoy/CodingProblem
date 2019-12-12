package stack;

public class LargestAreaHistogram {
    public static void main(String[] args) {
//        int[] a ={90, 58, 69, 70, 82, 100, 13, 57, 47, 18};
        int[] a ={47, 69, 67, 97, 86, 34, 98, 16, 65, 95, 66, 69, 18, 1, 99, 56, 35, 9, 48, 72, 49, 47, 1, 72, 87, 52, 13, 23, 95, 55, 21, 92, 36, 88, 48, 39, 84, 16, 15, 65, 7, 58, 2, 21, 54, 2, 71, 92, 96, 100, 28, 31, 24, 10, 94, 5, 81, 80, 43, 35, 67, 33, 39, 81, 69, 12, 66, 87, 86, 11, 49, 94, 38, 44, 72, 44, 18, 97, 23, 11, 30, 72, 51, 61, 56, 41, 30, 71, 12, 44, 81, 43, 43, 27};
        LargestAreaHistogram histogram = new LargestAreaHistogram();
        System.out.println(histogram.largestRectangleArea(a));
    }
    public int largestRectangleArea(int[] A) {
        int maxArea = A[0];
        for (int i = 0; i < A.length; i++) {
            int current = A[i];
            int currentArea;
            for (int j = i+1; j < A.length - 1; j++) {
                if (A[j] < current) {
                    current = A[j];
                }
                currentArea = current * (j - i + 1);
                if (currentArea > maxArea) {
                    maxArea = currentArea;
                }
            }
        }
        return maxArea;
    }
}
