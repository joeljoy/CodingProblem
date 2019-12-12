package searching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchForARange {

    public static void main(String[] args) {
        SearchForARange range = new SearchForARange();
        ArrayList<Integer> a = new ArrayList<>();
        a.add(5);
        a.add(7);
        a.add(7);
        a.add(8);
        a.add(8);
        a.add(10);

        ArrayList<Integer> res = range.searchRange(a, 8);
        System.out.println("");
    }

    public ArrayList<Integer> searchRange(final List<Integer> a, int b) {
        int first = findFirst(a, 0, a.size() - 1, b);
        int second = findSecond(a, 0, a.size() - 1, b);
        ArrayList<Integer> result = new ArrayList<>();
        result.add(first);
        result.add(second);
        return result;
    }

    private int findFirst(List<Integer> a, int start, int end, int b) {
        if (end >= start) {
            int mid = start + (end - start) / 2;
            if (a.get(mid) == b) {
                if (mid == start || a.get(mid - 1) < b) {
                    return mid;
                } else {
                    return findFirst(a, start, mid - 1, b);
                }
            } else if (a.get(mid) > b) {
                return findFirst(a, start, mid - 1, b);
            } else {
                return findFirst(a, mid + 1, end, b);
            }
        }
        return -1;
    }

    private int findSecond(List<Integer> a, int start, int end, int b) {
        if (end >= start) {
            int mid = start + (end - start) / 2;
            if (a.get(mid) == b) {
                if (mid == end || a.get(mid + 1) > b) {
                    return mid;
                } else {
                    return findSecond(a, mid + 1, end, b);
                }
            } else if (a.get(mid) > b) {
                return findSecond(a, start, mid - 1, b);
            } else {
                return findSecond(a, mid + 1, end, b);
            }
        }
        return -1;
    }
}
