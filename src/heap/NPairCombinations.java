package heap;

import java.util.*;

class Pair<K, V> {

    private K key;

    public K getKey() {
        return key;
    }

    private V value;

    public V getValue() {
        return value;
    }

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int hashCode() {
        return key.hashCode() * 13 + (value == null ? 0 : value.hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Pair) {
            Pair pair = (Pair) o;
            if (key != null ? !key.equals(pair.key) : pair.key != null) return false;
            if (value != null ? !value.equals(pair.value) : pair.value != null) return false;
            return true;
        }
        return false;
    }
}

class PairSum implements Comparable<PairSum> {

    public PairSum(int sum, int i1, int i2) {
        this.sum = sum;
        this.i1 = i1;
        this.i2 = i2;
    }

    int sum;
    int i1;
    int i2;

    @Override
    public int compareTo(PairSum o) {
        return Integer.compare(o.sum, sum);
    }
}

public class NPairCombinations {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Integer> result = new ArrayList<>();

        Collections.sort(A);
        Collections.sort(B);

        PriorityQueue<PairSum> pq = new PriorityQueue<>();
        HashSet<Pair> pairSet = new HashSet<>();

        int i1 = A.size() - 1;
        int i2 = B.size() - 1;
        pairSet.add(new Pair(i1, i2));
        pq.add(new PairSum(A.get(i1) + B.get(i2), i1, i2));

        for (int i = 0; i < A.size(); i++) {
            PairSum max = pq.poll();
            result.add(max.sum);

            i1 = max.i1 - 1;
            i2 = max.i2;

            if (i1 >= 0 && i2 >= 0 && !pairSet.contains(new Pair(i1, i2))) {
                pq.add(new PairSum(A.get(i1) + B.get(i2), i1, i2));
                pairSet.add(new Pair(i1, i2));
            }

            i1 = max.i1;
            i2 = max.i2 - 1;

            if (i1 >= 0 && i2 >= 0 && !pairSet.contains(new Pair(i1, i2))) {
                pq.add(new PairSum(A.get(i1) + B.get(i2), i1, i2));
                pairSet.add(new Pair(i1, i2));
            }

        }
        return result;
    }

    public static void main(String[] args) {
        NPairCombinations combinations = new NPairCombinations();
        Integer[] a = {1, 4, 2, 3};
        Integer[] b = {2, 5, 1, 6};
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(a));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(b));
        ArrayList<Integer> res = combinations.solve(A, B);
        System.out.println(Arrays.toString(res.toArray()));
    }
}
