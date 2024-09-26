package JavaDsa.BinaryTrees;

import java.util.ArrayList;

public class LowestCommonAncestor {

    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data= data;
            this.left= this.right= null;
        }
    }

    public static boolean getPath(Node root, int find, ArrayList<Node> arr){
        if(root==null){
            return false;
        }

        arr.add(root);

        if(root.data == find){
            return true;
        }

        boolean left= getPath(root.left,find, arr);
        boolean right= getPath(root.right,find, arr);

        if(left || right){
            return true;
        }

        arr.remove(arr.size()-1);
        return false;
    }
    public static Node lca(Node root, int n1, int n2){        //time-> O(n)   space-> O(n)
        ArrayList<Node> path1= new ArrayList<>();
        ArrayList<Node> path2= new ArrayList<>();

        getPath(root,n1,path1);
        getPath(root,n2,path2);

        int i=0;

        while(path1.get(i)== path2.get(i)){
            i++;
        }
        //no choice for nodes that don't exist in tree
        Node lca= path1.get(i-1);
        return lca;
    }


    public static Node lca2(Node root, int n1, int n2){          //time-> O(n)  space->O(1)

        if(root==null || root.data== n1 || root.data==n2){
            return root;
        }

        Node left= lca2(root.left, n1,n2);
        Node right= lca2(root.right, n1, n2);

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

        int n1=4;
        int n2=5;

        System.out.println(lca(root, n1,n2).data);
        System.out.println(lca2(root,n1,n2).data);
    }
}
