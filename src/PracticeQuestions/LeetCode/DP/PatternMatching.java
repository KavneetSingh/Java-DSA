package PracticeQuestions.LeetCode.DP;

import java.util.Arrays;

public class PatternMatching {

    //LeetCode Q)10

    public static boolean tabulation(boolean dp[][], String s1, String s2){
        if(s2.length()==1 && s2.charAt(0)=='*'){
            return true;
        }

        Arrays.fill(dp[0], false);
        for(int i=0;i<dp[0].length;i++){
            dp[0][i]= false;
        }

        for(int i=0;i<s1.length();i++){
            //look into it.
        }
        for(int j=0;j<s2.length();j++){

        }
        dp[0][0]= true;
//        dp[0][2]= true;

//        for(int j=0;j<dp[0].length;j++){
//
//        }

        for(int i=0;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){

                char a= ' ';
                if(i>0){
                    a= s1.charAt(i-1);
                }
                char b= s2.charAt(j-1);



                boolean ans= false;
                if(a==b){
                    ans|= dp[i-1][j-1];
                }

                else if(b=='.' && i>0){
                    ans|= dp[i-1][j-1];
                }

                else if(b=='*'){
                    char prev= s2.charAt(j-2);
                    if(prev=='.'){
                        if(i==0 && (j-2==0 || dp[i][j-2])){
                            dp[i][j]= true;
                            continue;
                        }
                        else{
                            for(int k=0;k<i;k++){
                                ans|= dp[k][j-2];
                            }
                        }

//                        char prevS1= s1.charAt(i-1);
//                        int k=i;
//                        ans|= dp[i][j-1];
//                        while(k-1>=0 && s1.charAt(k-1)==prevS1){
//                            ans|=dp[k][j];
//                            k--;
//                        }
//                        if(k>=0){
//                            ans|=dp[k][j-2];
//                        }
                    }
                    else{
                        int k=i;
                        char prevS1= ' ';
                        if(i>0){
                            prevS1= s1.charAt(i-1);
                        }

                        if(i==0 && (j-2==0 || dp[i][j-2])){
                            dp[i][j]= true;
                            continue;
                        }
                        else if(i>0){
                            while(k-1>=0 && s1.charAt(k-1)==prev){
                                ans|= dp[k][j];
                                k--;
                            }
                        }
                        ans|=dp[k][j-2];


//                        char prevS1= s1.charAt(i-1);
//                        int k=i;
//                        ans|= dp[i][j-1];
//
//                        while(k-1>=0 && s1.charAt(k-1)==prevS1){
//                            ans|= dp[k][j];
//                            k--;
//                        }
//                        ans|=dp[k][j-2];
//
//                        ans|= dp[i][j-2];
//                        System.out.println(i + " " + j);
                    }
                    ans|= dp[i][j-2];
                }

                dp[i][j]= ans;
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }

    public static void main(String[] args){
//        String s1= "aa";
//        String s2= "a";

//        String s1= "aacda";        //true
//        String s2= "a.*da";

        String s1= "a";        //false
        String s2= "a.*";

//        String s1= "aabcd";        //true
//        String s2= ".*bce*d";

//        String s1= "ab";          //true
//        String s2= ".*";

//        String s1= "aaa";         //false
//        String s2= "ab*a";

//        String s1= "aa";           //true
//        String s2= "a*";

        boolean dp[][]= new boolean[s1.length()+1][s2.length()+1];


        System.out.println(tabulation(dp, s1, s2));

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(dp[i][j]) System.out.print("T  ");
                else System.out.print(".  ");
            }
            System.out.println();
        }
    }
}
