package JavaDsa.BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class KthLevelOfTree {
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
        Node node;
        int k;

        Info(Node node, int level){
            this.node= node;
            this.k= level;
        }
    }

    public static void kLevel(Node root, int K){    //Aam zindagi      O(N)
        Queue<Info> q= new LinkedList<>();

        q.add(new Info(root,1));
        q.add(null);

        while(!q.isEmpty()){
            Info curr= q.remove();
            if(curr== null){
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }

            else{
                if(curr.k==K){
                    System.out.print(curr.node.data+" ");
                }
                if(curr.node.left!=null){
                    q.add(new Info(curr.node.left, curr.k+1));
                }
                if(curr.node.right!=null){
                    q.add(new Info(curr.node.right,curr.k+1));
                }
            }
        }
        System.out.println();
    }
                                                                                //mentos zindagi
    public static void kLevelUsingRecursion(Node root, int k, int K){         //similar to preorder traversal  O(N)
        if(root==null){
            return;
        }

        kLevelUsingRecursion(root.left,k+1,K);
        kLevelUsingRecursion(root.right,k+1,K);
        if(k==K){
            System.out.print(root.data+" ");
        }
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

        kLevel(root,3);
        kLevelUsingRecursion(root,1,3);
    }
}
