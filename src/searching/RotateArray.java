package searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotateArray {

    public static void main(String[] args) {
        RotateArray array = new RotateArray();
        Integer[] b = {9, 10, 11, 12, 14, 15, 17, 19, 24, 25, 30, 39, 40, 44, 46, 48, 51, 53, 54, 56, 59, 60, 69, 70, 73, 75, 80, 87, 88, 89, 92, 93, 97, 99, 104, 107, 109, 110, 111, 117, 123, 124, 125, 126, 127, 128, 135, 136, 137, 141, 148, 153, 154, 161, 166, 167, 169, 175, 177, 180, 181, 182, 185, 186, 189, 193, 198, 202, 1, 2, 6, 7};
        List<Integer> a = Arrays.asList(b);
        System.out.println(array.search(a, 198));
    }

    public int search(final List<Integer> a, int b) {
        return findElement(a, 0, a.size() - 1, b);
    }

    private int findElement(List<Integer> a, int start, int end, int b) {
        if (start <= end) {
            int mid = start + (end - start) / 2;
            if (a.get(mid) == b) {
                return mid;
            } else if (a.get(start) <= a.get(mid)) {
                if (a.get(start) <= b && b <= a.get(mid)) {
                    return findElement(a, start, mid - 1, b);
                } else {
                    return findElement(a, mid + 1, end, b);
                }
            } else {
                if (a.get(mid) <= b && b <= a.get(end)) {
                    return findElement(a, mid + 1, end, b);
                } else {
                    return findElement(a, start, mid - 1, b);
                }
            }
        } else {
            return -1;
        }
    }
}
