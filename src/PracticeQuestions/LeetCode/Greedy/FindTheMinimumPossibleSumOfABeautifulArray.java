package PracticeQuestions.LeetCode.Greedy;

public class FindTheMinimumPossibleSumOfABeautifulArray {
    /*
    LeetCode Q) 2834
    Find the minimum possible sum of an array of length 'n' such that no 2 integers
    in the array sum up to be equal to target.
    Return the minimum possible sum of all elements of such an array
    */

    public static int minSum(int n, int target){
//        int curr=1;
//        int sum=0;
//        if(n==1){
//            return 1;
//        }
//        while(n>0){
//            if(target-curr<curr && curr<target){
//                //ignore curr;
//            }
//            else{
//                sum+= curr;
////                System.out.print(curr+ " ");
//                n--;
//            }
//            sum%=1000000007;
//            curr++;
//        }
////        System.out.println();
//        return sum %1000000007;
        // 1 2 3 4 5 6 7 8 9 10 11 12 13 14

        /*
        int mod= Math.pov(10,9) +7;
        if(target>=2*n){                        //no worries. do not include target at all
            return (n*(n+1)/2) % 1000000007;
        }
        else{                       // we can use [1,target/2) U [target, target+m-1];     m= (target||n)- target/2;
                                                                                           //whichever is higher
            int x= target/2;
            int ans1= ((x*(x+1)))/2;
//            ans1%= 1000000007;
//            System.out.println("ans1 = "+ ans1);
            int m;
            if(n>=target){
                m= n-target/2;
            }
            else{
                m= n-target/2;
            }
            int tarMinus1= target-1;
            int finalN= target+m-1;
            int ans2= ((finalN*(finalN+1)))/2  -  ((tarMinus1*(tarMinus1+1)))/2;
//            ans2%= 1000000007;
            if(ans1+ ans2 <0){
                return (ans1 + ans2 + Integer.MAX_VALUE +1) %1000000007;
            }
            else{
                return (ans1 + ans2) %1000000007;
            }

        }
         */

        //Solution 2-->

        if(target>=2*n){                        //no worries. do not include target at all
            return (n*(n+1)/2) % 1000000007;
        }
        else{                       // we can use [1,target/2) U [target, target+m-1];     m= (target||n)- target/2;
                                                                                           //whichever is higher
            int x= target/2;
            int ans1= ((x*(x+1)))/2;
            ans1%= 1000000007;
//            System.out.println("ans1 = "+ ans1);
            int m;
            if(n>=target){
                m= n-target/2;
            }
            else{
                m= n-target/2;
            }
            int tarMinus1= target-1;
            int finalN= target+m-1;
            int ans2= ((finalN*(finalN+1)))/2 %1000000007 >0? (finalN*(finalN+1))/2 %1000000007 : ((finalN*(finalN+1)/2) + Integer.MAX_VALUE)%1000000007;
            ans2-= ((tarMinus1*(tarMinus1+1)))/2 >0? (tarMinus1*(tarMinus1+1))/2 %1000000007: ((tarMinus1*(tarMinus1+1))/2 +Integer.MAX_VALUE) %1000000007;
            ans2= ans2>0? ans2%1000000007 : (ans2+Integer.MAX_VALUE)%1000000007;
            if(ans1+ ans2 <0){
                return (ans1 + ans2 + Integer.MAX_VALUE +1);
            }
            else{
                return (ans1 + ans2) % 1000000007;
            }

        }
    }

    public int minimumPossibleSum(int n, int target) {
        int mod= 1000000007;
        if(target>=2*n){
            return (n*(n+1)/2) % mod;
        }
        else{
            long x= target/2;
            long ans1= x*(x+1)/2;
            int m= n-target/2;;

            n-= x;
            n+= (target-1);
            long ans2= ((n*(n+1))/2)-(((target-1)*target)/2);

            return (int)(ans1+ans2)%mod;
        }
    }

    public static void main(String[] args){
//        int n= 13;
//        int target= 50;
//        int n= 45456;
//        int target= 10867;

        int n= 1000000;
        int target= 1000000;

        System.out.println(minSum(n, target));
    }
}
