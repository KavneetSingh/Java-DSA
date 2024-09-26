public class AllPermutations {
    public static void allPerm(String str, String ans){
        if(str.length()== 0){
            System.out.println(ans);
            return;
        }
        for(int i=0;i< str.length();i++){
            char curr= str.charAt(i);
            //ans= ans+ str.charAt(i);
            String newStr= str.substring(0,i)+ str.substring(i+1);
            allPerm(newStr, ans+curr);
        }
    }
    public static void main(String[] Args){
        String str= "Kavi";
        allPerm(str, "");
    }
}
