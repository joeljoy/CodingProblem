package stack;

import java.util.Stack;

public class NearestSmallerElement {
    public int[] prevSmaller(int[] A) {
        int[] res = new int[A.length];
        Stack<Integer> stack = new Stack<>();
        int k = 1;
        stack.push(A[0]);
        res[0] = -1;
        for (int i = 1; i < A.length; i++) {
            while (!stack.isEmpty() && stack.peek() >= A[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                res[k] = -1;
                k++;
            } else {
                res[k] = stack.peek();
                k++;
            }
            stack.push(A[i]);

        }
        return res;
    }
}
