package JavaDsa.BST;

public class SortedArrayToBalancedBST {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data= data;
            this.left= this.right= null;
        }
    }

    public static Node BSTMaker(Node root, int in, int out, int arr[]){
        int mid= (in+out)/2;
        root= new Node(arr[mid]);
        if(in==out){
            return root;
        }
        root.left= BSTMaker(root.left, in, mid-1, arr);
        root.right= BSTMaker(root.right, mid+1, out, arr);
        return root;
    }

    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args){
        int arr[]= {3,5,6,8,10,11,12};
        Node root= BSTMaker(null, 0, arr.length-1, arr);
        inorder(root);
        System.out.println();
        preorder(root);
    }
}
