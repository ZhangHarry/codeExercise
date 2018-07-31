package Algorithm.ProgrammerInterview;

/**
 * Created by zhanghr on 2018/7/29.
 * 对于一个有正有负的整数数组，请找出总和最大的连续数列。

 给定一个int数组A和数组大小n，请返回最大的连续数列的和。保证n的大小小于等于3000。
 */

public class MaxSum {
    public int getMaxSum(int[] A, int n) {
        // write code here
        int res = Integer.MIN_VALUE;
        int max = res;
        for (int num : A){
            if (max >= 0){
                max = max+num;
            }else{
                max = num;
            }
            res = Math.max(res, max);
        }
        return res;
    }
}
