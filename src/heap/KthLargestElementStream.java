package heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class KthLargestElementStream {
    public ArrayList<Integer> solve(int A, ArrayList<Integer> B) {
        ArrayList<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(A);
        for (int i = 0; i < B.size(); i++) {
            if (i < A - 1) {
                pq.add(B.get(i));
                result.add(-1);
            } else {
                if (i == A - 1) {
                    pq.add(B.get(i));
                } else if (B.get(i) > pq.peek()) {
                    pq.poll();
                    pq.add(B.get(i));
                }
                result.add(pq.peek());
            }
        }
        return result;
    }
}
