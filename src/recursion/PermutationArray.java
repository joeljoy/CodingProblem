//package recursion;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class PermutationArray {
//
//    private List<List<Integer>> result = new ArrayList<>();
//
//    public static void main(String[] args) {
//        PermutationArray array = new PermutationArray();
//        int[] a = {1, 2, 3};
//        array.arrayPerm(a);
//    }
//
//    private int[][] arrayPerm(int[] a) {
//        if (a.length == 1) {
//
//        }
//        for (int i = 0; i < a.length; i++) {
//            int fixed = a[i];
//            int[] remaining = getRemaining(a, i);
//            int[][] perm = arrayPerm(remaining);
//            result = new int[perm.length + 1][];
//            for (int j = 0; j < perm.length; j++) {
//                int[] array = perm[j];
//                int[] res = new int[array.length + 1];
//                res[0] = fixed;
//                for (int k = 0; k < array.length; k++) {
//                    res[k + 1] = array[k];
//                }
//                result[i] = res;
//            }
//        }
//        return result;
//    }
//
//    private int[] getRemaining(int[] a, int i) {
//        int[] res = new int[a.length - 1];
//        int k = 0;
//        for (int j = 0; j < a.length; j++) {
//            if (j != i) {
//                res[k] = a[j];
//                k++;
//            }
//        }
//        return res;
//    }
//}
