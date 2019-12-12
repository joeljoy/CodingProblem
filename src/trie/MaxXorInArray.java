package trie;

class Trie1 {
    int val;
    Trie1 left;
    Trie1 right;

    public Trie1(int val) {
        this.val = val;
    }
}

public class MaxXorInArray {

    private Trie1 root = new Trie1(-1);

    public static void main(String[] args) {

    }

    private void search(int a) {
        Trie1 current = root;
        for (int i = 31; i >= 0; i--) {
            int b = (a >> i) & 1;
            if (b == 1){
                if (current.left != null){
                    current = current.left;

                }
            }
        }
    }

    private void insert(int a) {
        Trie1 current = root;
        for (int i = 31; i >= 0; i--) {
            int b = (a >> i) & 1;
            if (b == 1) {
                if (current.right != null) {
                    current.right = new Trie1(1);
                }
                current = current.right;

            } else {
                if (current.left != null) {
                    current.left = new Trie1(0);
                }
                current = current.left;

            }
        }
    }
}
