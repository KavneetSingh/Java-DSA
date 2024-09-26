import java.util.*;

public class practice3 {



    public static void main(String[] args){

//        int nums[]= {1,3,2,3,3};        //ans= 6;
//        int nums[]= {1,4,2,3};

        int nums[]= {61,23,38,23,56,40,82,56,82,82,82,70,8,69,8,7,19,14,58,42,82,10,82,78,15,82};        //ans= 224
        int k= 2;
        int max= -1;
        for(int i=0;i<nums.length;i++){
            max= Math.max(max, nums[i]);
        }

        int ans=0;

        List<Integer> q= new ArrayList<>();
//        int j=0;
        for(int i=0; i<nums.length;i++){
            if(nums[i]== max) q.add(i);
        }
        int start=0;
        for(int i=0, j=k-1;j<q.size();j++, i++){
            int st= q.get(i);
            int en= q.get(j);
            ans+= (st-start)*(nums.length-en+1);
//            ans+= st;
//            ans+= nums.length-en-1;
            ans++;
            start=st;
        }

        System.out.println(ans);
    }
}
