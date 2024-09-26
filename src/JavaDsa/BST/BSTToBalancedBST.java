package JavaDsa.BST;

import java.util.ArrayList;

public class BSTToBalancedBST {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data= data;
            this.left= this.right= null;
        }
    }

    public static void inorder(Node root, ArrayList<Integer> AL){
        if(root==null){
            return;
        }
        inorder(root.left, AL);
        AL.add(root.data);
        inorder(root.right, AL);
    }

    public static Node insert(Node root, int val){
        if(root==null){
            root= new Node(val);
            return root;
        }
        if(root.data<val){
            root.right= insert(root.right, val);
        }
        else{
            root.left= insert(root.left, val);
        }
        return root;
    }

    public static Node arrayToBST(Node root, int in, int out, ArrayList<Integer> AL){
        int mid= (in+out)/2;
        root= new Node(AL.get(mid));
        System.out.print(root.data+" ");
        if(in>=out){
            return root;
        }
        root.left= arrayToBST(root.left, in, mid-1, AL);
        root.right= arrayToBST(root.right, mid+1, out, AL);
        return root;
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
        //Convert a normal BST to balanced BST with min height
        int arr[]={8,6,10,3,7,11,1,4,14,5,12,20};
        Node root=null;
        for(int i=0;i<arr.length;i++){
            root= insert(root, arr[i]);
        }
        ArrayList<Integer> AL= new ArrayList<>();
        inorder(root, AL);
        System.out.println(AL);
        root= arrayToBST(null, 0, AL.size()-1,AL);

        System.out.println();
        preorder(root);
    }
}
