package JavaDsa.Hashing;
import java.util.*;

public class Itinerary {
    public static void main(String[] args){
        HashMap<String, String> hm= new HashMap<>();
        hm.put("Chennai","Bengaluru");
        hm.put("Mumbai","Delhi");
        hm.put("Goa","Chennai");
        hm.put("Delhi","Goa");

        HashSet<String> hs= new HashSet<>();

        for (String key : hm.keySet()) {
            hs.add(hm.get(key));
        }

        String start="";

        for(String key: hm.keySet()){
            if(!hs.contains(key)){
                start=key;
                break;
            }
        }

        System.out.print(start);    //Mumbai

        for(int i=0;i<hm.size();i++){
            System.out.print(" -> "+ hm.get(start) );
            start= hm.get(start);
        }
    }
}
