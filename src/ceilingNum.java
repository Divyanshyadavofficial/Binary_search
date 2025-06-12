public class ceilingNum {
    public static void main(String[] args) {
        int[] arr = {2,3,5,9,14,16,18};
        int target = 10;
        int result = ceilingNumber(arr,target);
        System.out.println(result);
    }
    static int ceilingNumber(int[]arr,int target){
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int mid = start + (end - start)/2;
            if(arr[mid] == target){
                return mid;
            } else if (arr[mid]<target) {
                start = mid+1;

            }else {
                end = mid-1;
            }
        }
        return start;
    }
}
