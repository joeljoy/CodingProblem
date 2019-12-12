public class ExcelColumnNumber {
    public static void main(String[] args) {
        System.out.println(titleToNumber("CCA"));
    }

    public static int titleToNumber(String A) {
        int res = 0;
        int j = 0;
        for (int i = A.length() - 1; i >= 0; i--, j++) {
            int mul = ((int) Math.pow(26, j));
            res += mul * ((A.charAt(i) + 1) - 'A');
        }
        return res;
    }
}
