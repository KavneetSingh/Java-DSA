package PracticeQuestions.LeetCode.String;

public class FindWordsThatCanBeFormedbyCharacters {

    //LeetCode Q) 1160

    public static void main(String[] args){

        String[] words = {"cat","bt","hat","tree"};
        String chars= "atach";

        int ans=0;

        for(int j=0;j<words.length;j++){
            boolean yes= true;
            int[] arr= new int[26];
            for(int i=0;i<chars.length();i++){
                int x= chars.charAt(i)-'a';
                arr[x]++;
            }
            for(int i=0;i<words[j].length();i++){
                int x= words[j].charAt(i)-'a';
                if(arr[x]<=0){
                    yes= false;
                    break;
                }
                else{
                    arr[x]--;
                }
            }
            if(yes) ans+= words[j].length();
        }

        System.out.println(ans);
    }
}
