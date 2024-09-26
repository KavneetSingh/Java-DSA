package JavaDsa.Heap;

import java.util.ArrayList;

public class HeapSort {
    static class Heap{
        ArrayList<Integer> arr= new ArrayList<>();

        public void insert(int val){    //maxHeap for ascending
            arr.add(val);
            int idx= arr.size()-1;
            int par= (idx-1)/2;

            while( arr.get(par) < arr.get(idx)){
                //swap
                int temp= arr.get(par);
                arr.set(par, arr.get(idx));
                arr.set(idx, temp);
                idx= par;
                par= (idx-1)/2;
            }
        }

        public int peek(){
            if(arr.size()== 0){
                return -1;
            }
            return arr.get(0);
        }

        protected void swap(int i, int j){
            int temp= arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j, temp);
        }
        protected void heapify(int i, int n){      //O(logn)
            int max=i;
            int left= 2*i+1;
            int right= 2*i+2;

            if(left<=n && arr.get(left)> arr.get(max)){
                max= left;
            }

            if(right<=n && arr.get(right)> arr.get(max)){
                max= right;
            }

            if(max!=i){
                swap(max, i);
                heapify(max, n);
            }
        }

        public void heapSort(){   // O(nlogn)
            int n= arr.size();
            for(int i=0; i<arr.size(); i++){
                swap(0, n-i-1);
                heapify(0,n-i-2);
            }
        }
    }

    public static void main(String[] args){        //maxHeap is used for ascending sorting
        Heap h= new Heap();
        System.out.println(h.peek());
        int arr[]= {3,6,7,8,2,9,0,1};
        for(int i=0;i<arr.length;i++){
            h.insert(arr[i]);
        }
        System.out.println(h.peek());
        h.heapSort();
        System.out.println(h.arr);  // works fine.
    }
}
