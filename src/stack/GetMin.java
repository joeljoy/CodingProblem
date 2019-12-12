package stack;

import java.util.Stack;

public class GetMin {

    private Stack<Integer> originalStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int x) {
        if (minStack.isEmpty() || x < minStack.peek()) {
            minStack.push(x);
        }
        originalStack.push(x);
    }

    public void pop() {
        if (originalStack.isEmpty()) {
            return;
        } else if (originalStack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        originalStack.pop();
    }

    public int top() {
        return originalStack.isEmpty() ? -1 : originalStack.peek();
    }

    public int getMin() {
        return minStack.isEmpty() ? -1 : minStack.peek();
    }
}
