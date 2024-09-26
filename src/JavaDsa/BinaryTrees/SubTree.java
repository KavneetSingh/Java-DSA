package JavaDsa.BinaryTrees;

public class SubTree {

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data= data;
            this.left= this.right= null;
        }
    }

    public static boolean isIdentical(Node root, Node subroot){
        if(root==null && subroot==null){
            return true;
        }
        else if( root==null|| subroot==null || root.data!= subroot.data){
            return false;
        }

        boolean left= isIdentical(root.left, subroot.left);
        boolean right= isIdentical(root.right, subroot.right);

        return left && right;
    }

    public static boolean subTree(Node root, Node subroot){
        if(root==null){
            return false;
        }

        if(root.data== subroot.data){
            if(isIdentical(root,subroot)){
                return true;
            }
        }

        return subTree(root.left, subroot) || subTree(root.right, subroot);
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

        Node subRoot= new Node(2);
        subRoot.left= new Node(4);
        subRoot.right= new Node(5);

        System.out.println(subTree(root, subRoot));

    }
}
