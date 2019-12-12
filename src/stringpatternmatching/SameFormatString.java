package stringpatternmatching;

public class SameFormatString {
    public int solve(final String A, final String B) {
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < B.length(); i++) {
            if (B.charAt(i) != B.charAt(i - 1)) {
                builder.append(B.charAt(i - 1));
            }
        }
        builder.append(B.charAt(B.length() - 1));
        if (A.equals(builder.toString())) {
            return 1;
        } else {
            return 0;
        }
    }
}
