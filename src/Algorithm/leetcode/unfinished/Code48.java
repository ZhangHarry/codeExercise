package Algorithm.leetcode.unfinished;

/**
 * You are given an n x n 2D matrix representing an image.

 Rotate the image by 90 degrees (clockwise).

 Follow up:
 Could you do this in-place?

 * Created by zhanghr on 2017/3/8.
 */
public class Code48 {

    public void rotate(int[][] matrix) {
        int length = matrix[0].length;
        if (length % 2 == 0){
            int boundary = length/2;
            for (int i =0;i<boundary;i++){
                for (int j=0;j<boundary;j++){
                    int[] temp = rotateXY(j-boundary,i-boundary);
                    int[] xy1 = new int[]{temp[0]+boundary,temp[0]+boundary};
                    temp = rotateXY(temp[0],temp[1]);
                    int[] xy2 = new int[]{temp[0]+boundary,temp[0]+boundary};
                    temp = rotateXY(temp[0],temp[1]);
                    int[] xy3 = new int[]{temp[0]+boundary,temp[0]+boundary};
                    temp = rotateXY(temp[0],temp[1]);
                    int[] xy4 = new int[]{temp[0]+boundary,temp[0]+boundary};
                    swap(xy1, xy2, xy3, xy4, matrix);
                }
            }
        }
    }

    public int[] rotateXY(int x, int y){
        return new int[]{y, -x};
    }

    public void swap(int[] xy1, int[] xy2, int[] xy3, int[] xy4, int[][] matrix){
        int temp = matrix[xy1[0]][xy1[1]];
        matrix[xy1[0]][xy1[1]] = matrix[xy2[0]][xy2[1]];
        matrix[xy2[0]][xy2[1]] = matrix[xy3[0]][xy3[1]];
        matrix[xy3[0]][xy3[1]] = matrix[xy4[0]][xy4[1]];
        matrix[xy4[0]][xy4[1]] = temp;
    }
}
