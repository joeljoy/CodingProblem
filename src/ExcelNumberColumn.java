public class ExcelNumberColumn {

    public static void main(String[] args) {
        System.out.println(convertToTitle(2107));
    }
    public static String convertToTitle(int A) {
        StringBuilder builder = new StringBuilder();
        while (A > 0) {
            int reminder = A % 26;
            if (reminder == 0) {
                builder.append('Z');
                A = A / 26 - 1;
            } else {
                builder.append((char) (reminder - 1 + 'A'));
                A = A / 26;
            }
        }
        return builder.reverse().toString();
    }
}
