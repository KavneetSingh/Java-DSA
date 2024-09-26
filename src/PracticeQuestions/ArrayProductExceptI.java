package PracticeQuestions;

public class ArrayProductExceptI {
    //given arr[], You need to produce a new array product[] where product[i]= product of all elements except arr[i];
    //Condition: *You cannot use division operator* and do it in O(N);
    //Spend some time by yourself

    public static void main(String[] args){
        int arr[]= {5,6,9,3,4,8};
        // answer should be {5184, 4320, 2880, 8640, 6480, 3240};
        int leftProduct=1;
        int rightProduct=1;
        int prod[]= new int[arr.length];
        for(int i=0;i<arr.length;i++){
            prod[i]= leftProduct;
            leftProduct *= arr[i];
        }

        for(int i= arr.length-1;i>=0;i--){
            prod[i]*= rightProduct;
            rightProduct*= arr[i];
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(prod[i] + ", ");
        }
    }
}
