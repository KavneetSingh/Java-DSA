package JavaDsa.Hashing;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class LinkedHashMaps {
    public static void main(String[] args){
        HashMap<String, Integer> hm= new HashMap<>();
        hm.put("India", 130);
        hm.put("China", 150);
        hm.put("US", 40);

        LinkedHashMap<String, Integer> lhm= new LinkedHashMap<>();             // stores every key serially as entered
        lhm.put("India", 130);
        lhm.put("China", 150);
        lhm.put("US", 40);

        System.out.println(hm);
        System.out.println(lhm);      //India-> China-> US.  It uses doubly linkedlist to be able to do so
    }
}
