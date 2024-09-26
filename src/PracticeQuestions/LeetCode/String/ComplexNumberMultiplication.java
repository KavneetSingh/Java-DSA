package PracticeQuestions.LeetCode.String;

public class ComplexNumberMultiplication {
    //LeetCode Q)537;
    public static void main(String[] args){
        String num1 = "1+-1i";
        String num2 = "1+-1i";
        StringBuilder sb= new StringBuilder("");
        int real1=0;
        int real2=0;
        int img1=0;
        int img2=0;
        int i=1;
        while(num1.charAt(i)!='+'){
            i++;
        }
        real1= Integer.parseInt(num1.substring(0,i));
        img1= Integer.parseInt(num1.substring(i+1, num1.length()-1));

        i=1;
        while(num2.charAt(i)!='+'){
            i++;
        }
        real2= Integer.parseInt(num2.substring(0,i));
        img2= Integer.parseInt(num2.substring(i+1, num2.length()-1));

        if(real1*real2 -img1*img2<0){
            sb.append('-');
        }
        sb.append(Math.abs(real1*real2 - img1*img2));
        sb.append('+');
        if(real1*img2 + real2*img1<0){
            sb.append('-');
        }
        // System.out.println(real1 + " " + img1 + " " + real2 + " " + img2 + " " );
        sb.append(Math.abs(real1*img2 + real2*img1));
        sb.append('i');
        System.out.println(sb.toString());
    }
}
