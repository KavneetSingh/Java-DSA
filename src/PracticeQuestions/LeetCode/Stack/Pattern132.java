package PracticeQuestions.LeetCode.Stack;

import java.util.*;

public class Pattern132 {

//    static class Pair{
//        int start;
//        int end;
//
//        Pair(int s, int e){
//            this.start= s;
//            this.end= e;
//        }
//    }

//    public static boolean patternObserver(int arr[]){
//        if(arr.length<3){
//            return false;
//        }
//
//        int min= arr[0];
//        int max= Integer.MIN_VALUE;
//        int prevMin= Integer.MAX_VALUE;
//        int prevMinIdx= -1;
//        int minIdx=0;
//        int maxIdx=-1;
//        int tempMax= Integer.MIN_VALUE;
//        int tempMaxIdx=-1;
//
//        for(int i=1;i<arr.length;i++){
//            if(arr[i]>min && arr[i]<max  && maxIdx>minIdx){
//                return true;
//            }
//            else if(arr[i]>prevMin && arr[i]<max && maxIdx> prevMinIdx){
//                return true;
//            }
//            else if(arr[i]> min && arr[i]<tempMax && minIdx<tempMaxIdx){
//                return true;
//            }
//            if(min>arr[i] && minIdx<maxIdx){
//                prevMinIdx= minIdx;
//                prevMin= min;
//                min= arr[i];
//                minIdx= i;
//            }
//            if(min>arr[i] && minIdx> maxIdx){
//                min= arr[i];
//                minIdx=i;
//            }
//            if(max<= arr[i] && minIdx!=i){
//                maxIdx= i;
//                max= arr[i];
//            }
//            if(minIdx>maxIdx){
//                if(minIdx>tempMaxIdx && arr[i]>min){
//                    tempMaxIdx=i;
//                    tempMax= arr[i];
//                }
//                else if(tempMaxIdx>minIdx){
//                    tempMax= Math.max(tempMax, arr[i]);
//                    tempMaxIdx= tempMax>arr[i]? tempMaxIdx: i;
//                }
//            }
////            min= Math.min(min, arr[i]);
////            max= Math.max(max, arr[i]);
//        }
//
//        return false;
//    }


//    public static boolean patternObserver2(int arr[]){
//        if(arr.length<3){
//            return false;
//        }
//
//        int min= arr[0];
//        int max= Integer.MIN_VALUE;
//        int prevMin= Integer.MAX_VALUE;
//        int prevMinIdx= -1;
//        int minIdx=0;
//        int maxIdx=-1;
//        int tempMax= Integer.MIN_VALUE;
//        int tempMaxIdx=-1;
//        boolean ascend= false;
//        int prev=arr[0];
//
//        Stack<Integer> mins= new Stack<>();
//        Stack<Integer> maxs= new Stack<>();
//
//        for(int i=1;i<arr.length;i++){
//            if(arr[i]>min && arr[i]<max  && maxIdx>minIdx){
//                return true;
//            }
//            else if(arr[i]>prevMin && arr[i]<max && maxIdx> prevMinIdx){
//                return true;
//            }
//            else if(arr[i]> min && arr[i]<tempMax && minIdx<tempMaxIdx){
//                return true;
//            }
//            if(arr[i]>prev){
//                ascend= true;
//            }
//            else{
//                ascend= false;
//            }
//
//            if (ascend) {
//                if(maxs.peek()==i-1){
//                    maxs.pop();
//                }
//                maxs.push(i);
//            }
//            else{
//                if(mins.peek()==i-1){
//                    mins.pop();
//                }
//                mins.push(i);
//            }
//
//            if(min>arr[i] && minIdx<maxIdx){
//                prevMinIdx= minIdx;
//                prevMin= min;
//                min= arr[i];
//                minIdx= i;
//            }
//            if(min>arr[i] && minIdx> maxIdx){
//                min= arr[i];
//                minIdx=i;
//            }
//            if(max<= arr[i] && minIdx!=i){
//                maxIdx= i;
//                max= arr[i];
//            }
//            if(minIdx>maxIdx){
//                if(minIdx>tempMaxIdx && arr[i]>min){
//                    tempMaxIdx=i;
//                    tempMax= arr[i];
//                }
//                else if(tempMaxIdx>minIdx){
//                    tempMax= Math.max(tempMax, arr[i]);
//                    tempMaxIdx= tempMax>arr[i]? tempMaxIdx: i;
//                }
//            }
////            min= Math.min(min, arr[i]);
////            max= Math.max(max, arr[i]);
//        }
//
//        return false;

//        for(int i=0;i<arr.length;i++){
//
//            if(arr[i]> max && arr[i]>min){
//                max= arr[i];
//                maxIdx= i;
////                System.out.println(i);
//            }
//
//            if(arr[i]<max){
//                al.add(new Pair(minIdx, maxIdx));
////                System.out.println("pair= " + minIdx +", " + maxIdx);
//            }
//
//            if(arr[i]<min){
////                if(maxIdx>0){
////
////                }
//                minIdx= i;
//                min= arr[i];
//                max= Integer.MIN_VALUE;
//                maxIdx=-1;
//            }
//
//            for(int j=0;j<al.size();j++){
//                Pair p= al.get(j);
////                System.out.println(arr[i] + " " + p.end);
//                if(arr[p.start]<arr[i] && arr[p.end]>arr[i]){
//                    return true;
//                }
//            }
//        }
//    }


    public static boolean patternObserver3(int arr[]){
        if(arr.length<3){
            return false;
        }
        Stack<Integer> s= new Stack<>();
        int thirdMax= Integer.MIN_VALUE;

        for(int i=arr.length-1;i>=0;i--){
            int curr= arr[i];

            if(curr< thirdMax){
                return true;
            }

            while(!s.isEmpty() && s.peek()<curr){
                thirdMax= s.pop();
            }

            s.push(curr);
        }
        return false;

    }

    public static void main(String[] args){
//        int arr[]= {1,4,0,-1,-2,-3,-1,-2};
//        int arr[]= {42,43,6,12,3,4,6,11,20};
//        int arr[]= {3,5,0,3,4};
//        int arr[]= {2,5,2,6,3,2,8};
//        int arr[]= {1,2,3,4};
//        int arr[]= {3,1,0,2};
        int arr[]= {-1,3,2,0};


        System.out.println(patternObserver3(arr));
    }
}
