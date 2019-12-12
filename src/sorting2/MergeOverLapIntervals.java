package sorting2;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

public class MergeOverLapIntervals {

    public static void main(String[] args) {
//        int[] a = {1, 10, 8, 15, 15, 18};
        int[] a = {4, 100, 48, 94, 16, 21, 58, 71, 36, 53, 49, 68, 18, 42, 37, 90, 68, 75, 6, 57, 25, 78, 58, 79, 18, 29, 69, 94, 5, 31, 10, 87, 21, 35, 1, 32, 7, 24, 17, 85, 30, 95, 5, 63, 1, 17, 67, 100, 53, 55, 30, 63, 7, 76, 33, 51, 62, 68, 78, 83, 12, 24, 31, 73, 64, 74, 33, 40, 51, 63, 17, 31, 14, 29, 9, 15, 39, 70, 13, 67, 27, 100, 10, 71, 18, 47, 48, 79, 70, 73, 44, 59, 68, 78, 24, 67, 32, 70, 29, 94, 45, 90, 10, 76, 12, 28, 31, 78, 9, 44, 29, 83, 21, 35, 46, 93, 66, 83, 21, 72, 29, 37, 6, 11, 56, 87, 10, 26, 11, 12, 15, 88, 3, 13, 56, 70, 40, 73, 25, 62, 63, 73, 47, 74, 8, 36};
        ArrayList<Interval> list = new ArrayList<>();
        for (int i = 0; i < a.length - 1; i += 2) {
            list.add(new Interval(a[i], a[i + 1]));
        }
        MergeOverLapIntervals intervals = new MergeOverLapIntervals();
        ArrayList<Interval> res = intervals.merge(list);
        System.out.println(Arrays.toString(res.toArray()));
    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        ArrayList<Interval> results = new ArrayList<>();
        int rIndex = 0;
        results.add(intervals.get(0));
        for (Interval current : intervals) {
            Interval result = results.get(rIndex);
            if (result.start <= current.start && current.start <= result.end) {
                if (current.end <= result.end) {
                    continue;
                } else {
                    result = new Interval(result.start, current.end);
                    results.set(rIndex, result);
                }
            } else {
                results.add(current);
                rIndex++;
            }
        }
        return results;
    }
}
