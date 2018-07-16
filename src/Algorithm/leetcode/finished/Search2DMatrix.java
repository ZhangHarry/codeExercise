package Algorithm.leetcode.finished;

/**
 * Created by zhanghr on 2018/7/16.

 Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

 Integers in each row are sorted from left to right.
 The first integer of each row is greater than the last integer of the previous row.
 Example 1:

 Input:
 matrix = [
 [1,   3,  5,  7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
 ]
 target = 3
 Output: true

 */

public class Search2DMatrix {
    int rows,columns;
    // beat 98.04%
    // 思路：binary search，进行binary search时注意二分原则要将区域缩小，对应(n,n+1)一定要小心
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length==0)
            return false;
        rows = matrix.length;
        columns = matrix[0].length;
        return searchMatrix(matrix, target, 0, rows*columns-1);
    }

    public boolean searchMatrix(int[][] matrix, int target, int start, int end) {
        if (start > end)
            return false;
        if (target == getV(matrix, start) || target == getV(matrix, end))
            return true;
        if (target < getV(matrix, start) || target > getV(matrix, end))
            return false;
        int mid = start + (end-start)/2;
        if (target == getV(matrix, mid))
            return true;
        else if(target > getV(matrix, mid)){
            return searchMatrix(matrix, target, mid+1, end);
        }else
            return searchMatrix(matrix, target, start, mid);
    }

    public int getV(int[][] matrix, int index){
        int i = index/columns;
        int j = index%columns;
        return matrix[i][j];
    }

    public static void main(String[] args){
        Search2DMatrix test = new Search2DMatrix();
        int[][] matrix = new int[][]{
                new int[]{1,3,5,7},
                new int[]{10,11,16,20},
                new int[]{23,30,34,50}
        };
        System.out.println(test.searchMatrix(matrix, 3));
    }

}
