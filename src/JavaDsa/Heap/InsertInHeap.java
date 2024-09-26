package JavaDsa.Heap;
import java.util.ArrayList;

public class InsertInHeap {

    static class Heap{
        //min heap
        ArrayList<Integer> arr= new ArrayList<>();

        public void add(int val){      //O(logn)
            //add at last index of arr
            arr.add(val);
            int x= arr.size()-1;  // x is child index
            int par= (x-1)/2;   // par is parent's index

            while(arr.get(par) > arr.get(x)){
                int temp= arr.get(par);
                arr.set(par, arr.get(x));
                arr.set(x, temp);
                x= par;
                par= (x-1)/2;
            }
            //System.out.println(arr);
        }

        public int peek(){    // gives you the min element or max element depending upon whether it is min heap or max heap
            if(arr.size()== 0){
                return -1;
            }
            return arr.get(0);
        }
    }

    public static void main(String[] args){
        Heap h= new Heap();
        System.out.println(h.peek());
        int arr[]= {3,6,7,8,2,9,0,1};
        for(int i=0;i<arr.length;i++){
            h.add(arr[i]);
        }
        System.out.println(h.peek());
    }
}
