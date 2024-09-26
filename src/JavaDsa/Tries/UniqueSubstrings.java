package JavaDsa.Tries;
import java.util.HashSet;

public class UniqueSubstrings {
    // Find the total no. of unique substrings in a string.   for eg- "ababa" has 10 unique substrings
    // Substring can be seen as all prefixes of all suffix or all suffixes of all prefix
    static class Node{
        Node[] children= new Node[26];
        boolean eow= false;

        public Node(){
            for(int i=0;i<26;i++){
                this.children[i]= null;
            }
        }
    }

    public static void insert(String str){
        Node curr= root;
        for(int i=0;i<str.length();i++){
            int ch= str.charAt(i)-'a';
            if(curr.children[ch]==null){
                curr.children[ch]= new Node();
            }
            if(i== str.length()-1){
                curr.children[ch].eow= true;
                return;
            }
            curr= curr.children[ch];
        }
    }

    public static void uniqSubs(Node curr, int i, String str, HashSet<String> subs){
        StringBuilder sb= new StringBuilder("");

        curr= curr.children[str.charAt(i)-'a'];

        while(curr!=null){

            sb.append(str.charAt(i));
            System.out.println(sb);
            subs.add(sb.toString());
            i++;
            if(i>=str.length()){
                break;
            }
            curr= curr.children[str.charAt(i)-'a'];
        }
    }


    public static Node root= new Node();

    public static void main(String[] args){
        HashSet<String> subs= new HashSet();
        subs.add("");
        String str= "ababa";
        insert(str);
        Node curr= root;
        for(int i=0;i<str.length();i++){
            uniqSubs(curr, i, str, subs);
            curr= curr.children[str.charAt(i)-'a'];
        }
        System.out.println(subs);
        System.out.println(subs.size());   // answer, I still don't know why I really used the trie ds here
    }
}
