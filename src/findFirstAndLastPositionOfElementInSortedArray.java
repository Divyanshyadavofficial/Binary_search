import java.util.Arrays;

public class findFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        int[]nums = {1,7,7,8};
        int target = 7;
        int[] result = searchRange(nums,target);
        System.out.println(Arrays.toString(result));
    }
    static int [] searchRange(int[] nums,int target){
        int[] ans = {-1,-1};
        int start = search(nums,target,true);
        int end = search(nums,target,false);
        ans[0] =start;
        ans[1] = end;
        return ans;
    }
    // this function just returns the index value of target
    static  int search(int[]nums,int target,boolean findStartIndex){
        int ans = -1;
        int start = 0;
        int end = nums.length-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(nums[mid]>target){
                end = mid-1;
            } else if (nums[mid]<target) {
                start = mid+1;

            }else{
                ans = mid;
                if(findStartIndex){
                    end = mid-1;

                }else {
                    start = mid+1;
                }
            }
        }
        return ans;
    }
}
