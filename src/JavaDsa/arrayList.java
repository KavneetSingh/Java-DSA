package JavaDsa;
import java.util.ArrayList;

public class arrayList {
    public static void main(String[] args){
        ArrayList<Integer> al= new ArrayList<Integer>(5);
        int arr[] = {20,30,10,40,80,50,60};
        for(int i=0;i<7;i++){
            if (arr[i]== 50){
                System.out.println(i);
            }
        }
//        al.add(10);
//        al.add(20);
//        al.add(30);
//        System.out.println(al);
    }
}
