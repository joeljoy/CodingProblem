package searching;

public class GoodBase {
    public static void main(String[] args) {
        GoodBase base = new GoodBase();
        System.out.println(base.solve("13"));
    }

    public String solve(String A) {
        long number = Long.parseLong(A);
        for (int i = 63; i > 1; i--) {
            long result = findGoodBaseFor(number, i);
            if (result != 0) {
                return result + "";
            }
        }
        return number - 1 + "";
    }

    private long findGoodBaseFor(long number, int i) {
        long low = 2;
        long high = number - 1;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long base = getBase(mid, i);
            if (base == number) {
                return mid;
            } else if (base < number) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return 0;
    }

    private long getBase(long x, int i) {
        int sum = 0;
        for (int j = 0; j < i; j++) {
            sum += Math.pow(x, j);
        }
        return sum;
    }
}
