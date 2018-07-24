package Algorithm.ProgrammerInterview;

/**
 * Created by zhanghr on 2018/7/21.
 请编写一个算法，若N阶方阵中某个元素为0，则将其所在的行与列清零。

 给定一个N阶方阵int[][](C++中为vector<vector><int>>)mat和矩阵的阶数n，
 请返回完成操作后的int[][]方阵(C++中为vector<vector><int>>)，保证n小于等于300，矩阵中的元素为int范围内
 */

import java.util.*;

public class Clearer {
    public int[][] clearZero(int[][] mat, int n) {
        // write code here
        boolean[] cols = new boolean[n];
        for (int[] m : mat){
            boolean bl = false;
            for (int i=0; i<n; i++){
                int tmp = m[i];
                if (tmp == 0){
                    bl = true;
                    cols[i] = true;
                }
            }
            if (bl)
                Arrays.fill(m, 0);
        }
        for (int[] m : mat){
            for (int i=0; i<n; i++){
                boolean bl = cols[i];
                if (bl)
                    m[i] = 0;
            }
        }
        return mat;
    }
}