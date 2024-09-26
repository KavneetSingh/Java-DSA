package PracticeQuestions.LeetCode.Arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    //LeetCode Q)119
    public static void main(String[] args){
        int row= 20;
        //0 to n-1 to 0;

//        int arr[]= new int[row+1];
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        long temp = 1;
        for(int i=1,up=row,down=1;i<=row;i++,up--, down++){
            temp=temp*up/down;
            ans.add((int)temp);
        }

        for(int i=0;i<ans.size();i++){
            System.out.print( ans.get(i) + ", ");
        }
    }
}
