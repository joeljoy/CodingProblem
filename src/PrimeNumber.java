import java.util.*;

public class PrimeNumber {
    public static void main(String args[]) {
//        Scanner s = new Scanner(System.in);
//        int n = s.nextInt();
        primesLessThanOrEqualTon(10);
    }

    // Method to print all primes less than or equal to n in ascending order
    static void primesLessThanOrEqualTon(int n) {
        if (n <= 1) {
            System.out.println("There are no prime numbers less than or equal to " + n);
            return;
        }
        int[] primeArray = new int[n];
        boolean[] isPrimeBoolean = new boolean[n];
        for (int i = 0; i <= n - 1; i++) {
            primeArray[i] = i + 1;
        }
        int p = 2;
        while (p != n) {
            for (int i = 2; p * i <= n; i++) {
                isPrimeBoolean[(p * i) - 1] = true;
            }
            p = getNextBigNumber(primeArray, isPrimeBoolean, p);
            if (p == -1) {
                break;
            }
        }
        printAllPrime(primeArray, isPrimeBoolean);
    }

    private static void printAllPrime(int[] primeArray, boolean[] isPrimeBoolean) {
        for (int i = 1; i < isPrimeBoolean.length; i++) {
            if (!isPrimeBoolean[i]) {
                System.out.print(primeArray[i] + " ");
            }
        }
    }

    private static int getNextBigNumber(int[] primeArray, boolean[] isPrimeBoolean, int p) {
        for (int i = 0; i < isPrimeBoolean.length; i++) {
            if (!isPrimeBoolean[i] && primeArray[i] > p) {
                return primeArray[i];
            }
        }
        return -1;
    }
}
