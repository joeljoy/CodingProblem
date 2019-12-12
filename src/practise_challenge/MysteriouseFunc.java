package practise_challenge;

public class MysteriouseFunc {

    public static void main(String[] args) {
//        int[] a = {4, 1, 2, 5, 3};
        int[] a = {296, 383, 79, 1630, 1640, 1913, 520, 154, 932, 578, 707, 1449, 73, 1300, 475};
        MysteriouseFunc func = new MysteriouseFunc();
        System.out.println(func.mysterious_function(a, 393));
    }

    public int mysterious_function(int[] A, int B) {
        double ans = 1;
        for (int i = 0; i < A.length; i++) {
            int a = A[i];
            ans = Math.pow(a, ans) % B;
        }
        return (int) ans % B;
    }
}
