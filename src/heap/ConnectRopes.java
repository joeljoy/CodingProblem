package heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class ConnectRopes {
    public int solve(ArrayList<Integer> A) {
        int result = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Integer a : A) {
            pq.add(a);
        }
        while (pq.size() > 1) {
            int smallest = pq.poll();
            int secondSmallest = pq.poll();
            int sum = smallest + secondSmallest;
            pq.add(sum);
            result += sum;
        }
        return result;
    }

    public static void main(String[] args) {
        Integer[] a = {1, 2, 3, 4, 5};
        ConnectRopes connectRopes = new ConnectRopes();
        System.out.println(connectRopes.solve(new ArrayList<>(Arrays.asList(a))));
    }
}
