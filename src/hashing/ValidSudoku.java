package hashing;

import java.util.HashSet;

public class ValidSudoku {

    public static void main(String[] args) {
        String[] a = {
                "53..7....",
                "6..195...",
                ".98....6.",
                "8...6...3",
                "4..8.3..1",
                "7...2...6",
                ".6....28.",
                "...419..5",
                "....8..79"
        };
        ValidSudoku sudoku = new ValidSudoku();
        System.out.println(sudoku.isValidSudoku(a));
    }

    public int isValidSudoku(final String[] A) {
        for (int i = 0; i < A.length; i++) {
            HashSet<Character> rowSet = new HashSet<>();
            for (int j = 0; j < A[i].length(); j++) {
                if (rowSet.contains(A[i].charAt(j))) {
                    return 0;
                } else {
                    if (A[i].charAt(j) != '.')
                        rowSet.add(A[i].charAt(j));
                }
            }
        }


        for (int i = 0; i < A.length; i++) {
            HashSet<Character> colSet = new HashSet<>();
            for (int j = 0; j < A.length; j++) {
                if (colSet.contains(A[j].charAt(i))) {
                    return 0;
                } else {
                    if (A[j].charAt(i) != '.')
                        colSet.add(A[j].charAt(i));
                }
            }
        }

        for (int i = 0; i < A.length; i += 3) {
            for (int j = 0; j < A.length; j += 3) {
                HashSet<Character> tabSet = new HashSet<>();
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        if (tabSet.contains(A[k].charAt(l))) {
                            return 0;
                        } else {
                            if (A[k].charAt(l) != '.')
                                tabSet.add(A[k].charAt(l));
                        }
                    }
                }
            }
        }
        return 1;
    }
}
