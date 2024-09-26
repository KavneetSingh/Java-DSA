package LoveBabbarDSASheet.Arrays;

public class ReverseAnArray {
    public static StringBuilder stringReverse(StringBuilder sb,String str, int curr){
        if(curr>= str.length()){
            return sb;
        }
        char removed= str.charAt(curr);
        stringReverse(sb, str, curr+1);
        sb.append(removed);
        return sb;
    }
    public static void reverse(int[] arr, int curr){
        if(curr>= arr.length){
            return;
        }
        int removed= arr[curr];
//        arr[curr]= 0;
        reverse(arr, curr+1);
        arr[arr.length-curr-1]= removed;
    }
    public static void main(String[] args){
        //Reverse an array. eg: 1,2,3,4,5 becomes 5,4,3,2,1.
        int[] arr= {1,2,3,4,5};
        String str= "abcdefghijk";
        reverse(arr,0);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        StringBuilder sb= new StringBuilder("");
        str= (stringReverse(sb, str, 0)).toString();
        System.out.println(str);
    }
}
