package JavaDsa.BinaryTrees;

public class DiameterOfTree2 {
    static class Info{
        int diam;
        int h;

        Info(int diam, int h){
            this.diam= diam;
            this.h= h;
        }
    }

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data= data;
            this.left= this.right=null;
        }
    }

    public static Info diameter(Node root){                //O(n)
        if(root== null){
//            Info newInfo= new Info(0,0);
//            return newInfo;                          //old zindagi
            return new Info(0,0);             // mentos zindagi
        }

        Info leftInfo= diameter(root.left);
        Info rightInfo= diameter(root.right);

        int h= Math.max(leftInfo.h, rightInfo.h) +1;
        int diam= Math.max( leftInfo.h+ rightInfo.h+1 , Math.max(rightInfo.diam, leftInfo.diam));
        return new Info(diam, h);
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

        Info details= diameter(root);
        System.out.println(details.diam);
    }
}
