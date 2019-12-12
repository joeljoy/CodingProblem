package stringpatternmatching;

import java.util.HashMap;

public class RomanToInt {

    public static void main(String[] args) {
        RomanToInt romanToInt = new RomanToInt();
        System.out.println(romanToInt.romanToInt("MMMCCLXXXVII"));
//        System.out.println(romanToInt.romanToInt("MDCXXXVII"));
    }

    public int romanToInt(String A) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        int i = 0;
        int answer = 0;
        while (i < A.length()) {
            if (i != A.length() - 1) {
                StringBuilder temp = new StringBuilder();
                temp.append(A.charAt(i));
                temp.append(A.charAt(i + 1));
                if (map.containsKey(temp.toString())) {
                    answer += map.get(temp.toString());
                    i += 2;
                } else {
                    answer += map.get(String.valueOf(A.charAt(i)));
                    i += 1;
                }
            } else {
                answer += map.get(String.valueOf(A.charAt(i)));
                i += 1;
            }
        }
        return answer;
    }
}
