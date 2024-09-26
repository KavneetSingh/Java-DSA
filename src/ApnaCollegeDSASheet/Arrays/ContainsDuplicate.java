package ApnaCollegeDSASheet.Arrays;
import java.util.*;

public class ContainsDuplicate {
    public static void main(String[] args){
        int[] arr= {1,2,3,1};
        boolean ans= false;
        HashSet<Integer> hs= new HashSet<>();
        for(int i=0;i<arr.length;i++){
            if(hs.contains(arr[i])){
                ans= true;
                break;
            }
            hs.add(arr[i]);
        }
        System.out.println(ans);
    }
}
