public class TrippleNumber {
    public static void main(String[] args) {
        int[] a = {1,1,1,2,2,2,3,3,3,4};
        System.out.println(singleNumber(a));
    }
    public static int singleNumber(final int[] A) {
        int result = 0;
        int sum, x;
        for (int i = 0; i < 32; i++) {
            sum = 0;
            x = (1 << i);
            for (int j = 0; j < A.length; j++) {
                if ((A[j] & x) == x) {
                    sum++;
                }
            }

            if (sum % 3 == 1) {
                result = result | x;
            }
        }
        return result;
    }
}
