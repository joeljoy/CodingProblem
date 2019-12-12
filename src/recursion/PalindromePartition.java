package recursion;

import java.util.*;

public class PalindromePartition {

    ArrayList<ArrayList<String>> result = new ArrayList<>();

    public static void main(String[] args) {
        PalindromePartition palindrome = new PalindromePartition();
        palindrome.partition("aab");
    }

    public ArrayList<ArrayList<String>> partition(String a) {
        result = new ArrayList<>();
        generatePalindromePartition(a, 0, new LinkedList<String>());
        return result;
    }

    private void generatePalindromePartition(String input, int start, Deque<String> current) {

        if (start == input.length()) {
            ArrayList<String> res = new ArrayList<>(current);
            result.add(res);
            return;
        }

        for (int i = start; i < input.length(); i++) {
            if (checkPalindrome(input, start, i)) {
                current.addLast(input.substring(start, i + 1));
                generatePalindromePartition(input, i + 1, current);
                current.removeLast();
            }
        }
    }

    private boolean checkPalindrome(String input, int start, int i) {
        while (start < i) {
            if (input.charAt(start++) != input.charAt(i--))
                return false;
        }
        return true;
    }
}
