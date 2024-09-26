package PracticeQuestions.LeetCode.Arrays;

import java.util.HashMap;
import java.util.Iterator;

public class TupleWithSameProduct {
    public static void main(String[] args){

//        int[] nums= {1,2,4,5,10};    //2,4,5,10; 8,10,20; 20,40; 50
        int nums[]= {1,2,4,8,16,32,64,128,256,512};
        HashMap<Integer, Integer> hm= new HashMap();
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                int prod= nums[i]*nums[j];
//                System.out.println(prod);
                hm.put(prod, hm.getOrDefault(prod, 0)+1);
//                System.out.println(hm.get(prod));
            }
        }

        //a,b,c,d => {(a,b),(a,c),(a,d), (b,c), (b,d), (c,d)};
        //3!=6, 4!= 24

        int ans= 0;
        Iterator<Integer> itr= hm.keySet().iterator();
        while(itr.hasNext()){
            int x= itr.next();
            int y= hm.get(x);

            System.out.println(x + "           " + y);

            if(y==2){
                ans+= 1;
            }
            else if(y>2){
                int combinations=(y*(y-1))/2;

                ans+= combinations;
            }
        }
        System.out.println(ans*8);
    }
}
