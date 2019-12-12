package sorting2;

import java.util.Arrays;

public class FlightBooking {

    public static void main(String[] args) {
        int[][] a = {
                {1, 2, 10},
                {2, 3, 20},
                {2, 5, 25}
        };
        FlightBooking booking = new FlightBooking();
        System.out.println(Arrays.toString(booking.solve(5, a)));
    }

    public int[] solve(int A, int[][] B) {
        int[] res = new int[A];
        for (int[] b : B) {
            res[b[0] - 1] += b[2];
            if (b[1] < A) {
                res[b[1]] += -b[2];
            }
        }

        int count = 0;
        for (int i = 0; i < A; i++) {
            res[i] = count + res[i];
            count = res[i];
        }
        return res;
    }
}
