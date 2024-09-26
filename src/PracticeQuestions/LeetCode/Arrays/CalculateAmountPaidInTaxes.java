package PracticeQuestions.LeetCode.Arrays;

import java.text.DecimalFormat;

public class CalculateAmountPaidInTaxes {

    // LeetCode Q) 2303
    //2.09 ~ 2.08999999914634     WTF 🥲
    //Solution-- Use double for tax variable and divide it by 100d and do not typecast the values coz That's the point to create all the problems
    public static double calculateTax(int[][] brackets, int income) {
        double tax=0;
        int i=0;
        int prevSlab= 0;
        while(income>prevSlab && i<brackets.length){
            int currSlab= brackets[i][0];
            int taxp= brackets[i][1];

            if(currSlab>=income){
                tax+= (income-prevSlab) *taxp/100d;
            }
            else{
                tax+= (currSlab-prevSlab) * taxp/100d;
            }

//            System.out.println((float)taxp/100);
            prevSlab= currSlab;
            i++;
        }

//        System.out.println(tax);

//        System.out.println("tax initially= " + tax);
//        System.out.println(tax*100);
//        if(tax*100- (int)tax*100 >0.8){
//            tax*=100;
//            tax-= tax- (int)tax;
//            tax+=1;
//            tax/=100;
//        }
//        else{
//            tax= (int)(tax*100);
//            tax/=100;
//        }
//        System.out.println(tax);
//        DecimalFormat df= new DecimalFormat();
//        df.setMaximumFractionDigits(2);
//        tax= Float.parseFloat(df.format(tax));
        return tax;
    }

    public static void main(String[] args){
        int arr[][]= {{1,93},{3,58},{5,68}};
        int income= 3;



        System.out.println(calculateTax(arr ,income));
    }
}
