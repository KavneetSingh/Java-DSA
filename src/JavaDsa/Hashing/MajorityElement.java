package JavaDsa.Hashing;
import java.util.HashMap;
import java.util.Set;
public class MajorityElement {
    //print the elements that have frequecy more than n/3 in an array of size n
    public static void main(String[] args){
        int arr[]= {1,3,2,5,1,3,1,5,1};

        HashMap<Integer, Integer> hm= new HashMap<>();

        for(int i=0;i<arr.length;i++){
            int temp= arr[i];
//            if(hm.containsKey(temp)){
//                hm.put(arr[i], hm.get(temp)+1 );
//            }
//            else{
//                hm.put(temp, 1);
//            }
            hm.put(temp, hm.getOrDefault(temp, 0) +1);  // it will either return the value of the key if it exists
                                                                   // or 0 if it doesn't
        }

        for( Integer key: hm.keySet()){   //directly use the keySet function instead of creating another set
            if(hm.get(key)> arr.length/3){
                System.out.println(key);
            }
        }
    }
}
