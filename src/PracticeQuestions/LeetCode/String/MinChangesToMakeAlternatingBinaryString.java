package PracticeQuestions.LeetCode.String;

public class MinChangesToMakeAlternatingBinaryString {
    //LeetCode Q)1758
    public static void main(String[] args){

        String s= "0100110";       //ans= 2

        int ans1= 0;   //starting at 0 --> odd char=1, even char=0
        int ans2= 0;   //starting at 1 --> odd char=0, even char=1

        for(int i=0;i<s.length();i++){
            char ch= s.charAt(i);
            if((i&1)==0){       // i is even
                if(ch=='1') ans1++;
                else ans2++;
            }
            else{               // i is odd
                if(ch=='0') ans1++;
                else ans2++;
            }
        }

        System.out.println(Math.min(ans1, ans2));
    }
}
