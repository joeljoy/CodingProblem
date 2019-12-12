public class ReverseIntegerOverFlow {

    public static void main(String[] args) {
        System.out.println(reverse(1000000045));
    }

    public static int reverse(int A) {
        boolean isNeg = false;
        int result = 0;
        int previousResult = 0;
        if (A < 0) {
            isNeg = true;
            A = -A;
        }
        while (A > 0) {
            int digit = A % 10;
            result = (result * 10) + digit;

            if (((result - digit) / 10) != previousResult) {
                return 0;
            }
            previousResult = result;
            A = A / 10;
        }

        if (isNeg) {
            return -result;
        } else {
            return result;
        }
    }
}
