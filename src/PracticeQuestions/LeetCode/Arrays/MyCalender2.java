package PracticeQuestions.LeetCode.Arrays;

import java.util.*;

public class MyCalender2 {

    //LeetCode Q) 731
    // Took 3hrs

    public static class event{
        int start;
        int end;

        event(int s, int e){
            this.start= s;
            this.end= e;
        }

    }

    public static boolean book(int start, int end, LinkedList<event> ll, LinkedList<event> overlap){
        event newEvent= new event(start, end);

        if(ll.isEmpty()){
            ll.add(newEvent);
            return true;
        }

        if(!overlap.isEmpty()){
            for(int i=0;i< overlap.size();i++){
                event curr= overlap.get(i);

                int s= curr.start;
                int e= curr.end;

                if((start<= s && s<end)  || (start< e && e<=end)) {
                    return false;
                }
                else if (start >= s && end <= e) {
                    return false;
                }
            }
        }

        for(int i=0;i<ll.size();i++){
            event curr= ll.get(i);
            int s= curr.start;
            int e= curr.end;

            if(start<=s && s<end  || start< e && e<=end || start>= s && end<=e){
                int s1=-1;
                int e1=-1;
                if(start<=s && s<end  || start< e && e<=end){
                    if(start<=s && s<end  && start< e && e<=end){
                        s1= s;
                        e1= e;
                    }
                    else if(start<=s && s<end){
                        s1= s;
                        e1= end;
                    }
                    else{
                        s1= start;
                        e1= e;
                    }

                }
                else if(start>= s && end<=e){
                    s1= start;
                    e1= end;
                }
                overlap.add(new event(s1,e1));
//                System.out.println("start= " + s1 + "     end= " + e1);
            }
        }
        ll.add(newEvent);
        return true;
    }

    public static LinkedList<event> ll;
    public static LinkedList<event> overlap;

    public static void main(String[] args){
//        int arr[][]= {{10, 20}, {50, 60}, {10, 40}, {5, 15}, {5, 10}, {25, 55}};
        int arr[][]= {{24,40},{43,50},{27,43},{5,21},{30,40},{14,29},{3,19},{3,14},{25,39},{6,19}};

        ll= new LinkedList<>();
        overlap= new LinkedList<>();

        for(int i=0;i<arr.length;i++){
            System.out.println(book(arr[i][0], arr[i][1], ll, overlap));
        }
    }
}
