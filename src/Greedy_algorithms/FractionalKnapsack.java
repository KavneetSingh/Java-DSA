package Greedy_algorithms;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    public static void main(String[] args){
        int val[]={60,100,120};
        int weight[]={10,20,30};
        int capacity=50;
        int total=0;

        double ratio[][]= new double[val.length][2];

        for(int i=0;i<val.length;i++) {
            //0th => index,  1st => ratio
            ratio[i][0]= i;
            ratio[i][1]= (double)val[i]/weight[i];
        }

        //ascending order sorting
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));
        // but we need descending order
        for(int i=val.length-1 ; i>=0;i--){
            int idx= (int)ratio[i][0];
            if(capacity>= weight[idx]){
                capacity-= weight[idx];
                total+= val[idx];
            }
            else{
                if(capacity>0){
                    total+= capacity* ratio[i][1];
                    capacity=0;
                }
            }
        }
        System.out.println((int)total);
    }
}
