package PracticeQuestions.LeetCode.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class NumberOfWaysOfCuttingAPizza {

    //LeetCode Q) 1444   🔥🔥🔥🔥  IMPORTANT QUESTION  Done using Memoization


//    if(i>=lastRow && j>=lastCol && k>0){
//        return 0;
//    }
//        if(k==0){
//        return 1;
//    }
//
//    int hcut=0;
//    int vcut=0;
//
//        for(int m= i==0?1:i ;m<lastRow;m++){
//        hcut+= cuts(arr, m, j, lastRow, lastCol, k-1);  // cutting the pizza horizontally at all possible points
//    }
//        for(int m= j==0?1:j ;m<lastCol;m++){
//        vcut+= cuts(arr, i, m, lastRow, lastCol, k-1);  // cutting the pizza vertically at all possible points
//    }
//
//        return hcut+vcut;

    public static int cuts(String[] arr, int i, int j,HashMap<Integer, ArrayList<Integer>> row, HashMap<Integer, ArrayList<Integer>> col, int k, int dp[][][]){
        if(k<=1){
//            System.out.println("ans found!! 🔥");
//            dp[i][j][k]=1;
            return 1;
        }

        if(dp[i][j][k]!=-1){
            return dp[i][j][k];
        }

        int hcut=0;
        int vcut=0;
        int lastRow=-1, lastCol=-1;
        int firstRow=Integer.MAX_VALUE, firstCol=Integer.MAX_VALUE;

        for(int m=i;m<arr.length;m++){

            ArrayList<Integer> al= row.get(m);
            int size= row.containsKey(m)? al.size():0;
            for(int n=0;n<size;n++){
                if(al.get(n)<j){
                    continue;
                }
                firstCol= Math.min(firstCol, al.get(n));
                lastCol= Math.max(lastCol, al.get(n));
            }
        }
        for(int m=j;m<arr[0].length();m++){
            ArrayList<Integer> al= col.get(m);
            int size= col.containsKey(m)? al.size():0;
            for(int n=0;n<size;n++){
                if(al.get(n)<i){
                    continue;
                }
                firstRow= Math.min(firstRow, al.get(n));
                lastRow= Math.max(lastRow, al.get(n));
            }
        }

//        System.out.println("i= "+i+" j= " + j +" firstRow= "+ firstRow + " lastRow= " + lastRow);
//        System.out.println("i= "+i+" j= " + j +" firstCol= "+ firstCol + " lastCol= " + lastCol);
//        System.out.println();

        if(firstCol== Integer.MAX_VALUE || firstRow== Integer.MAX_VALUE){
            return 0;
        }


        for(int m=i; m<= lastRow; m++){
            if(firstRow<m){
//                System.out.println("row= " +m + " col= " + j);
                hcut+= cuts(arr, m, j, row, col, k-1, dp);
                hcut%= 1000000007;
            }
        }

        for(int m=j;m<=lastCol; m++){
            if(firstCol<m){
//                System.out.println("col= " + m + " row= " + i);
                vcut+= cuts(arr, i, m, row, col, k-1, dp);
                vcut%= 1000000007;
            }
        }

        dp[i][j][k]= (hcut+vcut) % (int)(Math.pow(10,9)+7);
//        dp[i][j][k]= hcut+vcut;
        return (hcut+vcut) % (int)(Math.pow(10,9)+7);
    }

    public static void main(String[] args){
//        String[] arr= {"A..", "AAA", "..."};
//        String[] arr= {".A.A", "AAA.", "....", ".AA."};


        String arr[]= {"..A.A.AAA...AAAAAA.AA..A..A.A......A.AAA.AAAAAA.AA","A.AA.A.....AA..AA.AA.A....AAA.A........AAAAA.A.AA.","A..AA.AAA..AAAAAAAA..AA...A..A...A..AAA...AAAA..AA","....A.A.AA.AA.AA...A.AA.AAA...A....AA.......A..AA.","AAA....AA.A.A.AAA...A..A....A..AAAA...A.A.A.AAAA..","....AA..A.AA..A.A...A.A..AAAA..AAAA.A.AA..AAA...AA","A..A.AA.AA.A.A.AA..A.A..A.A.AAA....AAAAA.A.AA..A.A",".AA.A...AAAAA.A..A....A...A.AAAA.AA..A.AA.AAAA.AA.","A.AA.AAAA.....AA..AAA..AAAAAAA...AA.A..A.AAAAA.A..","A.A...A.A...A..A...A.AAAA.A..A....A..AA.AAA.AA.AA.",".A.A.A....AAA..AAA...A.AA..AAAAAAA.....AA....A....","..AAAAAA..A..A...AA.A..A.AA......A.AA....A.A.AAAA.","...A.AA.AAA.AA....A..AAAA...A..AAA.AAAA.A.....AA.A","A.AAAAA..A...AAAAAAAA.AAA.....A.AAA.AA.A..A.A.A...","A.A.AA...A.A.AA...A.AA.AA....AA...AA.A..A.AA....AA","AA.A..A.AA..AAAAA...A..AAAAA.AA..AA.AA.A..AAAAA..A","...AA....AAAA.A...AA....AAAAA.A.AAAA.A.AA..AA..AAA","..AAAA..AA..A.AA.A.A.AA...A...AAAAAAA..A.AAA..AA.A","AA....AA....AA.A......AAA...A...A.AA.A.AA.A.A.AA.A","A.AAAA..AA..A..AAA.AAA.A....AAA.....A..A.AA.A.A...","..AA...AAAAA.A.A......AA...A..AAA.AA..A.A.A.AA..A.",".......AA..AA.AAA.A....A...A.AA..A.A..AAAAAAA.AA.A",".A.AAA.AA..A.A.A.A.A.AA...AAAA.A.A.AA..A...A.AAA..","A..AAAAA.A..A..A.A..AA..A...AAA.AA.A.A.AAA..A.AA..","A.AAA.A.AAAAA....AA..A.AAA.A..AA...AA..A.A.A.AA.AA",".A..AAAA.A.A.A.A.......AAAA.AA...AA..AAA..A...A.AA","A.A.A.A..A...AA..A.AAA..AAAAA.AA.A.A.A..AA.A.A....","A..A..A.A.AA.A....A...A......A.AA.AAA..A.AA...AA..",".....A..A...A.A...A..A.AA.A...AA..AAA...AA..A.AAA.","A...AA..A..AA.A.A.AAA..AA..AAA...AAA..AAA.AAAAA...","AA...AAA.AAA...AAAA..A...A..A...AA...A..AA.A...A..","A.AA..AAAA.AA.AAA.A.AA.A..AAAAA.A...A.A...A.AA....","A.......AA....AA..AAA.AAAAAAA.A.AA..A.A.AA....AA..",".A.A...AA..AA...AA.AAAA.....A..A..A.AA.A.AA...A.AA","..AA.AA.AA..A...AA.AA.AAAAAA.....A.AA..AA......A..","AAA..AA...A....A....AA.AA.AA.A.A.A..AA.AA..AAA.AAA","..AAA.AAA.A.AA.....AAA.A.AA.AAAAA..AA..AA.........",".AA..A......A.A.AAA.AAAA...A.AAAA...AAA.AAAA.....A","AAAAAAA.AA..A....AAAA.A..AA.A....AA.A...A.A....A..",".A.A.AA..A.AA.....A.A...A.A..A...AAA..A..AA..A.AAA","AAAA....A...A.AA..AAA..A.AAA..AA.........AA.AAA.A.","......AAAA..A.AAA.A..AAA...AAAAA...A.AA..A.A.AA.A.","AA......A.AAAAAAAA..A.AAA...A.A....A.AAA.AA.A.AAA.",".A.A....A.AAA..A..AA........A.AAAA.AAA.AA....A..AA",".AA.A...AA.AAA.A....A.A...A........A.AAA......A...","..AAA....A.A...A.AA..AAA.AAAAA....AAAAA..AA.AAAA..","..A.AAA.AA..A.AA.A...A.AA....AAA.A.....AAA...A...A",".AA.AA...A....A.AA.A..A..AAA.A.A.AA.......A.A...A.","...A...A.AA.A..AAAAA...AA..A.A..AAA.AA...AA...A.A.","..AAA..A.A..A..A..AA..AA...A..AA.AAAAA.A....A..A.A"};


        int k= 8;
        HashMap<Integer, ArrayList<Integer>> row= new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> col= new HashMap<>();


        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length();j++){
                if(arr[i].charAt(j)=='A'){
                    if(row.containsKey(i)){
                        ArrayList<Integer> al = row.get(i);
                        al.add(j);
                        row.put(i, al);
                    } else{
                        ArrayList<Integer> al= new ArrayList<>();
                        al.add(j);
                        row.put(i, al);
                    }
                    if(col.containsKey(j)){
                        ArrayList<Integer> al= col.get(j);
                        al.add(i);
                        col.put(j, al);
                    }
                    else{
                        ArrayList<Integer> al= new ArrayList<>();
                        al.add(i);
                        col.put(j, al);
                    }
                }
            }
        }

//        for(int i=0;i<arr.length;i++){
//            if(row.containsKey(i)){
//                System.out.println(row.get(i));
//            }
//        }
//
//        System.out.println();
//        for(int j=0;j<arr[0].length();j++){
//            if(col.containsKey(j)){
//                System.out.println(col.get(j));
//            }
//        }

        int dp[][][]= new int[arr.length+1][arr[0].length()+1][k+1];

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                Arrays.fill(dp[i][j], -1);
            }
        }

        if(row.size()==0 && col.size()==0){
            System.out.println(0);
        }

        System.out.println(cuts(arr, 0,0, row, col, k, dp)  % 1000000007);

    }
}
