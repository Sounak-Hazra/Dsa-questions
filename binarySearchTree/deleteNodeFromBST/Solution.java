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

        Node search(Node root, int val) {
            if (root == null) {
                return null;
            }

            if (root.data == val) {
                return root;
            }

            if (root.data > val) {
                return search(root.left, val);
            } else {
                return search(root.right, val);
            }
        }


        Node inOrderSuccessor(Node root) {
            if (root.left == null) {
                return root;
            }

            return inOrderSuccessor(root.left);
        }

        Node deleteNode(Node root, int data) {
            if (root.data > data) {
                root.left = deleteNode(root.left, data);
            }

            else if (root.data < data) {
                root.right = deleteNode(root.right, data);
            }
            
            else {
                if (root.left == null && root.right == null) {
                    return null;
                }

                else if (root.right == null) {
                    return root.left;
                }

                else if (root.left == null) {
                    return root.right;
                } else {
                    Node is = inOrderSuccessor(root.right);
                    root.data = is.data;
                    root.right = deleteNode(root.right, is.data);
                }
            }
            
            return root;

        }
    }

    public static void main(String args[]){
        BinarySearchTree b1 = new BinarySearchTree(new int[]{5, 1, 3, 2, 6});

        b1.inonder(b1.root);

        b1.deleteNode(b1.root, 3);

        b1.inonder(b1.root);

    }
}