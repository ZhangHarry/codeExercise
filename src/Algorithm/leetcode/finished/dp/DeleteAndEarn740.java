package Algorithm.leetcode.finished.dp;

/**
 * Created by zhanghr on 2018/9/11.

 Given an array nums of integers, you can perform operations on the array.

 In each operation, you pick any nums[i] and delete it to earn nums[i] points. After, you must delete every element equal to nums[i] - 1 or nums[i] + 1.

 You start with 0 points. Return the maximum number of points you can earn by applying such operations.

 Example 1:
 Input: nums = [3, 4, 2]
 Output: 6
 Explanation:
 Delete 4 to earn 4 points, consequently 3 is also deleted.
 Then, delete 2 to earn 2 points. 6 total points are earned.
 Example 2:
 Input: nums = [2, 2, 3, 3, 3, 4]
 Output: 9
 Explanation:
 Delete 3 to earn 3 points, deleting both 2's and the 4.
 Then, delete 3 again to earn 3 points, and 3 again to earn 3 points.
 9 total points are earned.
 Note:

 The length of nums is at most 20000.
 Each element nums[i] is an integer in the range [1, 10000].

 */
import java.util.*;
public class DeleteAndEarn740 {
    // beat 36%
    public int deleteAndEarn(int[] nums) {
        if (nums.length==0)
            return 0;
        Arrays.sort(nums);
        List<Pair> list = new ArrayList<>();
        Pair p = new Pair();
        p.val = nums[0];
        p.earn+=p.val;
        list.add(p);
        for (int i=1; i<nums.length; i++){
            if (p.val == nums[i]){
                p.earn +=p.val;
            }else{
                p = new Pair();
                p.val = nums[i];
                p.earn +=p.val;
                list.add(p);
            }
        }
        int n = list.size();
        int[] dp = new int[n+1];
        dp[1] = list.get(0).earn;
        if (n == 1)
            return dp[1];
        Pair pre = list.get(0);
        Pair cur = list.get(1);
        dp[2] = cur.earn;
        if (cur.val != pre.val+1)
            dp[2] += dp[1];
        for (int i=3; i<=n; i++){
            cur = list.get(i-1);
            pre = list.get(i-2);
            if (pre.val == cur.val-1){
                dp[i] = Math.max(dp[i-2], dp[i-3]) + cur.earn;
            }else
                dp[i] = cur.earn + Math.max(dp[i-2],dp[i-1]);
        }
        return Math.max(dp[n-1], dp[n]);
    }

    class Pair{
        int val;
        int earn;
    }

    public static void main(String[] args){
        int[] nums = new int[]{1,6,3,3,8,4,8,10,1,3};
        DeleteAndEarn740 test = new DeleteAndEarn740();
        System.out.println(test.deleteAndEarn(nums));
    }
}
