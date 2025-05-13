package miniumDistanceBetweenTwoNodes;

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

        Node lastCommonAncestor(Node root, int n1, int n2) {

            if (root == null || root.data == n1 || root.data == n2) {
                return root;
            }

            Node left = lastCommonAncestor(root.left, n1, n2);
            Node right = lastCommonAncestor(root.right, n1, n2);

            if (left != null && right != null) {
                return root;
            }

            if (right == null) {
                return left;
            }

            if (left == null) {
                return right;
            }

            return null;
        }

        int calculateDistance(Node root, int n1) {
            // if(root == null ){
            // return 0;
            // }
            // if(root.data == n1 || root.data == n2){
            // return 1;
            // }

            // int inLeft = calculateDistance(root.left, n1, n2);
            // int inRight = calculateDistance(root.right, n1, n2);

            // if(inLeft != 0 && inRight != 0){
            // return inLeft + inRight;
            // }

            // if(inLeft == 0){
            // return inRight + 1;
            // }

            // if(inRight == 0){
            // return inLeft + 1;
            // }

            if (root == null) {
                return -1;
            }

            if (root.data == n1) {
                return 0;
            }

            int inLeft = calculateDistance(root.left, n1);
            int inRight = calculateDistance(root.right, n1);

            if (inLeft == -1 && inRight == -1) {
                return -1;
            } else if (inRight == -1) {
                return inLeft + 1;
            } else {
                return inRight + 1;
            }
        } 

    int distance(Node root, int n1, int n2) {
        Node commonAncestor = lastCommonAncestor(root, n1, n2);
        return calculateDistance(commonAncestor, n1) + calculateDistance(commonAncestor, n2);
    }

    }

    public static void main(String args[]) {
        binaryTree tree = new binaryTree();
        int arr[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1 };
        tree.root = tree.buildTree(arr);

        /*
         * 1
         * / \
         * 2 3
         * / \ / \
         * 4 5 6 7
         */

        System.out.println(tree.distance(tree.root, 5, 1));
    }

}
