public class RectangleOverlap {

    public static void main(String[] args) {
        System.out.println(solve(0, 0, 1, 1, 1, 1, 6, 6));
    }

    public static int solve(int A, int B, int C, int D, int E, int F, int G, int H) {
        if (G <= A || C <= E) {
            return 0;
        }

        if (H <= B || D <= F) {
            return 0;
        }

        return 1;
    }
}
