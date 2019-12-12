public class PalidromeInteger {

    public static void main(String[] args) {
        System.out.println(isPalindrome(10010));
    }
    public static int isPalindrome(int A) {
        int B = reverse(A);
        return (A == B) ? 1 : 0;
    }

    static int reverse(int n) {
        int r = 0;
        while (n > 0) {
            int a = n % 10;
            r = r * 10 + a;
            n = n / 10;
        }
        return r;
    }
}
