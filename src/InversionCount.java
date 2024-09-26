public class InversionCount {
    public static int merge(int arr[], int start, int mid, int end){
        int i= start;
        int j= mid;
        int k=0;
        int temp[]= new int[(end-start+1)];
        int invCount=0;

        while((i< mid) && (j<=end)){
            if(arr[i]<=arr[j]){
                temp[k]= arr[i];
                i++;
                k++;
            }
            else{
                temp[k]= arr[j];
                invCount+= (mid-i);
                j++;
                k++;
            }
        }
        while(i<mid){
            temp[k]= arr[i];
            i++;
            k++;
        }

        while(j<=end){
            temp[k]=arr[j];
            k++;
            j++;
        }
        for(i=start,k=0;i<=end;k++,i++){
            arr[i]= temp[k];
        }
        return invCount;
    }
    public static int mergeSort(int arr[], int start, int end){
        int invCount= 0;

        if(end>start) {
            int mid = (start + end) / 2;

            invCount = mergeSort(arr, start, mid);
            invCount += mergeSort(arr, mid + 1, end);
            invCount += merge(arr, start, mid + 1, end);
        }
        return invCount;
    }
    public static int InversionCounter(int arr[]){
        int n= arr.length;
        return mergeSort(arr,0,n-1);
    }
    public static void main(String[] args){
        int arr[]= {1,20,6,4,5};
        System.out.println("The no. of inversions in the array are:"+ InversionCounter(arr));
    }
}
