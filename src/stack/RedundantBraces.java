package stack;

import java.awt.*;
import java.util.Stack;

public class RedundantBraces {

    private Stack<Character> stack = new Stack<>();

    public static void main(String[] args) {
        RedundantBraces braces = new RedundantBraces();
        System.out.println(braces.braces("((a+b)+b)"));
        System.out.println(braces.braces("(a+(b+b))"));
        System.out.println(braces.braces("((a+b))"));
        System.out.println(braces.braces("(a)"));
    }

    public int braces(String A) {
        for (int i = 0; i < A.length(); i++) {
            int c = A.charAt(i);
            if (c == ')') {
                int count = 0;
                while (!stack.isEmpty() && stack.pop() != '(') {
                    count++;
                }
                if (count == 0) return 1;
            } else if (c == '(' || c == '+' || c == '-' || c == '/' || c == '*') {
                stack.push(A.charAt(i));
            }
        }
        return 0;
    }
}
