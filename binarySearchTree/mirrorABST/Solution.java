public class Solution {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinarySearchTree {
        Node root;

        BinarySearchTree(int arr[]) {
            for (int i = 0; i < arr.length; i++) {
                root = insert(root, arr[i]);
            }
        }

        Node insert(Node root, int data) {
            if (root == null) {
                return new Node(data);
            }

            if (root.data > data) {
                root.left = insert(root.left, data);
            }

            if (root.data < data) {
                root.right = insert(root.right, data);
            }

            return root;
        }

        void inonder(Node root) {
            if (root == null) {
                return;
            }

            inonder(root.left);
            System.out.print(root.data + " ");
            inonder(root.right);
        }

        Node search(Node root, int val) {
            if (root == null) {
                return null;
            }

            if (root.data == val) {
                return root;
            }

            if (root.data > val) {
                return search(root.left, val);
            } else {
                return search(root.right, val);
            }
        }

        void mirrorBst(Node root) {
            if (root == null) {
                return;
            }

            Node temp = root.left;
            root.left = root.right;
            root.right = temp;

            mirrorBst(root.left);
            mirrorBst(root.right);
        }

    }

    public static void main(String args[]) {
        BinarySearchTree b1 = new BinarySearchTree(new int[] { 5, 1, 3, 2, 6 });

        b1.inonder(b1.root);
        System.out.println();
        b1.mirrorBst(b1.root);

        b1.inonder(b1.root);
    }
}