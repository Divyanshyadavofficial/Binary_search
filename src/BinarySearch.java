public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,6};
        int result = binarySearch(arr,6);
        System.out.println(result);
    }
    static int binarySearch(int[] arr, int target){
        int start  = 0;
        int end = arr.length -1;

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
}
// if the array contains two similar numbers it will return the index
// where it found the first occurence of that element.