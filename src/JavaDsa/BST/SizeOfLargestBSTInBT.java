package JavaDsa.BST;

public class SizeOfLargestBSTInBT {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
            this.left= this.right= null;
        }
    }

    static class Info{
        boolean isBST;
        int size;
        int max;
        int min;

        Info(boolean isBST, int size, int max, int min){
            this.isBST= isBST;
            this.size= size;
            this.max= max;
            this.min= min;
        }
    }

    static int maxSize=0;

    public static Info maxBST(Node root){
        //this function checks if a node is root for a valid bst. And also gives out the length of max bst in the simple binary tree
        if(root.left == null && root.right==null){
            return new Info(true, 1, root.data, root.data);
        }
        Info left= maxBST(root.left);
        Info right= maxBST(root.right);
        int low= left.max;
        int high= right.min;
        int max= Math.max(root.data, Math.max(right.max, left.max)); //we know that right.max should be highest but what about
        // the case of !isBST, there even left subtree nodes can have higher values.

        int min= Math.min(root.data, Math.min(right.min, left.min));
        boolean isBST= left.isBST && right.isBST && root.data< high && root.data> low;
        //this boolean checks if the root's left and right subtrees are both valid BSTs or not and if the root itself follows
        // the logic of being the smaller than all right subtree-ers and greater than all left subtree-ers.

        int size= left.size + right.size + 1;
        if(isBST && size>maxSize){
            maxSize= size;
        }

        return new Info(isBST, size, max, min);
    }

    public static void main(String[] args){
        //given a normal Binary tree find out the size of largest BST in it
        Node root= new Node(50);
        root.left= new Node(30);
        root.left.left= new Node(5);
        root.left.right= new Node(20);

        root.right= new Node(60);
        root.right.left= new Node(45);
        root.right.right= new Node(70);
        root.right.right.left= new Node(65);
        root.right.right.right= new Node(80);


        /*
                 50
               /    \
             30       60
            /  \     /  \
           5    20  45   70
                        /  \
                       65   80


           expected OUTPUT= 5
         */

        System.out.println();
        maxBST(root);
        System.out.println(maxSize);
    }
}
