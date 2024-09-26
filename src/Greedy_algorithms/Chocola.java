package Greedy_algorithms;

import java.util.Arrays;

public class Chocola {
    //Given the cost of breaking each line of a n*m chocolate. Find the min cost of breaking all the pieces of chocolate.
    public static int minCostCalc(int row[], int col[]){
        Arrays.sort(row);  // sorted from 1 to 4 that's why we take the reverse count of j & k
        Arrays.sort(col);  // or Arrays.sort(col, Collections.reverseOrder()); for reverse sort
        int cost=0;
        int vp=1;
        int hp=1;
        int j=row.length-1;
        int k=col.length-1;
        for(int i=0;i< row.length + col.length;i++){
            if(j>=0 && k>=0){
                if(row[j]> col[k]){
                    cost+= vp * row[j];
                    hp++;
                    j--;
                }
                else{
                    cost+= hp * col[k];
                    vp++;
                    k--;
                }
            }

            else if(j<0 && k>=0){
                cost+= hp * col[k];
                vp++;
                k--;
            }
            else {
                cost += vp * row[j];
                hp++;
                j--;
            }
        }
        return cost;
    }
    public static void main(String[] args){
        int rows[]= {4,1,2};
        int cols[]= {2,1,3,1,4};

        System.out.println(minCostCalc(rows,cols));
    }
}
