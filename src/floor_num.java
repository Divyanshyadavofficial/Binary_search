public class floor_num {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        int target = 9;
        int result = floorNum(arr,target);
        System.out.println(result);
    }
    static  int floorNum(int[] arr,int target){
        if(arr.length==0){
            return -1;
        }
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int mid = start + (end - start)/2;
            if(arr[mid]==target){
                return mid;
            } else if (arr[mid]>target) {
                end = mid-1;

            }else {
                start = mid+1;
            }

        }
        return end;

    }
}
