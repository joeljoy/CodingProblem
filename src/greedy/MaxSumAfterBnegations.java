package greedy;

import java.util.*;

public class MaxSumAfterBnegations {

    public int solve(ArrayList<Integer> A, int B) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Integer a : A) {
            pq.add(a);
        }

        for (int i = 1; i <= B; i++) {
            int top = pq.poll();
            top *= -1;
            pq.add(top);
        }
        int sum = 0;
        for (Integer a : pq) sum += a;
        return sum;
    }

    public static void main(String[] args) {
        Integer[] a = {-20, 73, 89, -35, -20, 12, 25, -17, 93};
        int[] b = {-20, 73, 89, -35, -20, 12, 25, -17, 93};
        MaxSumAfterBnegations bnegations = new MaxSumAfterBnegations();
        System.out.println(bnegations.solve(new ArrayList<>(Arrays.asList(a)), 3));
    }
}
