package PracticeQuestions.LeetCode.Arrays;

import java.util.*;

public class ValidateBinaryTreeNodes {

    public static void main(String[] args){

        //LeetCode Q)1361        ❌ wrong solution
        int n=4;
//        int leftChild[]= {1,-1,3,-1};
//        int rightChild[]= {2,-1,-1,-1};

        int leftChild[]= {1,-1,3,-1};
        int rightChild[]= {2,3,-1,-1};
        boolean ans= true;

        HashMap<Integer, Integer> left= new HashMap<>();
        HashMap<Integer, Integer> right= new HashMap<>();
        HashSet<Integer> leftPar= new HashSet<>();
        HashSet<Integer> rightPar= new HashSet<>();

        for(int i=0;i<n;i++){
            if(left.containsKey(i) || (left.containsValue(leftChild[i]) && leftChild[i]!=-1)  || (right.containsValue(rightChild[i])  && rightChild[i]!=-1)){
                ans= false;
                System.out.println("a");
                //return false;
            }
            if(right.containsKey(i) || (right.containsValue(rightChild[i])  && rightChild[i]!=-1) ||  (left.containsValue(leftChild[i]) && leftChild[i]!=-1)){
                ans= false;
                System.out.println("b");
                //return false;
            }

            if(leftChild[i] !=-1 || rightChild[i]!=-1){
                if(!right.containsValue(i) && !left.containsValue(i) && i!=0){
                    System.out.println("c");
                    ans= false;
                    //return false;
                }
            }

            if(leftChild[i]!= -1){
                if(leftPar.contains(i)){
                    System.out.println("d");
                    ans= false;
                    //return false;
                }
                left.put(i, leftChild[i]);
                leftPar.add(i);
            }

            if(rightChild[i]!= -1){
                if(rightPar.contains(i)){
                    System.out.println("e");
                    ans= false;
                    //return false;
                }
                right.put(i, rightChild[i]);
                rightPar.add(i);
            }


        }

        System.out.println(ans);
    }
}
