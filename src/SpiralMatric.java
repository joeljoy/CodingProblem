public class SpiralMatric {

    public static void main(String[] args) {
        int R = 3;
        int C = 6;
        int a[][] = {{1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18}};
        spiral(a, R, C);
    }

    static void spiral(int[][] arr, int r, int c) {
        int i = 0;
        int k = 0; // starting row index
        int m = r; // ending row index
        int l = 0; // starting column index
        int n = c; // ending column index
        while (k < m && l < n) {
            for (i = l; i < n; i++) {
                System.out.print(arr[k][i] + ",");
            }
            System.out.println("");
            k++;

            for (i = k; i < m; i++) {
                System.out.print(arr[i][n - 1] + ",");
            }
            System.out.println("");
            n--;

            if (k < m) {
                for (i = n - 1; i >= l; i--) {
                    System.out.print(arr[m - 1][i] + ",");
                }
                System.out.println("");
                m--;
            }

            if (l < n) {
                for (i = m - 1; i >= k; i--) {
                    System.out.print(arr[i][l] + ",");
                }
                System.out.println("");
                l++;
            }
        }
    }
}
