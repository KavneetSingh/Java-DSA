package PracticeQuestions.LeetCode.Trees;

public class LongestUnivaluePath {

    //🔥 next level time taken on this one but was not very hard actually time wasted for nothing
    //LeetCode  Q)687
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
//        boolean involved;
//        int len;    //if involved, the length is path including child else max length
        int max;
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

//    static class returnType{
//        boolean involved;
//        int len;    //if involved, the length is path including child else max length
//        int max;
//    }

    public static int longestPath(TreeNode root){
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
//            root.involved= true;
            root.max=1;
//            root.len=1;         //int value that is returned
            return 1;
        }

        int left= longestPath(root.left);
        int right= longestPath(root.right);


        if(root.left!=null && root.val== root.left.val || root.right!=null && root.val==root.right.val){

            if(root.left!=null && root.right!=null && root.val== root.left.val && root.val==root.right.val){
//                root.involved= true;
//                root.len= Math.max(left,right)+1;
//                System.out.print(root.len + "    ");
                root.max= Math.max(root.left.max, Math.max(root.right.max, right+left+1));
//                System.out.println(root.max);
                return Math.max(left,right)+1;
            }
            else if(root.left!=null && root.val== root.left.val){
//                root.involved= true;
//                root.len= left+1;
                if(root.right!=null){
                    root.max= Math.max(root.right.max, Math.max(root.left.max, left+1));
                }
                else{
                    root.max= Math.max(root.left.max, left+1);
                }
                return left+1;
            }
            else{
//                root.involved= true;
//                root.len= right+1;
                if(root.left!=null){
                    root.max= Math.max(root.right.max, Math.max(root.left.max, right+1));
                }
                else{
                    root.max= Math.max(root.right.max, right+1);
                }
                return right+1;
            }
        }
        else{
//            root.involved=true;
////            root.len= Math.max(left, right);
//            root.len=1;
            if( root.left!=null && root.right!=null)
                root.max= Math.max(root.left.max, root.right.max);

            else if(root.left!=null)
                root.max= Math.max(left, root.left.max);

            else
                root.max= Math.max(right, root.right.max);
            return 1;
        }
    }

    public static void main(String[] args){
//        TreeNode root= new TreeNode(5);
//        root.left= new TreeNode(5);
//        root.left.left= new TreeNode(4);
//        root.left.right= new TreeNode(5);
//        root.left.right.right= new TreeNode(5);
//        root.left.left.right= new TreeNode(4);
//        root.left.left.right.right= new TreeNode(4);

//        TreeNode root= new TreeNode(1);
//        root.right= new TreeNode(1);
//        root.right.left= new TreeNode(1);
//        root.right.right= new TreeNode(1);
//        root.right.right.left= new TreeNode(1);
//        root.right.left.left= new TreeNode(1);
//        root.right.left.right= new TreeNode(1);

        TreeNode root= new TreeNode(5);
        root.right= new TreeNode(5);
        root.right.left= new TreeNode(5);
        root.right.right= new TreeNode(3);
        root.right.left.right= new TreeNode(4);
        root.right.left.right.right= new TreeNode(4);
        root.right.left.right.right.left= new TreeNode(4);
        root.left= new TreeNode(4);
        root.left.right= new TreeNode(4);
        root.left.left= new TreeNode(4);
        root.left.left.left= new TreeNode(4);
        root.left.left.right= new TreeNode(4);
        root.left.left.left.left= new TreeNode(4);
        root.left.left.left.left.left= new TreeNode(4);
        root.left.left.right.right= new TreeNode(4);
        root.left.left.right.right.right= new TreeNode(4);


        int x= longestPath(root);

        System.out.println(Math.max(root.max, x)-1);
    }
}
