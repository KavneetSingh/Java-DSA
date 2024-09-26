public class QuickSort {
    public static void quickSort(int arr[],int si, int ei){
        if(si>=ei){
            return;
        }
        int pivot= arr[ei];
        int pivPos=partition(arr, pivot,si,ei);
        quickSort(arr,si,pivPos-1); //left
        quickSort(arr,pivPos+1,ei); //right
    }
    public static int partition(int arr[],int pivot, int si,int ei){
        int i=-1;
        for(int j=si;j<=ei;j++){
            if(arr[j]<pivot){
                i++;
                swap(arr,si+i,j);
            }
        }
        i++;
        swap(arr,si+i,ei);
        return si+i;
    }
    public static void swap(int arr[], int i, int j){
        int temp= arr[i];
        arr[i]= arr[j];
        arr[j]= temp;
    }
    public static void main(String[] args){
        int arr[]={6,3,9,8,2,5,0};
        quickSort(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
