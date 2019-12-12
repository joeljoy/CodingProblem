package sorting2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class LargestNumber {

    public static void main(String[] args) {
        int[] a = {3, 30, 34, 5, 9};
//        int[] a = {0, 0, 0, 0};
        LargestNumber number = new LargestNumber();
        System.out.println(number.largestNumber(a));
    }

    public String largestNumber(final int[] A) {
        ArrayList<String> stringList = new ArrayList<>();
        for (int a : A) {
            stringList.add(String.valueOf(a));
        }
        Collections.sort(stringList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String comp1 = o1 + o2;
                String comp2 = o2 + o1;
                return comp2.compareTo(comp1);
            }
        });
        StringBuilder builder = new StringBuilder();
        for (String a : stringList) {
            if (a.equalsIgnoreCase("0")) {
                return "0";
            }
            builder.append(a);
        }
        return builder.toString();
    }
}
