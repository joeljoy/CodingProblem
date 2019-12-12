public class FIndPosition {

    public static void main(String[] args) {
        FIndPosition position = new FIndPosition();
        System.out.println(position.solve(20));
    }

    public int solve(int A) {
        return findHighestPowerOf2LessThan(A);
    }

    private int findHighestPowerOf2LessThan(int a) {
        int power = 1;
        while (a != 1) {
            a /= 2;
            power *= 2;
        }
        return power;
    }
}
