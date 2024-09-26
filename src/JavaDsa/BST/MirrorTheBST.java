package JavaDsa.BST;

public class MirrorTheBST {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data= data;
            this.left= this.right=null;
        }
    }

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

    public static void mirror(Node root){
        if(root==null){
            return;
        }
        //swap
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        mirror(root.left);
        mirror(root.right);
    }

    public static void main(String[] args){     //Mirror all nodes of the BST-- similar to mirroring a binary tree? YES (Hell Yweah)
        int arr[]={8,6,10,3,7,11,1,4,14,5,12,20};
        Node root=null;
        for(int i=0;i<arr.length;i++){
            root= insert(root, arr[i]);
        }

        inorder(root);
        mirror(root);

        System.out.println();
        inorder(root);
    }
}
