package JavaDsa.BinaryTrees;

public class MinimumDistBW2Nodes {

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int Data){
            this.data= Data;
            this.left=this.right= null;
        }
    }

    public static int lcaDist(Node root, int n){

        if(root== null){
            return -1;
        }
        if(root.data==n){
            return 0;
        }
        int left= lcaDist(root.left, n);
        int right= lcaDist(root.right, n);

        if(left==-1 && right==-1){
            return -1;
        }
        return Math.max(left,right) +1;
    }
    public static int minDist(Node root, int n1, int n2){

        Node lca= lca(root,n1,n2);

        int dist1= lcaDist(root,n1);
        int dist2= lcaDist(root,n2);

        return dist1+ dist2;
    }
    public static Node lca(Node root, int n1, int n2){
        if(root==null || root.data==n1 || root.data== n2){
            return root;
        }

        Node left= lca(root.left, n1,n2);
        Node right= lca(root.right, n1,n2);

        if(right==null){
            return left;
        }

        if(left==null){
            return right;
        }

        return root;
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

        int n1=1;
        int n2=6;
        System.out.println(lca(root,n1,n2).data);
        System.out.println(minDist(lca(root,n1,n2),n1,n2));
    }
}
