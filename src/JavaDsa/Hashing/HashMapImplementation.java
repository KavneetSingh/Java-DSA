package JavaDsa.Hashing;

import java.util.LinkedList;
import java.util.ArrayList;

public class HashMapImplementation {
    static class HashMap<K,V> {  //K,V are called generics
        private class Node{
            K key;
            V value;

            public Node(K key, V value){
                this.key= key;
                this.value= value;
            }
        }

        private int n; //no. of nodes in the hashMap
        private int N;   // no. of buckets or size of array
        private LinkedList<Node> buckets[];       //similar to--  private int arr[];  && N=buckets.length

        //@SuppressWarnings("unchecked")    might be needed in some versions of java
        public HashMap(){
            this.N=4;
            this.buckets= new LinkedList[N];
            for(int i=0;i<N;i++){
                this.buckets[i]= new LinkedList<>();
            }
        }

        private int hashFunction(K key){
            int hc= key.hashCode();
            return Math.abs(hc)% N;
        }

        private int searchInLL(K key, int bi){
            LinkedList<Node> ll= buckets[bi];
            if(ll.size()==0){
                return -1;
            }
            int len=0;
            for(int i=0;i<ll.size();i++){
                Node n= ll.get(i);
                if(n.key== key){
                    return len;
                }
                len++;
            }
            return -1;
        }

        private void rehash(){
            LinkedList<Node> oldBuck[]= buckets;
            buckets= new LinkedList[N*2];
            N= 2*N;
            for(int i=0;i<buckets.length; i++){
                buckets[i]= new LinkedList<>();
            }

            // Nodes-> add in new Bucket
            for(int i=0;i< oldBuck.length;i++){
                LinkedList<Node> ll= oldBuck[i];
                Node node= ll.remove();
                while(node!=null){
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value){        //O(lambda)--> O(1)
            int bi= hashFunction(key);     //0 to 3
            int di= searchInLL(key, bi);

            if(di != -1){                       //key already exists in hashMap
                Node n= buckets[bi].get(di);
                n.value= value;   //update
            } else{
                buckets[bi].add(new Node(key, value));
                n++;
            }

            double lambda= (double)n/(double)N;
            if(lambda> 2.0){
                rehash();
            }
        }

        public boolean containsKey(K key){     //O(lambda) --> O(1)
            int bi= hashFunction(key);   //bucketIndex
            int di= searchInLL(key, bi);

            if(di==-1){
                return false;
            }
            return true;
//            LinkedList<Node> ll= buckets[bucket];
//            if(ll.size()==0){
//                return false;
//            }
//
//            for(int i=0;i<ll.size();i++){
//                Node n= ll.get(i);
//                if(n.key== key){
//                    return true;
//                }
//            }
//            return false;
        }

        public V get(K key){        //O(1)
            int bi= hashFunction(key);
            int di= searchInLL(key,bi);
            if(di==-1){
                return null;
            }
            return buckets[bi].get(di).value;
        }

        public V remove(K key){          //O(1)
            int bi= hashFunction(key);
            int di= searchInLL(key,bi);
            if(di==-1){
                return null;
            }
            Node N= buckets[bi].remove(di);
            n--;
            return N.value;
        }

        public ArrayList<K> keySet(){
            ArrayList<K> keys= new ArrayList<>();

            for(int i=0;i<N;i++){
                LinkedList<Node> ll= buckets[i];
                if(ll.size()==0){
                    continue;
                }
                for (Node node: ll) {
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty(){
            return n==0;
        }

    }
    public static void main(String[] args){
        //worst case of hashmap occurs when hashCode returns the same bucket index for every key. Hence, all the keys will be stored at the same index of array and
        // in single linked list. The worst case complexity in this case is not O(lambda) but O(n), n= no. of keys
        HashMap<String, Integer> hm= new HashMap<>();
        hm.put("India", 130);
        hm.put("US", 40);
        hm.put("China", 150);
        hm.put("Nepal", 10);
        hm.put("Thailand", 12);
        hm.put("Germany", 11);
        hm.put("Canada", 5);
        hm.put("Russia", 30);
        System.out.println(hm.containsKey("Pakistan"));
        System.out.println(hm.containsKey("Germany"));
        System.out.println(hm.get("Nepal"));
        System.out.println(hm.remove("Thailand"));
        ArrayList<String> keys= hm.keySet();
        System.out.println(keys);
        System.out.println(hm.isEmpty());
    }
}
