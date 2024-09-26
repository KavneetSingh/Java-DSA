package JavaDsa.Tries;

public class WordBreakProb {  //break a given string to words already given to you and return if it fits or not

    static class Node{
        Node[] children= new Node[26];
        Boolean eow= false;

        Node(){
            for(int i=0;i< children.length;i++){
                this.children[i]= null;
            }
        }
    }

    static Node root= new Node();

    public static void insert(String word){     //O(L)  here, L= length of key/word
        Node curr= root;
        for(int i=0; i<word.length(); i++){
            char ch= word.charAt(i);
            if(curr.children[ch-'a']== null){
                curr.children[ch-'a']= new Node();
            }
            if(i== word.length()-1){
                curr.children[ch-'a'].eow= true;
            }
            else{
                //eat 5 star do nothing
            }
            curr= curr.children[ch-'a'];
        }
    }

    public static boolean fits(String str){
        System.out.println(str);   //Added only to confirm the functioning
        Node curr= root;
        boolean fits= true;
        for(int i=0;i<str.length();i++){
            int temp= str.charAt(i)- 'a';
            if(curr.children[temp]==null){
                return false;
            }
            if(curr.children[temp].eow){
                return fits(str.substring(i+1));
            }
            curr= curr.children[temp];
        }
        return fits;
    }

    public static void main(String[] args){
        String words[]= {"i", "like", "sam", "samsung", "ice", "mobile"};

        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }

        String str= "ilikesamsung";      // it gives false as the answer in O(n)... itne me bas itna hi milega
        //if you need whole correct solution then go for O(n^2) and involve that search() function of tries in fits() function
        System.out.println( fits(str) );
    }
}
