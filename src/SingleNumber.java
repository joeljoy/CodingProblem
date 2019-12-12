public class SingleNumber {
    public int singleNumber(final int[] A) {
        int single = A[0];
        for (int i = 1; i < A.length; i++) {
            single = single ^ A[i];
        }
        return single;
    }
}
