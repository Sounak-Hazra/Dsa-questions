import java.util.*;
public class Solution {

    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinarySearchTree {
        Node root;

        BinarySearchTree(int arr[]){
            for(int i = 0;i<arr.length;i++){
                root = insert(root, arr[i]);
            }
        }

        Node insert(Node root,int data){
            if (root == null) {
                this.root = new Node(data);
                return this.root;
            }

            if(root.data > data){
                root.left = insert(root.left, data);
            }

            if(root.data < data){
                root.right = insert(root.right, data);
            }

            return root;
        }

        void inonder(Node root){
            if(root == null){
                return;
            }

            inonder(root.left);
            System.out.println(root.data);
            inonder(root.right);
        }

        Node sortedArrayToBST(int[] arr, int start, int end) {
            if (start > end) {
                return null;
            }
            
            int mid = (start + end) / 2;

            Node root = new Node(arr[mid]);
            root.left = sortedArrayToBST(arr, start, mid - 1);
            root.right = sortedArrayToBST(arr, mid + 1, end);

            return root;

        }

    }

    public static void main(String args[]) {
        
        BinarySearchTree b1 = new BinarySearchTree(new int[0]);
        int[] sortedArray = { 1, 2, 3, 4, 5, 6, 7 };
        Node root = b1.sortedArrayToBST(sortedArray,0,sortedArray.length - 1);
        b1.inonder(root);
    }
}