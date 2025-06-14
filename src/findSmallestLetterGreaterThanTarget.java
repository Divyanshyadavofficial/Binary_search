public class findSmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        char[] arr = {'c','f','j'};
        char target = 'a';
        char result = smallestGreaterThanTarget(arr,target);
        System.out.println(result);
    }
    static char smallestGreaterThanTarget(char[] arr,char target){
        int start = 0;
        int end = arr.length-1;
        while (start<=end){
            int mid = start + (end-start)/2;
            if(mid<arr[target]){
                start = mid+1;
            }else if(mid>arr[target]){
                end = mid-1;
            }
        }
        return arr[start%arr.length];
    }

}
// letters wrap around
// it means that if no character is available there that is larger then
// the target element then just return the first index the zeroth index one