package recursion;

public class PrintPattern {

    private void printPattern(int index, String str, String curr) {
        if (index == str.length()){
            System.out.println(curr);
            return;
        }
        printPattern(index + 1, str, curr + str.charAt(index));
        printPattern(index + 1, str, curr);
    }

    public static void main(String[] args) {
        PrintPattern pattern = new PrintPattern();
        pattern.printPattern(0, "123", "");
    }
}
