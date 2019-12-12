package stringpatternmatching;

public class IntegerToRoman {

    public static void main(String[] args) {
        IntegerToRoman roman = new IntegerToRoman();
        System.out.println(roman.intToRoman(1637));
    }
    public String intToRoman(int A) {
        StringBuilder builder = new StringBuilder();
        int[] a = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] b = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int i = a.length - 1;
        while (A > 0) {
            int Q = A / a[i];
            A = A % a[i];
            while (Q > 0) {
                builder.append(b[i]);
                Q--;
            }
            i--;
        }
        return builder.toString();
    }
}
