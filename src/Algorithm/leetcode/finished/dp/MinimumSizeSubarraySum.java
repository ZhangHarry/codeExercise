package Algorithm.leetcode.finished.dp;
import java.util.*;
/**
 * Created by zhanghr on 2018/6/17.
 */

public class MinimumSizeSubarraySum {
    // dp , over time limit
    public int minSubArrayLen(int s, int[] nums) {
        int length = nums.length;
        int[][] dp = new int[s+1][length+1];
        for (int i=1; i<=s ; i++){
            for (int j=1; j<=length; j++){
                if (nums[j-1] >= i)
                    dp[i][j] = 1;
                else
                    dp[i][j] = dp[i-nums[j-1]][j-1] > 0 ? dp[i-nums[j-1]][j-1]+1 : 0;
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i=1;i<=length;i++)
            if (dp[s][i] > 0)
                res = Math.min(res, dp[s][i]);
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    // beat 13%
    public int minSubArrayLen1(int s, int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        int sum =0;
        int res = Integer.MAX_VALUE;
        for (int i=0; i<nums.length; i++){
            if (nums[i] >= s)
                return 1;
            list.add(nums[i]);
            sum += nums[i];
            sum = tuned(list, sum, s);
            if (sum>=s)
                res = Math.min(res, list.size());
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    private int tuned(LinkedList<Integer> list, int sum, int s){
        Integer first = list.getFirst();
        int tmp = sum - first;
        while (tmp >= s){
            sum = tmp;
            list.remove(0);
            first = list.getFirst();
            tmp = sum - first;
        }
        return sum;
    }

    public static void main(String[] args){
        MinimumSizeSubarraySum test = new MinimumSizeSubarraySum();
        int[] array = new int[]{2,3,1,2,4,3};
        System.out.println(test.minSubArrayLen(7, array));
    }
}
