package JavaDsa.Hashing;
import java.util.HashMap;
import java.util.TreeMap;

public class TreeMaps {
    public static void main(String[] args){
        TreeMap<String, Integer> tm= new TreeMap<>();   //It sorts the keys on the basis of keys and not values.
                                                        // It doesn't use arrays or linkedList instead uses red black trees.
        tm.put("India", 130);      // time for put() is also O(logn) due to sorting and also for get() and remove()
        tm.put("China", 150);
        tm.put("US", 40);
        tm.put("Indonesia", 20);


        HashMap<String, Integer> hm= new HashMap<>();
        hm.put("India", 130);
        hm.put("China", 150);
        hm.put("US", 40);


        System.out.println(tm);      // China-> India-> Indonesia-> US    sorted according to keys and not values by default
        System.out.println(tm.get("India"));
        System.out.println(tm.remove("China"));
        System.out.println(hm);
    }
}
