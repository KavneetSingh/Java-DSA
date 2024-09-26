package JavaDsa.BinaryTrees;

import java.util.Arrays;
import java.util.Scanner;

public class DiameterOfTree {

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data= data;
            this.left=this.right= null;
        }
    }

    public static int heightOfTree(Node root){
        int rh= 0;
        int lh= 0;
        if(root==null){
            return 0;
        }

        lh+= heightOfTree(root.left);
        rh+= heightOfTree(root.right);

        return Math.max(rh,lh) +1;
    }

    public static int diameter(Node root){    //O(N^2)
        if(root== null){
            return 0;
        }

        int leftDiam= diameter(root.left);
        int rightDiam= diameter(root.right);
        int leftHt= heightOfTree(root.left);
        int rightHt= heightOfTree(root.right);

        int selfDiam= leftHt+rightHt+1;

        return Math.max(selfDiam, Math.max(leftDiam, rightDiam));
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

        System.out.println(diameter(root));
    }
}
