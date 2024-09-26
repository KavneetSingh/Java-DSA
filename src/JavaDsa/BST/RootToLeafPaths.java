package JavaDsa.BST;

import java.util.ArrayList;

public class RootToLeafPaths {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data= data;
            this.left= this.right= null;
        }
    }

    static ArrayList<Integer> AL= new ArrayList<>();

    public static Node insert(Node root, int val){
        if(root==null){
            root= new Node(val);
            return root;
        }
        if(root.data>val){
            root.left= insert(root.left,val);
        }
        else{
            root.right= insert(root.right, val);
        }
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

    public static void pathPrint(Node root){
        AL.add(root.data);
        if(root.left==null && root.right==null){  //leaf
            System.out.println(AL);
            AL.remove(AL.size()-1);
            return;
        }
        if(root.left!=null){
            pathPrint(root.left);
        }
        if(root.right!=null){
            pathPrint(root.right);
        }
        AL.remove(AL.size()-1);
    }

    public static void main(String[] args){
        int arr[]={8,6,10,3,7,11,1,4,14,5,12,20};       //print all paths from root to every leaf
        Node root=null;
        for(int i=0;i<arr.length;i++){
            root= insert(root, arr[i]);
        }

        inorder(root);
        System.out.println();
        pathPrint(root);
    }
}
