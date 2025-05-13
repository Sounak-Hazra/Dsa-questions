package transfromToSumTree;

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

    public static class binaryTree {
        Node root = null;
        int index = -1;

        public Node buildTree(int arr[]) {
            index++;
            if (arr[index] == -1) {
                return null;
            }
            Node newNode = new Node(arr[index]);
            if (index == 0) {
                root = newNode;
            }
            newNode.left = buildTree(arr);
            newNode.right = buildTree(arr);
            return newNode;
        }

        void printTreePreorder(Node root) {
            if (root == null) {
                System.out.print("-1 ");
                return;
            }

            System.out.print(root.data + " ");
            printTreePreorder(root.left);
            printTreePreorder(root.right);
        }

        int transFormSum(Node root) {
            if (root == null) {
                return 0;
            }

            int left = transFormSum(root.left);
            int right = transFormSum(root.right);
            int val = root.data;
            root.data = left + right;
            return root.data + val;
        }
    }

    public static void main(String args[]) {
        binaryTree tree = new binaryTree();
        int arr[] = { 1, 2, 4, 8, -1, -1, 9, -1, -1, 5, -1, 10, -1, -1, 3, 6, -1, -1, 7, -1, -1 };
        tree.root = tree.buildTree(arr);

    /*

              1
            /   \
          2       3
        /   \    / \
       4     5  6   7
     /  \     \
    8    9     10

    */

    /*
              54
            /    \
          36      13
         /  \     / \
       17   10   0   0
      /  \    \
     0    0    0

    */
        tree.printTreePreorder(tree.root);
        System.out.println();
        tree.transFormSum(tree.root);
        System.out.println();
        tree.printTreePreorder(tree.root);
    }
}
