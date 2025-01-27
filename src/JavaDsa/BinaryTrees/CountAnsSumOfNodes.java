package JavaDsa.BinaryTrees;

public class CountAnsSumOfNodes {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data= data;
            this.left=this.right= null;
        }
    }

    public static int count(Node root){   //O(n)
        int left=0;
        int right=0;
        if(root==null){
            return 0;
        }

        right+= count(root.right);
        left+= count(root.left);

        return left+right+1;
    }

    public static int sum(Node root){  //O(n)
        int left=0;
        int right=0;
        if(root==null){
            return 0;
        }

        left+= sum(root.left);
        right+= sum(root.right);

        return left+right+root.data;
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

        System.out.println(count(root));
        System.out.println(sum(root));
    }
}
