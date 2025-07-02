import java.util.*;

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

        boolean isSubTree(Node p, Node c) {
            if (p == null || c == null) {
                return false;
            }

            if (p.data == c.data && isIdentical(p, c)) {
                return true;
            }
            
            return isSubTree(p.right, c) || isSubTree(p.left, c);
        }
        
        boolean isIdentical(Node p, Node c) {
            if (p == null && c == null) {
                return true;
            }

            if (p == null || c == null) {
                return false;
            }

            if (p.data != c.data) {
                return false;
            }

            return isIdentical(p.right, c.right) && isIdentical(p.left, c.left);
        }
    }

    public static void main(String args[]) {
        binaryTree tree = new binaryTree();
        int arr1[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, -1};
        Node root1 = tree.buildTree(arr1);

        binaryTree subTree = new binaryTree();
        int arr2[] = {2, 4, -1, -1, 5, -1, -1};
        Node root2 = subTree.buildTree(arr2);

        System.out.println(tree.isSubTree(root1, root2)); // Expected output: true
        
        binaryTree notSubTree = new binaryTree();
        int arr3[] = {2, 4, -1, -1, 6, -1, -1};
        Node root3 = notSubTree.buildTree(arr3);
        
        System.out.println(tree.isSubTree(root1, root3)); // Expected output: false
    }
}