package JavaDsa.BinaryTrees;

public class KthAncestor {     //error

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data= data;
            this.left= this.right= null;
        }
    }
    static boolean found=false;
    public static int kAncestor(Node root, int n, int par){
        if(par==0){          //very speacial case
            return n;
        }
        if(root== null){
            return -1;
        }
        if(root.data== n){
            found=true;
            return 0;
        }
        int left= kAncestor(root.left, n, par);
        int right= kAncestor(root.right, n, par);

        if(left==-1 && right==-1){
            return -1;
        }
        int max= Math.max(left,right);

        if(Math.max(left,right)+1 == par){
            System.out.println(root.data);
        }
        if(found ){
            return Math.max(left,right)+1;
        }

        return Math.max(left,right)+1;
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


        kAncestor(root, 5, 1);
    }
}
