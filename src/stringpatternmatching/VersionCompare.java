package stringpatternmatching;

import java.math.BigInteger;

public class VersionCompare {
    public static void main(String[] args) {
        String s1 = "444444444444444444444444";
        String s2 = "4444444444444444444444444";
        VersionCompare compare = new VersionCompare();
        System.out.println(compare.compareVersion(s1, s2));
    }

    public int compareVersion(String A, String B) {
        int i = 0;
        int j = 0;
        BigInteger num1 = new BigInteger("0");
        BigInteger num2 = new BigInteger("0");
        while (i < A.length() || j < B.length()) {
            while (i < A.length() && A.charAt(i) != '.') {
                num1 = num1.multiply(BigInteger.valueOf(10)).add(new BigInteger(A.charAt(i) + ""));
                i++;
            }

            while (j < B.length() && B.charAt(j) != '.') {
                num2 = num2.multiply(BigInteger.valueOf(10)).add(new BigInteger(B.charAt(j) + ""));
                j++;
            }

            if (num1.compareTo(num2) > 0) {
                return 1;
            } else if (num2.compareTo(num1) > 0) {
                return -1;
            } else {
                num1 = new BigInteger("0");
                ;
                num2 = new BigInteger("0");
                ;
            }
            i++;
            j++;
        }
        return 0;
    }
}
