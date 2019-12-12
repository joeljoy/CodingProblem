package greedy;

public class Bulb {
    public int bulbs(int[] A) {
        int minSwaps = 0;
        for (int i = A.length - 2; i >= 0; i--) {
            if (A[i] != A[i + 1]) {
                minSwaps++;
            }
        }
        return minSwaps;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 0, 0, 1, 1, 0, 0, 1};
        Bulb bulb = new Bulb();
        System.out.println(bulb.bulbs(a));
    }
}
