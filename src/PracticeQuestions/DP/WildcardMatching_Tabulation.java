package PracticeQuestions.DP;

public class WildcardMatching_Tabulation {

    //The question is whether or not can you convert str2 to str1 using some of the rules specified in the question itself.
    //1. if the character of str2 is '?', then it has to be converted to one char in order to make the strings match.
    //2. If there is a '*' in str2, then it can convert into ANY given pattern or it can even convert into 'void'.
    // eg: *c?***f can be converted into  abcdef.

    public static boolean tabulation(String str1, String str2, boolean[][] dp){   //O(n^2)
        for(int i=0;i<dp.length;i++){
            dp[i][0]= false;
        }

        boolean foundChar= false;
        for(int j=1;j<dp[0].length;j++){
            if(!foundChar && str2.charAt(j-1)== '*'){     //if str1 is empty but str2 has only '*' then yes it is convertible
                dp[0][j]= true;
            }
            if(str2.charAt(j-1)!='*'){
                foundChar= true;
            }
        }

        dp[0][0]= true;

        for(int i=1;i< dp.length;i++){
            for(int j=1; j<dp[0].length; j++){
                char a= str1.charAt(i-1);
                char b= str2.charAt(j-1);

                if(a==b || b=='?'){                 //Valid condition
                    dp[i][j]= dp[i-1][j-1];
                }
                else if(b=='*'){                     //inValid condition
                    boolean ans1= dp[i-1][j-1];         //when the * is converted into the ith char of str1.
                    // I think this 1st case makes no difference
                    boolean ans2= dp[i][j-1];           //when * is not converted into anything and simply void or ignored.
                    boolean ans3= dp[i-1][j];           //when the * is converted into more than one chars of str1.

                    dp[i][j]= ans1 | ans2 | ans3;        //The final answer is the best of 3 cases above.
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }

    public static void main(String[] args){
        //Done by myself 🔥
        String str1= "baaabab";
        String str2= "****ba**?ab";    //Yes this can be converted into str1.

//        String str1= "abcdef";
//        String str2= "*c?***f";

        boolean[][] dp= new boolean[str1.length()+1][str2.length()+1];

        boolean ans= tabulation(str1, str2, dp);
        System.out.println(ans);

        System.out.println();
        System.out.println();


        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(dp[i][j]==true){
                    System.out.print("1 ");
                }
                else{
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }
}
