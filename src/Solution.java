import java.awt.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solve(12, 3, 2));
    }

    public static int solve(int A, int B, int C) {
        int gcd = findGCD(B, C);
        int lcm = (B * C) / gcd;
        return A / lcm;
    }

    private static int findGCD(int a, int b) {
        if (a == 0) {
            return b;
        }
        return findGCD(b % a, a);
    }
}
