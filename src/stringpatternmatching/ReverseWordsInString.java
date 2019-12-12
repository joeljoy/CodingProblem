package stringpatternmatching;

public class ReverseWordsInString {

    public static void main(String[] args) {
        String a = "the sky is blue";
        ReverseWordsInString string = new ReverseWordsInString();
        System.out.println(string.solve(a));
    }

    public String solve(String A) {
        String[] split = A.split("\\s+");
        StringBuilder builder = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            builder.append(split[i]);
            builder.append(" ");
        }
        return builder.toString().trim();
    }
}
