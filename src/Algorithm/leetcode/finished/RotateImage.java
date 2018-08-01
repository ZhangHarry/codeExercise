package Algorithm.leetcode.finished;

import Algorithm.leetcode.util.Tool;

/**
 * Created by zhanghr on 2018/7/12.
 *
 You are given an n x n 2D matrix representing an image.

 Rotate the image by 90 degrees (clockwise).

 Note:

 You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

 Example 1:

 Given input matrix =
 [
 [1,2,3],
 [4,5,6],
 [7,8,9]
 ],

 rotate the input matrix in-place such that it becomes:
 [
 [7,4,1],
 [8,5,2],
 [9,6,3]
 ]
 */

public class RotateImage {
    // beat 100%
    // 思路：因为是n*n矩阵，从外层往内层开始旋转，每次都旋转一个正方形，旋转正方形时每次选取4个点（从上面这条边选取一个点，可以算出另外三个点）进行旋转，直到把所有点都旋转过
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        int start = 0;
        for (int side=length; side > 1; side-=2){
            int ltx = start;
            int lty = start;
            for (int ahead = 0; ahead<side-1; ahead++){
                rotateFour(matrix, ltx, lty+ahead, ahead,side);
            }
            start++;
        }
    }

    public void rotateFour(int[][] matrix, int ltx, int lty, int ahead, int side){
        int rtx = ltx+ahead, rty = lty+side-1-ahead;
        int lbx = ltx+side-1-ahead, lby = lty-ahead;
        int rbx = lbx+ahead, rby = rty-ahead;
        int lt = matrix[ltx][lty];
        matrix[ltx][lty] = matrix[lbx][lby];
        matrix[lbx][lby] = matrix[rbx][rby];
        matrix[rbx][rby] = matrix[rtx][rty];
        matrix[rtx][rty] = lt;
    }

    public static void main(String[] args){
        RotateImage test = new RotateImage();
        int[][] matrix = new int[][]{
                new int[]{1,2,3},
                new int[]{4,5,6},
                new int[]{7,8,9}
        };
        test.rotate(matrix);
        Tool.print(matrix);
    }
}
