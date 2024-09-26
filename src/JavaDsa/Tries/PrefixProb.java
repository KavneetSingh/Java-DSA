package JavaDsa.Tries;

public class PrefixProb {
    // print the shortest prefixes for all the strings given in an array which can tell respective strings apart

    static class Node{
        Node[] children= new Node[26];
        boolean eow= false;
        int freq;     // this stores the number of strings that the node is a part of

        Node(){
            for(int i=0;i<26;i++){
                this.children[i]= null;
            }
        }
    }
    static Node root= new Node();

    public static void insert(String str){
        Node curr= root;

        for(int i=0;i<str.length();i++){
            int temp= str.charAt(i)- 'a';

            if(curr.children[temp]== null){
                curr.children[temp]= new Node();
                curr.children[temp].freq= 1;
            }
            else{
                curr.children[temp].freq++;
            }
            if(i== str.length()-1){
                curr.children[temp].eow= true;
            }

            curr= curr.children[temp];
        }
    }

    public static StringBuilder prefix(String str){   //worst case--> O(L),  L= length of longest word
        StringBuilder ans= new StringBuilder("");
        Node curr= root;
        for(int i=0; i<str.length(); i++){
            int temp= str.charAt(i)-'a';
            ans.append(str.charAt(i));
            if(curr.children[temp].freq==1){
                return ans;
            }
            curr= curr.children[temp];
        }
        return ans;
    }

    public static void main(String[] args){
        String[] words= {"dog", "zebra", "duck", "dove"};   //it is given that no string completely overlaps any other string

        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }

        for(int i=0;i<words.length;i++){
            System.out.println(prefix(words[i]));
        }

    }
}
