package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class ParanthesisGeneration {

    ArrayList<ArrayList<String>> result;

    public static void main(String[] args) {
        ParanthesisGeneration gen = new ParanthesisGeneration();
        String[] res = gen.generateParenthesis(3);
        System.out.println(Arrays.toString(res));
    }

    public String[] generateParenthesis(int A) {
        result = new ArrayList<>();
        permuteParenthesis(A, 0, 0, new LinkedList<String>(), 0);
        return getStringsFromList();
    }

    private String[] getStringsFromList() {
        String[] res = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < result.get(i).size(); j++) {
                builder.append(result.get(i).get(j));
            }
            res[i] = builder.toString();
        }
        return res;
    }

    private void permuteParenthesis(int A, int open, int close, Deque<String> current, int index) {
        if (index == 2 * A) {
            result.add(new ArrayList<>(current));
        }

        if (open < A) {
            current.addLast("(");
            permuteParenthesis(A, open + 1, close, current, index + 1);
            current.removeLast();
        }

        if (close < open) {
            current.addLast(")");
            permuteParenthesis(A, open, close + 1, current, index + 1);
            current.removeLast();
        }
    }
}
