package JavaDsa.Hashing;
import java.util.HashMap;
public class ValidAnagram {
    public static void main(String[] args){ //check if two strings are valid anagrams or not
        String str= "keen";
        String str2= "knee";
        HashMap<Character, Integer> hm= new HashMap<>();

        boolean valid= true;
        for(int i=0;i<str.length();i++){
            hm.put(str.charAt(i), hm.getOrDefault(str.charAt(i), 0) +1);
        }

        for(int i=0;i<str2.length();i++){
            if(hm.containsKey(str2.charAt(i))){
                if(hm.get(str2.charAt(i))==1){
                    hm.remove(str2.charAt(i));
                }
                else{
                    hm.put(str2.charAt(i), hm.get(str2.charAt(i))-1);
                }
            }
            else{
                valid= false;
                break;
            }
        }

        if(valid && hm.isEmpty()){
            System.out.println(true);
        }
        else{
            System.out.println(false);
        }
    }
}
