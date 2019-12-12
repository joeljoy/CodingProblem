package recursion;

public class PrintArray {
    private void printArrayRecursion(int index, int[] A) {
        if (index == A.length) return;
        System.out.println(A[index]);
        printArrayRecursion(index + 1, A);
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        PrintArray array = new PrintArray();
        array.printArrayRecursion(0, a);
    }
}
