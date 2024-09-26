public class PalindromeCHeck {
    public static boolean check(String a, int i, int j){
        if(i>=j){
            return true;
        }

        if(a.charAt(i)== a.charAt(j)){
            System.out.println(i +","+ j);

            boolean x= check(a, i+1,j-1 );
            System.out.println(x+ "...."+  i+","+ j);
        }

        System.out.println(i +","+ j);
        return false;
    }
    public static void main(String[] args){
        String a= "racecar";  //length=7
        System.out.println(check(a,0, a.length()-1));
    }
}
