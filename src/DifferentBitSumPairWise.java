public class DifferentBitSumPairWise {

    public static void main(String[] args) {
        int[] A = {1, 3, 5};
        DifferentBitSumPairWise d = new DifferentBitSumPairWise();
        System.out.println(d.cntBits1(A));
    }

    public int cntBits1(int[] A) {
        int[] countOne = new int[32];
        for (int i = 0; i < A.length; i++) {
            int a = A[i];
            for (int j = 0; j < 32; j++) {
                countOne[j] += a & 1;
                a = a >> 1;
            }
        }
        long res = 0;
        for (int i = 0; i < 32; i++) {
            res += ((long) countOne[i] * (A.length - countOne[i])) % 1000000007;
        }
        return (int) (2 * res % 1000000007);
    }
}
