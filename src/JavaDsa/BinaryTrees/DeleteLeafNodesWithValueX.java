package JavaDsa.BinaryTrees;

public class DeleteLeafNodesWithValueX {
    //We have a binary tree and a target integer x, delete all the leaf nodes having value as x.
    // Also,delete the newly formed leaves with the target value as x.
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data= data;
            this.left= this.right= null;
        }
    }

    public static void preorder(Node root){
        if(root==null){
            System.out.print("- ");
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);

    }

    public static void deleteNodes(Node root, int n){
        if(root==null){
            return;
        }
        if(root.left!=null || root.right!=null){
            if(root.left!=null && root.left.data==n && root.left.left==null && root.left.right==null){
                root.left=null;
            }
            if(root.right!=null && root.right.data==n && root.right.left==null && root.right.right==null){
                root.right=null;
            }
        }

        deleteNodes(root.left,n);
        deleteNodes(root.right,n);

        if(root.left!=null || root.right!=null){
            if(root.left!=null && root.left.data==n && root.left.left==null && root.left.right==null){
                root.left=null;
            }
            if(root.right!=null && root.right.data==n && root.right.left==null && root.right.right==null){
                root.right=null;
            }
        }
    }


    public static void main(String[] args){
        /*
                1
               / \
              3   3
             / \
            3   2
           /
          3

         */
        Node root= new Node(1);
        root.left= new Node(3);
        root.right= new Node(3);
        root.left.right= new Node(2);
        root.left.left= new Node(3);
        root.left.left.left= new Node(3);

        preorder(root);
        System.out.println();
        deleteNodes(root,3);
        preorder(root);
    }
}
