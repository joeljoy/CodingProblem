package stack;

import java.util.Stack;

public class SimplifyPath {

    public String simplifyPath(String A) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < A.length(); i++) {
            StringBuilder builder = new StringBuilder();
            while (i < A.length() && A.charAt(i) == '/') {
                i++;
            }
            while (i < A.length() && A.charAt(i) != '/') {
                builder.append(A.charAt(i));
                i++;
            }

            if (builder.toString().equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (builder.toString().equals(".")) {
                continue;
            } else if (builder.toString().length() != 0) {
                stack.push(builder.toString());
            }
        }
        Stack<String> reverse = new Stack<>();
        while (!stack.isEmpty()) {
            reverse.push(stack.pop());
        }
        StringBuilder answer = new StringBuilder();
        if (reverse.isEmpty()) {
            answer.append("/");
        } else {
            while (!reverse.isEmpty()) {
                answer.append('/');
                answer.append(reverse.pop());
            }
        }
        return answer.toString();
    }
}
