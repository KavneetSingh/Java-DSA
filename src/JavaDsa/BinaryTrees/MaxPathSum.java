package JavaDsa.BinaryTrees;

public class MaxPathSum {
    //Traverse through any path of the tree from one leaf to another and report the max sum out of all paths
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data= data;
            this.left=this.right= null;
        }
    }

    static int max;
    public static int maxSum(Node root, int ancestorSum){
        if(root==null){
            return 0;
        }

        int left= maxSum(root.left, ancestorSum+ root.data);
        int right= maxSum(root.right, ancestorSum + root.data);

        int currMax= Math.max( left+right +root.data ,Math.max(left+ancestorSum +root.data, right+ ancestorSum +root.data));
        max= Math.max(max, currMax);
        return Math.max(left, right)+ root.data;
    }

    public static void main(String[] args){
        /*
                   1
                  / \
                 2   3
                / \ / \
               4  5 6  7

         */

//        Node root= new Node(1);
//        root.left = new Node(2);
//        root.right= new Node(3);
//        root.left.left= new Node(4);
//        root.left.right= new Node(5);
//        root.right.left= new Node(6);
//        root.right.right= new Node(7);

        /*
                -10
                /  \
               9    20
                   /  \
                  15   7
        */

        Node root= new Node(-10);
        root.left = new Node(9);
        root.right= new Node(20);
//        root.left.left= new Node(4);
//        root.left.right= new Node(5);
        root.right.left= new Node(15);
        root.right.right= new Node(7);

        maxSum(root,0);
        System.out.println(max);
    }
}
