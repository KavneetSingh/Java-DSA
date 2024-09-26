package JavaDsa.BST;

public class PrintInRange {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data= data;
            this.left= this.right= null;
        }
    }

    public static Node insert(Node root, int val){
        if(root==null){
            root= new Node(val);
            return root;
        }
        else if(root.data>val){
            root.left= insert(root.left,val);
        }
        else{
            root.right= insert(root.right, val);
        }
        return root;
    }

    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static void printInRange(Node root, int k1, int k2){
        if(root==null){
            return;
        }
        if(root.data>= k1 && root.data<=k2){
            printInRange(root.left, k1, k2);
            System.out.print(root.data+" ");
            printInRange(root.right, k1, k2);
        }
        else if(root.data<k1){
            printInRange(root.right, k1, k2);
        }
        else{
            printInRange(root.left, k1, k2);
        }
    }

    public static void main(String[] args){
        int nodes[]= {8,5,10,3,6,11,1,4,14,12};
        Node root=null;

        for(int i=0;i<nodes.length;i++){
            root= insert(root, nodes[i]);
        }

        inorder(root);
        System.out.println();
        printInRange(root, 4,13);
    }
}
