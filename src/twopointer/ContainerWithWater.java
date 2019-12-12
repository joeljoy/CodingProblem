package twopointer;

public class ContainerWithWater {
    public static void main(String[] args) {
        int[] a = {1, 5, 4, 3};
        ContainerWithWater water = new ContainerWithWater();
        System.out.println(water.maxArea(a));
    }

    public int maxArea(int[] A) {
        int maxVolume = 0;
        int i = 0;
        int j = A.length - 1;
        while (i < j) {
            int width = j - i;
            int current;
            if (A[i] < A[j]) {
                current = width * A[i];
                i++;
            } else {
                current = width * A[j];
                j--;
            }
            if (current > maxVolume) {
                maxVolume = current;
            }
        }
        return maxVolume;
    }
}
