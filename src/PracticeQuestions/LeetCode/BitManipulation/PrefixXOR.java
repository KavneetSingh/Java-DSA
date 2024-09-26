package PracticeQuestions.LeetCode.BitManipulation;

public class PrefixXOR {
    //LeetCode Q)2433

    public static void main(String[] args){

        int pref[]= {5,2,0,3,1};   //output: 5,7,2,3,2

        for(int i=pref.length-1;i>0;i--){
            pref[i]= pref[i]^pref[i-1];
        }

        for(int i=0;i<pref.length;i++){
            System.out.print(pref[i] + " ");
        }
    }
}
