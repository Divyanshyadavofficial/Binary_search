public class orderAgnoisticBinarySearch {
    public static void main(String[] args) {
        int[] arr  = {1,2,3,4,5,6,7};
        int target = 5;
        int result = orderAgnoisticBinarySearch_(arr,target);
        System.out.println(result);
    }
    static int orderAgnoisticBinarySearch_(int[]arr,int target){
        if (arr.length ==0){
            return -1;
        }
        // find whether the array is ascending or descending
        boolean isAsc;

        int start = 0;
        int end = arr.length-1;


        if(arr[start]<arr[end]){
            isAsc = true;
        }else {
            isAsc = false;
        }


        while(start<=end){
            int mid = start+(end-start)/2;

            if(arr[mid] == target){
                return mid;
            }

            if(isAsc){
                if(target < arr[mid]){
                    end = mid-1;
                }else{
                    start = mid +1;
                }
            }else{
                if(target> arr[mid]){
                    end = mid-1;
                }else{
                    start = mid +1;
                }
            }
        }
        return -1;
    }
}
