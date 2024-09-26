package JavaDsa.AVLTrees;

public class AVLTree {
    static class Node{
        int data;
        Node left;
        Node right;
        int height;

        Node(int data){
            this.data= data;
            this.height= 1;
        }
    }

    public static int diff(Node root){
        if(root.left==null && root.right==null){
            return 0;
        }
        if(root.left==null){
            return -1*root.right.height;
        }
        else if(root.right==null){
            return root.left.height;
        }
        return root.left.height- root.right.height;
    }

    public static void heightsAfterReadjustment(Node root, Node left, Node right, int type){
        switch (type){
            case 1: { //LL

                int rl= (right.left!=null) ? right.left.height : 0;    //true : false
                int rr= (right.right!=null) ? right.right.height: 0;

                right.height= Math.max(rl, rr) +1;
                root.height= Math.max(right.height, left.height) +1;
                return;
            }

            case 2:

            case 3: {  //LR  same as RL in changes of heights

                int ll= (left.left!=null) ? left.left.height : 0;
                int lr= (left.right!=null) ? left.right.height : 0;
                int rl= (right.left!=null) ? right.left.height : 0;
                int rr= (right.right!=null) ? right.right.height : 0;

                left.height= Math.max(ll, lr) +1;
                right.height= Math.max(rl, rr) +1;
                root.height= Math.max(left.height, right.height) +1;
                return;
            }

            case 4:{
                int ll= (left.left!=null) ? left.left.height : 0;
                int lr= (left.right!=null) ? left.right.height : 0;

                left.height= Math.max(ll, lr) +1;
                root.height= Math.max(right.height, left.height) +1;
                return;
            }
        }
    }

    public static Node createAVL(Node root){
        Node newP;
        if(diff(root)>1){
            if(diff(root.left)>0){
                //LL case
                newP= root.left;
                Node relocate= newP.right;
                newP.right= root;
                root.left= relocate;
                heightsAfterReadjustment(newP, newP.left, newP.right, 1);
            }
            else{
                //LR case
                newP= root.left.right;
                Node rel1= newP.left;
                Node rel2= newP.right;
                newP.right= root;
                newP.left= root.left;
                newP.left.right= rel1;
                newP.right.left= rel2;
                heightsAfterReadjustment(newP, newP.left, newP.right, 2);
            }
        }
        else{
            if(diff(root.right)>0){
                //RL case
                newP= root.right.left;
                Node rel1= newP.left;
                Node rel2= newP.right;
                newP.left= root;
                newP.right= root.right;
                newP.left.right= rel1;
                newP.right.left= rel2;
                heightsAfterReadjustment(newP, newP.left, newP.right, 3);
            }
            else{
                //RR case
                newP= root.right;
                Node relocate= newP.left;
                newP.left= root;
                newP.left.right= relocate;
                heightsAfterReadjustment(newP, newP.left, newP.right, 4);
            }
        }
        return newP;
    }

    public static Node insert(Node root, int val){
        if(root==null){
            root= new Node(val);
            return root;
        }
        if(root.data> val){
            root.left= insert(root.left , val);
        }
        else{
            root.right= insert(root.right , val);
        }

        {   //height calculator for the root
            if(root.left==null){
                root.height= root.right.height+1;
            }
            else if(root.right== null){
                root.height= root.left.height+1;
            }
            else{
                root.height= Math.max(root.left.height, root.right.height)+1;
            }
        }

        if(diff(root)> 1 || diff(root)<-1){
            root= createAVL(root);
        }
        return root;

    }

    public static void preorder(Node root){
        if(root== null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args){
        int arr[]= {40,20,10,25,30,22,50};

        /*
               expected AVL
                     25
                  /     \
                20       40
               /  \     /  \
             10   22   30   50
         */

        Node root= null;

        for(int i=0;i<arr.length;i++){
            root= insert(root, arr[i]);
        }

        System.out.println("The preorder traversal of the AVL is: ");
        preorder(root);
    }
}
