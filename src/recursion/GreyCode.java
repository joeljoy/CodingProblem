package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GreyCode {

    public static void main(String[] args) {
        GreyCode code = new GreyCode();
        code.grayCode(4);
    }

    public ArrayList<Integer> grayCode(int a) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(0);
        res.add(1);
        for (int i = 2; i <= a; i++) {
            int size = res.size();
            for (int j = res.size() - 1; j >= 0; j--) {
                res.add(res.get(j));
            }

            for (int j = size; j < res.size(); j++) {
                res.set(j, (res.get(j) | (1 << (i - 1))));
            }
        }
        return res;
    }
}
