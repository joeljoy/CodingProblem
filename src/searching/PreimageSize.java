package searching;

public class PreimageSize {

    public static void main(String[] args) {
        PreimageSize size = new PreimageSize();
//        System.out.println(size.trailingZeroes(0));
//        System.out.println(size.solve(8554));
        System.out.println(size.solution(8554));
    }

    public int solve(int A) {
        int first = binarySearchFirstOccurrence(A, 0, Integer.MAX_VALUE);
        int second = binarySearchSecondOccurrence(A, 0, Integer.MAX_VALUE);
        return (second - first);
    }

    private int binarySearchSecondOccurrence(int a, int start, int end) {
        if (start <= end) {
            int mid = start + (end - start) / 2;
            int trailingZeroes = trailingZeroes(mid);
            if (trailingZeroes == a) {
                int nextZeroes = trailingZeroes(mid + 1);
                if (mid == end || trailingZeroes < nextZeroes) {
                    return mid + 1;
                } else {
                    return binarySearchSecondOccurrence(a, mid + 1, end);
                }
            } else if (trailingZeroes > a) {
                return binarySearchSecondOccurrence(a, start, mid - 1);
            } else {
                return binarySearchSecondOccurrence(a, mid + 1, end);
            }
        }
        return 0;
    }

    private int binarySearchFirstOccurrence(int a, int start, int end) {
        if (start <= end) {
            int mid = start + (end - start) / 2;
            int trailingZeroes = trailingZeroes(mid);
            if (trailingZeroes == a) {
                int previousZeroes = trailingZeroes(mid - 1);
                if (mid == start || previousZeroes < trailingZeroes) {
                    return mid;
                } else {
                    return binarySearchFirstOccurrence(a, start, mid - 1);
                }
            } else if (trailingZeroes > a) {
                return binarySearchFirstOccurrence(a, start, mid - 1);
            } else {
                return binarySearchFirstOccurrence(a, mid + 1, end);
            }
        }
        return 0;
    }

    private int trailingZeroes(int a) {
        int count = 0;
        for (int i = 5; a / i > 0; i = i * 5) {
            count += a / i;
        }
        return count;
    }

    private int solution(int A) {
        int low = 0;
        int high = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int c = mid;
            c += trailingZeroes(mid);
            if (c < A) {
                low = mid + 1;
            } else if (c > A) {
                high = mid - 1;
            } else {
                return 5;
            }
        }
        return 0;
    }
}
