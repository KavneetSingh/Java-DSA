package JavaDsa.BinaryTrees;

public class HeightOfTree {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data= data;
            this.left=this.right= null;
        }
    }

    static class BinaryTree{
        static int idx=-1;
        public static Node createTree(int datas[]){
            idx++;
            if(datas[idx]==-1){
                return null;
            }

            Node newN= new Node(datas[idx]);
            newN.left= createTree(datas);
            newN.right= createTree(datas);
            return newN;
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

        System.out.println(heightOfTree(root));
    }
}
