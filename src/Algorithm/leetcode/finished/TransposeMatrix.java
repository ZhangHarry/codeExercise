package Algorithm.leetcode.finished;

/**
 * Created by zhanghr on 2018/8/2.

 Given a matrix A, return the transpose of A.

 The transpose of a matrix is the matrix flipped over it's main diagonal, switching the row and column indices of the matrix.

 */

public class TransposeMatrix {
    public int[][] transpose(int[][] A) {
        if (A.length==0)
            return A;
        int rows = A.length;
        int cols = A[0].length;
        int[][] res = new int[cols][rows];
        for (int i=0; i<cols; i++){
            for (int j=0; j<rows; j++){
                res[i][j] = A[j][i];
            }
        }
        return res;
    }
}
