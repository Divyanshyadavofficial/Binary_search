public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        int target = 0;
        int result = PivotBinarySearch(arr,target);

        System.out.println(result);
        System.out.println(findPivot(arr));
    }
    static int findPivot(int[] arr){
        if(arr.length==0){
            return -1;
        }
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int mid = start + (end - start)/2;
            if(mid<end && arr[mid]>arr[mid+1]){
                return  mid;

            }if(mid >start && arr[mid]<arr[mid-1]){
                return mid-1;

            }
             if(arr[mid]<=start) {
                 end = mid - 1;
             }else{
                start = mid+1;
            }
        }
        return  -1;
    }
    static int binarySearch(int[] arr, int target,int start,int end){


        while(start<=end){
//           int mid = (start+end)/2; might be possiblw that (start + end)
//           might exceed the interger range in java
            int mid = start + (end-start)/2;
            if (target < arr[mid]){
                end = mid-1;
            } else if (target> arr[mid]) {
                start = mid+1;
            }else {
                return mid;
            }

        }
        return  -1;
    }
    static  int PivotBinarySearch(int[] nums,int target){

        int pivot = findPivot(nums);

        // if you did not find the pivot,
        // it means the array is not rotated
        if(pivot==-1){
            // just do normal binary search.
            return  binarySearch(nums,target,0, nums.length-1);
        }
        // if pivot is found you habe found two asc sorted arrays
        if(nums[pivot]==target){
            return  pivot;
        }
        if(target>=nums[0]){
            return  binarySearch(nums,target,0,pivot-1);

        }
            return binarySearch(nums,target,pivot+1,nums.length-1);

    }

}
