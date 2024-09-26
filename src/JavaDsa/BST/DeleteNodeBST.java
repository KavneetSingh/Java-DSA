package JavaDsa.BST;

public class DeleteNodeBST {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
            this.left= this.right= null;
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

    public static Node delete(Node root, int val){
        if(root==null){
            return null;
        }

        if(root.data<val){
            root.right= delete(root.right, val);
        }
        else if(root.data>val){
            root.left= delete(root.left,val);
        }
        else{ //voila  root.data==val
            // case1-- leaf node
            if(root.left==null && root.right==null){
                return null;
            }

            //case2-- single child
            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }

            //case3-- Both children exist
            Node IS= findInorderSuccessor(root.right);
            root.data= IS.data;
            root.right= delete(root.right,IS.data);
        }
        return root;
    }

    public static Node findInorderSuccessor(Node root){
        if(root.left== null){
            return root;
        }
        return findInorderSuccessor(root.left);
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

    public static void main(String[] args){
        Node root= insert(null, 8);
        insert(root, 5);
        insert(root, 6);
        insert(root, 3);
        insert(root, 1);
        insert(root, 4);
        insert(root, 10);
        insert(root, 11);
        insert(root, 14);

        inorder(root);
        delete(root, 1);
        System.out.println();
        inorder(root);
        delete(root, 10);
        System.out.println();
        inorder(root);
        delete(root, 5);
        System.out.println();
        inorder(root);
    }
}
