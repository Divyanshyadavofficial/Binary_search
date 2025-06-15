public class FindInMountainArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,3,1};
        int target = 3;
        int result = search(arr,target);
        System.out.println(result);
    }
    static int search(int[] arr,int target){
        int peak = peakIndex(arr);
        int firstTry = orderAgnoisticBinarySearch_(arr,target,0,peak);
        if(firstTry!=-1){
            return firstTry;
        }
        // try to search in second half.
        return orderAgnoisticBinarySearch_(arr,target,peak+1, arr.length-1);
    }
    static int peakIndex(int[]arr){
        if(arr.length==0){
            return -1;
        }
        int start = 0;
        int end = arr.length-1;
        while(start<end){
            int mid = start + (end-start)/2;
            if(arr[mid]>arr[mid+1]){
                // you are in dec part of array
                // this may be the ans but look at left
                // this is why end != mid-1;
                end = mid;
            } else {
                // you are in asc part of array
                // because we know that mid+1 element is > mid element
                start = mid+1;

            }
        }
        // in the end, start == end and pointing to the largest number
        // because of the two checks above
        // start and end are always trying to find the max element in the above 2 checks
        // hence, when they are pointing to just one element , that is the max element.
        // more elaboration: at every point of time for start and end, they have the
        // best possible answer till that time and if we are saying that only one
        // item is remaining hence cuz of the above line that is the best possible answer.

        return start;
    }
    static int orderAgnoisticBinarySearch_(int[]arr,int target,int start,int end){
        if (arr.length ==0){
            return -1;
        }
        // find whether the array is ascending or descending
        boolean isAsc;
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
