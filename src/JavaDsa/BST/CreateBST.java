package JavaDsa.BST;

public class CreateBST {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data= data;
            this.left=this.right= null;
        }
    }

    public static Node insert(Node root, int val){
        if(root==null){
            root= new Node(val);
            return root;
        }

        if(root.data> val){
            //left Subtree
            root.left= insert(root.left,val);
        }
        else{
            root.right= insert(root.right,val);
        }
        return root;
    }

    public static void inorder(Node root){
        if(root== null){
            System.out.print("-1 ");
            return;
        }
        inorder(root.left);
        System.out.print(root.data+ " ");
        inorder(root.right);
    }

    public static boolean search(Node root, int key){
        if(root==null){
            return false;
        }

        if(root.data== key){
            return true;
        }

        if(root.data> key){
            return search(root.left, key);
        }
        return search(root.right, key);
    }

    public static void main(String[] args){
        Node root= insert(null, 4);
        insert(root, 5);
        insert(root, 7);
        insert(root, 1);
        insert(root, 3);
        insert(root, 6);
        insert(root, 2);

        inorder(root);
        System.out.println();
        System.out.println(search(root, 6));

    }
}
