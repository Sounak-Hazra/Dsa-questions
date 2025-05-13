package kThAncestorOfaNode;
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


        class Result {
            int val = -1;
        }
        
        int kThAncestor(Node root, int data, int k) {
            Result res = new Result();
            findKthAncestor(root, data, k, res);
            return res.val;
        }
        
        int findKthAncestor(Node root, int data, int k, Result res) {
            if (root == null) return -1;
        
            if (root.data == data) return 0;
        
            int left = findKthAncestor(root.left, data, k, res);
            int right = findKthAncestor(root.right, data, k, res);
        
            if (left != -1) {
                if (left + 1 == k) res.val = root.data;
                return left + 1;
            }
        
            if (right != -1) {
                if (right + 1 == k) res.val = root.data;
                return right + 1;
            }
        
            return -1;
        }
        


    }

    public static void main(String args[]) {
        binaryTree tree = new binaryTree();
        int arr[] = {
            1,
      2,
        4,
          8, -1, -1,
          9, -1, -1,
        5,
          -1,
          10, -1, -1,
      3,
        6, -1, -1,
        7, -1, -1
        };  
        tree.root = tree.buildTree(arr);
    
        /*
            1
          /   \
        2       3
      /   \    / \
     4     5  6   7
    / \     \
   8   9     10


        */
    
        System.out.println(tree.kThAncestor(tree.root, 10, 1));
    }
    
}

