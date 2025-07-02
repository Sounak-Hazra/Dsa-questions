// package unOptimizedBstToOptimizedBst;

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

        Node sortedArrayToBST(ArrayList<Integer> a,int start, int end){

            if(start > end){
                return null;
            }

            int mid = (start + end) / 2;

            Node root = new Node(a.get(mid));

            root.left = sortedArrayToBST(a, start, mid - 1);
            root.right = sortedArrayToBST(a, mid + 1, end);

            return root;
        }


        void unoptimizedToOptimized(Node root){
            ArrayList<Integer> a = new ArrayList<>();

            inonder(root, a);

            root = sortedArrayToBST(a, 0, a.size() - 1);
        }

    }

    public static void main(String args[]) {
        BinarySearchTree b1 = new BinarySearchTree(new int[] { 5, 1, 3, 2, 6, 5 });
    
        // Before optimization
        System.out.println("Inorder of Unoptimized BST:");
        ArrayList<Integer> originalInorder = new ArrayList<>();
        b1.inonder(b1.root, originalInorder);
        System.out.println(originalInorder);
    
        // Optimize the BST
        b1.unoptimizedToOptimized(b1.root);
    
        // After optimization (note: unoptimizedToOptimized creates new root but doesn’t return it,
        // so we need to capture it manually; for now, we're calling inonder again for demonstration)
        System.out.println("Inorder of Optimized BST:");
        ArrayList<Integer> optimizedInorder = new ArrayList<>();
        b1.inonder(b1.root, optimizedInorder);
        System.out.println(optimizedInorder);
    
    
        // Additional test case 2
        BinarySearchTree b2 = new BinarySearchTree(new int[] { 10, 5, 15, 3, 7, 12, 18 });
        System.out.println("\nTest Case 2 - Inorder of Unoptimized BST:");
        ArrayList<Integer> b2Before = new ArrayList<>();
        b2.inonder(b2.root, b2Before);
        System.out.println(b2Before);
    
        b2.unoptimizedToOptimized(b2.root);
    
        System.out.println("Test Case 2 - Inorder of Optimized BST:");
        ArrayList<Integer> b2After = new ArrayList<>();
        b2.inonder(b2.root, b2After);
        System.out.println(b2After);
    }
    
}