package PracticeQuestions.LeetCode.String;

public class ZigzagConversion {

    //LeetCode Q)6.   Important question

    public static void main(String[] args){
//        String s= "PAYPALISHIRING";
//        int rows= 4;                 //ans= PINALSIGYAHRPI

        String s="A";
        int rows= 1;



        StringBuilder sb= new StringBuilder();
        for(int i=0;i<rows;i++){
            int down= 2*Math.max((rows-i-1),0);
            int up= 2*i;
            boolean curr=false;
//            int prevj=-1;
            for(int j=i;j<s.length();){
//                if(prevj==j) continue;
//                prevj=j;
                if(!curr && down!=0){
                    sb.append(s.charAt(j));
                    j+= down;
                }
                else if(up!=0){
                    sb.append(s.charAt(j));
                    j+= up;
                }
                curr= !curr;
//                prevj=j;
            }
        }

        System.out.println(sb.toString());
    }
}
