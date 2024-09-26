package JavaDsa;
import java.util.ArrayList;
public class ArrayLista {
    public static void main(String[] args){
        //2D arraylist-->
        ArrayList<ArrayList<Integer>> mainList= new ArrayList<>();
        ArrayList<Integer> arr= new ArrayList<>();
        arr.add(1); arr.add(2);
        mainList.add(arr);
        System.out.println(mainList.get(0));
        ArrayList<Integer> list2= new ArrayList<>();
        list2.add(3); list2.add(4);
        mainList.add(list2);
        System.out.println(mainList.get(1));
        System.out.println(mainList);

        for(int i=0;i<mainList.size();i++){
            ArrayList<Integer> currList= mainList.get(i);
            for(int j=0;j<currList.size();j++){
                System.out.print(currList.get(j)+" ");
            }
            System.out.println();
        }
    }
}
