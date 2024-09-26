package PracticeQuestions.LeetCode.BinarySearch;

public class ValidPerfectSquare {
    //LeetCode Q)367
    public static void main(String[] args){
//        int num= 256;       //true
        int num= Integer.MAX_VALUE;    //false

        if(num==1) System.out.println(true);
        long max= (long)Math.pow(2,17);
        long min= 1;
        long mid = (max-min)/2 +min;
        long prod= mid*mid;
        boolean found=false;
        while(mid<max || mid>min){
            if(prod==num) System.out.println(true);
            if(prod>num){
                max= mid;
            }
            else{
                min= mid;
            }
            mid= (max-min)/2 +min;
            prod= mid*mid;
            if(num<prod && num> (mid-1)*(mid-1) || num>prod && num< (mid+1)*(mid+1)) System.out.println(false);
        }
        // System.out.println(Integer.MAX_VALUE);
        // System.out.println(mid*mid);
        System.out.println(false);
        //All the print statements were supposed to be return statements so ignore any misinterpretation.
    }
}
