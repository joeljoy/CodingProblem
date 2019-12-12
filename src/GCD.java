import java.util.Arrays;

public class GCD {
    public static void main(String[] args) {
        System.out.println(solve(5, 0));
    }

    public static int solve(int A, int B) {
        if (A == 0) return B;
        if (B == 0) return A;
        while (B != 0) {
            int temp = B;
            B = A % B;
            A = temp;

        }
        return 2*A;
    }
}
