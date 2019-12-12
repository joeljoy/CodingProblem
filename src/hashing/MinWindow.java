package hashing;

import java.util.HashMap;

public class MinWindow {

    public static void main(String[] args) {
        MinWindow minWindow = new MinWindow();
        System.out.println(minWindow.minWindow("ADOBECODEBANC", "ABC"));
    }

    public String minWindow(String A, String B) {
        int i = 0;
        int j = 0;
        int minStart = -1;
        int minLength = Integer.MAX_VALUE;

        HashMap<Character, Integer> hashPattern = new HashMap<>();
        HashMap<Character, Integer> hashString = new HashMap<>();

        for (int k = 0; k < B.length(); k++) {
            if (hashPattern.containsKey(B.charAt(k))) {
                int count = hashPattern.get(B.charAt(k));
                count += 1;
                hashPattern.put(B.charAt(k), count);
            } else {
                hashPattern.put(B.charAt(k), 1);
            }
        }
        int count = 0;
        while (j < A.length() && i <= j) {
            if (hashString.containsKey(A.charAt(j))) {
                int c = hashString.get(A.charAt(j));
                c += 1;
                hashString.put(A.charAt(j), c);
            } else {
                hashString.put(A.charAt(j), 1);
            }
            if (hashPattern.get(A.charAt(j)) != null &&
                    hashString.get(A.charAt(j)) <= hashPattern.get(A.charAt(j))) {
                count++;
            }

            if (count == B.length()) {
                while (!hashPattern.containsKey(A.charAt(i)) ||
                        hashString.get(A.charAt(i)) > hashPattern.get(A.charAt(i))) {
                    if (hashPattern.containsKey(A.charAt(i)) &&
                            hashString.get(A.charAt(i)) > hashPattern.get(A.charAt(i))) {
                        int c = hashString.get(A.charAt(i));
                        c -= 1;
                        if (c == 0) {
                            hashString.remove(A.charAt(i));
                        } else {
                            hashString.put(A.charAt(i), c);
                        }
                    }
                    i++;
                }
                int length = j - i + 1;
                if (length < minLength) {
                    minLength = length;
                    minStart = i;
                }
            }
            j++;
        }
        if (minStart == -1) {
            return "";
        }
        return A.substring(minStart, minStart + minLength);
    }

}
