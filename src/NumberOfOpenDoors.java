public class NumberOfOpenDoors {

    public static void main(String[] args) {
        System.out.println(solve(10));
    }

    public static int solve(int A) {
        boolean isPerfectSquare = false;
        int i;
        for (i = 1; i * i <= A; i++) {
            if (i * i == A) {
                isPerfectSquare = true;
                break;
            }
        }

        if (isPerfectSquare)
            return i;
        else
            return i - 1;
    }
}
