package stack;

import java.util.Stack;

public class EvaluateExpression {

    private Stack<Integer> stack = new Stack<>();

    public int evalRPN(String[] A) {
        for (int i = 0; i < A.length; i++) {
            if (isOperator(A[i])) {
                int a = stack.pop();
                int b = stack.pop();
                int res = evaluate(b, a, A[i]);
                stack.push(res);
            } else {
                stack.push(Integer.parseInt(A[i]));
            }
        }
        return stack.peek();
    }

    private int evaluate(int a, int b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            default:
                return a / b;
        }
    }

    private boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }
}
