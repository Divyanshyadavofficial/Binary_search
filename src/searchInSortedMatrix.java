import java.util.Arrays;

public class searchInSortedMatrix {
    public static void main(String[] args) {
        int[][]arr = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        int target = 15;
        int[] result = searchInSorted2D(arr,target);
        System.out.println(Arrays.toString(result));
    }
    static int[] binarySearch(int[][]arr,int row,int colStart,int colEnd,int target){
        while (colStart<=colEnd){
            int mid = colStart+(colEnd-colStart)/2;
            if(arr[row][mid]==target) {
                return new int[]{row, mid};
            }
            if(arr[row][mid]<target){
                colStart=mid+1;
            }else{
                colEnd = mid-1;
            }
        }
        return new int[]{-1,-1};
    }
    static int[] searchInSorted2D(int[][] arr,int target){
        int rows = arr.length;
        int cols = arr[0].length;

        if(rows == 1){
            return binarySearch(arr,0,0,cols-1,target);
        }
        int rstart = 0;
        int rEnd = rows-1;
        int cMid = cols/2;
        // run the loop till two rows are remaining.
        while(rstart<(rEnd-1)){// while this is true we are having >2 rows
            // which are needed to eliminate
            int mid = rstart+(rEnd-rstart)/2;
            if(arr[mid][cMid]==target){
                return new int[]{mid,cMid};

            }
            if(arr[mid][cMid]<target) {
                rstart = mid;
            }
            else{
                rEnd = mid;
            }
        }

        //now we have 2 rows
        // check whether the target is in the col of 2 rows
        if(arr[rstart][cMid]==target){
            return new int[]{rstart,cMid};
        }
        if(arr[rstart+1][cMid]==target){
            return new int[]{rstart+1,cMid};
        }
        //search in 1,2,3,4 halves.
        // 1st
        if(target<=arr[rstart][cMid-1]){
            return binarySearch(arr,rstart,0,cMid-1,target);
        }
        //2nd
        if(target>=arr[rstart][cMid+1]&&target<=arr[rstart][cols-1]){
            return binarySearch(arr,rstart,cMid+1,cols-1,target);
        }
        //3rd
        if(target<=arr[rstart+1][cMid-1]){
            return binarySearch(arr,rstart+1,0,cMid-1,target);
        }
        //4th
        if(target>=arr[rstart+1][cMid+1]){
            return binarySearch(arr,rstart+1,cMid+1,cols-1,target);
        }


        return new int[]{-1,-1};

    }
}
