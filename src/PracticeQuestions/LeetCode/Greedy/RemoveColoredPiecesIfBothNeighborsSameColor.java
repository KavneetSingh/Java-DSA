package PracticeQuestions.LeetCode.Greedy;
import java.util.*;


public class RemoveColoredPiecesIfBothNeighborsSameColor {
    // LeetCode-- Q) 2038

    //ALICE and BOB remove chars A and B respectively from the string such that the chars can only be removed
    // if both the neighbours are same chars. If they are different, they cannot be removed.
    // If the player is out of moves, he loses.
    // Alice moves first, return true if alice wins and false if bob.

    public static boolean game(String str){
        if(str.length()<3){
            return false;
        }

        int a=0;
        int b=0;


        for(int i=1;i<str.length()-1;i++){
            char x= str.charAt(i-1);
            char y= str.charAt(i);
            char z= str.charAt(i+1);

            if(x==y && y==z) {
                if (y == 'A') {
                    a++;
                } else {
                    b++;
                }
            }
        }

        return a>b;
    }

    public static void main(String[] args){
        String str= "AAABABB";

        System.out.println(game(str));
    }
}
