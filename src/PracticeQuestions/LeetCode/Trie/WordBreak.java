package PracticeQuestions.LeetCode.Trie;

import java.util.HashSet;

public class WordBreak {

    static class Node{

        Node children[]= new Node[26];     //For chars from a to z
        boolean eow= false;               //For EndOfWord detection

        public Node(){
            for(int i=0;i<26;i++){
                this.children[i]= null;
            }
        }
    }

    public static Node root= new Node();      //root node

    public static void insert(String str){
        Node curr= root;

        for(int i=0;i<str.length(); i++){
            char ch= str.charAt(i);
            if(curr.children[ch-'a']== null){
                curr.children[ch-'a']= new Node();
            }

            curr= curr.children[ch-'a'];

            if(i== str.length()-1){
                curr.eow= true;
            }

        }
    }

    public static boolean search(String key){
        Node curr= root;
        for(int i=0;i<key.length();i++){
            int idx= key.charAt(i)- 'a';
            if(curr.children[idx]== null){
                return false;
            }
            curr= curr.children[idx];
        }

        return curr.eow;            //if it is the end of a word
    }

    public static boolean breakable(String str, HashSet<String> hs){
        if(str.length()==0){
            return true;
        }

        if(hs.contains(str)){
            return true;
        }


//        for(int i=1;i< str.length()+1;i++){
////            String search= ;
//            if(search(str.substring(0, i))  && breakable(str.substring(i+1), hs)){
////                hs.add(str.substring(0, i));
//                return true;
//            }
//        }


//        return false;


        if(str.length()== 0){
            return true;
        }
        if(str.length()== 1 && root.children[str.charAt(0)-'a']!= null && root.children[str.charAt(0)-'a'].eow){
            return true;
        }
        else if(str.length()== 1 && root.children[str.charAt(0)-'a']== null){
            return false;
        }
        else if(str.length()== 1 && !root.children[str.charAt(0)-'a'].eow){
            return false;
        }
        Node curr= root;
        boolean subStringDone= false;

        for(int i=0;i<str.length();i++){
//            System.out.println(str);
            char ch= str.charAt(i);
            curr= curr.children[ch-'a'];
            if(curr ==null){
                return false;
            }
            if(curr.eow){
                subStringDone= breakable(str.substring(i+1), hs);
                if(subStringDone){
                    hs.add(str.substring(i+1));
                    return true;
                }
            }

            if(i== str.length()-1 && !curr.eow && !subStringDone){
                return false;
            }
            if(ch== str.length()-1 && curr.eow){
                hs.add(str);
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args){
//        String s= "leetcode";
//        String[] wordDict = {"leet", "code"};
//        String s= "abcd";     //true     IMPORTANT case
//        String[] wordDict = {"a","abc","b","cd"};


        String s= "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        String[] wordDict = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};

        for(int i=0;i< wordDict.length;i++){
            insert(wordDict[i]);
        }

        HashSet<String> hs= new HashSet<>();

        boolean possible= breakable(s, hs);
        System.out.println(possible);

    }
}
