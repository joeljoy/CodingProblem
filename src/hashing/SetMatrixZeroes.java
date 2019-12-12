package hashing;

import java.util.ArrayList;
import java.util.HashSet;

public class SetMatrixZeroes {
    public void setZeroes(ArrayList<ArrayList<Integer>> a) {
        HashSet<Integer> rowSet = new HashSet<>();
        HashSet<Integer> colSet = new HashSet<>();
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.get(i).size(); j++) {
                if (a.get(i).get(j) == 0) {
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }

        for (int i = 0; i < a.size(); i++) {
            if (rowSet.contains(i)) {
                for (int j = 0; j < a.get(i).size(); j++) {
                    a.get(i).set(j, 0);
                }
            }

        }

        for (int i = 0; i < a.get(0).size(); i++) {
            if (colSet.contains(i)) {
                for (int j = 0; j < a.size(); j++) {
                    a.get(j).set(i, 0);
                }
            }
        }
    }
}
