package recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class CombinationSum {

    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();

    public int sum(ArrayList<Integer> A) {
        int sum = 0;
        for (int X : A)
            sum += X;
        return sum;
    }

    public void generateCombinations(ArrayList<Integer> A, ArrayList<Integer> cur, int B, int index) {
        for (int i = index; i < A.size(); i++) {
            cur.add(A.get(i));
            if (sum(cur) == B && !set.contains(cur)) {
                result.add(new ArrayList<Integer>(cur));
                set.add(cur);
            }
            generateCombinations(A, cur, B, i + 1);
            cur.remove(cur.size() - 1);
        }
    }

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
        Collections.sort(a);
        generateCombinations(a, new ArrayList<Integer>(), b, 0);
        return result;
    }
}
