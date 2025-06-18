import java.util.Arrays;

public class SearchInTwoDArray {
    public static void main(String[] args) {
        int[][] arr = {
                {10,20,30,37},
                {15,25,31,46},
                {28,34,36,50}
        };
        int target = 31;
        int[] result = search(arr,target);
        System.out.println(Arrays.toString(result));
    }
    static int[] search(int[][]arr,int target){
        int row= 0;
        int col = arr[0].length-1;

        while(row< arr.length&&col>=0){
            if (arr[row][col]==target){
                return new int[]{row,col};
            }
            if(arr[row][col]< target){
                row++;
            }else{
                col--;
            }
        }
        return new int[]{-1,-1};

    }
}
