package Sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class AlternateNegPos {

    public static void main(String[] args) {
        int[] a = {-1, -2, -3, 4, 5};
        AlternateNegPos pos = new AlternateNegPos();
        int[] res = pos.solve(a);
        System.out.println();
    }

    public int[] solve(int[] A) {
        int[] res = new int[A.length];
        ArrayList<Integer> neg = new ArrayList<>();
        ArrayList<Integer> pos = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] < 0) {
                neg.add(A[i]);
            } else {
                pos.add(A[i]);
            }
        }
        int nIndex = 0;
        int pIndex = 0;
        int index = 0;
        boolean toggleNegative = true;
        while (nIndex < neg.size() && pIndex < pos.size()) {
            if (toggleNegative) {
                res[index] = neg.get(nIndex);
                nIndex++;
                index++;
            } else {
                res[index] = pos.get(pIndex);
                pIndex++;
                index++;
            }
            toggleNegative = !toggleNegative;
        }

        while (nIndex < neg.size()) {
            res[index] = neg.get(nIndex);
            nIndex++;
            index++;
        }

        while (pIndex < pos.size()) {
            res[index] = pos.get(pIndex);
            pIndex++;
            index++;
        }
        return res;
    }
}
