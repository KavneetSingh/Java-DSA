package Greedy_algorithms;
import java.util.*;

public class MinimumCoins {
    public static void main(String[] args){
        Integer coin[]= {1,2,5,10,20,50,100,500,2000};
        Arrays.sort(coin, Comparator.reverseOrder());
        int amt= 1059;
        int numCoin=0;
        ArrayList<Integer> ans= new ArrayList<>();

        for(int i=0;i<coin.length;i++){
            if (coin[i]<= amt){
                while(coin[i]<=amt){
                    amt-= coin[i];
                    numCoin++;
                    ans.add(coin[i]);
                }
            }
            if(amt<=0){
                break;
            }
        }

        System.out.println(numCoin);
        System.out.println(ans);
    }
}
