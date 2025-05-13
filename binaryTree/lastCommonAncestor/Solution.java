package lastCommonAncestor;
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

        boolean getPath(Node root, int data, ArrayList<Node> path){
            if(root == null){
                return false;
            }
            path.add(root);

            boolean left = getPath(root.left, data, path);
            boolean right = getPath(root.right, data, path);

            if(root.data == data){
                return true;
            }

            if(!left && !right){
                path.remove(path.size() - 1);
                return false;
            } else{
                return true;
            }

        }

        Node lastCommonAncestor(Node root,int n1,int n2){
            ArrayList<Node> path1 = new ArrayList<>();
            ArrayList<Node> path2 = new ArrayList<>();

            getPath(root,n1,path1);
            getPath(root,n2,path2);

            int i = 0;
            for( ; i<path1.size() && i<path2.size();i++){
                if(path1.get(i).data != path2.get(i).data){
                    break;
                }
            }

            Node lca = path1.get(i - 1);

            return lca;

        }

        Node lastCommonAncestor2(Node root,int n1, int n2){

            if(root == null || root.data == n1 || root.data == n2 ){
                return root;
            }

            Node left = lastCommonAncestor2(root.left,n1,n2);
            Node right = lastCommonAncestor2(root.right,n1,n2);

            if(left != null && right != null){
                return root;
            }

            if(left != null){
                return left;
            }
            if(right != null){
                return right;
            }

            return null;
        } 
    }

    public static void main(String args[]) {
        binaryTree tree = new binaryTree();
        int arr[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1};  
        tree.root = tree.buildTree(arr);
    
        /*
                1
               / \
              2   3
             / \  / \
            4   5 6   7
        */
    
        System.out.println("\nLCA Test Cases:");
        System.out.println("LCA of 4 and 5: " + tree.lastCommonAncestor2(tree.root, 4, 5).data);
        System.out.println("LCA of 4 and 6: " + tree.lastCommonAncestor2(tree.root, 4, 6).data);
        System.out.println("LCA of 3 and 4: " + tree.lastCommonAncestor2(tree.root, 3, 4).data);
        System.out.println("LCA of 2 and 4: " + tree.lastCommonAncestor2(tree.root, 2, 4).data);
        System.out.println("LCA of 6 and 7: " + tree.lastCommonAncestor2(tree.root, 6, 7).data);
    }
    
}
