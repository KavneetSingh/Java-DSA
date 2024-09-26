package JavaDsa.Heap;

import java.util.ArrayList;

public class DeletionInHeap {

    static class Heap{
        ArrayList<Integer> arr= new ArrayList<>();

        public void insert(int val){

            arr.add(val);
            int ind= arr.size()-1;
            int par= (ind-1)/2;

            while(arr.get(ind)< arr.get(par)){    //min heap
                int temp= arr.get(par);
                arr.set(par, arr.get(ind));
                arr.set(ind, temp);
                ind= par;
                par= (ind-1)/2;
            }
        }

        public int peek(){
            if(arr.size()== 0){
                return -1;
            }
            return arr.get(0);
        }

        private void heapify(int i){
            int left= 2*i+1;
            int right= 2*i+2;
            int minIdx= i;

            if(left< arr.size() && arr.get(left)< arr.get(minIdx)){
                minIdx= left;
            }

            if(right< arr.size() && arr.get(right)< arr.get(minIdx)){
                minIdx= right;
            }

            if(minIdx!=i){
                //swap par and minIdx (can I call it:) node
                int temp= arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                heapify(minIdx);
            }
        }

        public int delete(){
            int data= arr.get(0);

            //step 1: Swap first and last elements
            int temp= arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            //step 2: delete last
            arr.remove(arr.size()-1);

            //step 3: Heapify
            heapify(0);
            return data;
        }
    }

    public static void main(String[] args){
        Heap h= new Heap();
        System.out.println(h.peek());
        int arr[]= {3,6,7,8,2,9,0,1};
        for(int i=0;i<arr.length;i++){
            h.insert(arr[i]);
        }
        System.out.println(h.peek());
        for(int i=0;i<arr.length;i++){
            System.out.println(h.delete());
        }
    }
}
