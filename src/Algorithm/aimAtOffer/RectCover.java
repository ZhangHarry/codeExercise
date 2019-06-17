package Algorithm.aimAtOffer;

/**
 * Created by zhanghr on 2018/9/5.
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */

public class RectCover {
    public int RectCover(int target) {
        if (target<2)
            return target;
        int[] dp = new int[target+1];
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        for (int i=3; i<=target;i++){
            dp[i] = dp[i-3]+(dp[i-2]<<1);
        }
        return dp[target];
    }
}
