package JavaDsa.Queues;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FirstNonRepeatingLetter {

    public static void main(String[] args){
        // Print the first non-repeating letter for all the insertions in the stream of characters that are there in the string
        // print that for every single character inserted everytime
        Scanner sc= new Scanner(System.in);
        Queue<Character> q= new LinkedList<>();
        int arr[]= new int[26];
        String str= sc.next();  //aabccxb
        for(int i=0;i<str.length();i++){
            char ch= str.charAt(i);
            q.add(ch);
            arr[ch-'a']++;
            while(!q.isEmpty() && arr[q.peek()-'a']>1){
                q.remove();
            }
            if(q.isEmpty()){
                System.out.println(-1);
                continue;
            }
            System.out.println(q.peek());
        }
    }
}
