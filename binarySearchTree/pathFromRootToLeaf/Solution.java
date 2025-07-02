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

        void pathFromRootToLeaf(Node root,ArrayList<Integer> arr) {
            if (root == null) {
                return;
            }

            arr.add(root.data);

            if (root.left == null && root.right == null) {
                for (int i = 0; i < arr.size(); i++) {
                    System.out.print(arr.get(i));
                }

                System.out.println();

            }

            pathFromRootToLeaf(root.left, arr);
            pathFromRootToLeaf(root.right, arr);

            arr.remove(arr.size() - 1);

        }

    }

    public static void main(String args[]){
        BinarySearchTree b1 = new BinarySearchTree(new int[] { 5, 1, 3, 2, 6 });
        
        b1.pathFromRootToLeaf(b1.root, new ArrayList<>());

    }
}