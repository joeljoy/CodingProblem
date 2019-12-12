import java.util.HashSet;
import java.util.Set;

public class AllGCD {
    public static void main(String[] args) {
        int[] a = {3,2,8};
        System.out.println(solve(a));
    }
    public static int solve(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
               int gcd =  getGcd(A[i],A[j]);
               set.add(gcd);
            }
        }
        return set.size();
    }

    static int getGcd(int A, int B) {
        if (B == 0) return A;
        return getGcd(B, A % B);
    }
}
