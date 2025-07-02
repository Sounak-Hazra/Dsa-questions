// package maximumSizeOfBstInBt;

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

    public static class Info {
        boolean isBst;
        int size;
        int max;
        int min;

        Info(boolean isBst, int size, int max, int min){
            this.isBst = isBst;
            this.size = size;
            this.max = max;
            this.min = min;
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
            if(root == null){
                return new Node(data);
            }

            if(root.data > data){
                root.left = insert(root.left, data);
            }

            if(root.data < data){
                root.right = insert(root.right, data);
            }

            return root;
        }

        void inonder(Node root, ArrayList<Integer> list){
            if(root == null){
                return;
            }

            inonder(root.left, list);
            list.add(root.data);
            inonder(root.right, list);
        }


        public static int maxSize = 0;

        Info maximiumSizeOfBst(Node root){
            if(root == null){
                return new Info(true, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
            }

            Info leftInfo = maximiumSizeOfBst(root.left);
            Info rightInfo = maximiumSizeOfBst(root.right);
            int size = leftInfo.size + rightInfo.size + 1;
            int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
            int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

            if(root.data <= leftInfo.max && root.data >= rightInfo.min){
                return new Info(false, size, max, min);
            }

            if(leftInfo.isBst && rightInfo.isBst){
                maxSize = Math.max(maxSize, size);
                return new Info(true, size, max, min);
            }

            return new Info(false, size, max, min);

        }
    }

    public static void main(String args[]) {
        BinarySearchTree bst = new BinarySearchTree(new int[]{10, 5, 1, 8, 15, 7, 20});
        bst.maximiumSizeOfBst(bst.root);
        System.out.println("Maximum size of BST in BT: " + BinarySearchTree.maxSize);
    }
    
    
}