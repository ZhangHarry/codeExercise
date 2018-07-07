package Algorithm.leetcode.finished.dp;

import java.util.Arrays;

/**
 * Created by zhanghr on 2018/7/4.
 */

public class CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        int[] dp= new int[target+1];
        dp[0] = 1;
        for (int i=0; i<nums.length; i++){
            for (int j=1; j<= target; j++)
                if (j-nums[i] >= 0)
                    dp[j] += dp[j-nums[i]];
            System.out.println(i + " : " + Arrays.toString(dp));
        }
        return dp[target];
    }

    public int getSequence(int[] dp,int t, int item){
        int v = item;
        int i = 1;
        int sum = 0;
        while (t >= v){

            v += item;
            i++;
        }
        return sum;
    }

    public int c(int origin, int insert){
        int sum = origin+insert;
        insert = Math.min(insert, origin);
        int i = 1;
        for (int j=2; j<=insert; j++)
            i *= j;
        int k =1;
        for (int j=sum; j>=sum-insert+1;j--)
            k *= j;
        return k/i;
    }


    public static void  main(String[] args){
        CombinationSumIV test = new CombinationSumIV();
        int[] nums = new int[]{1,2,3};
        System.out.println(test.combinationSum4(nums, 4));
    }
}
