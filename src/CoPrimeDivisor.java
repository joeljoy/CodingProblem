public class CoPrimeDivisor {

    public static void main(String[] args) {
        System.out.println(cpFact(30, 12));
    }

    public static int cpFact(int A, int B) {
        while (gcd(A, B) != 1) {
            A = A / gcd(A, B);
        }
        return A;
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}

