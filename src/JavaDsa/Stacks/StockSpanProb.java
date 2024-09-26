package JavaDsa.Stacks;
import java.util.Stack;
public class StockSpanProb {

    public static void spanCalc(Stack<Integer> s, int price[], int span[]){
        //Span reports the number of days to last day which had higher price than curr price
        span[0]=1;
        s.push(0);

        for(int i=1;i<price.length;i++){
            int currPrice= price[i];
            while(!s.isEmpty() && currPrice>=price[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                span[i]= i+1;
            } else{
                int prevHigh= s.peek();
                span[i]= i-prevHigh;
            }

            s.push(i);
        }
    }

    public static void main(String[] args){
        //find the max no. of consecutive days just before current day where the stock price was less than or equal to today's price
        Stack s= new Stack();
        int price[]= {100,80,60,70,60,85,100};
        int span[]= new int[price.length];

        spanCalc(s,price,span);

        for(int i=0;i<span.length;i++){
            System.out.print(span[i]+" ");
        }
        System.out.println();
    }
}
