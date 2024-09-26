package PracticeQuestions.LeetCode.Arrays;

public class flowerGame {
    public static long flowerGame(int n, int m) {
        // n=7;
        // m=7;
        if(n==1 && m==1) return 0;       //not needed
        long ans=0;
        if((n&1)==1){         //n is odd
            if(n==1) return m/2;
            if(m>=2){         //m odd or even
                ans+= ((n+1)/2)*(m/2);
            }
            else{
                return n/2;
            }
        }
        else{       //n is even;
            if(m>=2){
                ans+= (n/2)*(m/2);
            }
            else{
                return n/2;
            }
        }

        System.out.println(ans);

        if((m&1)==1){       //m is odd
            if(n>=2){
                ans+= (m+1)/2 * (n/2);
            }
        }
        else{        //m is even
            if(n>=2){
                ans+= (m/2)*(n/2);
            }
        }

        return ans;
    }

    public static void main(String[] args){
        System.out.println(flowerGame(3,8));
    }
}
