package JavaDsa.BST;

public class ValidityOfBST {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data= data;
            this.right= this.left= null;
        }
    }

    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static boolean isValid(Node root, int max, int min){
        if(root==null){
            return true;
        }
        if(root.data<=min){
            return false;
        }
        if(root.data>= max){
            return false;
        }
        Boolean left= isValid(root.left, root.data, min);
        Boolean right= isValid(root.right, max, root.data);
        return left && right;
    }

    public static void main(String[] args){  // check if BST is following all of its properties
        // another method would be to store inorder traversal output in an array and then check if all the values are sorted or not
        // if sorted, then true; else-false
        Node root=new Node(9);
        root.left= new Node(6);
        root.left.left=  new Node(3);
        root.left.right=  new Node(8);
        root.right=  new Node(12);
        root.right.right=  new Node(14);

        inorder(root);
        System.out.println();
        System.out.println(isValid(root, Integer.MAX_VALUE, Integer.MIN_VALUE));
    }
}
