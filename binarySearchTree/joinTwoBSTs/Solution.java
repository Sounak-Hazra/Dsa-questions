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

    static class BinarySearchTree {
        Node root;

        BinarySearchTree(int arr[]) {
            for (int i = 0; i < arr.length; i++) {
                root = insert(root, arr[i]);
            }
        }

        Node insert(Node root, int data) {
            if (root == null) {
                this.root = new Node(data);
                return this.root;
            }

            if (root.data > data) {
                root.left = insert(root.left, data);
            }

            if (root.data < data) {
                root.right = insert(root.right, data);
            }

            return root;
        }

        void treeToArray(Node root, ArrayList<Integer> arr) {
            if (root == null) {
                return;
            }

            treeToArray(root.left, arr);
            arr.add(root.data);
            treeToArray(root.right, arr);
        }

        ArrayList<Integer> margeArray(ArrayList<Integer> arr, ArrayList<Integer> arr2) {
            ArrayList<Integer> sorted = new ArrayList<>();
            int i = 0;
            int j = 0;

            while (i < arr.size() && j < arr2.size()) {
                if (arr.get(i) < arr2.get(j)) {
                    sorted.add(arr.get(i));
                    i++;
                } else {
                    sorted.add(arr2.get(j));
                    j++;
                }
            }

            while (i < arr.size()) {
                sorted.add(arr.get(i));
                i++;
            }
            while (j < arr2.size()) {
                sorted.add(arr2.get(j));
                j++;
            }

            return sorted;
        }


        Node arrayToTree(ArrayList<Integer> arr,int st, int ed) {
            if (st > ed) {
                return null;
            }

            int mid = (st + ed) / 2;

            Node root = new Node(arr.get(mid));

            root.left = arrayToTree(arr, st, mid - 1);
            root.right = arrayToTree(arr, mid + 1, ed);

            return root;
        }


        Node margedTree(Node root1, Node root2) {
            ArrayList<Integer> arr1 = new ArrayList<>();
            treeToArray(root1, arr1);
            ArrayList<Integer> arr2 = new ArrayList<>();
            treeToArray(root2, arr2);


            ArrayList<Integer> margedArray = margeArray(arr1, arr2);


            return arrayToTree(margedArray, 0, margedArray.size() - 1);


        }   
    }

    public static void main(String args[]) {

        BinarySearchTree b1 = new BinarySearchTree(new int[]{1, 3, 5});
        BinarySearchTree b2 = new BinarySearchTree(new int[]{2, 4, 6});

        Node mergedRoot = b1.margedTree(b1.root, b2.root);

        ArrayList<Integer> result = new ArrayList<>();
        b1.treeToArray(mergedRoot, result);
        System.out.println("Inorder traversal of merged tree: " + result);
    }
}
