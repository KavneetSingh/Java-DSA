public class MyStringBuilder {
    public void StringBuilder(String str) {
    }
//aaabsdddd
    public static void compress(String str){
        StringBuilder sb= new StringBuilder("");
        for(int i=0;i<str.length(); i++){
            char ch= str.charAt(i);
            sb.append(ch);
            Integer count=1;
            while(i<str.length()-1 && str.charAt(i+1)== str.charAt(i)){
                count++;
                i++;
            }
            if(count==1){
                //Eat 5-Star--- do nothing
            }
            else{
                sb.append(count.toString());
            }
        }
        System.out.println(sb);
    }
    public static void main(String[] Args){
        String str= "aaabsdddd";
        compress(str);
    }
}


// a-> 110110  == 54
// b-> 100101  == 37
//^ == 19 -> a
// a=  010011  == 19
// n>>i && n!=0
// lsb==1 negate the ith bit of a,b
// b= a^b == 110110 == 54
// a= a^b == 100101 == 37   