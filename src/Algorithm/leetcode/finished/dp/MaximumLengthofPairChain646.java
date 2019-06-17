package Algorithm.leetcode.finished.dp;

/**
 * Created by zhanghr on 2018/9/15.
 *
 * You are given n pairs of numbers. In every pair, the first number is always smaller than the second number.

 Now, we define a pair (c, d) can follow another pair (a, b) if and only if b < c. Chain of pairs can be formed in this fashion.

 Given a set of pairs, find the length longest chain which can be formed. You needn't use up all the given pairs. You can select pairs in any order.

 Example 1:
 Input: [[1,2], [2,3], [3,4]]
 Output: 2
 Explanation: The longest chain is [1,2] -> [3,4]
 Note:
 The number of given pairs will be in the range [1, 1000].

 */
import Algorithm.leetcode.util.Tool;

import java.util.*;
public class MaximumLengthofPairChain646 {
    public static void main(String[] args){
        int[][] pairs = Tool.toIntAA("[[1,2], [2,3], [3,4]]");
        System.out.println(findLongestChain(pairs));
    }

    // beat 50%，其实有更优的解法：贪婪算法，先按照end排序，然后贪婪地选取不相连区间个数
    public static int findLongestChain(int[][] p) {
        if (p.length<=1)
            return p.length;
        Pair[] pairs = new Pair[p.length];
        for (int i=0;i<p.length; i++){
            pairs[i] = new Pair(p[i][0], p[i][1]);
        }
        Arrays.sort(pairs);
        int n = pairs.length;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i=1; i<n; i++){
            int max = 0;
            int cur = pairs[i].start;
            for (int j=i-1; j>=0; j--){
                if (cur > pairs[j].end)
                    max = Math.max(max, dp[j]);
            }
            dp[i] = max+1;
        }
        int res = 1;
        for (int i=1; i<n; i++)
            res = Math.max(res, dp[i]);
        return res;
    }

    public static int findLongestChainLambda(int[][] pairs) {
        if (pairs.length<=1)
            return pairs.length;
        Arrays.sort(pairs, (a,b)->a[0]-b[0]);
        int n = pairs.length;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i=1; i<n; i++){
            int max = 0;
            int cur = pairs[i][0];
            for (int j=i-1; j>=0; j--){
                if (cur > pairs[j][1])
                    max = Math.max(max, dp[j]);
            }
            dp[i] = max+1;
        }
        int res = 1;
        for (int i=1; i<n; i++)
            res = Math.max(res, dp[i]);
        return res;
    }
}

class Pair implements Comparable<Pair>{
    int start, end;
    Pair(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Pair o) {
        return this.start-o.start;
    }
}
