package topViewOfaTree;

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

    static class Info {
        Node data;
        int hd;

        Info(Node data, int hd) {
            this.data = data;
            this.hd = hd;
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

        void topView(Node root) {
            if (root == null) return;
            
            Queue<Info> q = new LinkedList<>();
            HashMap<Integer, Node> map = new HashMap<>();
            
            int min = 0, max = 0;
            q.add(new Info(root, 0));
            
            while (!q.isEmpty()) {
                Info current = q.poll();
                if (!map.containsKey(current.hd)) {
                    map.put(current.hd, current.data);
                }
                if (current.data.left != null) {
                    q.add(new Info(current.data.left, current.hd - 1));
                    min = Math.min(min, current.hd - 1);
                }
                if (current.data.right != null) {
                    q.add(new Info(current.data.right, current.hd + 1));
                    max = Math.max(max, current.hd + 1);
                }
            }
            
            for (int i = min; i <= max; i++) {
                System.out.print(map.get(i).data + " ");
            }
            System.out.println();
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
        System.out.print("Top View of Tree 1: ");
        tree1.topView(root1);
        // Expected Output: 4 2 1 3

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
        System.out.print("Top View of Tree 2: ");
        tree2.topView(root2);
        // Expected Output: 1 2 3 4 5

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
        System.out.print("Top View of Tree 3: ");
        tree3.topView(root3);
        // Expected Output: 1 2 3 4 5
    }
}