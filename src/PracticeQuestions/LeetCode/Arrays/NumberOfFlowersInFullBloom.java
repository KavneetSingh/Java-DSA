package PracticeQuestions.LeetCode.Arrays;
import java.util.*;

public class NumberOfFlowersInFullBloom {

    //LeetCode Q) 2251    🔥


//    static class Person{
//        int idx;
//        int entry;
//
//        Person(int i, int e){
//            this.idx= i;
//            this.entry= e;
//        }
//    }

//    public static int[] fullBloomFlowers(int flower[][], Person people[]){
//        Queue<int[]> q= new LinkedList<>();
//        int ans[]= new int[people.length];
//
//        for(int i=0, j=0;i<people.length;i++){
//            Person curr= people[i];
//
//            while(j<flower.length && flower[j][0]<= curr.entry){
//                q.add(flower[j]);
//                j++;
//            }
//
////            for(int k=0;k<q.size();){              //remove the flowers which have same start but diff exits
////                if(q.get(k)[1]<curr.entry){
////                    q.remove(k);
////                }
////                else{
////                    k++;
////                }
////            }
//
//            while(!q.isEmpty() && q.peek()[1]<curr.entry){
//                q.remove();
//            }
//            ans[curr.idx]= q.size();
//        }
//        return ans;
//    }

    public static int startSearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static int endSearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args){
//        int flower[][]= {{1,6},{3,7},{9,12},{4,13}};
//        int people[]= {2,3,7,11};

        int flower[][]= {{19,37},{19,38},{19,35}, {20,20}};
        int people[]= {6,7,21,1,13,37,5,37,46,43, 38};

//        Arrays.sort(flower, (a,b)-> Integer.compare(a[1], b[1]));     //Sorts the 2d array according to start values
//        Arrays.sort(flower, (a,b)-> Integer.compare(a[0], b[0]));

//        Arrays.sort(people);

        int[] start = new int[flower.length];
        int[] end = new int[flower.length];

        for (int i = 0; i < flower.length; i++) {
            start[i] = flower[i][0];
            end[i] = flower[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int[] res = new int[people.length];
        for (int i = 0; i < people.length; i++) {
            int t = people[i];
            int started = startSearch(start, t);
            int ended = endSearch(end, t);
            res[i] = started - ended;
        }

        for(int i=0;i<res.length;i++){
            System.out.print(res[i] + " ");
        }
    }
}
