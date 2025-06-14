public class FindPositiionOfAnElementInASortedArrayOfInfiniteNumbers {
    public static void main(String[] args) {
        int[] arr = {3,5,7,9,10,90,100,130,140,160,170};
        int target = 10;

        int pos = ans(arr, target);
        System.out.println("Element found at index: " + pos);

    }
    static int ans(int[]arr,int target){
        //first find the range
        // first start with a box of 2
        int start = 0;
        int end = 1;
        while (target>arr[end]){
            int temp = end+1;
            // double the box value
            // end = previous end + size of the box * 2
            end = end + (end-start+1)*2;
            start = temp;
        }
        return FindPositiionOfAnElementInASortedArray(arr,target,start,end);


    }
    static int FindPositiionOfAnElementInASortedArray(int[]arr,int target,int start,int end){

        while(start<=end){
            int mid = start+(end-start)/2;
            if(arr[mid]>target){
                end = mid-1;

            } else if (arr[mid]<target) {
                start = mid+1;

            }else {
                return mid;
            }
        }
        return -1;
    }
}
