package JavaDsa.BinaryTrees;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data= data;
            this.left= this.right= null;
        }
    }

    static class BinTrees{
        static int idx=-1;

        public static Node buildTree(int datas[]){
            idx++;
            if(datas[idx]==-1){
                return null;
            }
            Node newN= new Node(datas[idx]);
            newN.left= buildTree(datas);
            newN.right= buildTree(datas);
            return newN;              // will return root node
        }
    }

    public static void levelOrder(Node root){
        if(root==null){
            return;
        }

        Queue<Node> q= new LinkedList<>();
        q.add(root);
        q.add(null);


        while(!q.isEmpty()){
            Node removed= q.remove();
            if(removed==null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }
            else{
                System.out.print(removed.data+" ");
                if(removed.left!=null){
                    q.add(removed.left);
                }
                if(removed.right!=null){
                    q.add(removed.right);
                }
            }
        }

    }

    public static void main(String[] args){
        BinTrees bt= new BinTrees();
        int arr[]= {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Node root= bt.buildTree(arr);
        levelOrder(root);
    }
}
