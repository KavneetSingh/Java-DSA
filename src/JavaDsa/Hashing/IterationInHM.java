package JavaDsa.Hashing;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.*;

public class IterationInHM {
    public static void main(String[] args){
        HashMap<String, Integer> hm= new HashMap<>();
        hm.put("India", 130);
        hm.put("China", 150);
        hm.put("US", 40);
        hm.put("Nepal", 9);
        hm.put("Indonesia", 15);

        //iterate
        Set<String> keys= hm.keySet();
        System.out.println(keys);

        for (String k: keys) {                      // foreach loop used for any abstract data struct to iterate all objects
            System.out.println("Key= " + k + ", value= " + hm.get(k));      // we can also use entryset instead of keyset,
                                                                             //entryset gives you the pair instead of just key
            //delete this part
            Set<String> hss= new HashSet<>();
            if(hss.contains(k)){

            }
        }
        StringBuilder sb= new StringBuilder("");
        System.out.println(sb.toString());
    }
}
