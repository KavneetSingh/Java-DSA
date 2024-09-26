package PracticeQuestions.LeetCode.Arrays;

public class SearchMountainArray {

    //LeetCode Q)1095   🔥

    public static int findPeak(int arr[]){
        int start= 0;
        int end= arr.length-1 ;
        boolean found=false;
        boolean leftPeak= false;
        int mid= (start+end)/2;
        while(!found){
            mid= (start+end)/2;
            int currVal= arr[mid];
            int currM1= arr[mid-1];
            int currP1= arr[mid+1];

            if(currP1< currVal && currM1<currVal){
                found=true;
                return mid;
            }
            else if(currP1> currVal && currVal> currM1){
                start= mid+1;
            }
            else{
                end= mid;
            }
        }
        return mid;
    }

    public static int findFirstOccurance(int arr[], int target, int peak){
        if(arr[peak]== target){
            return peak;
        }
        int start=0;
        int end= peak;
        int mid= (start+end)/2;
//        int ans=-1;

        while(start<=end){
            mid= (start+end)/2;
            int curr= arr[mid];
            if(curr== target){
                return mid;
            }
            else if(curr> target){
                end= mid-1;
            }
            else{
                start= mid+1;
            }
        }

        start= peak;
        end= arr.length-1;

        while(start<=end){
            mid= (start+end)/2;
            int curr= arr[mid];
            if(curr== target){
                return mid;
            }
            else if(curr> target){
                start= mid+1;
            }
            else{
                end= mid-1;
            }
        }
        return -1;
    }

//    public static int searchMountain(int arr[], int target,int start, int end){
//        //0,5,3,1
//        int mid= (start+end)/2;
//        int curr= arr[mid];
//        System.out.println(start + " " + mid + " " + end);
//        int currAns=Integer.MAX_VALUE;
//        if(curr== target){
//            currAns= Math.min(currAns,mid);
//        }
//        if(mid==start){
//            if(currAns== mid){
//                return mid;
//            }
//            if(start== end-1){
//                int curr2= arr[end];
//                if(curr2==target && curr!= target){
//                    return end;
//                }
//            }
//            return -1;
//        }
//        else if(mid==end && currAns== Integer.MAX_VALUE){
//            return -1;
//        }
//
//        int left= searchMountain(arr, target, start, mid-1);
//        if(currAns!=Integer.MAX_VALUE && left!=-1){
//            return Math.min(currAns, left);
//        }
//        else if(currAns!=Integer.MAX_VALUE){
//            return currAns;
//        }
//        else if(left!=-1){
//            return left;
//        }
//        int right= searchMountain(arr, target, mid+1, end);
//        return right;

//        int mid= (start+end)/2;
//        System.out.print(mid + ", ");
//        int curr= arr[mid];
//        if(mid== start){
//            if(curr== target){
//                return mid;
//            }
//            return -1;
//        }
//        int left= searchMountain(arr, target, start, mid-1);
//        if(left!=-1){
//            return left;
//        }
//
//        if(mid== start && start== end-1){
//            int curr2= arr[end];
//            if(curr2==target){
//                return end;
//            }
//        }
////        System.out.println(mid);
//        if(curr== target){
//            return mid;
//        }
//
//        if(mid== start){
//            return -1;
//        }
//        else if(mid==end) {
//            return -1;
//        }
//
//        int right= searchMountain(arr, target, mid+1, end);
//        return right;

//        int currM1= arr[mid-1];                  //curr minus 1 (curr-1)
//        int currP1= arr[mid+1];                  //curr plus 1 (curr+1)
//
//        if(curr>currM1 && curr>currP1){            //curr is the peak
//            int left= searchMountain(arr, target, start, mid-1);
//            int right= searchMountain(arr, target, mid+1, end);
//
//
//            if(left==-1||right==-1){
//                return Math.max(left, right);
//            }
//            else{
//                return Math.min(left, right);
//            }
//        }
//        else if(currM1>curr && curr>currP1){       //peak on the left
//            int left= searchMountain(arr, target, start, mid-1);
//            int right= searchMountain(arr, target, mid+1, end);
//
//
//            if(left==-1||right==-1){
//                return Math.max(left, right);
//            }
//            else{
//                return Math.min(left, right);
//            }
//        }
//        else if(currM1<curr && curr<currP1){      //peak on the right
//            int left= searchMountain(arr, target, start, mid-1);
//            int right= searchMountain(arr, target, mid+1, end);
//
//
//            if(left==-1||right==-1){
//                return Math.max(left, right);
//            }
//            else{
//                return Math.min(left, right);
//            }
//        }
//        return -1;

//        while(start<end){          //left iteration
//            int curr= arr[mid];
//            if(curr == target){
//                return mid;
//            }
//            if(target<mid){
//
//            }
//        }
//    }

    public static void main(String[] args){
        int arr[]= {1,2,3,4,5,3,1};    //ans=2
        int target= 3;

//        int arr[]= {0,1,2,4,2,1};     //ans=-1
//        int target= 3;

//        int arr[]= {0,5,3,1};          //ans=3;
//        int target=1;

//        int arr[]= {3,5,3,2,0};        //ans=0;
//        int target=3;

        int start=0;
        int end= arr.length-1;
//        int mid= (start+ end)/2;

        int peak= findPeak(arr);
        System.out.println(peak);


        int ans= findFirstOccurance(arr, target, peak);
        System.out.println(ans);
    }
}
