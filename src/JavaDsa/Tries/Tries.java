package JavaDsa.Tries;

public class Tries {      // they store strings in them and trie takes lesser space as compared to multiple individual strings

    static class Node{
        Node[] children= new Node[26];   //26 size
        boolean endOfWord= false;

        Node(){
            for(int i=0; i<26; i++){
                this.children[i]=null;
            }
        }
    }

    public static Node root= new Node();   //root of trie is always empty by default

    public static void insert(String word){     //O(L)  here, L= length of key/word
        Node curr= root;
        for(int i=0; i<word.length(); i++){
            char ch= word.charAt(i);
            if(curr.children[ch-'a']== null){
                curr.children[ch-'a']= new Node();
            }
            if(i== word.length()-1){
                curr.children[ch-'a'].endOfWord= true;
            }
            else{
                //eat 5 star do nothing
            }
            curr= curr.children[ch-'a'];
        }
    }

    public static boolean search(String word){   //O(L)
        Node curr= root;

        for(int i=0; i<word.length(); i++){
            int k= word.charAt(i)-'a';
            if(curr.children[k]!=null){
                curr= curr.children[k];
                if(i==word.length()-1 && curr.endOfWord){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args){
        String words[]= {"the", "a", "there", "their", "any", "thee"};


        for(int j=0; j<words.length;j++){
            insert(words[j]);
        }

        System.out.println(search("thee"));
        System.out.println(search("ther"));
    }
}
