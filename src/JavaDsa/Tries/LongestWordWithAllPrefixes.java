package JavaDsa.Tries;


public class LongestWordWithAllPrefixes {
    //print the largest string which has all its prefixes in a given array
    // and if 2 strings are there print the one which comes first bibliographically
    static class Node{
        Node[] children = new Node[26];
        boolean eow= false;
        int freq;

        public Node(){
            for(int i=0;i<26;i++){
                this.children[i]= null;
            }
        }
    }

    public static Node root= new Node();

    public static void insert(String str){   // working fine
        Node curr= root;
        for(int i=0;i<str.length();i++){
            int ch= str.charAt(i)-'a';
            if(curr.children[ch]== null){
                curr.children[ch]= new Node();
                curr.children[ch].freq= 1;
            }
            else{
                curr.children[ch].freq++;
            }
            if(i== str.length()-1){
                curr.children[ch].eow= true;
            }
            curr= curr.children[ch];
        }
    }

    static String largest= "";
//    static StringBuilder temp= new StringBuilder("");
    public static void largestStringWithAllPrefixesListed(Node curr, StringBuilder temp){
        if(curr==null){
            return;      //will never hit but just for clarity
        }

        for(int i=0;i<26;i++){
            if(curr.children[i]!=null && curr.children[i].eow==true){
                char ch= (char) ('a'+ i);
                temp.append(ch);
                if(temp.length()> largest.length()){
                    largest= temp.toString();
                }
//                if(temp.length()== largest.length() && temp.compareTo(largest)<0){
//                    largest= temp;                      // no need coz we are looking for lexicographically smaller answer
//                }
                largestStringWithAllPrefixesListed(curr.children[i], temp);
//                {                                    // delete last character but then the answer is blank string
//                    temp.reverse();
//                    temp.deleteCharAt(0);
//                    temp.reverse();
//                }
                // or simply 
                temp= temp.deleteCharAt(temp.length()-1);

            }
        }

    }

    public static void main(String[] args){
        String[] strs= {"a","banana", "ban", "ap", "app", "appl", "apple", "apply"};
        for(int i=0; i<strs.length; i++){
            insert(strs[i]);
        }
        largestStringWithAllPrefixesListed(root,new StringBuilder(""));
        System.out.println(largest.toString());
        System.out.println();
    }
}
