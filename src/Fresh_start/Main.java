package Fresh_start;
import java.util.*;

public class Main {
    public static void Bubble(int arr[]){
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    //swap
                    int temp= arr[j];
                    arr[j]= arr[j+1];
                    arr[j+1]= temp;
                }
            }
        }
    }

    public static void Selection(int arr[]){
        for(int i=0;i<arr.length-1;i++){
            int ind=arr.length-1;
            int min= arr[arr.length-1];
            for(int j=i;j<arr.length;j++){
                if(arr[j]<min){
                    min= arr[j];
                    ind=j;
                }
            }
            int temp= arr[i];
            arr[i]=min;
            arr[ind]=temp;
        }
    }

    public static void Insertion(int arr[]){
        for(int i=1;i<arr.length;i++){
            int temp= arr[i];
            for(int j=i-1;j>=0;j--){
                if(temp<arr[j]){
                    arr[j+1]= arr[j];
                    arr[j]=temp;
                }
            }
        }
    }

    public static void counting(int arr[]){
        int max=arr[0];
        for(int i=0;i<arr.length;i++){
            max= Math.max(max, arr[i]);
        }
        int temp[]= new int[max+1];
        for(int i=0;i<max;i++){
            temp[arr[i]]+=1;
        }
        int a=0;
        for(int i=0;i<temp.length;i++){
            while (temp[i]!=0){
                arr[a]= i;
                a++;
                temp[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int arr[]={3,2,9,8,1,6,7,5,4};
        double boat=3500000;
        double invested=3500000;
        double dep=1.5; //a month
        double prof= 50000;
        double net=boat;
        for(int i=1;i<100;i++){
            net+= prof-boat*dep/100.00;
            boat = boat*98.5/100.00;
            System.out.println(net);
            if(net>= 2*invested){
                System.out.println("You took "+ i +" months to double your money");
                break;
            }
        }
        
    }
}