package ApnaCollegeDSASheet.Arrays;
import java.util.*;

public class MaxSubarrayWithSumK {
    //Important 🔥🔥🔥🔥
    public static void main(String[] args){

        int n= 7;
        int k=3;
        int a[]= {-2,2,-5,12,-11,-1,7};  //ans is 5 in index range [1,5];

        HashMap<Integer, Integer> hm= new HashMap();//stores the point where 1 to k-1 sums end.

        int ans= 0;
        int leftSum=0;

        for(int i=0;i<n;i++){
            leftSum+= a[i];

            int curr= (leftSum%k+k)%k;
            if((leftSum%k+k)%k==0) ans= i+1;   //the array from 0 to i are a valid solution


            if(hm.containsKey(curr)){
                int temp= i- hm.get(curr);   //(i - first similar remainder) is also a valid
                //answer where sum of elements in between is a multiple of 'k'
                ans= Math.max(ans, temp);
            }
            else{
                hm.put(curr, i);
            }
        }

        System.out.println(ans);
    }
}
