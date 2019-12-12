package stack;

import java.util.LinkedList;
import java.util.Queue;

public class GasStation {
    public int canCompleteCircuit(final int[] A, final int[] B) {
        int total = 0;
        int start = 0;
        int petrolRemaining = 0;
        for (int i = 0; i < A.length; i++) {
            int remaining = A[i] - B[i];
            if (petrolRemaining >= 0) {
                petrolRemaining += remaining;
            } else {
                start = i;
                petrolRemaining = remaining;
            }
            total += remaining;
        }
        if (total >= 0) {
            return start;
        } else {
            return -1;
        }
    }
}
