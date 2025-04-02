
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

        
    }

    public static void main(String args[]) {
        binaryTree tree = new binaryTree();
        int arr1[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, -1};
        Node root1 = tree.buildTree(arr1);

        binaryTree subTree = new binaryTree();
        int arr2[] = {2, 4, -1, -1, 5, -1, -1};
        Node root2 = subTree.buildTree(arr2);

    }
}