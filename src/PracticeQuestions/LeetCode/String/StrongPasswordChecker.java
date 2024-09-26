package PracticeQuestions.LeetCode.String;
import java.util.*;

public class StrongPasswordChecker {

    //LeetCode 420
    //   ❌ Unsolved ❌
    public static int strongPasswordChecker(String password) {
        boolean smallChar= false;
        boolean capital= false;
        boolean digit= false;
        int repeats=0;
        char prevCh= password.charAt(0);
        int repeatedFreq=0;

        ArrayList<Integer> arr= new ArrayList<>();

        for(int i=1;i<password.length();i++){
            char ch= password.charAt(i);
            if(prevCh!=ch || i== password.length()-1){
                if(i== password.length()-1){
                    if(prevCh == ch){
                        repeatedFreq++;
                    }
                }

                if(repeatedFreq>=2){
                    arr.add(repeatedFreq);
                    repeats++;
                }
                repeatedFreq=0;
            }
            else if(prevCh == ch){
                repeatedFreq++;
            }

            if(!capital && ch-'A'<=25 && ch-'A'>=0){
                capital= true;
            }
            if(!smallChar && ch-'a'<=25 && ch-'a'>=0){
                smallChar= true;
            }
            if(!digit && ch-'0'>=0 && ch-'0'<=9){
                digit= true;
            }
            prevCh= ch;
        }


        if(password.length()<=3){
            return 6- password.length();
        }

        int missing=0;
        if(!capital){
            missing++;
        }
        if(!smallChar){
            missing++;
        }
        if(!digit){
            missing++;
        }

        if(password.length()>=6 && password.length()<=20 && missing==0 && repeats==0){
            return 0;
        }

        if(password.length()<6){         //3<length<6
            //cases= aaaa, ....., ...., aaaaa
            if(missing==3){
                return 3;
            }
            else if(missing==2){
                return 2;
            }

            else if(missing==1){
                if(repeats>0){
                    return 2;
                }
                return 6-password.length();
            }
        }


        else if(password.length()>= 6 && password.length()<=20){
            //cases= "a...!aAcccs32134", "a...!acs32134", "aaaaaaaaaaaaaaaaaaaa" 20 a's,
            int rep= 0;
            int repChanges=0;
            if(repeats>0){
                for(int i=0;i<arr.size();i++){
                    int x= arr.get(i);
                    // System.out.println(x);
                    rep+= x;
                    repChanges+= (x+1)/3;
//                    repChanges+= (x+1)%3;
                }
            }
            if(repChanges<missing){
                return missing;
            }
            return repChanges;
        }


//        else if(password.length()> 17 && password.length()<20){
//
//        }

//        else{          //length>20
//            if(repeats>0){
//                int remove= password.length()- 20;
//                int rep=0;
//                int replaceable=0;
//
////                for(int j=1;j<=3;j++){
//                for(int i=0;i<arr.size();i++){
//                    int x= arr.get(i);
//                    if(x>2 && (x-2)%3>0){
//                        remove-= (x-2)%3==2? 2:1;
//                        rep+= (x-2)%3==2? 2:1;
//                        arr.set(i, arr.get(i)- (x-2)%3==2? 2:1);
//                        if(remove<=0){
//                            break;
//                        }
//                    }
//                }
////                    if(remove<=0){
////                        break;
////                    }
////                }
//
//                for(int i=0;i<arr.size();i++){
//                    int x= arr.get(i);
//                    if((x>=2)){
//                        remove-= (x-2)%3==2? 2:1;
//                        rep+= (x-2)%3==2? 2:1;
//                        if(remove<=0){
//                            break;
//                        }
//                        if(remove< x-2){
//
//                        }
//                        else{
//                            remove-= x-2;
//                            rep+= x-2;
//                        }
//                    }
//                }
//            }
//        }


        return 0;
    }



    public static void main(String[] args){
        String pass= "1337C0d3";

        System.out.println(strongPasswordChecker(pass));
    }
}
