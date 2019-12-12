package tree;


import java.util.LinkedList;
import java.util.Queue;

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;

    TreeLinkNode(int x) {
        val = x;
    }
}

public class SiblingsPointer {
    public void connect(TreeLinkNode root) {
        root.next = null;
        connectRecur(root);
    }


    private void connectRecurr(TreeLinkNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            node.left.right = node.right;
        }
        if (node.right != null) {
            if (node.next != null) {
                if (node.next.left != null) {
                    node.right.next = node.next.left;
                } else {
                    node.right.next = node.next.right;
                }
            } else {
                node.right = null;
            }
        }
    }

    private void connectRecur(TreeLinkNode root) {
        TreeLinkNode temp = null;

        if (root == null)
            return;

        root.next = null;
        while (root != null) {

            TreeLinkNode q = root;
            while (q != null) {
                if (q.left != null) {
                    if (q.right != null) q.left.next = q.right;
                    else q.left.next = getNextRight(q);
                }
                if (q.right != null) q.right.next = getNextRight(q);
                q = q.next;
            }

            if (root.left != null) root = root.left;
            else if (root.right != null) root = root.right;
            else root = getNextRight(root);
        }
    }

    private TreeLinkNode getNextRight(TreeLinkNode root) {
        TreeLinkNode temp = root.next;

        while (temp != null) {
            if (temp.left != null)
                return temp.left;
            if (temp.right != null)
                return temp.right;
            temp = temp.next;
        }
        return null;
    }

    public static void main(String[] args) {
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.left.left = new TreeLinkNode(4);
        root.left.right = new TreeLinkNode(5);
        root.left.left.left = new TreeLinkNode(8);
        root.left.left.right = new TreeLinkNode(9);

        root.right = new TreeLinkNode(3);
        root.right.left = new TreeLinkNode(6);
        root.right.right = new TreeLinkNode(7);
        root.right.right.left = new TreeLinkNode(10);
        root.right.right.right = new TreeLinkNode(11);

        SiblingsPointer pointer = new SiblingsPointer();
        pointer.connect(root);
        System.out.println();
    }
}
