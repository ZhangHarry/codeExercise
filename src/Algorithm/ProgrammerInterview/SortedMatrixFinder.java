package Algorithm.ProgrammerInterview;

/**
 * Created by zhanghr on 2018/7/26.

 有一个NxM的整数矩阵，矩阵的行和列都是从小到大有序的。请设计一个高效的查找算法，查找矩阵中元素x的位置。

 给定一个int有序矩阵mat，同时给定矩阵的大小n和m以及需要查找的元素x，
 请返回一个二元数组，代表该元素的行号和列号(均从零开始)。保证元素互异。

 */

public class SortedMatrixFinder {
    public int[] findElement(int[][] mat, int n, int m, int x) {
        // write code here
        int i=0, j=m-1;
        while (i<n && j>=0){
            if (mat[i][j] <x){
                i++;
            }else if(mat[i][j] >x)
                j--;
            else
                break;
        }
        int[] res = new int[2];
        res[0] = i;
        res[1] = j;
        return res;
    }
}
