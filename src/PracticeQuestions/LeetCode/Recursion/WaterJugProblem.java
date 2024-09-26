package PracticeQuestions.LeetCode.Recursion;

public class WaterJugProblem {
    //LeetCode Q)365
    public static void jugger(boolean can[], int target, int a, int b, int i){
        if(target<0 || target> a+b || can[target] && i!=1) return;
        // System.out.print(target + " ");

        if(target-a>0 && can[target-a] || target-b>0 && can[target-b] ||
                target+a<can.length && can[target+a] || target+b<can.length && can[target+b])
            can[target]= true;

        jugger(can, target+a, a, b, i+1);
        jugger(can, target+b, a, b, i+1);
        jugger(can, target-a, a, b, i+1);
        jugger(can, target-b, a, b, i+1);
    }
    public static boolean canMeasureWater(int jug1, int jug2, int target) {
        if(target>jug1+jug2) return false;

        boolean can[]= new boolean[jug1+jug2+1];
        can[jug1]= true;
        can[jug2]= true;

        jugger(can, 0, jug1, jug2, 0);
        // jugger(can, jug1+jug2, jug1, jug2, 0);

        return can[target];
    }

    public static void main(String[] args){
        int jug1= 5;
        int jug2= 3;
        int target= 4;
        System.out.println(canMeasureWater(jug1,jug2,target));
    }
}
