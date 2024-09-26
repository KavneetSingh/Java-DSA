package JavaDsa.Hashing;
import java.util.HashMap;

public class HashMaps {

    public static void main(String[] args){
        HashMap<String, Integer> hm= new HashMap<>();     //unordered maps and that's why you get China, US, India as output
        //insertion - O(1)                                // follows any random order
        hm.put("India", 130);
        hm.put("China", 150);
        hm.put("US", 40);

        System.out.println(hm);

        //get- O(1)
        System.out.println(hm.get("k"));   //gives null as its not stored
        System.out.println(hm.get("India"));

        //containsKey- O(1)
        System.out.println(hm.containsKey("India"));
        System.out.println(hm.containsKey("France"));

        //Remove- O(1)
        System.out.println(hm.remove("Thailand"));    //returns null value
        System.out.println(hm.remove("China"));
        System.out.println(hm);

        //Size- O(1)
        System.out.println(hm.size());

        //isEmpty
        System.out.println(hm.isEmpty());
        hm.clear();       //removes all the keys in hm
        System.out.println(hm.isEmpty());
    }
}
