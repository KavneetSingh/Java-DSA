package JavaDsa.Tries;
import java.util.*;

public class ReplaceWords {
    //NOT COMPLETE
    static class Node{
        Node[] child= new Node[26];
        boolean eow= false;

        Node(){
            for(int i=0; i<26; i++){
                this.child[i]=null;
            }
        }
    }

    public static void noder(Node root, String s, int a){
        if(a==s.length()){
            return;
        }

        root.child[s.charAt(a)-'a']= new Node();
        if(a==s.length()-1){
            root.eow= true;
        }
        noder(root.child[s.charAt(a)-'a'], s, a+1);
    }

    public static String StringCheck(Node root, String s){
        Node temp= root;
        StringBuilder sb= new StringBuilder("");
        for(int i=0;i<s.length();i++){
            char ch= s.charAt(i);
            if(temp.child[ch-'a']==null){
                return "";
            }
            else{
                if(temp.eow) return sb.toString();
                sb.append(ch);
            }
            temp= temp.child[ch-'a'];

        }

        return sb.toString();

    }

    public static String replaceWords(List<String> dic, String sen) {
        Node root= new Node();
        for(int i=0;i<dic.size();i++){      //constructs the trie.
            noder(root, dic.get(i),0);
        }

        StringBuilder sb= new StringBuilder("");

        for(int i=0;i<sen.length();i++){
            char ch= sen.charAt(i);
            if(ch==' '){
                sb.append(ch);
            }
            else{
                int st=i;
                int en;
                while(i<sen.length()-1 && sen.charAt(i+1)!=' '){
                    i++;
                }
                en= i;
                String sub1= sen.substring(st, en+1);
//                System.out.println(sub1);

                StringCheck(root, sub1);
            }
        }
        return sb.toString();
    }


    public static void main(String[] args){
        List<String> dic= new ArrayList<>();
        String sen= "the cattle was rattled by the battery";
        String ans= replaceWords(dic, sen);
        System.out.println(ans);
    }
}
