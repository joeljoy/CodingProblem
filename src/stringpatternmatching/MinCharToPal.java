package stringpatternmatching;

public class MinCharToPal {
    public static void main(String[] args) {
        MinCharToPal minCharToPal = new MinCharToPal();
        System.out.println(minCharToPal.solve("ABC"));
    }
    public int solve(String A) {
        int maxLength = Integer.MIN_VALUE;
        for (int i = 1; i < A.length(); i++) {
        if (isPalindrome(A.substring(0, i))) {
            if (i > maxLength) {
                maxLength = i;
            }
        }
    }
        return A.length() - maxLength;
}

    private boolean isPalindrome(String a) {
        String rev = new StringBuilder(a).reverse().toString();
        return a.equals(rev);
    }
}
