package Algorithm.aimAtOffer;

/**
 * Created by zhanghr on 2018/9/5.
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */

public class JumpFloorII {
    public int JumpFloorII(int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int i=1; i<=target; i++){
            int tmp=0;
            for (int j=0;j<i;j++)
                tmp+=dp[j];
            dp[i] = tmp;
        }
        return dp[target];
    }
}
