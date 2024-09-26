package JavaDsa.Hashing;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;


public class HashSets {
    public static void main(String[] args){
        HashSet<Integer> hs= new HashSet<>();   // stores in an unordered manner, no duplicates and null is allowed to be added
        // HashSets are implemented using HashMaps and similarly LinkedHashSets are implemented using LinkedHashMaps
        // and treeSets are implemented using TreeMaps
        hs.add(3);   //O(1)
        hs.add(5);
        hs.add(2);
        hs.add(5);
        hs.add(6);
        hs.add(7);
        System.out.println(hs.contains(3)); //O(1)
        System.out.println(hs.remove(3));  //O(1)
        System.out.println(hs);   //idk why it's printed in ordered format
        System.out.println(hs.size());
//        hs.clear();
//        System.out.println(hs.size());


        //iterating on hashSet using iterators
        Iterator it= hs.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }
        System.out.println();


        HashSet<String> cities= new HashSet<>();
        cities.add("Delhi");
        cities.add("Ludhiana");
        cities.add("Pune");
        cities.add("Kolkata");
        cities.add("Singapore");
        cities.add("Chennai");
        cities.add("Hyderabad");
        Iterator<String> i= cities.iterator();
        while(i.hasNext()){
            System.out.print(i.next()+ "    ");  //iterates and prints in the same step
            // and linked hash set just like linkedHashMaps would save in the order of insertion using doubly linkedList
            // LHS and HS(hashset) can add null in them but treeSet cannot.
        }

        LinkedHashSet<String> lhs= new LinkedHashSet<>();
        lhs.add("Delhi");
        lhs.add("Ludhiana");
        lhs.add("Pune");
        lhs.add("Kolkata");
        lhs.add("Singapore");

        TreeSet<String> ts= new TreeSet<>();
        ts.add("Delhi");
        ts.add("Ludhiana");
        ts.add("Pune");
        ts.add("Kolkata");
        ts.add("Singapore");

        System.out.println();
        System.out.println(lhs);
        System.out.println(ts);
    }
}
