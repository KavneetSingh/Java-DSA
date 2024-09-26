package PracticeQuestions.DP;
import java.util.*;

public class EditDistance_Tabulation {
    //This question is about the minimum number of operations you would need to perform in order to convert a
    // given word to another word.
    // eg- string1: intention    string2: execution
    // You can insert, delete, replace a character
    // minimum number of operations needed= 5

    public static int tabulation(String str1, String str2, int[][] dp){
        for(int i=0;i<dp.length;i++){
            dp[i][0]= i;
        }

        for(int j=0;j<dp[0].length;j++){
            dp[0][j]= j;
        }

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                char a= str1.charAt(i-1);
                char b= str2.charAt(j-1);

                if(a==b){                             //valid
                    dp[i][j]= dp[i-1][j-1];           //since the chars are equal, we don't need to do any operation
                }
                else{
                    int ans1= dp[i][j-1] + 1;            //add operation performed so the (j-1)th char of str2 and newly added of str1
                    // are same. One operation is performed

                    int ans2= dp[i-1][j] + 1;          //delete operation is performed and the (i-1)th char of str1 is deleted.
                    // 1 is added for delete operation is performed.

                    int ans3= dp[i-1][j-1] + 1;        //Replace operation is performed. so the (i-1)th char of str1 and (j-1)th
                    // char of str2 are same.

                    dp[i][j]= Math.min(Math.min(ans1, ans2), ans3);
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }


    public static void main(String[] args){
//        String str1= "abdefcg";
//        String str2= "abcdefg";          //ans = 2   remove c and relocate it.

        String str1= "ae";
        String str2= "abcdefg";            //ans= 5

        int[][] dp= new int[str1.length()+1][str2.length()+1];

        for (int[] ints : dp) {             //Enhanced for loop
            Arrays.fill(ints, -1);
        }

        int ans= tabulation(str1, str2, dp);
        System.out.println(ans);

        System.out.println();
        System.out.println();

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}

//Another approach:-
//You could use hashmaps to store the key value pair of all chars in both strings and
// then find the difference in freq of diff chars and also the lengths of the strings.
// The sum of both length diff and char freq diff could tell you the number of operations needed.