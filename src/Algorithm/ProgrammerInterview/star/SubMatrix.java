package Algorithm.ProgrammerInterview.star;

/**
 * Created by zhanghr on 2018/7/31.
 有一个方阵，其中每个单元(像素)非黑即白(非0即1)，请设计一个高效算法，找到四条边颜色相同的最大子方阵。

 给定一个01方阵mat，同时给定方阵的边长n，请返回最大子方阵的边长。保证方阵边长小于等于100。
 */

public class SubMatrix {
    // 思路很简单。就是cache每个元素左边和上边的连续元素个数。然后遍历每个元素，以此为方阵的右下角，判断是否方阵。
    // 需要注意的地方：黑色和白色都有可能，所以需要两套cache。
    public static int maxSubMatrix(int[][] mat, int n) {
        // write code here
        int[][] leftOne = new int[n][n];
        int[][] upOne = new int[n][n];
        int[][] leftZero = new int[n][n];
        int[][] upZero = new int[n][n];
        leftOne[0][0] = upOne[0][0] = mat[0][0];
        leftZero[0][0] = upZero[0][0] = 1 - mat[0][0];
        for (int j=1; j<n; j++){
            upOne[0][j] = mat[0][j];
            leftOne[0][j] = mat[0][j] == 1 ? leftOne[0][j-1] + 1 : 0;
            upZero[0][j] = 1-mat[0][j];
            leftZero[0][j] = mat[0][j] == 0 ? leftZero[0][j-1] + 1 : 0;
        }
        for (int j=1; j<n; j++){
            leftOne[j][0] = mat[j][0];
            upOne[j][0] = mat[j][0] == 1 ? upOne[j-1][0] + 1 : 0;
            leftZero[j][0] = 1-mat[j][0];
            upZero[j][0] = mat[j][0] == 1 ? upZero[j-1][0] + 1 : 0;
        }

        for (int i=1;i<n; i++){
            for (int j=1; j<n; j++){
                leftOne[i][j] = mat[i][j] == 1 ? leftOne[i][j-1] + 1 : 0;
                upOne[i][j] = mat[i][j] == 1 ? upOne[i-1][j] + 1 : 0;
                leftZero[i][j] = mat[i][j] == 0 ? leftZero[i][j-1] + 1 : 0;
                upZero[i][j] = mat[i][j] == 0 ? upZero[i-1][j] + 1 : 0;
            }
        }
        int res = 1;
        for (int i=1;i<n; i++){
            for (int j=1; j<n; j++){
                int length = Math.min(leftOne[i][j], upOne[i][j]);
                if (length>1){
                    if(leftOne[i-length+1][j] >= length && upOne[i][j-length+1] >= length)
                        res = Math.max(res, length);
                }
                length = Math.min(leftZero[i][j], upZero[i][j]);
                if (length>1){
                    if(leftZero[i-length+1][j] >= length && upZero[i][j-length+1] >= length)
                        res = Math.max(res, length);
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        int[][] mat = new int[][]{
                new int[]{1,1,1},
                new int[]{1,0,1},
                new int[]{1,1,1}
        };
        System.out.println(SubMatrix.maxSubMatrix(mat, mat.length));
    }
}
