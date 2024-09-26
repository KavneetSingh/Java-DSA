package JavaDsa;
import java.util.ArrayList;
public class ContainerWithMostWater {
    public static void main(String[] args){

        //One solution to the question can be by using the nested loops traversing for each index everytime all over
        // the arrayList and finding the max solution

        // This new solution is called 2=pointer approach

        ArrayList<Integer> list= new ArrayList<>();
        list.add(1);
        list.add(8);
        list.add(6);
        list.add(2);
        list.add(5);
        list.add(4);
        list.add(8);
        list.add(3);
        list.add(7);

        System.out.println(list);
        int max=0;
        int m=0; int n=list.size()-1;
        while(m<n){
            int width= n-m;
            int ht= Math.min(list.get(m),list.get(n));
            max= Math.max(width*ht,max);
            if(list.get(m)<list.get(n)){
                m++;
            }
            else{
                n--;
            }
        }

        System.out.println(max);
    }
}
