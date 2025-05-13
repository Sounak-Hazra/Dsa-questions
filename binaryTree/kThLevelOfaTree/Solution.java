package kThLevelOfaTree;
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

        void kThOrder(Node root,int level){
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while (!q.isEmpty()) {
                Node current = q.remove();

                if(current == null){
                    if(q.isEmpty()){
                        break;
                    } else {
                        if(level-- < 0){
                            break;
                        }
                        q.add(null);
                    }
                } else {
                    if(level == 0){
                        System.out.println(current.data);
                    }

                    if(current.left != null){
                        q.add(current.left);
                    } 

                    if(current.right != null){
                        q.add(current.right);
                    }
                }
            }

            if(level > 0){
                System.out.println("Levle doesnot exist !");
            }
        }

        void kThOrderRecursive(Node root,int level,int currentlevel){
            if(root == null){
                return;
            }

            if(level == currentlevel){
                System.out.println(root.data);
                return;
            }

            kThOrderRecursive(root.left,level, currentlevel + 1);
            kThOrderRecursive(root.right,level, currentlevel + 1);
        }
        
    }

    public static void main(String args[]) {
        // Test Case 1: Full binary tree
        //        1
        //       / \
        //      2   3
        //     / \
        //    4   5
        binaryTree tree1 = new binaryTree();
        int arr1[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, -1};
        Node root1 = tree1.buildTree(arr1);
        tree1.kThOrderRecursive(root1,2,0);

        // Test Case 2: Left skewed tree
        //        5
        //       /
        //      4
        //     /
        //    3
        //   /
        //  2
        // /
        //1
        binaryTree tree2 = new binaryTree();
        int arr2[] = {5, 4, 3, 2, 1, -1, -1, -1, -1, -1, -1};
        Node root2 = tree2.buildTree(arr2);

        // Test Case 3: Right skewed tree
        // 1
        //  \
        //   2
        //    \
        //     3
        //      \
        //       4
        //        \
        //         5
        binaryTree tree3 = new binaryTree();
        int arr3[] = {1, -1, 2, -1, 3, -1, 4, -1, 5, -1, -1};
        Node root3 = tree3.buildTree(arr3);
    }
}