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

        void inonder(Node root){
            if(root == null){
                return;
            }

            inonder(root.left);
            System.out.println(root.data);
            inonder(root.right);
        }

        boolean isValid(Node root, int min, int max) {
            if (root == null) {
                return true;
            }
            if (root.data <= min || root.data >= max) {
                return false;
            } else {
                return isValid(root.left, min, root.data) && isValid(root.right, root.data, max);
            }
        }

    }

    public static void main(String args[]){
        BinarySearchTree b1 = new BinarySearchTree(new int[] { 5, 1, 3, 2, 6, 5 });
        
        System.out.println(b1.isValid(b1.root, Integer.MIN_VALUE,Integer.MAX_VALUE));

    }
}