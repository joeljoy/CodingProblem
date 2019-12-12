package hashing;

import java.util.ArrayList;
import java.util.HashMap;

public class PalindromePairs {

    public int[][] solve(String[] A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], i);
        }

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length(); j++) {
                String str1 = A[i].substring(0, j);
                String str2 = A[i].substring(j);

                if (isPalindrome(str1)) {
                    String str2Rev = new StringBuilder(str2).reverse().toString();
                    if (map.containsKey(str2Rev) && map.get(str2Rev) != i) {
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(map.get(str2Rev));
                        temp.add(i);
                        result.add(temp);
                    }
                }

                if (isPalindrome(str2)) {
                    String str1Rev = new StringBuilder(str1).reverse().toString();
                    if (map.containsKey(str1Rev) && map.get(str1Rev) != i && str1Rev.length() != 0) {
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(i);
                        temp.add(map.get(str1Rev));
                        result.add(temp);
                    }
                }
            }
        }
        int[][] answer = new int[result.size()][];
        for (int i = 0; i < result.size(); i++) {
            int[] temp = new int[result.get(i).size()];
            for (int j = 0; j < result.get(i).size(); j++) {
                temp[j] = result.get(i).get(j);
            }
            answer[i] = temp;
        }
        return answer;
    }

    private boolean isPalindrome(String word) {

        int left = 0;
        int right = word.length() - 1;
        while (left <= right) {
            if (word.charAt(left++) != word.charAt(right--)) return false;
        }
        return true;
    }
}
