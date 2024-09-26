package PracticeQuestions.LeetCode.BinarySearch;

public class MaxValueAtGivenIndex {

    //Not done by me using Binary search

    //Problem: 1802
    /*
    You are given three positive integers: n, index, and maxSum. You want to construct
    an array nums (0-indexed) that satisfies the following conditions:

    nums.length == n
    nums[i] is a positive integer where 0 <= i < n.
    abs(nums[i] - nums[i+1]) <= 1 where 0 <= i < n-1.
    The sum of all the elements of nums does not exceed maxSum.
    nums[index] is maximized.
    Return nums[index] of the constructed array.

    Note that abs(x) equals x if x >= 0, and -x otherwise.
     */


    public static void main(String[] args){

        //We need to distribute this effectiveValue left in the local vicinity of the current given top index.
        //An idea could be that you can start denoting each local neighbour a particular value so that it is working.
        //Or you can simply subtract values with every given iteration in order to get to the final value.
        // Now subtract the number of enjoying group from effectValue left and keep increasing the group until
        //you get to a point where you have no more effectiveValue left or you reach an edge of the array...


         int index= 1;
         int n=6;
         int maxSum= 10;

        if(n==1){
//            return maxSum;
            System.out.println(maxSum);
        }
        else if(n==2){
//            return (maxSum+1)/2;
            System.out.println((maxSum+1)/2);
        }

        int effectiveValue= maxSum- n;

        int i=0;
        int ans=1;

        boolean reachedEdges= false;

        while(!reachedEdges && effectiveValue> 0){
            if(index- i <0 || index+i >= n){
                if(index- i <0 && index+i >= n){
                    reachedEdges= true;
                    effectiveValue-=n;
                }
                else if(index- i <0){
                    effectiveValue-= 1+i+index;
                }
                else if(index+i >= n){
                    effectiveValue-= 1+ i + n-index-1;
                }
            }
            else{
                effectiveValue-= 2*i+1;
            }
            i++;
            if(effectiveValue>=0){
                ans++;
            }
        }

        if(reachedEdges){
            ans+= effectiveValue/n;
        }

         System.out.println(ans);
//        return ans;
    }
}
