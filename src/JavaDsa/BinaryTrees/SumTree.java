package JavaDsa.BinaryTrees;

public class SumTree {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
            this.left= this.right= null;
        }
    }

    public static int sumTree(Node root){
        if(root==null){
            return 0;
        }
        int left= sumTree(root.left);
        int right= sumTree(root.right);
        int newLeftChild=0;
        int newRightChild=0;
        int temp= root.data;
        if(root.left!=null){
            newLeftChild= root.left.data;
        }
        if(root.right!=null){
            newRightChild= root.right.data;
        }
        root.data= left + right + newLeftChild + newRightChild;
        return temp;
    }

    public static void preorder(Node root){
        if(root==null){
            System.out.print("-1"+" ");
            return;
        }
        System.out.print(root.data+" ");

        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args){
         /*
                   1
                  / \
                 2   3
                / \ / \
               4  5 6  7

         */
        Node root= new Node(1);
        root.left = new Node(2);
        root.right= new Node(3);
        root.left.left= new Node(4);
        root.left.right= new Node(5);
        root.right.left= new Node(6);
        root.right.right= new Node(7);

        System.out.println(sumTree(root));
        preorder(root);
    }
}
