package stack;

import java.util.Stack;

public class LongestValidParanthesis {
    public static void main(String[] args) {
        LongestValidParanthesis paranthesis = new LongestValidParanthesis();
//        System.out.println(paranthesis.longestValidParentheses(")()())"));
        System.out.println(paranthesis.longestValidParentheses(")()))(())((())))))())()(((((())())((()())(())((((())))())((()()))(()(((()()(()((()()))(())()))((("));
//        System.out.println(paranthesis.longestValidParentheses("((()))"));
//        System.out.println(paranthesis.longestValidParentheses("))())((()))"));
//        System.out.println(paranthesis.longestValidParentheses("((()))))()"));
//        System.out.println(paranthesis.longestValidParentheses("(((()((()))()"));

    }

    public int longestValidParentheses(String A) {
        Stack<Integer> stack = new Stack<>();
        int maxLength = 0;
        stack.push(-1);
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (!stack.isEmpty()) {
                    maxLength = Math.max(maxLength, i - stack.peek());
                } else {
                    stack.push(i);
                }
            }
        }
        return maxLength;
    }
}
