package JavaDsa.Stacks;
import java.util.Stack;

public class TrappingRainWater {

    public static int rainWaterCalc(int arr[], int nextGreater[]){
        Stack<Integer> s= new Stack<>();
        int rW=0;
        for(int i=arr.length-1;i>=0;i--){
            while(!s.isEmpty() && arr[s.peek()]<= arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nextGreater[i]= arr.length;
                if(rW==0){
                    rW=i;
                }
            }
            else{
                nextGreater[i]= s.peek();
            }
            s.push(i);
        }
        return rW;
    }

    public static void main(String[] args){
        int bar[]= {7,0,4,2,5,0,6,4,0,6};
        int nxtGrtr[]= new int[bar.length];
        int stored[]= new int[bar.length];
        stored[0]=0;
        int leftWall= 0;

        int rightWall=rainWaterCalc(bar,nxtGrtr); // Working perfectly
        int walls[]= new int[bar.length]; // stores index of all walls
        for(int i=0, j=0;i<bar.length;i++){
            if(nxtGrtr[i]== bar.length){
                walls[j]= i;
                j++;
            }
        }

        int j=0;
        rightWall= walls[++j];

        for(int i=1;i<bar.length;i++){
            if(nxtGrtr[i]==bar.length){
                stored[i]=0;
                leftWall= rightWall;
                rightWall= walls[++j];
            }
            else{
                stored[i]= Math.min(bar[rightWall],bar[leftWall]) - bar[i] ;
            }
        }
        int total= 0;
        for(int i=0;i<bar.length;i++){
            System.out.print(stored[i]+" ");
            total=total+stored[i];
        }
        System.out.println();
        System.out.println(total);
    }
}
