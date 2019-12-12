package Sorting;

import java.util.Arrays;

public class ClosestPoint {

    public static void main(String[] args) {
        int[][] a = {
                {3, 3},
                {5, -1},
                {-2, 4}
        };
        int[][] b = {
                {-832, 834},
                {901, -707},
                {-870, 624},
                {959, -827},
                {-979, 962},
                {767, -1062},
                {-903, 835},
                {976, -948},
                {-989, 758},
                {755, -651},
                {-758, 750},
                {1015, -773},
                {-767, 894},
                {998, -753},
                {-879, 817},
                {791, -918},
                {-740, 845},
                {1082, -837},
                {-920, 1019},
                {752, -626},
                {-916, 684},
                {792, -902},
                {-1001, 980},
                {794, -986},
                {-911, 673},
                {872, -808},
                {-794, 963},
                {1082, -1014},
                {-836, 733},
                {979, -729},
                {-786, 700},
                {970, -680},
                {-875, 831},
                {724, -753},
                {-987, 744},
                {963, -1020},
                {-1038, 603},
                {608, -684},
                {-843, 965},
                {716, -1051},
                {-648, 648},
                {1012, -771},
                {-995, 773},
                {711, -1043},
                {-703, 977},
                {1025, -761},
                {-145, 40},
                {105, -363},
                {-238, 85},
                {192, -220},
                {-325, 18},
                {107, -96},
                {-312, 183},
                {260, -226},
                {-385, 232},
                {43, -419},
                {-36, 123},
                {11, -366},
                {-430, 311},
                {56, -174},
                {-235, 200},
                {373, -361},
        };
        ClosestPoint point = new ClosestPoint();
        int[][] res = point.solve(b, 16);
        System.out.println("");
    }

    public int[][] solve(int[][] A, int B) {
        int[][] res = new int[B][2];
        sort(A, 0, A.length - 1, B);
        for (int i = 0; i < B; i++) {
            res[i][0] = A[i][0];
            res[i][1] = A[i][1];
        }
        return res;
    }

    private void sort(int[][] A, int start, int end, int B) {
        if (start >= end) return;
        int mid = partition(A, start, end);
        int leftLength = (mid - start + 1);
        if (B < leftLength) {
            sort(A, start, mid - 1, B);
        } else {
            sort(A, mid + 1, end, B - leftLength);
        }
    }

    private int partition(int[][] a, int start, int end) {
        int i = end;
        int pivot = calculateDistance(a[end][0], a[end][1]);
        end--;
        while (true) {
            while (start < end && calculateDistance(a[start][0], a[start][1]) < pivot) {
                start++;
            }

            while (start <= end && calculateDistance(a[end][0], a[end][1]) > pivot) {
                end--;
            }
            if (start >= end) {
                break;
            }
            swap(a, start, end);
        }
        swap(a, start, i);
        return end;
    }

    private void swap(int[][] a, int i, int j) {
        int t0 = a[i][0], t1 = a[i][1];
        a[i][0] = a[j][0];
        a[i][1] = a[j][1];
        a[j][0] = t0;
        a[j][1] = t1;
    }

    private int calculateDistance(int x, int y) {
        return (x * x) + (y * y);
    }
}
