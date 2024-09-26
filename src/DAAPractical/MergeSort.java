package DAAPractical;

public class MergeSort{
    public static void mergeSort(int arr[], int in, int out){
        if(in>= out){
            return;
        }
        int mid= in + (out-in)/2;
        mergeSort(arr, in, mid);
        mergeSort(arr, mid+1,out);
        merge(arr, in, mid ,out);
    }
    public static void merge(int arr[], int in, int mid, int out){
        int newArr[]= new int[out-in+1];
        int i= in;
        int j= mid +1;
        int k=0;

        while(i<=mid && j<=out){
            if(arr[i]>arr[j]){
                newArr[k]= arr[j];
                j++;
            }
            else{
                newArr[k]= arr[i];
                i++;
            }
            k++;
        }

        while(i<=mid){
            newArr[k]= arr[i];
            i++;
            k++;
        }
        while(j<=out){
            newArr[k]= arr[j];
            k++;
            j++;
        }

        // copying to original array:

        for( k=0, i= in;k<newArr.length;k++,i++){
            arr[i]= newArr[k];
        }

    }

    public static void main(String [] args){
        int arr[]= {3,6,2,8,43,0,-4,5};
        mergeSort(arr,0, arr.length-1);

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+", ");
        }
        System.out.println();
    }
}