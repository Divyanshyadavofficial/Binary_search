public class PeakIndexInAMountainArray {
    public static void main(String[] args) {
        int[] arr = {1,3,4,0,2};
        int result = peakIndex(arr);
        System.out.println(result);
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

}
