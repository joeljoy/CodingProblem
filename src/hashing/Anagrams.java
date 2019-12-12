package hashing;

import java.util.*;

public class Anagrams {
    public static void main(String[] args) {
        String[] a = {"bbbaabbbabbbbabababbbbbbbaabaaabbaaababbabbabbaababbbaaabbabaabbaabbabbbbbababbbababbbbaabababba",
                "abaaabbbabaaabbbbabaabbabaaaababbbbabbbaaaabaababbbbaaaabbbaaaabaabbaaabbaabaaabbabbaaaababbabbaa",
                "babbabbaaabbbbabaaaabaabaabbbabaabaaabbbbbbabbabababbbabaabaabbaabaabaabbaabbbabaabbbabaaaabbbbab",
                "bbbabaaabaaaaabaabaaaaaaabbabaaaabbababbabbabbaabbabaaabaabbbabbaabaabaabaaaabbabbabaaababbaababb",
                "abbbbbbbbbbbbabaabbbbabababaabaabbbababbabbabaaaabaabbabbaaabbaaaabbaabbbbbaaaabaaaaababababaabab",
                "aabbbbaaabbaabbbbabbbbbaabbababbbbababbbabaabbbbbbababaaaabbbabaabbbbabbbababbbaaabbabaaaabaaaaba",
                "abbaaababbbabbbbabababbbababbbaaaaabbbbbbaaaabbaaabbbbbbabbabbabbaabbbbaabaabbababbbaabbbaababbaa",
                "aabaaabaaaaaabbbbaabbabaaaabbaababaaabbabbaaaaababaaabaabbbabbababaabababbaabaababbaabbabbbaaabbb"
        };
        String[] b = {"cat", "act", "dog", "god"};
        String[] c = {"cat", "car", "dog", "god" };
        Anagrams anagrams = new Anagrams();
        int[][] res = anagrams.anagrams(c);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }

    public int[][] anagrams(final String[] A) {
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
        LinkedHashMap<String, ArrayList<Integer>> map = new LinkedHashMap<>();
        for (int i = 0; i < A.length; i++) {
            String sorted = getSorted(A[i]);
            if (map.get(sorted) == null) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i + 1);
                map.put(sorted, list);
            } else {
                map.get(sorted).add(i + 1);
            }
        }
        answer.addAll(map.values());
        int[][] res = new int[answer.size()][];
        for (int i = 0; i < answer.size(); i++) {
            ArrayList<Integer> child = answer.get(i);
            int[] temp = new int[child.size()];
            for (int j = 0; j < child.size(); j++) {
                temp[j] = child.get(j);
            }
            res[i] = temp;
        }
        return res;
    }

    private String getSorted(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
